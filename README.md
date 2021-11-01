# jsp-tutorial
![MVC2](https://user-images.githubusercontent.com/70089259/132357704-02077372-9fec-4d85-b44d-5e0ae8a4fa66.png)  
![image](https://user-images.githubusercontent.com/70089259/139640979-833374ad-06e8-452a-a989-59dcaaf09cac.png)

**MVC3** is consist of **view(jsp) & controller(servlet) & model** 

### controller(servlet)
- showList(forward to jsp and Redrirect to Register.html)
- showPrivateContent(forward to jsp)
- insert(redirect to showListController) 
- delete(redirect to showListController)
- update(redirect to showListController)
### view(jsp)
- showList
- showPrivateContent
### model
ModelVO & ModelDVO (use JDBC to MySQL)
---
### [Controller]
* **all requests receive Controller and forward, JSP address not exposed.**  

MemberListController (forward to jsp)  
MemberContentController (forward to jsp)  
MemberDeleteController  (interaction DB and Redirect MemberListController)  
MemberInsertController  (interaction DB and Redirect MemberListController)  
MemberUpdateController  (interaction DB and Redirect MemberListController)  

[Controller](https://github.com/moo-on/jsp-tutorial/tree/MVC3/src/com/web/controller)

### [View]
memberContent  
memberList  
memberRegister  

[View](https://github.com/moo-on/jsp-tutorial/tree/MVC3/WebContent/member)



### [Model]
VO and DAO is interaction MySQL ↓  
[MemberVO](https://github.com/moo-on/jsp-tutorial/blob/MVC3/src/com/web/model/MemberVO.java)   
[MemberDAO](https://github.com/moo-on/jsp-tutorial/blob/MVC3/src/com/web/model/MemberDAO.java)  
