<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.web.model.*" %>
<% MemberVO vo = (MemberVO)request.getAttribute("vo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
Controller���� ���� ������ ��� <br>
�̸�:<%=vo.getName() %> <br>
����:<%=vo.getAge() %> <br>
�̸���:<%=vo.getEmail() %> <br>

</body>
</html>