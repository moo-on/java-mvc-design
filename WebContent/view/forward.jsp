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
Controller에서 받은 데이터 출력 <br>
이름:<%=vo.getName() %> <br>
나이:<%=vo.getAge() %> <br>
이메일:<%=vo.getEmail() %> <br>

</body>
</html>