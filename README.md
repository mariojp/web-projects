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



>## PROJETO 7:
No projeto anterior temos uma tela de login.jsp um dashboard.jsp e um index.jsp todos estão dentro do ```/src/main/webapps/``` e por isso podem ser acessados pelo navegador e esses recursos estão mapeados pelo proprio nome do arquivo. Em ```src/main/java/ temos os Sevlets ```IndexServlet.java``` e ```LoginServlet.java```mapeados pela anotação ```@WebServlet``` como ```/index```e ```/login``` respectivamente. Outra coisa que é possivel observar é que os arquivos ```.jsp```respondem a HTTP GET e a HTTP Post não fazendo uma distinção, já os Servlets voce pode definir o metodo ```doPost``` para atender a requisições HTTP POST e ou o metodo ```doGet``` para atender as requisições do tipo HTTP GET.

>Para garantir que só alguem altenticado acesse ao dashboard.jsp poderiamos adicionar ao arquivo um codigo que testa se existe um usuario na session e caso não exista ele redireciona para o login.jsp:

```java
<%
String usuario = (String) session.getAttribute("usuario");
if(usuario == null){
	response.sendRedirect("./login");
}
%>
```

ou uma versão melhorada (JSTL e EL) :

```html
<c:if test="${usuario == null}">
	<c:redirect url="/login.jsp" />
</c:if>
```

Isso não é legal porque voce precisaria fazer isso em todos os jsp e Servlets onde precisa checar se existe usuario autenticado (ou seja se ele está na session).

Vamo a uma solução, podemos usar um ```Filter``` 

>Filter é um objeto que pode transformar o cabeçalho e o conteúdo (ou ambos) de um request ou response. Os filtros geralmente não criam um response. Os filtro fornecem funcionalidades que pode ser “transversais” a qualquer tipo de recurso da web.  As principais tarefas que um filtro pode realizar são as seguintes:
>
>-Verificar o request e tomar uma ação.
>
>-Bloquear uma requisição.
>
>-Modificar os cabeçalhos e dados da requisição.
>
>-Modifique os cabeçalhos e dados de resposta.
>
>- Interagir com recursos externos.
>
>Os filtros podem ser aplicados para: autenticação, registro em log, conversão de imagem, compactação de dados, criptografia, fluxos de tokenização, transformações XML e assim por diante.

Então vamo criar um filtro para verificar se existe usuario autenticado.
- AutenticacaoFilter.java
```java
@WebFilter("/dashboard.jsp")
public class AutenticacaoFilter extends HttpFilter {
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request; 
		HttpServletResponse httpResponse = (HttpServletResponse) response; 	
		Object usuario = httpRequest.getSession().getAttribute("usuario");
		if(usuario == null ) {
			httpResponse.sendRedirect("./login.jsp");
		}else {
			// passar a requisição adiante 
			chain.doFilter(request, response);
		}
		
	}
}
```

Então toda vez que uma requisição for efetuada para o recurso ```@WebFilter("/dashboard.jsp")``` o filtro vai capturar e testar. Se ```usuario == null``` então ele vai redirecionar para ```login.jsp```, senão ele da continuidade a requisição.


Run on server...

Acessos: 
- http://localhost:8080/blog/index.jsp
- http://localhost:8080/blog/login.jsp

>## PROJETO 8:
Vamos agora nos voltar para o negocio a organização do projeto, nosso objetivo é ter um blog. Vamos adotar uma empacotamento baseado em **camadas ou layers**.

A estrutura de pacotes baseada em camadas:

```ascii
java
|-- br
	`-- com
    	`-- mariojp
    	   	`-- blog
       		   	`-- controller
				|-- model
    			|-- repository
				|-- service
				|-- filter
				|-- util
