<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!-- �� ���� -->
<c:set var ="cnt" value = "10"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- �� ��� -->
${cnt}

<!-- if�� -->
<c:if test="${cnt%2 == 0 }">¦���Դϴ�.</c:if>
<c:if test="${cnt%2 != 0 }">Ȧ���Դϴ�.</c:if>

<!-- switch�� -->
<c:choose>
<c:when test="${cnt%2 == 0}">¦���Դϴ�.</c:when>
<c:when test="${cnt%2 != 0}">Ȧ���Դϴ�.</c:when>
<c:otherwise>��ġ�ϴ� when���� �����ϴ�.</c:otherwise>
</c:choose>

<!-- for�� -->
<c:forEach var = "i" begin = "1" end = "5" step = "1">
<font size = "${i}">��ȣ</font> <br>
</c:forEach>



</body>
</html>