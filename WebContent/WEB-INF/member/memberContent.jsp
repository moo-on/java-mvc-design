<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.web.model.*" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var = "ctx" value = "${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>
<title>Insert title here</title>
</head>
<body>
<form action="memberUpdate.do" method = "post">
<input type="hidden" name="num" value="${vo.num}"/>
<table class='table table-bordered'>

<c:if test="${vo != null}">
  <tr>
    <td colspan="2">${vo.name} ȸ���� �󼼺���</td>
  </tr>
  <tr>
    <td>��ȣ</td>
    <td>${vo.num}</td>
  </tr>
   <tr>
    <td>���̵�</td>
    <td>${vo.id}</td>
  </tr>
   <tr>
    <td>��й�ȣ</td>
    <td>${vo.pass}</td>
  </tr>
    <tr>
    <td>�̸�</td>
    <td>${vo.name}</td>
  </tr>
  <tr>
    <td>����</td>
    <td><input type="text" name="age" value="${vo.age}"/></td>
  </tr>
     <tr>
    <td>�̸���</td>
    <td><input type="text" name="email" value="${vo.email}"/></td>
  </tr>
  <tr>
    <td>��ȭ��ȣ</td>
    <td><input type="text" name="phone" value="${vo.phone}"/></td>
  </tr>
  </c:if>

  <tr>
    <td colspan="2" align="center">
       <input type="submit" value="�����ϱ�" class='btn btn-primary'/>
       <input type="reset" value="���" class='btn btn-warning'/>
       <input type="button" value="����Ʈ" onclick="location.href='memberList.do'" class='btn'/>
    </td>
  </tr>
</table>
</form>

</body>
</html>