<!doctype html>
<html lang="en" xmlns:c="">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="getIndex">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="redirectToMakeup">order Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ShowAllProducts">Show Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="d-flex justify-content-center">
    <table class="table table-hover w-75">
        <thead>
        <tr>
            <th scope="col">Product Id</th>
            <th scope="col">Product Name</th>
            <th scope="col">Brand</th>
            <th scope="col">Price</th>
            <th scope="col">Item Count</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ref" items="${listOfDto}">
            <tr>
                <td>${ref.productId}</td>
                <td>${ref.productName}</td>
                <td>${ref.brand}</td>
                <td>${ref.price}</td>
                <td>${ref.itemCount}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
</body>
</html>


<h2>Buy Makeup Products</h2>
<p>${message}</p>

<p><strong>Product Name:</strong> ${dto.productName}</p>
<p><strong>Brand:</strong> ${dto.brand}</p>
<p><strong>Product Price:</strong> ${dto.price}</p>
<p><strong>Item Count:</strong> ${dto.itemCount}</p>
