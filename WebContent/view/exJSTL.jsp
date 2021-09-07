<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import  = "com.web.model.*" %>
<%@page import  = "java.util.*" %>


<!-- controller에서 forward 받았다고 가정 -->
<%
String[] str = {"a","b","c"}; //EL로 표현 불가능
request.setAttribute("str", str);//setAttribute로 등록 시 스크립트로 선언 한 것들도 표현 가능

MemberVO vo = new MemberVO();
vo.setNum(1);
vo.setId("testid");
vo.setName("jk");
vo.setAge(19);

List<MemberVO> lst = new ArrayList<>();
lst.add(vo);
lst.add(vo);
request.setAttribute("lst", lst);

%>

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
<!-- 내부적으로 str을 인식하기 때문에 getAttribute를 할 필요가 없다 -->
<c:forEach var = "f" items = "${str}">
${f} <br>
</c:forEach>

<!-- EL에서는 vo.num == vo.getNum과 자체적으로 변환 -->
<table>
<tr>${vo.age}</tr>
</table>

<!-- list view로 받기 -->
<table>
<c:forEach var = "vo" items ="${lst}">
<tr>
	<td>${vo.num}
	<td>${vo.id}
	<td>${vo.name}
	<td>${vo.age}
</tr>
</c:forEach>
</table>
</body>
</html>