<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジュール掲示板　ログイン画面</title>
</head>
<body>
	<h1>スケジュール掲示板　ログイン画面</h1>
	<form action="/JweGenEx/login" method="post">
		グループ名:<input type="text" name="groupName"><br/>
		パスワード:<input type="password" name="password"><br/>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>