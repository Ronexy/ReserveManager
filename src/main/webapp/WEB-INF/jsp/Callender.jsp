<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.temporal.TemporalAdjusters" %>
<%@ page import="java.time.DayOfWeek" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>カレンダー</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <style>
        .calendar-table th, .calendar-table td {
            text-align: center;
            padding: 5px;
        }
        .calendar-table .btn {
            width: 100%;
        }
    </style>
    <script>
        function handleDateButtonClick(date) {
            document.getElementById("selectedDate").value = date;
            document.getElementById("dateForm").submit();
        }
    </script>
</head>
<body>
    <div class="container mt-4">
        <h1 class="text-center">カレンダー</h1>
        <%
            LocalDate currentDate = (LocalDate) request.getAttribute("currentDate");
            LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
            LocalDate firstDayOfCalendar = firstDayOfMonth.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
            LocalDate lastDayOfMonth = firstDayOfMonth.with(TemporalAdjusters.lastDayOfMonth());
            LocalDate lastDayOfCalendar = lastDayOfMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        %>
        <div class="d-flex justify-content-between align-items-center">
            <a href="callender?year=<%= currentDate.minusMonths(1).getYear() %>&month=<%= currentDate.minusMonths(1).getMonthValue() %>" class="btn btn-primary">前の月</a>
            <h2><%= currentDate.format(DateTimeFormatter.ofPattern("yyyy年 MMMM")) %></h2>
            <a href="callender?year=<%= currentDate.plusMonths(1).getYear() %>&month=<%= currentDate.plusMonths(1).getMonthValue() %>" class="btn btn-primary">次の月</a>
        </div>
        <form id="dateForm" action="callender" method="POST">
            <input type="hidden" id="selectedDate" name="selectedDate" value="">
            <table class="table table-bordered calendar-table mt-3">
                <thead>
                    <tr>
                        <th>日</th>
                        <th>月</th>
                        <th>火</th>
                        <th>水</th>
                        <th>木</th>
                        <th>金</th>
                        <th>土</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        LocalDate currentDay = firstDayOfCalendar;
                        while (!currentDay.isAfter(lastDayOfCalendar)) { 
                    %>
                        <tr>
                            <% for (int i = 0; i < 7; i++) { %>
                                <td>
                                    <% if (currentDay.getMonthValue() == currentDate.getMonthValue()) { %>
                                        <button type="button" class="btn btn-outline-secondary w-100" onclick="handleDateButtonClick('<%= currentDay %>')">
                                            <%= currentDay.getDayOfMonth() %>
                                        </button>
                                    <% } else { %>
                                        <span><%= currentDay.getDayOfMonth() %></span>
                                    <% } %>
                                </td>
                                <% currentDay = currentDay.plusDays(1); %>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </form>
    </div>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
