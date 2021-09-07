<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import  = "com.web.model.*" %>
<%@page import  = "java.util.*" %>


<!-- controller���� forward �޾Ҵٰ� ���� -->
<%
String[] str = {"a","b","c"}; //EL�� ǥ�� �Ұ���
request.setAttribute("str", str);//setAttribute�� ��� �� ��ũ��Ʈ�� ���� �� �͵鵵 ǥ�� ����

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
<!-- ���������� str�� �ν��ϱ� ������ getAttribute�� �� �ʿ䰡 ���� -->
<c:forEach var = "f" items = "${str}">
${f} <br>
</c:forEach>

<!-- EL������ vo.num == vo.getNum�� ��ü������ ��ȯ -->
<table>
<tr>${vo.age}</tr>
</table>

<!-- list view�� �ޱ� -->
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