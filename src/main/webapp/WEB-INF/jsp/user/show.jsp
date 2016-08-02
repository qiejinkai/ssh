<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<h2>查看用户</h2>
	
		id:${user.uid}<br/>
		nick:${user.nick }<br/>
		phone:${user.phone }<br/>
		email:${user.email }<br/>
	<a href="${user.uid }/update">修改</a>
</body>
</html>
