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
회원가입화면
<form action="/jsp-tutorial/memberInsert.do" method = "post">
<table class="table table-bordered">
  <tr> 
    <td class="tg-baqh">아이디</td>
    <td class="tg-baqh"><input type ="text" name = "id"/></td>
  </tr>
  <tr>
    <td class="tg-baqh">패스워드</td>
    <td class="tg-baqh"><input type ="password" name = "pass"/></td>
  </tr>
  <tr>
    <td class="tg-baqh">이름</td>
    <td class="tg-baqh"><input type ="text" name = "name"/></td>
  </tr>
  <tr>
    <td class="tg-baqh">나이</td>
    <td class="tg-baqh"><input type ="text" name = "age"/></td>
  </tr>
  <tr>
    <td class="tg-baqh">이메일</td>
    <td class="tg-baqh"><input type ="text" name = "email"/></td>
  </tr>
  <tr>
    <td class="tg-baqh">전화번호</td>
    <td class="tg-baqh"><input type ="text" name = "phone"/></td>
  </tr>
  <tr>
    <td class="tg-baqh" colspan="2">
    <input type ="submit" value = "전송" class = "btn btn-primary"/>
    <input type ="reset" value = "취소" class = "btn btn-warning"/>
    </td>
  </tr>
</table>
</form>
</body>
</html>