<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="/images/logo.png" src="../static/images/logo.png" width="auto" height="40"
                 class="d-inline-block align-top" alt=""/>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto"></ul>
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="/" href="#">home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/shop" href="#">shop</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" sec:authorize="isAnonymous()" href="/signIn" href="#">login</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" sec:authorize="isAuthenticated()" href="/logout" href="#">logout</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="/cart">cart</a>
                </li>
                <li class="nav-item active">
                    <span class="nav-link" text=${cartCount}>0</span>
                </li>
            </ul>

        </div>
    </div>
</nav>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-sm-3">
            <h4>Categories</h4>
            <ul class="list-group">
                <a href="/shop">
                    <li class="list-group-item">All Products</li>
                    <#list categories as category>
                </a>
                <a href="/shop/category/${category.id}">
                    <li>
                            <h5>${category.name}</h5>
                    </li>
                    </#list>
                </a>

            </ul>
        </div>
        <div class="col-sm-9">
            <#list products as product>
                <div class="row no-gutters">
                    <div class="col-sm-7 d-flex justify-content-center">
                        <div class="card-body">
                            <h4>${product.name}</h4>
                            <h4>${product.price}</h4>
                            <h4>${product.description}</h4>
                            <a href="/shop/viewProduct/${product.id}" class="btn btn-primary">View Product</a>
                            <a href="/shop/addToCart/${product.id}" class="btn btn-primary">Add Product</a>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</div>
