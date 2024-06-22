package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationDAOTest {

	public static void main(String[] args) {
        ReservationBean reservation = new ReservationBean();
        reservation.setStartDate(LocalDate.of(2024, 5, 8));
        reservation.setEndDate(LocalDate.of(2024, 5, 9));
        reservation.setStartTime(LocalTime.of(11, 0));
        reservation.setEndTime(LocalTime.of(12, 0));
        reservation.setNumberOfUsers(5);
        reservation.setUuid(12345);
        reservation.setSumPrice(333);
        reservation.setRoomId(2);
        reservation.setEquipment(new EquipmentBean(3, 2, 3, 0, 1));

        ReservationDAO dao = new ReservationDAO();
        dao.makeReservations(reservation);
    }

}
