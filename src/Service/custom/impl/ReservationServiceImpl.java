/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.custom.impl;

import Service.custom.ReservationService;
import dto.ReservationDto;
import entity.CustomerEntity;
import entity.ReservationEntity;
import entity.RoomEntity;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.RepositoryFactory;
import repository.custom.CustomerRepository;
import repository.custom.ReservationRepository;
import repository.custom.RoomRepository;
import util.SessionFactoryConfiguration;

/**
 *
 * @author Nushan Vandabona
 */
public class ReservationServiceImpl implements ReservationService {

    private CustomerRepository customerRepository = (CustomerRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.CUSTOMER);
    private RoomRepository roomRepository = (RoomRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.ROOM);
    private ReservationRepository reservationRepository = (ReservationRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.RESERVATION);

    @Override
    public String placeReservation(ReservationDto reservationDto) throws Exception {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            CustomerEntity customerEntity = customerRepository.getCustomer(reservationDto.getCustomerId(), session);
            RoomEntity roomEntity = roomRepository.getRoom(reservationDto.getRoomId(), session);
            if ((roomEntity.getStatus() == RoomEntity.RoomStatus.AVAILABLE) && (roomRepository.isRoomAvailable(reservationDto.getRoomId(), reservationDto.getCheckInDate(), reservationDto.getCheckOutDate(), session))) {
                ReservationEntity reservationEntity = new ReservationEntity();
                reservationEntity.setCheckInDate(reservationDto.getCheckInDate());
                reservationEntity.setCheckOutDate(reservationDto.getCheckOutDate());
                reservationEntity.setPlacedAt(reservationDto.getPlacedAt());
                reservationEntity.setCustomer(customerEntity);
                reservationEntity.setRoom(roomEntity);

                // Convert java.util.Date to LocalDate
                LocalDate checkInLocalDate = reservationDto.getCheckInDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate checkOutLocalDate = reservationDto.getCheckOutDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                // Calculate the total price based on package type and room category's base price
                long daysBetween = ChronoUnit.DAYS.between(checkInLocalDate, checkOutLocalDate);
                double packageMultiplier = getPackageMultiplier(reservationDto.getPackageType().toString());
                double totalPrice = daysBetween * roomEntity.getCategory().getBasePrice() * packageMultiplier;

                reservationEntity.setTotalPrice(totalPrice);
                reservationEntity.setPackageType(reservationDto.getPackageType());
                reservationEntity.setStatus(ReservationEntity.ReservationStatus.CONFIRMED);
                Integer reservationId = reservationRepository.placeReservation(reservationEntity, session);
                if (reservationId != null) {
                    transaction.commit();
                    return "Reservation Confirmed";
                } else {
                    transaction.rollback();
                    return "Reservation Placement Error";
                }
            } else {
                transaction.rollback();
                return "Room is Not Available";
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public List<ReservationDto> getAll() throws Exception {
        Session session = null;
        try {
            session = SessionFactoryConfiguration.getInstance().getSession();
            List<ReservationEntity> reservationEntitys = reservationRepository.getAllReservations(session);
            List<ReservationDto> reservationDtos = new ArrayList<>();
            for (ReservationEntity entity : reservationEntitys) {
                ReservationDto dto = new ReservationDto(
                        entity.getReservationId(),
                        entity.getCheckInDate(),
                        entity.getCheckOutDate(),
                        entity.getPlacedAt(),
                        entity.getTotalPrice(),
                        entity.getCustomer().getCustomerId(),
                        entity.getRoom().getRoomId(),
                        entity.getPackageType(),
                        entity.getStatus());
                reservationDtos.add(dto);
            }
            return reservationDtos;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ReservationDto getReservation(Integer reservationId) throws Exception {
        Session session = null;

        try {
            session = SessionFactoryConfiguration.getInstance().getSession();
            ReservationEntity reservationEntity = reservationRepository.getReservation(reservationId, session);
            if (reservationEntity != null) {
                ReservationDto reservationDto = new ReservationDto(
                        reservationEntity.getCheckInDate(),
                        reservationEntity.getCheckOutDate(),
                        reservationEntity.getPlacedAt(),
                        reservationEntity.getTotalPrice(),
                        reservationEntity.getCustomer().getCustomerId(),
                        reservationEntity.getRoom().getRoomId(),
                        reservationEntity.getPackageType(),
                        reservationEntity.getStatus());
                reservationDto.setReservationId(reservationEntity.getReservationId());
                return reservationDto;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private double getPackageMultiplier(String packageType) {
        switch (packageType) {
            case "FULL_BOARD":
                return 1.25;
            case "HALF_BOARD":
                return 1.15;
            case "BED_AND_BREAKFAST":
                return 1.05;
            default:
                return 1.0; // No package or unrecognized package type defaults to basic pricing
        }
    }

    @Override
    public String deleteReservation(Integer reservationId) throws Exception {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            ReservationEntity reservationEntity = reservationRepository.getReservation(reservationId, session);
            if (reservationEntity == null) {
                transaction.rollback();
                return "Reservation Not Found";
            } else {
                Date now = new Date();
                Date placedAt = reservationEntity.getPlacedAt();

                // Calculate the difference in milliseconds
                long timeDiff = now.getTime() - placedAt.getTime();

                // Convert milliseconds to hours and check if it's less than or equal to 24
                if (timeDiff <= 24 * 60 * 60 * 1000) { // 24 hours in milliseconds
                    reservationRepository.deleteReservation(reservationEntity, session);
                    transaction.commit();
                    return "Reservation Cancelled";
                } else {
                    transaction.rollback();
                    return "Cancellation period has expired";
                }
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
