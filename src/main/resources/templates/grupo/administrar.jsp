<!doctype html>
<html lang="en">

<head th:include="layout/base :: head">

</head>

<body>
  <header th:replace="layout/base :: header">
  </header>

  <div class="container py-4">

    <div class="card bg-light">
      <div class="card-header">Crear nuevo grupo</div>
      <div class="card-body">
        <form th:object="${grupo}" th:action="@{/carreras/} + ${carrera.id} + '/grupos/form.jsp'" method="POST">
          <div class="form-group">
            <label for="idProfesor">Profesor</label>
            <select th:field="*{idProfesor}" id="idProfesor" class="form-control">
              <option value="0">Seleccionar Profesor</option>
              <option th:each="profesor : ${profesores}" th:value="${profesor.id}"
                th:text="${profesor.nombre} + ' ' + ${profesor.primerApellido}"
                th:selected="${grupo.idProfesor == profesor.id}"></option>
            </select>
            <small class="form-text text-danger" th:if="${#fields.hasErrors('idProfesor')}"
              th:errors="*{idProfesor}"></small>
          </div>

          <div class="form-group">
            <label for="idMateria">Materia</label>
            <select th:field="*{idMateria}" id="idMateria" class="form-control">
              <option value="0">Seleccionar Materia</option>
              <option th:each="materia : ${materias}" th:value="${materia.id}" th:text="${materia.nombre}"
                th:selected="${grupo.idMateria == materia.id}"></option>
            </select>
            <small class="form-text text-danger" th:if="${#fields.hasErrors('idMateria')}"
              th:errors="*{idMateria}"></small>
          </div>

          <div class="form-group">
            <label for="idHorario">Horario</label>
            <select th:field="*{idHorario}" id="idHorario" class="form-control">
              <option value="0">Seleccionar Horario</option>
              <option th:each="horario : ${horarios}" th:value="${horario.id}" th:text="${horario.detalle}"
                th:selected="${grupo.idHorario == horario.id}"></option>
            </select>
            <small class="form-text text-danger" th:if="${#fields.hasErrors('idHorario')}"
              th:errors="*{idHorario}"></small>
          </div>

          <div class="form-group">
            <label for="idHorario">Horario</label>
            <select th:field="*{idHorario}" id="idHorario" class="form-control">
              <option value="0">Seleccionar Horario</option>
              <option th:each="horario : ${horarios}" th:value="${horario.id}" th:text="${horario.detalle}"
                th:selected="${grupo.idHorario == horario.id}"></option>
            </select>
            <small class="form-text text-danger" th:if="${#fields.hasErrors('idHorario')}"
              th:errors="*{idHorario}"></small>
          </div>

          <div class="form-group">
            <label for="idAula">Aula</label>
            <select th:field="*{idAula}" id="idAula" class="form-control">
              <option value="0">Seleccionar Aula</option>
              <option th:each="aula : ${aulas}" th:value="${aula.id}" th:text="${aula.nombre}"
                th:selected="${grupo.idAula == aula.id}"></option>
            </select>
            <small class="form-text text-danger" th:if="${#fields.hasErrors('idAula')}" th:errors="*{idAula}"></small>
          </div>

          <div class="form-group">
            <label for="grupo">Grupo</label>
            <select th:field="*{grupo}" id="grupo" class="form-control">
              <option value="">Seleccionar Grupo</option>
              <option value="A">A</option>
              <option value="B">B</option>
              <option value="C">C</option>
              <option value="D">D</option>
              <option value="E">E</option>
            </select>
            <small class="form-text text-danger" th:if="${#fields.hasErrors('grupo')}" th:errors="*{grupo}"></small>
          </div>
          <button type="submit" class="btn btn-primary">Guardar</button>
        </form>
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