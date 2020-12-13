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
      <a th:href="@{/carreras/} + ${carrera.id} + '/grupos/form.jsp'" class="col-md-1"> <button
        class="btn btn-primary ">Crear grupo</button> </a>
      </a>
    </div>
    <div class="card bg-light">
      <div class="card-header">Crear nuevo grupo</div>
      <div class="card-body table-responsive">
        <table class="table" id="table">
          <thead>
            <tr>
              <th>ClaveHorario</th>
              <th>ClaveMateria</th>
              <th>ClaveCarrera</th>
              <th>Materia</th>
              <th>Carrera</th>
              <th>Maestro</th>
              <th>Periodo</th>
              <th>Turno</th>
              <th>Grupo</th>
              <th>NoAlumnos</th>
              <th>Semestre</th>
              <th>Creditos</th>
              <th>Salon</th>
              <th>Lunes</th>
              <th>Martes</th>
              <th>Miercoles</th>
              <th>Jueves</th>
              <th>Viernes</th>
              <th>Eliminar</th>
            </tr>
          </thead>
          <tbody>
            <tr th:each="grupo : ${grupos}">
              <td th:text="${grupo.id}"></td>
              <td th:text="${grupo.materia.clave}"></td>
              <td th:text="${grupo.carrera.clave}"></td>
              <td th:text="${grupo.materia.nombre}"></td>
              <td th:text="${grupo.carrera.nombre}"></td>
              <td
                th:text="${grupo.profesor.nombre} + ' ' + {grupo.profesor.primerApellido} + ' ' + {grupo.profesor.segundoApellido}">
              </td>
              <td th:text="'Agosto - Diciembre'"></td>
              <td th:text="${grupo.horario.turno}"></td>
              <td th:text="${grupo.grupo}"></td>
              <td th:text="${grupo.numeroAlumnos}"></td>
              <td th:text="${grupo.semestre}"></td>
              <td th:text="${grupo.materia.creditos}"></td>
              <td th:text="${grupo.aula.nombre}"></td>
  
              <td th:if="${grupo.horario.dias == 'L-M-V'}">${grupo.horario.detalle}</td>
              <td th:if="${grupo.horario.dias == 'L-M-V'}"></td>
              <td th:if="${grupo.horario.dias == 'L-M-V'}">${grupo.horario.detalle}</td>
              <td th:if="${grupo.horario.dias == 'L-M-V'}"></td>
              <td th:if="${grupo.horario.dias == 'L-M-V'}">${grupo.horario.detalle}</td>
  
  
              <td th:if="${grupo.horario.dias == 'Ma-J-V'}"></td>
              <td th:if="${grupo.horario.dias == 'Ma-J-V'}">${grupo.horario.detalle}</td>
              <td th:if="${grupo.horario.dias == 'Ma-J-V'}"></td>
              <td th:if="${grupo.horario.dias == 'Ma-J-V'}">${grupo.horario.detalle}</td>
              <td th:if="${grupo.horario.dias == 'Ma-J-V'}">${grupo.horario.detalle}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

  </div>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous">
</script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
    crossorigin="anonymous"></script>
    <script>
    $('#table').DataTable({
  	  "scrollX": true
  	  });

    </script>
</body>

</html>