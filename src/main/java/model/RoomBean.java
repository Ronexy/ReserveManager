package model;

import java.time.ZonedDateTime;

public class RoomBean {
    private int roomId;
    private String image;
    private String roomName;
    private ZonedDateTime startAvailableTime;
    private ZonedDateTime endAvailableTime;
    private boolean isInstallWiFi;
    private int floor;
    private int area;
    private int seatingCapacity;
    private Integer chairQuantity; // Use Integer for nullable fields
    private Integer tableQuantity; // Use Integer for nullable fields
    private int[] feeId;

    // Constructor
    public RoomBean() {}

    // Getters and Setters
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public ZonedDateTime getStartAvailableTime() {
        return startAvailableTime;
    }

    public void setStartAvailableTime(ZonedDateTime startAvailableTime) {
        this.startAvailableTime = startAvailableTime;
    }

    public ZonedDateTime getEndAvailableTime() {
        return endAvailableTime;
    }

    public void setEndAvailableTime(ZonedDateTime endAvailableTime) {
        this.endAvailableTime = endAvailableTime;
    }

    public boolean isInstallWiFi() {
        return isInstallWiFi;
    }

    public void setInstallWiFi(boolean installWiFi) {
        isInstallWiFi = installWiFi;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public Integer getChairQuantity() {
        return chairQuantity;
    }

    public void setChairQuantity(Integer chairQuantity) {
        this.chairQuantity = chairQuantity;
    }

    public Integer getTableQuantity() {
        return tableQuantity;
    }

    public void setTableQuantity(Integer tableQuantity) {
        this.tableQuantity = tableQuantity;
    }

    public int[] getFeeId() {
        return feeId;
    }

    public void setFeeId(int[] feeId) {
        this.feeId = feeId;
    }

}

