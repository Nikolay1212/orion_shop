<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <title>Товары</title>
</head>
<body>
<h1>Список товаров</h1>
<table id="usersTable">
    <thead>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Category</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <#list products as product>
        <form id="${product.id}" method="post" action="/products/${product.id}/add">
        </form>
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.category.name}</td>
            <td>${product.price}</td>
            <td><a href="/admin/product/delete/${product.id}" class="btn btn-danger">Delete</a></td>
        </tr>
    </#list>
    </tbody>
    <form action="/admin/products/add" method="post">
        <div class="row">
            <div class="col-sm-5">
                <input id="name" type="text" name="name" placeholder="Name">
                <input id="description" type="text" name="description" placeholder="Description">
                <input id="price" type="text" name="price" placeholder="Price">
            </div>
            <div>
                <select name="categoryId">
                    <#list categories as category>
                        <option value=${category.id}>${category.name}</option>
                    </#list>
                </select>
            </div>
            <input type="submit" value="Add product">
        </div>
    </form>
</table>
</body>
</html>