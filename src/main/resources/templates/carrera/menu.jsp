<!doctype html>
<html lang="en">

<head th:include="layout/base :: head">

</head>

<body>
  <header th:replace="layout/base :: header">
  </header>

  <div class="container">
    <h1 th:text="${titulo}"></h1>
    <div th:each="carrera: ${carreras}" class="card w-75">
      <div class="card-body">
        <h5 class="card-title" th:text="${carrera.nombre}"></h5>
        <p class="card-text" th:text="${ carrera.clave}"></p>
        <a th:href="@{/carreras/} +  ${carrera.id} + '/administrar.jsp'" class="btn btn-primary">Administrar</a>
      </div>
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