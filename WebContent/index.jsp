<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.web.util.*" %>
<%
ExUtil ex = new ExUtil();
int sum = ex.sum();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<td>1~10까지의 총합</td>
	<td><%=sum%></td>
</tr>
</table>
</body>
</html>
