<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<li class="nav-item active">
    <a class="nav-link" th:href="@{/admin}" href="/admin">admin-home</a>
</li>
<li class="nav-item active">
    <a class="nav-link" th:href="@{/logout}" href="/logout">logout</a>
</li>
<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <form action="/admin/categories/add" method="post" th:object="${category}">
                <input type="hidden" name="id"  th:field="*{id}">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" required th:field="*{name}" name="name" id="name"  placeholder="Enter name">

                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>