```

> Controller (controller) o objetivo desse pacote é conter todos os Servlets que vão reprensentar controllers. Deste modo, toda requisição criada pelo usuário deve passar pelo controller, e este então se comunica com o model.

> Model (model): a funcão desse pacote é reperentar o modelo de negocio. As classes desse pacote é responsável por manter e lidar com as informações.

> Repository: pacote vai conter as classes que fazem acesso ao banco de bados ou outra forma de armazenamento dos dados.

> Service: nesse pacote estão as classes que vão conter as regras de negocio.

> Filter: pacote onde colocamos os as classes que tem as funcionalidades ligadas a FIlters

> Util; nomalmente um pacote onde podemos colocar classes com funções de biblioteca ou generias que serão usadas e que não se encaixam nas outras especificações.

Um parenteses 

(

Vale apena se aprofundar mas vou só levantar a questão.

Model View Controller (MVC) e Camadas não são a mesma coisa.

>Estilos arquiteturais referem-se a uma terminologia que caracteriza, através aparência estética, componentes de software cujo o design seja notável e identificável a partir de uma visão do nível mais alto de abstração. Quando definimos o estilo arquitetural de nosso software estamos interessados em prever como as camadas e módulos irão comunicar-se, identificando e isolando suas responsabilidades. Existem diferentes tipos de estilos arquiteturais, podendo ainda serem combinados produzindo estilos híbridos adicionais.

> Padrões arquiteturais possuem natureza conceitual, sendo aplicados com flexibilidade variando seu nível de granularidade em seu escopo de aplicação. A diferença entre estilos e padrões arquiteturais ocorre no escopo do problema a ser resolvido.

)

Voltando ao codigo:

Distribui as classes que já existiam no pacote de controller. Criei a classe ``` Usuario.java``` no pacote model. 

```java
public class Usuario {
	
	private String login;
	
	private String password;
	
	//get's e set's omitidos

}
```

Criei tambem uma classe ```UsuarioDAO.java```  para representar a persistencia dos objetos.

```java
public class UsuarioDAO {
	//Abstração de uma "tabela de usuarios"
	private static Map<String,Usuario> usuarios = new HashMap<String,Usuario>();
	//uma estrategia para que sempre que essa classe crie um suario 
	//login: root e senha: 1234
	static {
		if(usuarios.isEmpty()) {
			Usuario usuario = new Usuario();
			usuario.setLogin("root");
			usuario.setPassword("1234");
			usuarios.put(usuario.getLogin(), usuario);
		}
	}
	
	public List<Usuario> findAll(){ ... }
	
	public Usuario save(Usuario usuario) { ... }
	
	public Usuario findByLogin(String login) { ... }
	
	public Usuario delete{ ... }
	
```

Classe ```UsuarioService.java``` que vai conter as regras de negocio.

```java

```

As demais classes foram um Filtro para Verificar se esta autenticado os servlets para todas as requisições.

O projeto agora tem tambem novos arquivos JSP e alguns que não devem ser acessados sem autenticação como ```usuarios.jsp```que possui a lista de usuarios ou ```usuarioform.jsp``` que é o formulario para adicionar um novo usuario ou editar um usuario existente. 
Então o filtro ficaria algo assim:
```java
@WebFilter(urlPatterns = {"/dashboard.jsp", "/usuarios.jsp","/usuarioform.jsp"})
```
Não me me parece uma boa ideia, porque sempre que há que sugir um novo jsp ou servlet devemos adicionar ao mapeamento. Uma opção é criar uma pasta  ```webapp\autenticado\``` e colocar todos os recursos onde seja necessario estar autenticado (jsp) lá. Nosso filtro passaria a ter esse formato:

```java
@WebFilter(urlPatterns = "/autenticado/*")
```

Nesse caso os servelts que necessitam de autenticação também teriam que ter ```autenticado``` em seu mapeamento. Exemplo:

```java 
@WebServlet("/autenticado/usuario/alterar")
public class UsuarioEditarServlet extends HttpServlet{ ... }
```

Outra coisa muito comum de se encontrar em algumas aplicações é colocar os jsp dentro da pasta ```webapp\WEB-INF```, nesse caso os arquivos lá não são mais acessiveis externamente, ou seja, não há mais mapeamento direto pela url. Nesse caso é necessario o acesso via Servlet usando o ```forward``` e o jsp assume claramente o papel de view/template.

Vamos adotar essa abordagem e para que nossa pagina inicial não fique com 404 ao colocar o index.jsp dentro do ```WEB-INF``` vamos adicionar ao web.xml um welcome file para nosso servlet inicial.

```webapp\WEB-INF\web.xml```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="4.0" xmlns="http://xmlns.jcp.org/xml/ns/javaee"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee 
   http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd">

	<display-name>Blog</display-name>
	<description>Sample Blog class</description>

    <welcome-file-list>
    	<welcome-file>index</welcome-file>
    </welcome-file-list>
    
</web-app>
```

IndexServlet.java
```java
@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");			
		requestDispatcher.forward(request, response);
	}

}
```

Agora temo como criar usuarios e alterar seus dados.

>## PROJETO 9:
Adicionar Banco de Dados JDBC
TODO: Adicionar Post e comentarios


>## PROJETO 10:
Adicionar Bootstrap
TODO: Adicionar Post e comentarios


>## PROJETO 11:
Alterar para empacotamento por funcionalidades by feature

>## PROJETO 12:
Colocar tomcat embarcado e rodar no heroku