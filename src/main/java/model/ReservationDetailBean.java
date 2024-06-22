package model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class ReservationDetailBean {
    private Timestamp reservationTimestamp;
    private Timestamp latestUpdateTimestamp;
    private Date startDay;
    private Date endDay;
    private Time startTime;
    private Time endTime;
    private int numberOfUser;
    private int uuid;
    private int sumPrice;
    private int roomId;
    private int equipmentId;

    // コンストラクタ
    public ReservationDetailBean(Timestamp reservationTimestamp, Timestamp latestUpdateTimestamp, Date startDay, Date endDay, Time startTime, Time endTime, int numberOfUser, int uuid, int sumPrice, int roomId, int equipmentId) {
        this.reservationTimestamp = reservationTimestamp;
        this.latestUpdateTimestamp = latestUpdateTimestamp;
        this.startDay = startDay;
        this.endDay = endDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numberOfUser = numberOfUser;
        this.uuid = uuid;
        this.sumPrice = sumPrice;
        this.roomId = roomId;
        this.equipmentId = equipmentId;
    }

    public ReservationDetailBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	// ゲッターとセッター
    public Timestamp getReservationTimestamp() {
        return reservationTimestamp;
    }

    public void setReservationTimestamp(Timestamp reservationTimestamp) {
        this.reservationTimestamp = reservationTimestamp;
    }

    public Timestamp getLatestUpdateTimestamp() {
        return latestUpdateTimestamp;
    }

    public void setLatestUpdateTimestamp(Timestamp latestUpdateTimestamp) {
        this.latestUpdateTimestamp = latestUpdateTimestamp;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getNumberOfUser() {
        return numberOfUser;
    }

    public void setNumberOfUser(int numberOfUser) {
        this.numberOfUser = numberOfUser;
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

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }
}
