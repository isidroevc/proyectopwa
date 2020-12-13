<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
xmlns:sec="http://www.thymeleaf.org/extras/spring-security">

<head th:fragment="head">
	<link th:href="@{/carrera/css/styles.css}" href="/carrera/css/styles.css" rel="stylesheet" />
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
    integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

  <title th:text="${titulo}"></title>
</head>

<body>
  <header th:fragment="header">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <a class="navbar-brand" href="#">SIIA 16.X</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">

          <li class="nav-item active">
            <a class="nav-link" th:href="@{/usuarios/perfil.jsp}" sec:authorize="isAuthenticated()">Mi perfil</a>
          </li>
          <li class="nav-item active" sec:authorize="hasAuthority('ADMINISTRADOR')">
            <a class="nav-link" th:href="@{/carreras/listado.jsp}" >Carreras</a>
          </li>
          
          
          <li class="nav-item active" sec:authorize="hasAuthority('ADMINISTRADOR')">
            <a class="nav-link" th:href="@{/profesores/listado.jsp}">Profesores</a>
          </li>
          
          <!-- Opciones para el jefe de carrera -->
          <li class="nav-item active" sec:authorize="hasAuthority('JEFE')">
            <a class="nav-link" th:href="@{/carreras/menu.jsp}" >Mis carreras</a>
          </li>
        </ul>
        <ul class="navbar-nav navbar-right">
					<li sec:authorize="!isAuthenticated()"><a
						class="btn btn-outline-primary" th:href="@{/login}">Sign In</a></li>

					<li sec:authorize="isAuthenticated()" class="dropdown show">
						<a class="btn btn-outline-primary dropdown-toggle" href="#"
							role="button" id="dropdownMenuLink" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"><span sec:authentication="name"></span></a>

						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<form id="logoutForm" th:action="@{/logout}" method="post">
								<button class="dropdown-item" onclick="document.getElementById('logoutForm').submit();" type="submit">Sign Out</button>
								<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}"/>
							</form>
							
						</div>
					</li>
				</ul>
      </div>
    </nav>
  </header>
  <h1 th:text="${titulo}"></h1>


  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
    crossorigin="anonymous"></script>
</body>

</html>