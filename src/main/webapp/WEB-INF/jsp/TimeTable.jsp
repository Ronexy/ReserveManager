<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タイムテーブル</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h2>タイムテーブル</h2>
        <div class="table-responsive">
            <table class="table table-bordered table-fixed">
                <thead>
                    <tr>
                        <th class="th-fixed">時間</th>
                        <% 
                        // AttributeからstartTimeとendTimeを受け取る
                        String startTime = (String) request.getAttribute("startTime");
                        String endTime = (String) request.getAttribute("endTime");
                        startTime = "11:00";
                        endTime = "13:00";
                        
                        // startTimeとendTimeを時刻としてパースする
                        int startHour = Integer.parseInt(startTime.split(":")[0]);
                        int endHour = Integer.parseInt(endTime.split(":")[0]);
                        
                        // 時間帯を表すセルを生成する
                        for (int hour = 8; hour < 20; hour++) {
                            // 時間帯の文字列を生成
                            String timeRange = hour + ":00-" + (hour + 1) + ":00";
                            // startTimeとendTimeの間に予定があるかどうかをチェックし、表示する
                            if (hour >= startHour && hour < endHour) { %>
                                <th class="th-fixed"><%= timeRange %></th>
                            <% } else { %>
                                <th class="th-fixed"><%= timeRange %></th>
                            <% }
                        } %>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>予定</td>
                        <% 
                        // 予定の表示を生成する
                        for (int hour = 8; hour < 20; hour++) {
                            // startTimeとendTimeの間に予定があるかどうかをチェックし、表示する
                            if (hour >= startHour && hour < endHour) { %>
                                <td class="table-danger">予定あり</td>
                            <% } else { %>
                                <td></td>
                            <% }
                        } %>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>

</html>
