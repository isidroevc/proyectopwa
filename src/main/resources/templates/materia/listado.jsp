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
      <a th:href="@{/carreras/} + ${carrera.id} + '/materias/form.jsp'" class="col-md-1"> <button
          class="btn btn-primary ">Crear materia</button> </a>
    </div>
    <div class="row">
      <div class="container">
        <form action="@{/carreras/} + ${carrera.id} + '/materias/filepreview.jsp" class="form" method="POST">
          <input type="file" class="" name="file" required>
          <button class="btn btn-primary" onclick="return dialog('Esta seguro de querer subir el archivo?')">
            Subir archivo
          </button>
        </form>
      </div>
    </div>
    <div class="row">
      <table class="table">
        <thead>
          <tr>
            <th>Clave</th>
            <th>Nombre</th>
            <th>Editar</th>
            <th>Eliminar</th>
          </tr>
        </thead>
        <tbody>
          <tr th:each="materia : ${materias}">
            <td th:text="${materia.clave}"></td>
            <td th:text="${materia.nombre}"></td>
            <td> <a th:href="@{/carreras/} + ${carrera.id} + '/materias/' + ${materia.id}+ '/form.jsp'"><button
                  class="btn btn-warning">Editar</button></a> </td>
            <td> <a th:href="@{/carreras/} + ${materia.id}"><button class="btn btn-danger">Eliminar</button></a> </td>
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