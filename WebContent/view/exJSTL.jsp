<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!-- 값 저장 -->
<c:set var ="cnt" value = "10"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- 값 출력 -->
${cnt}

<!-- if문 -->
<c:if test="${cnt%2 == 0 }">짝수입니다.</c:if>
<c:if test="${cnt%2 != 0 }">홀수입니다.</c:if>

<!-- switch문 -->
<c:choose>
<c:when test="${cnt%2 == 0}">짝수입니다.</c:when>
<c:when test="${cnt%2 != 0}">홀수입니다.</c:when>
<c:otherwise>일치하는 when절이 없습니다.</c:otherwise>
</c:choose>

<!-- for문 -->
<c:forEach var = "i" begin = "1" end = "5" step = "1">
<font size = "${i}">야호</font> <br>
</c:forEach>



</body>
</html>