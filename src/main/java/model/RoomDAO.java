package model;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    // JDBC接続情報
    private String jdbcURL = "jdbc:postgresql://localhost:5432/rms"; // データベースのURLを適宜変更する
    private String jdbcUsername = "testpg";
    private String jdbcPassword = "testpg";

    private static final String INSERT_ROOM_SQL = "INSERT INTO room (roomId, image, roomName, startAvailableTime, endAvailableTime, isInstallWiFi, floor, area, seatingCapacity, chairQuantity, tableQuantity, feeId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_ROOMS = "SELECT * FROM room";
    private static final String SELECT_ROOM_BY_ID = "SELECT * FROM room WHERE roomId = ?";
    private static final String DELETE_ROOM_SQL = "DELETE FROM room WHERE roomId = ?";
    private static final String UPDATE_ROOM_SQL = "UPDATE room SET image = ?, roomName = ?, startAvailableTime = ?, endAvailableTime = ?, isInstallWiFi = ?, floor = ?, area = ?, seatingCapacity = ?, chairQuantity = ?, tableQuantity = ?, feeId = ? WHERE roomId = ?";

    public RoomDAO() {
    }

    // データベースとの接続を確立するメソッド
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver"); // PostgreSQLの場合、適切なドライバーを使用する
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Roomをデータベースに挿入するメソッド
//    public void insertRoom(RoomBean room) throws SQLException {
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM_SQL)) {
//            preparedStatement.setInt(1, room.getRoomId());
//            preparedStatement.setString(2, room.getImage());
//            preparedStatement.setString(3, room.getRoomName());
//            preparedStatement.setObject(4, room.getStartAvailableTime().withZoneSameInstant(ZoneId.of("Asia/Tokyo")));
//            preparedStatement.setObject(5, room.getEndAvailableTime().withZoneSameInstant(ZoneId.of("Asia/Tokyo")));
//            preparedStatement.setBoolean(6, room.isInstallWiFi());
//            preparedStatement.setInt(7, room.getFloor());
//            preparedStatement.setInt(8, room.getArea());
//            preparedStatement.setInt(9, room.getSeatingCapacity());
//            preparedStatement.setObject(10, room.getChairQuantity());
//            preparedStatement.setObject(11, room.getTableQuantity());
//            preparedStatement.setArray(12, connection.createArrayOf("integer", room.getFeeId()));
//
//            preparedStatement.executeUpdate();
//        }
//    }

    // 全てのRoomを取得するメソッド
    public List<RoomBean> getAllRooms(){
        List<RoomBean> rooms = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOMS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                RoomBean room = new RoomBean();
                room.setRoomId(rs.getInt("roomId"));
                room.setImage(rs.getString("image"));
                room.setRoomName(rs.getString("roomName"));
                room.setStartAvailableTime(ZonedDateTime.ofInstant(rs.getTimestamp("startAvailableTime").toInstant(), ZoneId.of("Asia/Tokyo")));
                room.setEndAvailableTime(ZonedDateTime.ofInstant(rs.getTimestamp("endAvailableTime").toInstant(), ZoneId.of("Asia/Tokyo")));
                room.setInstallWiFi(rs.getBoolean("isInstallWiFi"));
                room.setFloor(rs.getInt("floor"));
                room.setArea(rs.getInt("area"));
                room.setSeatingCapacity(rs.getInt("seatingCapacity"));
                room.setChairQuantity(rs.getInt("chairQuantity"));
                room.setTableQuantity(rs.getInt("tableQuantity"));
                Array array = rs.getArray("feeId");
                if (array != null) {
                    Object[] objects = (Object[]) array.getArray(); // Object[] として取得
                    int[] ints = new int[objects.length];
                    for (int i = 0; i < objects.length; i++) {
                        ints[i] = (Integer) objects[i]; // Integer から int へのキャスト
                    }
                    room.setFeeId(ints);
                } else {
                    // エラー処理やデフォルト値の設定など
                }

                rooms.add(room);
            }
        }catch(SQLException e){
        	return null;
        }
        return rooms;
    }

    // 特定のroomIdに対応するRoomを取得するメソッド
    public RoomBean getRoomById(int roomId) throws SQLException {
        RoomBean room = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROOM_BY_ID)) {
            preparedStatement.setInt(1, roomId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                room = new RoomBean();
                room.setRoomId(rs.getInt("roomId"));
                room.setImage(rs.getString("image"));
                room.setRoomName(rs.getString("roomName"));
                room.setStartAvailableTime(ZonedDateTime.ofInstant(rs.getTimestamp("startAvailableTime").toInstant(), ZoneId.of("Asia/Tokyo")));
                room.setEndAvailableTime(ZonedDateTime.ofInstant(rs.getTimestamp("endAvailableTime").toInstant(), ZoneId.of("Asia/Tokyo")));
                room.setInstallWiFi(rs.getBoolean("isInstallWiFi"));
                room.setFloor(rs.getInt("floor"));
                room.setArea(rs.getInt("area"));
                room.setSeatingCapacity(rs.getInt("seatingCapacity"));
                room.setChairQuantity(rs.getInt("chairQuantity"));
                room.setTableQuantity(rs.getInt("tableQuantity"));
                room.setFeeId((int[]) rs.getArray("feeId").getArray());
            }
        }
        return room;
    }

    // 特定のroomIdに対応するRoomを削除するメソッド
    public boolean deleteRoom(int roomId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ROOM_SQL)) {
            statement.setInt(1, roomId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    // Roomの情報を更新するメソッド
//    public boolean updateRoom(RoomBean room) throws SQLException {
//        boolean rowUpdated;
//        try (Connection connection = getConnection();
//             PreparedStatement statement = connection.prepareStatement(UPDATE_ROOM_SQL)) {
//            statement.setString(1, room.getImage());
//            statement.setString(2, room.getRoomName());
//            statement.setObject(3, room.getStartAvailableTime().withZoneSameInstant(ZoneId.of("Asia/Tokyo")));
//            statement.setObject(4, room.getEndAvailableTime().withZoneSameInstant(ZoneId.of("Asia/Tokyo")));
//            statement.setBoolean(5, room.isInstallWiFi());
//            statement.setInt(6, room.getFloor());
//            statement.setInt(7, room.getArea());
//            statement.setInt(8, room.getSeatingCapacity());
//            statement.setObject(9, room.getChairQuantity());
//            statement.setObject(10, room.getTableQuantity());
//            statement.setArray(11, connection.createArrayOf("integer", room.getFeeId()));
//            statement.setInt(12, room.getRoomId());
//
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//        return rowUpdated;
//    }
}

