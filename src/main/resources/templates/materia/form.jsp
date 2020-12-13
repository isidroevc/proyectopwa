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
      <form th:object="${materia}" th:action="@{/carreras/} + ${carrera.id} + '/materias/form.jsp'" method="POST">
        <div class="form-group">
          <label for="clave">Clave</label>
          <input type="text" th:field="*{clave}" class="form-control" id="clave" required>
          <small class="form-text text-danger" th:if="${#fields.hasErrors('clave')}" th:errors="*{clave}"></small>
        </div>
        <div class="form-group">
          <label for="nombre">Nombre</label>
          <input th:field="*{nombre}" type="text" class="form-control" id="nombre" >
          <small class="form-text text-danger" th:if="${#fields.hasErrors('nombre')}" th:errors="*{nombre}"></small>
        </div>
        <div class="form-group">
          <label for="nombre">Créditos</label>
          <input th:field="*{creditos}" type="number" class="form-control" id="creditos" required min=4 max=6>
          <small class="form-text text-danger" th:if="${#fields.hasErrors('creditos')}" th:errors="*{creditos}"></small>
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
      </form>
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