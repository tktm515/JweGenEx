<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジュール掲示板　スケジュール登録画面</title>
</head>
<body>
	<h1>グループ名:<c:out value="${ groupAccount.groupName}"></c:out></h1>

	<font color="red"><c:forEach var="messageList" items="${messageList}">
		　<tr>
		　　<td><c:out value="${ messageList}"/><br/></td>
		　</tr>
	</c:forEach></font>

	<form action="/JweGenEx/addSchedule" method="post">
	<table border=1>
		　
	　　<tr>
			<th bgcolor="#FFCC66">日付</th>
			<td><input type="text" name="date" value="${schedule.date}"></td>
		</tr>
　　　　<tr>
			<th bgcolor="#FFCC66">開始</th>
			<td><input type="text" name="startTime" value="${schedule.startTime}"></td>
		</tr>
	　　<tr>
			<th bgcolor="#FFCC66">終了</th>
			<td><input type="text" name="endTime" value="${schedule.endTime}"></td>
		</tr>
　　	<tr>
			<th bgcolor="#FFCC66">用件</th>
			<td><input type="text" name="title" value="${schedule.title}"></td>
		</tr>
　　	<tr>
			<th bgcolor="#FFCC66">場所</th>
			<td><input type="text" name="place" value="${schedule.place}"></td>
	　	</tr>
	</table>
		<input type="submit" value="登録">
	</form>

</body>
</html>