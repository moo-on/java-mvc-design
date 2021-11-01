![사진](https://user-images.githubusercontent.com/70089259/136155942-47832cf2-d7fc-4ed7-8668-4aab4686b092.png)

**MVC4** is consist of view(jsp) & controller(servlet) & model
### Controller
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

   
### View
view(jsp)
- showList
- showPrivateContent
- showRegister
  
[View JSP file](https://github.com/moo-on/jsp-tutorial/tree/MVC4/WebContent/WEB-INF/member)


### Model
model
- ModelVO & ModelDVO (use JDBC to MySQL)
  
[Model](https://github.com/moo-on/jsp-tutorial/tree/MVC4/src/com/web/model)
