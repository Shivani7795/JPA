<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>registration details</title>
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
                    <a class="nav-link" href="redirecTologin">Login</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div align="center">
    <form action="register" method="post"  class="p-4 border rounded shadow" style="width: 100%; max-width: 600px;">
        <h4 class="text-center mb-4">Login details</h4>
        <h6 class="text-center text-danger mb-4">${message}</h6>


        <div class="mb-3">
            <label for="regName" class="form-label">registerer Name</label>
            <input type="text" class="form-control" id="regName" name="regName" value="${dto.regName}" required>
            <span id="errormail" style="color:red;"></span>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">email</label>
            <input type="email" class="form-control" id="email" name="email" value="${dto.email}" required>
        </div>

        <div class="mb-3">
            <label for="mobile" class="form-label">mobile number</label>
            <input type="number" class="form-control" id="mobile" name="mobile" value="${dto.mobile}" required>
        </div>

        <div class="mb-3">
            <label for="dob" class="form-label">Date of Birth</label>
            <input type="date" class="form-control" id="dob" name="dob" value="${dto.dob}" required>
        </div>

        <div class="mb-3">
            <label for="state" class="form-label">state</label>
            <input type="text" class="form-control" id="state" name="state" value="${dto.state}" required>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">password</label>
            <input type="text" class="form-control" id="password" name="password" value="${dto.password}" required>
        </div>

        <div class="mb-3">
            <label for="cpassword" class="form-label">confirm password</label>
            <input type="text" class="form-control" id="cpassword" name="cpassword" value="${dto.cpassword}" required>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-success">login</button>
        </div>

        <button type="submit" class="btn btn-primary w-100">register</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
</body>
</html>


