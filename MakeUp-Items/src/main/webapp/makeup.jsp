<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: blue; ">
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
            </ul>
        </div>
    </div>
</nav>

<div align="center">
<form action="items" method="post"  class="p-4 border rounded shadow" style="width: 100%; max-width: 600px;">
    <h4 class="text-center mb-4">buy makeup products</h4>
    <h6 class="text-center text-danger mb-4">${message}</h6>


    <div class="mb-3">
        <label for="productName" class="form-label">product Name</label>
        <input type="text" class="form-control" id="productName" name="productName" value="${dto.productName}" required>
    </div>

    <div class="mb-3">
        <label for="brand" class="form-label">brand</label>
        <input type="text" class="form-control" id="brand" name="brand" value="${dto.brand}" required>
    </div>

    <div class="mb-3">
        <label for="price" class="form-label">product Price</label>
        <input type="number" step="any" class="form-control" id="price" name="packagePrice" value="${dto.price}" required>
    </div>

    <div class="mb-3">
        <label for="itemCount" class="form-label">item Count</label>
        <input type="number" class="form-control" id="itemCount" name="itemCount" value="${dto.itemCount}" required>
    </div>

    <div class="text-center">
        <button type="submit" class="btn btn-success">Order</button>
    </div>

</form>
</div>



</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>

</html>


