<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Quest</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>


<div class="container text-center mt-5">
    <button type="button" class="btn btn-outline-info" data-bs-toggle="modal" data-bs-target="#myModal">Статистика
    </button>
</div>

<!-- Vertically centered modal -->
<div class="modal-dialog modal-dialog-centered">
    <div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="myModalLabel">Статистика</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Квест проходит: ${sessionScope.get("username")} <br>
                    Всего сыграно: ${sessionScope.get("countGames")}
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыть</button>
                </div>
            </div>
        </div>
    </div>
</div>

<%--question--%>
<div class="container text-center mt-5">
    <div class="col-12 text-center fs-2 mt-2 mb-2">
        ${requestScope.question.text}
    </div>
</div>

<%--img--%>
<div class="container text-center mt-5">
    <div class="col-12 text-center fs-2 mt-2 mb-2">
        <img src=${requestScope.question.imageLink} height="300px" alt="">
    </div>
</div>

<%--buttons/answers--%>
<div class="container text-center mt-5">
    <div class="row">
        <c:forEach var="answer" items="${requestScope.question.answers}">
            <div class="col-6">
                <button type="button" class="btn col-8 btn-primary"
                        onclick="window.location='/quest?questionId=${answer.nextQuestionId}&answerId=${answer.id}'"
                        style="">
                        ${answer.text}
                </button>
            </div>
        </c:forEach>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</body>
</html>



