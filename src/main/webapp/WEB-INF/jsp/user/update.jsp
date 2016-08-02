<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<h2>修改用户</h2>
	
	<sf:form method="post" modelAttribute="user">
		id:${user.uid}<sf:hidden path="uid"/><br/>
		nick:<sf:input path="nick"/><sf:errors path="nick"/><br/>
		phone:<sf:input path="phone"/><sf:errors path="phone"/><br/>
		email:<sf:input path="email"/><sf:errors path="email"/><br/>
		<input type="submit" value="commit">
	
	</sf:form>
	
</body>
</html>
