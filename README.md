# jsp-tutorial
![MVC2](https://user-images.githubusercontent.com/70089259/132357704-02077372-9fec-4d85-b44d-5e0ae8a4fa66.png)  
**MVC2** is consist of **only view(jsp)** & model 

### view
insert delete update showList showPrivateContent
### model
ModelVO & ModelDVO (use JDBC)

---
### [View]
* Insertion scriptlet to JSP, Convenience of development is low. 
 
This JSP show member list.↓       
[MemberListController.java](https://github.com/moo-on/jsp-tutorial/blob/MVC2/WebContent/member/memberList.jsp)  

This JSP show member private content.↓     
[MemberContentController.java](https://github.com/moo-on/jsp-tutorial/blob/MVC2/WebContent/member/memberContent.jsp)   

This JSP only interaction DB. and Redirection member List Page ↓  
[MemberDeleteController.java](https://github.com/moo-on/jsp-tutorial/blob/MVC2/WebContent/member/memberDelete.jsp)  
[MemberInsertController.java](https://github.com/moo-on/jsp-tutorial/blob/MVC2/WebContent/member/memberInsert.jsp)  
[MemberUpdateController.java](https://github.com/moo-on/jsp-tutorial/blob/MVC2/WebContent/member/memberUpdate.jsp)  

### [Model]
VO and DAO is interaction MySQL ↓  
[MemberVO](https://github.com/moo-on/jsp-tutorial/blob/MVC2/src/com/web/model/MemberVO.java)   
[MemberDAO](https://github.com/moo-on/jsp-tutorial/blob/MVC2/src/com/web/model/MemberDAO.java)  
