<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>

</head>
<body>
ȸ������ȭ��
<form action="/jsp-tutorial/memberInsert.do" method = "post">
<table class="table table-bordered">
  <tr> 
    <td class="tg-baqh">���̵�</td>
    <td class="tg-baqh"><input type ="text" name = "id"/></td>
  </tr>
  <tr>
    <td class="tg-baqh">�н�����</td>
    <td class="tg-baqh"><input type ="password" name = "pass"/></td>
  </tr>
  <tr>
    <td class="tg-baqh">�̸�</td>
    <td class="tg-baqh"><input type ="text" name = "name"/></td>
  </tr>
  <tr>
    <td class="tg-baqh">����</td>
    <td class="tg-baqh"><input type ="text" name = "age"/></td>
  </tr>
  <tr>
    <td class="tg-baqh">�̸���</td>
    <td class="tg-baqh"><input type ="text" name = "email"/></td>
  </tr>
  <tr>
    <td class="tg-baqh">��ȭ��ȣ</td>
    <td class="tg-baqh"><input type ="text" name = "phone"/></td>
  </tr>
  <tr>
    <td class="tg-baqh" colspan="2">
    <input type ="submit" value = "����" class = "btn btn-primary"/>
    <input type ="reset" value = "���" class = "btn btn-warning"/>
    </td>
  </tr>
</table>
</form>
</body>
</html>