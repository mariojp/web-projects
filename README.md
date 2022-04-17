# PROGRAMAÇÃO WEB 

## Como usar:
- Clone o repositorio e use a IDE de sua preferencia para abrir/importar os projetos maven.

## Estrutura do maven aplicações web
````
projeto
|-- pom.xml
`-- src
    |-- main
    |   |-- java
    |   |   `-- br
    |   |       `-- com           
    |   |           `-- mariojp
    |   |               `-- blog
    |   |                   `-- App.java
    |   |-- resources+
    |   |
    |   `-- webapps
    |       |-- WEB-INF
    |       |   |-- classes+
    |       |   |-- lib+
    |       |   `-- web.xml   
    |       `-- index.jsp
    | 
    |-- test
    |   |-- java
    |   |   `-- br
    |   |       `-- com           
    |   |           `-- mariojp
    |   |               `-- blog
    |   |                   `-- AppTest.java
    |   `-- resources+ 

````
BY PROJETOS

## PROJETO 1:

Projeto criado com maven usando o maven-archetype-webapp como base e atualizando as bibliotecas.

- index.jsp 
- web.xml

Run on server...

Acesso: http://localhost:8080/blog


### REQUISITOS:
- MAVEN (https://maven.apache.org/)
- JAVA 11 (https://openjdk.java.net/)
- TOMCAT 10 (https://tomcat.apache.org/)

