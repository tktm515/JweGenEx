<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジュール掲示板　スケジュール一覧画面</title>
<body>
	<h1>グループ名:<c:out value="${ groupAccount.groupName}"/></h1>
	<a href="/JweGenEx/addSchedule">スケジュール登録</a>
	<table border="1">
	　<tr>
	　　<th bgcolor="#FFCC66">日付</th>
　　　　<th bgcolor="#FFCC66">開始</th>
	　　<th bgcolor="#FFCC66">終了</th>
　　	<th bgcolor="#FFCC66">用件</th>
　　	<th bgcolor="#FFCC66">場所</th>

	　</tr>
	<c:forEach var="scheduleList" items="${scheduleList}">
	　<tr>
	　　<td><c:out value="${ scheduleList.date}"/></td>
	　　<td><c:out value="${ scheduleList.startTime}"/></td>
		<td><c:out value="${ scheduleList.endTime}"/></td>
		<td><c:out value="${ scheduleList.title}"/></td>
		<td><c:out value="${ scheduleList.place}"/></td>
	　</tr>
	</c:forEach>

	</table>
</body>
</html>
