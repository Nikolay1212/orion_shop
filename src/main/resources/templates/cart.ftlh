<a href="/shop">Вернуться в магазин</a>
<h1>Список покупок</h1>
<#list cart as item>
    <h3>${item.name}</h3>
</#list>
<h4>Общее количество = ${cartCount}</h4>
<h4>Общая сумма = ${total}</h4>
<#list cart as product>
    <form id="${product.id}" method="post" action="/products/${product.id}/add">
    </form>
    <tr>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.price}</td>
        <td><a href="/cart/delete/${product.id}" class="btn btn-danger">Delete</a></td>
    </tr>
</#list>