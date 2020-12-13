<!doctype html>
<html lang="en">

<head th:include="layout/base :: head">
	
</head>

<body>
  <header th:replace="layout/base :: header">
  </header>
  
 	<div class="container">
    <h1 th:text="${titulo}"></h1>
    <div class="row">
      <a th:href="@{/profesores/form.jsp}" class="col-md-1"> <button class="btn btn-primary ">Crear profesor</button> </a>
    </div>
    <div class="row">
      <table class="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Carrera</th>
            <th>Editar</th>
          </tr>
        </thead>
        <tbody>
          <tr th:each="profesor : ${profesores}">
            <td th:text="${profesor.id}"></td>
            <td th:text="${profesor.nombre} + ' ' + ${profesor.primerApellido} + ' ' + ${profesor.segundoApellido}"></td>
            <td th:text="${profesor.carrera.nombre}"></td>
            <td> <a th:href="@{/profesores/form/} + ${profesor.id}"><button class="btn btn-warning">Editar</button></a> </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
    crossorigin="anonymous"></script>
</body>

</html>