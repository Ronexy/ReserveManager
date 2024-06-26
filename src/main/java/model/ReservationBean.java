package model;


import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationBean {
	private int reservationId;
	private Timestamp reservationTimestamp;
	private Timestamp latestUpdateTimestamp;
	private String cancelReason;
	private String reservationStatus; 
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private int numberOfUsers;
    private int uuid;
    private int sumPrice;
    private int roomId;
    private EquipmentBean equipment;

    public int getReservationId() {
		return reservationId;
	}

	public Timestamp getReservationTimestamp() {
		return reservationTimestamp;
	}

	public Timestamp getLatestUpdateTimestamp() {
		return latestUpdateTimestamp;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public void setReservationTimestamp(Timestamp reservationTimestamp) {
		this.reservationTimestamp = reservationTimestamp;
	}

	public void setLatestUpdateTimestamp(Timestamp latestUpdateTimestamp) {
		this.latestUpdateTimestamp = latestUpdateTimestamp;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	// 各フィールドのgetterとsetterを定義します
    // 例：
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    // 他のフィールドのgetterとsetterも同様に定義してください
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public int getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public EquipmentBean getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentBean equipment) {
        this.equipment = equipment;
    }
}

