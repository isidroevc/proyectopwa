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
      <form th:object="${profesor}" method="POST">
        <input type="hidden" th:field="*{id}" class="form-control" id="id" required disabled>
        <div class="form-group">
          <label for="nombre">Nombre</label>
          <input type="text" th:field="*{nombre}" class="form-control" id="nombre" required disabled>
          <small class="form-text text-danger" th:if="${#fields.hasErrors('nombre')}" th:errors="*{nombre}"></small>
        </div>
        <div class="form-group">
          <label for="primerApellido">Primer apellido</label>
          <input th:field="*{primerApellido}" type="text" class="form-control" id="primerApellido" required disabled>
          <small class="form-text text-danger" th:if="${#fields.hasErrors('primerApellido')}"
            th:errors="*{primerApellido}"></small>
        </div>
        <div class="form-group">
          <label for="primerApellido">Segundo apellido</label>
          <input th:field="*{segundoApellido}" type="text" class="form-control" id="segundoApellido" required disabled>
          <small class="form-text text-danger" th:if="${#fields.hasErrors('segundoApellido')}"
            th:errors="*{segundoApellido}"></small>
        </div>
        <div class="form-group">
          <label for=username>Username</label>
          <input th:field="*{username}" type="text" class="form-control" id="username" required disabled>
          <small class="form-text text-danger" th:if="${#fields.hasErrors('username')}" th:errors="*{username}"></small>
        </div>
        <div class="form-group">
          <label for=username>Email</label>
          <input th:field="*{email}" type="text" class="form-control" id="email" required disabled>
          <small class="form-text text-danger" th:if="${#fields.hasErrors('email')}" th:errors="*{email}"></small>
        </div>
        <div class="form-group">
          <label for=username>Tel�fono</label>
          <input th:field="*{telefono}" type="text" class="form-control" id="telefono" required disabled>
          <small class="form-text text-danger" th:if="${#fields.hasErrors('telefono')}" th:errors="*{telefono}"></small>
        </div>
        <div class="form-group">
          <label for="idCarrerea">Rol</label>
          <select th:field="*{role}" id="idCarrera" class="form-control" disabled>
            <option value="PROFESOR" th:selected="${profesor.role == 'PROFESOR'}">Profesor</option>
            <option value="JEFE" th:selected="${profesor.role == 'JEFE'}">Jefe</option>
          </select>
          <small class="form-text text-danger" th:if="${#fields.hasErrors('role')}" th:errors="*{idCarrera}"></small>
        </div>
        <div class="form-group">
          <label for="idCarrerea">Carrera</label>
          <select th:field="*{idCarrera}" id="idCarrera" class="form-control" disabled>
            <option th:each="carrera : ${carreras}" th:value="${carrera.id}" th:text="${carrera.nombre}"
              th:selected="${profesor.idCarrera== carrera.id}"></option>
          </select>
          <small class="form-text text-danger" th:if="${#fields.hasErrors('idCarrera')}"
            th:errors="*{idCarrera}"></small>
        </div>
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