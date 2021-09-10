# Currency-Converter
App has been built by using Java. This project is clean architected and developed according to MVP design pattern. You can see basic implementations of RxJava and GreenDAO libraries. In whole project, Dagger2 is used as a DI tool

# Used Technologies
App uses Dagger2 for dependency injection. For asynchronous calls, RxJava has been used. Project Lombok is useful for model classes (DTO, Domain models). For database processes, GreenDAO third party library has been used.

# Modular architecture
Project consists of 4 main modules. App, Domain, UI and Data modules. App modules implements all other modules for combine them in itself. Domain module is independent module and it provides main communication between UI and Data modules. Each of UI and Data modules implements Domain module. By this way, UI and Data modules completely isolated from each other with help of Domain module
