<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Quest</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<div class="container text-center mt-5">
    <div class="col-12 text-center fs-2 mt-2 mb-2">
        Добро пожаловать на квест!
    </div>
</div>

<div class="container text-center mt-5">
    <div class="col-12 text-center fs-2 mt-2 mb-2">
        <input type="text" class="form-control" placeholder="Введите имя" aria-label="First name">
    </div>
</div>

<%--img--%>
<div class="container text-center mt-5">
    <div class="col-12 text-center fs-2 mt-2 mb-2">
        <img src="image/start-image.png" height="300px" alt="">
    </div>
</div>


<div class="container text-center mt-5">
    <div class="col-12 text-center fs-2 mt-2 mb-2">
        <button type="button" class="btn col-8 btn-primary" onclick="window.location='/quest?questionId=1'" style="">
            Приступить к квесту
        </button>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>



