<!doctype html>
<html lang="en">

<head th:include="layout/base :: head">
	
</head>

<style>
  div.menu {
    display: flex;
    justify-content: center;
    width: 40%;
    }
    button.btn-menu {
      margin-top: 30px;
    }
</style>

<body>
  <header th:replace="layout/base :: header">
  </header>
  
 	<div class="container">
    <h1>Menú</h1>
    <div class="menu-container">
      <button class="btn btn-primary btn-menu">Carreras</button>
      <button class="btn btn-primary btn-menu">Profesores</button>
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