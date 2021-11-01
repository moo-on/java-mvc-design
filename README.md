# jsp-tutorial
![MVC2](https://user-images.githubusercontent.com/70089259/132357704-02077372-9fec-4d85-b44d-5e0ae8a4fa66.png)  
MVC1 is consist of only controller & model

### controller
insert delete update showList showPrivateContent
### model
ModelVO & ModelDAO (use JDBC)

---
### [Controller]
* insertion html code, readability is poor

This serlvet show member list.↓     
[MemberListController.java](https://github.com/moo-on/jsp-tutorial/blob/MVC1/src/com/web/controller/MemberListController.java)  

This servlet show member private content.↓     
[MemberContentController.java](https://github.com/moo-on/jsp-tutorial/blob/MVC1/src/com/web/controller/MemberContentController.java)   

This serlvet only interaction DB. and Redirection member List Page ↓  
[MemberDeleteController.java](https://github.com/moo-on/jsp-tutorial/blob/MVC1/src/com/web/controller/MemberDeleteController.java)  
[MemberInsertController.java](https://github.com/moo-on/jsp-tutorial/blob/MVC1/src/com/web/controller/MemberInsertController.java)  
[MemberUpdateController.java](https://github.com/moo-on/jsp-tutorial/blob/MVC1/src/com/web/controller/MemberUpdateController.java)  

### [Model]
VO and DAO is interaction MySQL ↓  
[MemberVO](https://github.com/moo-on/jsp-tutorial/blob/MVC1/src/com/web/model/MemberVO.java)   
[MemberDAO](https://github.com/moo-on/jsp-tutorial/blob/MVC1/src/com/web/model/MemberDAO.java)  
