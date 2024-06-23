package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOTest {

	public static void main(String[] args) {
	    // テスト用のReservationBeanとEquipmentBeanを作成
	    
	        ReservationBean reservation1 = new ReservationBean();
	        reservation1.setRoomId(3);
	        reservation1.setStartDate(LocalDate.of(2025, 7, 1));
	        reservation1.setEndDate(LocalDate.of(2025, 7, 3));
	        reservation1.setStartTime(LocalTime.of(10, 0));
	        reservation1.setEndTime(LocalTime.of(12, 0));
	        reservation1.setNumberOfUsers(10);
	        reservation1.setUuid(123456789); // 仮のUUID
	        reservation1.setSumPrice(10000); // 仮の合計金額

	        EquipmentBean equipment1 = new EquipmentBean();
	        equipment1.setMicrophone(1);
	        equipment1.setPodium(1);
	        equipment1.setScreen(1);
	        equipment1.setLcdProjector(0);
	        equipment1.setWhiteboard(1);
	        reservation1.setEquipment(equipment1);

	        ReservationBean reservation2 = new ReservationBean();
	        reservation2.setRoomId(1);
	        reservation2.setStartDate(LocalDate.of(2025, 7, 1));
	        reservation2.setEndDate(LocalDate.of(2025, 7, 3));
	        reservation2.setStartTime(LocalTime.of(10, 0));
	        reservation2.setEndTime(LocalTime.of(12, 0));
	        reservation2.setNumberOfUsers(15);
	        reservation2.setUuid(123456789); // 別の仮のUUID
	        reservation2.setSumPrice(15000); // 別の仮の合計金額

	        EquipmentBean equipment2 = new EquipmentBean();
	        equipment2.setMicrophone(1);
	        equipment2.setPodium(0);
	        equipment2.setScreen(1);
	        equipment2.setLcdProjector(1);
	        equipment2.setWhiteboard(0);
	        reservation2.setEquipment(equipment2);

	        // テスト用の予約リストを作成
	        List<ReservationBean> reservations = new ArrayList<>();
	        reservations.add(reservation1);
	        reservations.add(reservation2);

	        // ReservationDAOを使って予約を作成する
	        ReservationDAO dao = new ReservationDAO();
	        System.out.println(dao.makeReservations(reservations));
	    
	        
	}

}
