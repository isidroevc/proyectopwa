<!doctype html>
<html lang="en">

<head th:include="layout/base :: head">
	
</head>

<body>
  <header th:replace="layout/base :: header">
  </header>
  
 	<div class="container">
    <h1 th:text="${titulo}"></h1>
    <div class="card bg-light" sec:authorize="hasAuthority('JEFE')">
      <div class="card-header">Seleccione un archivo/div>
      <div class="card-body table-responsive">
        <form class="form" th:action="@{/carreras/} + ${carrera.id} + '/materias/formCSV.jsp'" method="POST" id="form">
          <div class="form-group">
            <input type="hidden" name="claves" id="claves">
            <input type="hidden" name="nombres" id="nombres">
            <input type="hidden" name="creditos" id="creditos">
            <label for="archivo">Archivo</label>
            <input type="file" id="archivo">
          </div>
          <button class="btn btn-primary">
            Finalizar Carga
          </button>
        </form>
      </div>
    </div>

    <div class="card bg-light">
      <div class="card-header">Vista previa de los datos</div>
      <div class="card-body table-responsive">
        <table class="table" id="table">
          <thead>
           <tr>
             <th>Clave</th>
             <th>Materia</th>
             <th>creditos</th>
           </tr>
          </thead>
          <tbody id="tableContent">
          </tbody>
        </table>
      </div>
    </div>

  </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"crossorigin="anonymous"></script>
  <script>
    const fileInput = document.getElementById('archivo');
    const tableBody = document.getElementById('tableContent');
    function processContent(content) {
      const lines = content.split('\n');
      const materias = [];
      if (lines.length == 0) return;
      for(const line of lines) {
        const parts = line.split(';');
        materias.push({
          clave: parts[0],
          nombre: parts[1],
          creditos: parts[2]
        });
      }
      renderizarMaterias(materias);
    }

    function renderizarMaterias(materias) {
      const claves = materias.map(materia => materia.clave);
      const nombres = materias.map(materia => materia.nombre);
      const creditos = materias.map(materia => materia.creditos);
      document.getElementById('claves').value = claves.join(',');
      document.getElementById('nombres').value = nombres.join(',');
      document.getElementById('creditos').value = creditos.join(',');
      tableBody.innerHTML = materias.map(materia => {
        return `
          <tr>
            <td>${materia.clave}</td>
            <td>${materia.nombre}</td>
            <td>${materia.creditos}</td>   
          </tr>
        `;
      })
    };


    fileInput.onchange = function() {
        console.log(this.files);
      const file = this.files[0];
      const reader = new FileReader();
      reader.onload = (function(reader)
        {
            return function()
            {
                processContent(reader.result)
            }
        })(reader);
        reader.readAsText(file);
    };

    const form = document.getElementById('form');
    form.onsubmit = function() {
        const input = document.querySelector('#archivo');
        input.parentNode.removeChild(input);
        return true;
    }

  </script>
</body>

</html>