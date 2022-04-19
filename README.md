# PROGRAMAÇÃO WEB 

## Como usar:
- Clone o repositorio e use a IDE de sua preferencia para abrir/importar os projetos maven.

## Estrutura do maven aplicações web
```ascii
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

```

### REQUISITOS:
- MAVEN (https://maven.apache.org/)
- JAVA 11 (https://openjdk.java.net/)
- TOMCAT 10 (https://tomcat.apache.org/)


BY PROJETOS

>## PROJETO 1:
Projeto criado com maven usando o maven-archetype-webapp como base e atualizando as bibliotecas.

> Criado com maven e adcionado o index.jsp 

```html
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
	<body>
		<h1>ALÔ MUNDO</h1>
	</body>
</html>
```

Run on server...

Acesso: http://localhost:8080/blog/index.jsp


>## PROJETO 2:
Projeto criado com maven usando o maven-archetype-webapp como base e atualizando as bibliotecas.

>Adiocinado o IndexServlet.java

Mapeamento com anotação:
```java
@WebServlet("/index")
```
Mapeamento no web.xml
```xml
<servlet>
    <servlet-name>alias</servlet-name>
    <servlet-class>br.com.mariojp.blog.IndexServlet</servlet-class>
</servlet>  
<servlet-mapping>
    <servlet-name>alias</servlet-name>
    <url-pattern>/index</url-pattern>
</servlet-mapping>
````

- index.jsp
```html
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
	<body>
		<h1>ALÔ MUNDO</h1>
	</body>
</html>
```

- IndexServlet.java
```java
@WebServlet("/index")
public class IndexServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.getWriter().append("<!DOCTYPE html>");
		response.getWriter().append("<html>");
		response.getWriter().append("<head>");
		response.getWriter().append("<meta charset=\"UTF-8\"/>");
		response.getWriter().append("</head>");
		response.getWriter().append("<body>");
		response.getWriter().append("<h1>ALÔ MUNDO SERVLET</h1>");
		response.getWriter().append("</body>");
		response.getWriter().append("</html>");
	}
}
```
Run on server...

Acessos: 
- http://localhost:8080/blog/index.jsp
- http://localhost:8080/blog/index 
- http://localhost:8080/blog/index2


>## PROJETO 3:
Passando paramentos e capturando no arquivo jsp no servlet

> O método HTTP GET solicita uma representação do recurso especificado. Solicitações usando GET só devem recuperar dados.

> Os paramento são enviados para o servidor por meio do par chave e valor. Os parametros podem ser passados ao fim da URL usando uma ? para indicar o primeiro e para passar mais de um parametro pode ser usado o &. Exemplo url?chave=valor&chave2=valor2 


- index.jsp
```html
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
<body>
	<%
		response.getWriter().append("<h1>OLÁ, ");
		String nome = request.getParameter("nome");		
		response.getWriter().append(nome);
		response.getWriter().append("!</h1>");
	%>
</body>
</html>
````

- IndexServlet.java
```java
    //...
    response.getWriter().append("<h1>OLÁ, ");
    String nome = request.getParameter("nome");		
    response.getWriter().append(nome);
    response.getWriter().append("!</h1>");
    //...
```

Run on server...

Acessos: 
- http://localhost:8080/blog/index.jsp?nome=[Seu Nome]
- http://localhost:8080/blog/index?nome=[Seu Nome]


>## PROJETO 4:
Criando formularios para passagem de parametro por HTTP POST e recuperando no servlet e no jsp.

> O método HTTP POST envia dados ao servidor. O tipo do corpo da solicitação é indicado pelo cabeçalho Content-Type. Uma solicitação POST geralmente é enviada por meio de um formulário HTML e resulta em uma alteração no servidor. Nesse caso, o tipo de conteúdo é selecionado colocando a string adequada no atributo enctype do elemento < form > ou o atributo formenctype dos elementos < input > ou < button >

> Os paramento são enviados para o servidor por meio do par chave e valor. Os parametros devem estar contidos nos elementos dentro da tag < form > < /form > e que contem o atributo name, que vai ser a chave. Exemplo: < input name="nome" type="text" > 

- formtoindex.jsp
```html
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
<body>
	<form action="./index.jsp" method="post">
		Campo(nome): <input name="nome" type="text" />
		<button type="submit">Enviar</button>
	</form>
</body>
</html>
```

- index.jsp
```html
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
<body>
	<%
		response.getWriter().append("<h1>OLÁ, ");
		String nome = request.getParameter("nome");		
		response.getWriter().append(nome);
		response.getWriter().append("!</h1>");
	%>
</body>
</html>
```

- formtoservlet.jsp
```html
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
<body>
	<form action="./index" method="post">
		Campo(nome): <input name="nome" type="text" />
		<button type="submit">Enviar</button>
	</form>
</body>
</html>
```

- IndexServlet.java
```java
@WebServlet("/index")
public class IndexServlet extends HttpServlet{

	//doGet modificado para doPost agora esse servlet não respode a chamadas HTTP GET (Erro 405), apenas HTTP POST
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.getWriter().append("<!DOCTYPE html>");
		response.getWriter().append("<html>");
		response.getWriter().append("<head>");
		response.getWriter().append("<meta charset=\"UTF-8\"/>");
		response.getWriter().append("</head>");
		response.getWriter().append("<body>");
		response.getWriter().append("<h1>OLÁ, ");
		
		String nome = request.getParameter("nome");		
		response.getWriter().append(nome);
		response.getWriter().append("!</h1>");

		response.getWriter().append("</body>");
		response.getWriter().append("</html>");
	}
	
}
```

Run on server...

Acessos: 
- http://localhost:8080/blog/formtoindex.jsp
- http://localhost:8080/blog/formtoservlet.jsp


>## PROJETO 5:
Removendo os scriptlets <% %> do JSP e adicionando a biblioteca de tags Jakarta Standard Tag Library (JSTL) e usando Expression Language (EL) 

>A Jakarta Standard Tag Library (JSTL; anteriormente JavaServer Pages Standard Tag Library) é um componente da plataforma de desenvolvimento de aplicativos da Web Java EE. Ele estende a especificação JSP adicionando uma biblioteca de tags JSP para tarefas comuns, como processamento de dados XML, execução condicional, acesso ao banco de dados, loops e internacionalização.

>A Expression Language (EL) simplifica a acessibilidade dos dados armazenados no componente Java Bean, e outros objetos como request, session, application etc. Existem muitos objetos implícitos, operadores e palavras de reserva em EL. É o recurso recém-adicionado na tecnologia JSP versão 2.0.

- pom.xml 

Adicionando a dependencia ao  pom.xml

```xml
<!-- https://mvnrepository.com/artifact/org.glassfish.web/jakarta.servlet.jsp.jstl -->
<dependency>
    <groupId>org.glassfish.web</groupId>
    <artifactId>jakarta.servlet.jsp.jstl</artifactId>
    <version>2.0.0</version>
</dependency>
```

-index.jsp

Adicionando a taglib no jsp
```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
``` 

```html
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
<body>

	<!--  IMPRIMINDO A LISTA DE PARAMETRO NOME -->
	<h1>Imprinmindo parametro nome: ${param.nome}</h1>

	<!--  IMPRIMINDO A LISTA DE PARAMETRO QUE FOREM PASSADOS DINAMICAMENTE -->
	<c:forEach var="p" items="${paramValues}">
    	${p.key} = ${p.value[0]} <br>
	</c:forEach>
  
</body>
</html>
```

- IndexServlet.java

```java
@WebServlet("/index")
public class IndexServlet extends HttpServlet{

	/**
	 * 	doGet modificado para doPost agora esse servlet não respode a chamadas HTTP GET (Erro 405), apenas HTTP POST
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.getWriter().append("<!DOCTYPE html>");
		response.getWriter().append("<html>");
		response.getWriter().append("<head>");
		response.getWriter().append("<meta charset=\"UTF-8\"/>");
		response.getWriter().append("</head>");
		response.getWriter().append("<body>");
		response.getWriter().append("<h1>OLÁ, ");
		
		String nome = request.getParameter("nome");		
		response.getWriter().append(nome);
		response.getWriter().append("!</h1>");
		
		Map<String, String[]> parametros = request.getParameterMap();
		for (Entry<String, String[]> item: parametros.entrySet()) {
			response.getWriter().append(item.getKey() +" = "+item.getValue()[0]);
			response.getWriter().append("<br>");			
		}

		response.getWriter().append("</body>");
		response.getWriter().append("</html>");
						
		
	
	}
	

```


Run on server...

Acessos: 
- http://localhost:8080/blog/formtoindex.jsp
- http://localhost:8080/blog/formtoservlet.jsp


>## PROJETO 6:
Usando o Redirect e o Forward. Neste projeto a ideia é separar a logica de negocio da visualização e apresentar dois componentes importantes em relação ao redirecionamento e repasse de requisições. Tambem utilizamos atributos em escopos diferentes.

> O redirect é usado para enviar ao cliente uma informação o codigo de redirecionamento 302 e o recurso para onde ele deve ir. Como é uma resposta ele provoca que o cliente faça uma nova requisição.

>O forward é usado para repassar uma requisição dentro do proprio servidor. Ele permite por exemplo o uso do jsp como um template para view que sera enviada ao usuario. 

> Escopo de Request: são úteis ao processar os resultados de um formulário enviado. Com o escopo de request, você também garante que nenhuma outra requisição poderá afetar seus objetos nesse escopo de request enquanto sua requisição estiver sendo tratada. Este escopo tem o  tempo de vida equivalente ao da requisição.
> Escopo de Session: Em geral fica associado a um browser. Quando um site é acessado, uma sessão é criada pelo contêiner da web. Portanto, a vida útil da sessão dura enquanto o browser estiver ativo e requisições estejam sendo efetuadas, a sessão pode expiram (tempo padrão 30 minutos) caso não haja interações ao site durante um tempo maior que o configurado para finalizar a sessão. Outra forma é executar o ```session.invalidate()```. Importante que os atributos adicionados nesse escopo podem ser obtidos ou alterados em quanquer requisição dentro da sessão.

Nesse projeto criamos uma pagina de login.jsp que exibe um formulario com os campos usuario e senha. O submit desse formulario cria uma Requisição HTTP POST enviada para o servlet mapeado como /login. No servlet criamos uma logica simples onde se a senha for igual ao login o usuario vai ser considerado valido e vamos redirecionar (302) para um jsp de bemvindo. Caso contrario, o usuario invalido vamos usar o forward para que possamos renderizar o jsp com uma mensagem de erro.

- LoginServlet
```java
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");	
		String senha = request.getParameter("senha");		
		
		if( usuario != null && usuario.equalsIgnoreCase(senha)){
			request.getSession().setAttribute("usuario", usuario);	
			response.sendRedirect("./dashboard.jsp");
		}else{
			String mensagem = "usuario e senha são diferentes!";
			request.setAttribute("erro", mensagem);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./login.jsp");			
			requestDispatcher.forward(request, response);
		}
	}
	
}
```

- login.jsp
```html
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
<body>
	<form action="./login" method="post">
		Usuario: <input name="usuario" type="text" /><br>
		Senha: <input name="senha" type="text" /><br>
		<span style="color: red;">${erro}</span><br>
		<button type="submit">Enviar</button>

	</form>
</body>
</html>
```

- dashboard.jsp
```html
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
    </head>
<body>


	<h1>DASHBOARD</h1>

	Bem vindo, ${usuario}!
  
</body>
</html>

````

Run on server...

Acessos: 
- http://localhost:8080/blog/index.jsp
- http://localhost:8080/blog/login.jsp