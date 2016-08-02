<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<h2>添加用户</h2>
	
	<sf:form method="post" modelAttribute="user">
		nick:<sf:input path="nick"/><sf:errors path="nick"/><br/>
		phone:<sf:input path="phone"/><sf:errors path="phone"/><br/>
		email:<sf:input path="email"/><sf:errors path="email"/><br/>
		password:<sf:password path="password"/><sf:errors path="password"/><br/>
		<input type="submit" value="commit">
	
	</sf:form>
	
</body>
</html>
