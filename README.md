![사진](https://user-images.githubusercontent.com/70089259/136155942-47832cf2-d7fc-4ed7-8668-4aab4686b092.png)

MVC4 is consist of view(jsp) & controller(servlet) & model

controller(servlet)
- insert(interaction DB and redirect to showListController)
- delete(interaction DB and redirect to showListController)
- update(interaction DB and redirect to showListController)
- showList(forward to jsp )
- showPrivateContent(forward to jsp)
- Register(forward to jsp)

- etc
    - viewresolver
    - handlerMapping

view(jsp)
- showList
- showPrivateContent
- showRegister

model
- ModelVO & ModelDVO (use JDBC to MySQL)
