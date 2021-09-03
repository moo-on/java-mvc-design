<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.web.model.*" %>
<%
  MemberVO vo = (MemberVO)request.getAttribute("vo") ;
%>    
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
<input type="hidden" name="num" value="<%=vo.getNum()%>"/>
<table class='table table-bordered'>
<%  if(vo!=null){ %>
  <tr>
    <td colspan="2"><%=vo.getName()%> ȸ���� �󼼺���</td>
  </tr>
  <tr>
    <td>��ȣ</td>
    <td><%=vo.getNum()%></td>
  </tr>
   <tr>
    <td>���̵�</td>
    <td><%=vo.getId()%></td>
  </tr>
   <tr>
    <td>��й�ȣ</td>
    <td><%=vo.getPass()%></td>
  </tr>
    <tr>
    <td>�̸�</td>
    <td><%=vo.getName()%></td>
  </tr>
  <tr>
    <td>����</td>
    <td><input type="text" name="age" value="<%=vo.getAge()%>"/></td>
  </tr>
     <tr>
    <td>�̸���</td>
    <td><input type="text" name="email" value="<%=vo.getEmail()%>"/></td>
  </tr>
  <tr>
    <td>��ȭ��ȣ</td>
    <td><input type="text" name="phone" value="<%=vo.getPhone()%>"/></td>
  </tr>
  <% } else { %>
   <tr>
    <td>��ġ�ϴ� ȸ���� �����ϴ�.</td>
  </tr> 
  <% } %>
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