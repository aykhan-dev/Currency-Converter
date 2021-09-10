# Currency-Converter
App has been built by using Java. This project is clean architected and developed according to MVP design pattern. You can see basic implementations of RxJava and GreenDAO libraries. In whole project, Dagger2 is used as a DI tool

# Modular Structure
App has been devided into 4 main modules. UI, DOMAIN, DATA and APP modules. APP module combines other modules in itself. There is a unidirectional flow like this, UI -> DOMAIN -> DATA. 
To provide this flow, repository interfaces and their implementations has been placed in DATA module, and DTO to Domain mapping happens in DOMAIN module. In this case, only DOMAIN can see DATA module.
But, if repository interfaces placed in DOMAIN module and DTO to Domain mapping happened in DATA module, the relation between these two modules would be like DOMAIN <--> DATA

# Used Technologies
App uses Dagger2 for dependency injection. For asynchronous calls, RxJava has been used. Project Lombok is useful for model classes (DTO, Domain models). For database processes, GreenDAO third party library has been used. 
