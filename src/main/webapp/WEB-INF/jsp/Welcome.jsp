<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.RoomBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<%
	List<RoomBean> roomList = (List<RoomBean>) request.getAttribute("roomList");
	%>

	<nav class="navbar bg-body-tertiary">
		<div class="container-fluid d-flex justify-content-between">
			<a class="navbar-brand" href="#"> <svg
					xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="currentColor" class="bi bi-table" viewBox="0 0 16 16">
                <path
						d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm15 2h-4v3h4V4zm0 4h-4v3h4V8zm0 4h-4v3h3a1 1 0 0 0 1-1v-2zm-5 3v-3H6v3h4zm-5 0v-3H1v2a1 1 0 0 0 1 1h3zm-4-4h4V8H1v3zm0-4h4V4H1v3zm5-3v3h4V4H6zm4 4H6v3h4V8z" />
            </svg> RMS (Reservation Management System)
			</a>
			<div class="d-flex justify-content-end">
				<%
				if (session.getAttribute("loginId") == null) {
				%>
				<form action="login" method="get">
					<button type="submit" class="btn btn-outline-primary">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-box-arrow-in-right"
							viewBox="0 0 16 16">
  <path fill-rule="evenodd"
								d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z" />
  <path fill-rule="evenodd"
								d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z" />
</svg>
						Login
					</button>
					<button type="submit" class="btn btn-primary">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-person-fill-add"
							viewBox="0 0 16 16">
  <path
								d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7Zm.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0Zm-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z" />
  <path
								d="M2 13c0 1 1 1 1 1h5.256A4.493 4.493 0 0 1 8 12.5a4.49 4.49 0 0 1 1.544-3.393C9.077 9.038 8.564 9 8 9c-5 0-6 3-6 4Z" />
</svg>
						Create Account
					</button>
				</form>
				<%
				} else {
				%>
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-primary dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
  <path fill-rule="evenodd"
								d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z" />
</svg>
						メニュー
					</button>
					<ul class="dropdown-menu">
						<li><form action="logout" method="get">
								<button type="submit" class="dropdown-item">ログアウト</button>
							</form></li>
						<li><a class="dropdown-item" href="#">予約履歴</a></li>
						<li><a class="dropdown-item" href="#">アカウント情報変更</a></li>
					</ul>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</nav>


	<table class="table">
		<thead>
			<tr>
				<th>Room</th>
				<th>Room Name</th>
				<th>利用開始時間</th>
				<th>利用終了時間</th>
				<th>Wi-Fi有無</th>
				<th>階数</th>
				<th>面積</th>
				<th>収容人数</th>
				<th>席数</th>
				<th>机数</th>
				<th>料金ID</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (RoomBean room : roomList) {
			%>
			<tr>
				<td><%=room.getRoomId()%></td>
				<td><%=room.getRoomName()%></td>
				<td><%=room.getStartAvailableTime()%></td>
				<td><%=room.getEndAvailableTime()%></td>
				<td><%=room.isInstallWiFi() ? "Yes" : "No"%></td>
				<td><%=room.getFloor()%></td>
				<td><%=room.getArea()%></td>
				<td><%=room.getSeatingCapacity()%></td>
				<td><%=room.getChairQuantity() != null ? room.getChairQuantity() : ""%></td>
				<td><%=room.getTableQuantity() != null ? room.getTableQuantity() : ""%></td>
				<td>
					<%
					int[] feeIds = room.getFeeId();
					%> <%
 if (feeIds != null) {
 %> <%
 for (int i = 0; i < feeIds.length; i++) {
 %> <%=feeIds[i]%><%=i < feeIds.length - 1 ? ", " : ""%> <%
 }
 %> <%
 }
 %>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>







	<%
	for (RoomBean room : roomList) {
	%>
	<div class="card mb-3" style="width: 80%; margin: 0 auto;">
		<div class="row no-gutters">
			<div class="col-md-4">
				<img src="<%=room.getImage()%>" class="card-img"
					style="object-fit: cover; height: 100%;" alt="...">
			</div>
			<div class="col-md-8">
				<div class="card-body">
					<h5 class="card-title"><%=room.getRoomName()%></h5>
					<p class="card-text">
						<strong>Room ID:</strong>
						<%=room.getRoomId()%><br> <strong>Available Time:</strong>
						<%=room.getStartAvailableTime()%>
						-
						<%=room.getEndAvailableTime()%><br> <strong>WiFi:</strong>
						<%=room.isInstallWiFi() ? "Yes" : "No"%><br> <strong>Floor:</strong>
						<%=room.getFloor()%><br> <strong>Area:</strong>
						<%=room.getArea()%>
						sq. ft.<br> <strong>Seating Capacity:</strong>
						<%=room.getSeatingCapacity()%><br> <strong>Chair
							Quantity:</strong>
						<%=room.getChairQuantity() != null ? room.getChairQuantity() : "N/A"%><br>
						<strong>Table Quantity:</strong>
						<%=room.getTableQuantity() != null ? room.getTableQuantity() : "N/A"%><br>
						<strong>Fee IDs:</strong>
						<%
						int[] feeIds = room.getFeeId();
						%>
						<%
						if (feeIds != null && feeIds.length > 0) {
						%>
						<%
						for (int i = 0; i < feeIds.length; i++) {
						%>
						<%=feeIds[i]%><%=i < feeIds.length - 1 ? ", " : ""%>
						<%
						}
						%>
						<%
						} else {
						%>
						N/A
						<%
						}
						%>
					</p>
					<a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
		</div>
	</div>
	<%
	}
	%>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
		crossorigin="anonymous"></script>
</body>
</html>