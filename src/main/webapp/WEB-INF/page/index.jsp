<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<c:set value="${pageContext.request.contextPath}/" var="path"/>
	</head>
	<body>
		<form action="${path}/file/upload" method="post" enctype="multipart/form-data">
			<input type="file" name="file">
			<button type="submit">submit</button>
		</form>
	</body>
</html>