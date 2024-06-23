package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReservationDAO {

	private static final String DB_URL = "jdbc:postgresql://localhost:5432/rms";
	private static final String DB_USER = "testpg";
	private static final String DB_PASSWORD = "testpg";

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	public String makeReservations(List<ReservationBean> reservations) {
		Connection conn = null;
		PreparedStatement pstmtCheck = null;
		PreparedStatement pstmtInsertEquip = null;
		PreparedStatement pstmtInsertRes = null;

		try {
			conn = getConnection();
			conn.setAutoCommit(false); // Start transaction
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE); // Serializable level

			StringBuilder overlappingDates = new StringBuilder();
			boolean reservationPossible = true;

			String checkSQL = "SELECT EXISTS ( " +
					"    SELECT 1 FROM public.reservationdetail " +
					"    WHERE room_id = ? " +
					"    AND start_day = ? " +
					"    AND ( " +
					"        (start_time < ? AND end_time > ?) " +
					"        OR (start_time = ? AND end_time = ?) " +
					"    ) " +
					")";
			pstmtCheck = conn.prepareStatement(checkSQL);

			String insertEquipSQL = "INSERT INTO public.equipment (microphone, podium, screen, lcd_projector, whiteboard) "
					+
					"VALUES (?, ?, ?, ?, ?) " +
					"RETURNING equipment_id";
			pstmtInsertEquip = conn.prepareStatement(insertEquipSQL);

			String insertResSQL = "INSERT INTO public.reservationdetail (reservation_timestamp, latest_update_timestamp, start_day, end_day, start_time, end_time, number_of_user, uuid, sum_price, room_id, equipment_id,reservation_status) "
					+
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmtInsertRes = conn.prepareStatement(insertResSQL);

			for (ReservationBean reservation : reservations) {
				LocalDate startDate = reservation.getStartDate();
				LocalDate endDate = reservation.getEndDate();

				for (LocalDate reservationDate = startDate; !reservationDate
						.isAfter(endDate); reservationDate = reservationDate.plusDays(1)) {
					pstmtCheck.setInt(1, reservation.getRoomId());
					pstmtCheck.setDate(2, java.sql.Date.valueOf(reservationDate));
					pstmtCheck.setTime(3, java.sql.Time.valueOf(reservation.getEndTime()));
					pstmtCheck.setTime(4, java.sql.Time.valueOf(reservation.getStartTime()));
					pstmtCheck.setTime(5, java.sql.Time.valueOf(reservation.getStartTime()));
					pstmtCheck.setTime(6, java.sql.Time.valueOf(reservation.getEndTime()));
					ResultSet rsCheck = pstmtCheck.executeQuery();
					boolean reservationExists = rsCheck.next() && rsCheck.getBoolean(1);
					rsCheck.close();

					if (reservationExists) {
						overlappingDates.append(reservationDate);
						reservationPossible = false;
						break; // Exit loop if overlap found
					} else {
						EquipmentBean equipment = reservation.getEquipment();
						pstmtInsertEquip.setInt(1, equipment.getMicrophone());
						pstmtInsertEquip.setInt(2, equipment.getPodium());
						pstmtInsertEquip.setInt(3, equipment.getScreen());
						pstmtInsertEquip.setInt(4, equipment.getLcdProjector());
						pstmtInsertEquip.setInt(5, equipment.getWhiteboard());
						ResultSet rsEquip = pstmtInsertEquip.executeQuery();
						int equipmentIdInserted = rsEquip.next() ? rsEquip.getInt(1) : 0;
						rsEquip.close();

						LocalDateTime now = LocalDateTime.now();
						pstmtInsertRes.setTimestamp(1, Timestamp.valueOf(now));
						pstmtInsertRes.setTimestamp(2, Timestamp.valueOf(now));
						pstmtInsertRes.setDate(3, java.sql.Date.valueOf(reservationDate));
						pstmtInsertRes.setDate(4, java.sql.Date.valueOf(reservationDate));
						pstmtInsertRes.setTime(5, java.sql.Time.valueOf(reservation.getStartTime()));
						pstmtInsertRes.setTime(6, java.sql.Time.valueOf(reservation.getEndTime()));
						pstmtInsertRes.setInt(7, reservation.getNumberOfUsers());
						pstmtInsertRes.setInt(8, reservation.getUuid());
						pstmtInsertRes.setInt(9, reservation.getSumPrice());
						pstmtInsertRes.setInt(10, reservation.getRoomId());
						pstmtInsertRes.setInt(11, equipmentIdInserted);
						pstmtInsertRes.setString(12, "reserved");
						pstmtInsertRes.executeUpdate();
					}
				}
				if (!reservationPossible) {
					conn.rollback(); // Rollback transaction if overlap found
					return overlappingDates.toString();
				}

			}

			conn.commit(); // Commit transaction if all reservations are valid
			return "Done";

		} catch (SQLException e) {
			try {
				if (conn != null) {
					conn.rollback(); // Rollback transaction on error
				}
			} catch (SQLException rollbackEx) {
				rollbackEx.printStackTrace();
			}
			// Uncomment the line below for debugging:
			// e.printStackTrace();
			return "Error";
		} finally {
			try {
				if (pstmtCheck != null)
					pstmtCheck.close();
				if (pstmtInsertEquip != null)
					pstmtInsertEquip.close();
				if (pstmtInsertRes != null)
					pstmtInsertRes.close();
				if (conn != null)
					conn.close();
			} catch (SQLException closeEx) {
				// Uncomment the line below for debugging:
				// closeEx.printStackTrace();
			}
		}
	}

}
