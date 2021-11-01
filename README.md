![사진](https://user-images.githubusercontent.com/70089259/136155942-47832cf2-d7fc-4ed7-8668-4aab4686b092.png)

**MVC4** is consist of view(jsp) & controller(servlet) & model
---

## Controller
controller(servlet)
- frontController  
- etc  
    - viewresolver  
    - handlerMapping  

[FrontController](https://github.com/moo-on/jsp-tutorial/tree/MVC4/src/com/web/frontcontroller)

- java source file
    - insert(interaction DB and redirect to showListController)
    - delete(interaction DB and redirect to showListController)
    - update(interaction DB and redirect to showListController)
    - showList(forward to jsp )
    - showPrivateContent(forward to jsp)
    - Register(forward to jsp)

[Controller Source](https://github.com/moo-on/jsp-tutorial/tree/MVC4/src/com/web/controller)

   
## View
view(jsp)
- showList
- showPrivateContent
- showRegister
  
[View JSP file](https://github.com/moo-on/jsp-tutorial/tree/MVC4/WebContent/WEB-INF/member)


## Model
model
- ModelVO & ModelDVO (use JDBC to MySQL)
  
[Model](https://github.com/moo-on/jsp-tutorial/tree/MVC4/src/com/web/model)

---
### 동작방식
1. 클라이언트의 요청
2. 요청된 명령을 frontController가 전부 받는다.
3. 명령을 HandlerMapping 객체에 넣으면, 요청에 알맞는 POJO를 반환한다.
4. 반환된 Controller(POJO)가 메서드를 실행한다.
5. VO, DAO와 상호작용하는 POJO들은 실행 후 view page를 반환하는 POJO로 넘긴다.(redirect)
6. view page를 반환하는 POJO들은 forward방식으로 page를 반환한다.
7. view page반환 시 context root 관리를 위해서 viewresolver라는 객체를 만들어 관리한다.
