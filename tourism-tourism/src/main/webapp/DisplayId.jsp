<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Tourism</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr"
          crossorigin="anonymous"/>
</head>

<body>
<nav class="navbar navbar-expand-lg" style="background-color: pink; ">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link " href="getIndex">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="redirectToTourism">Tourism Form</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="getAllEntity">Get All</a>
                </li>

            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
                <button class="btn btn-outline-success text-dark" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<h4 class="text-center mb-4">Tourism Details</h4>

<p class="text-danger">${errorMessage}</p>

<c:if test="${not empty ref}">

    <div class="d-flex justify-content-center">
        <table class="table table-hover table-bordered w-50">
            <tr>
                <th scope="col">Package Id</th>
                <td>${ref.packageId}</td>
            </tr>
            <tr>
                <th scope="col">Package Name</th>
                <td>${ref.packageName}</td>
            </tr>
            <tr>
                <th scope="col">Destination</th>
                <td>${ref.destination}</td>
            </tr>
            <tr>
                <th scope="col">Price</th>
                <td>${ref.packagePrice}</td>
            </tr>
            <tr>
                <th scope="col">Days</th>
                <td>${ref.days}</td>
            </tr>
            <tr>
                <th scope="col">Person count</th>
                <td>${ref.personCount}</td>
            </tr>
        </table>
    </div>
</c:if>




<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.min.js"
        integrity="sha384-7qAoOXltbVP82dhxHAUje59V5r2YsVfBafyUDxEdApLPmcdhBPg1DKg1ERo0BZlK"
        crossorigin="anonymous"></script>
</body>

</html>