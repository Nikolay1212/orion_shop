<form method="post" action="/list">
    <div>
        <input id="name" type="text" name="name" placeholder="Name">
    </div>
    <div>
        <input id="price" type="text" name="price" placeholder="Price">
    </div>
    <div>
        <input id="description" type="text" name="description" placeholder="Description">
    </div>
    <div>
        <select name="categoryId">
            <#list categories as category>
                <option value=${category.id}>${category.name}</option>
            </#list>
        </select>
    </div>
    <div><input type="submit" value="Sign In"/></div>
</form>

<#--                <option value=${font}>${font.nameFont?ifExists}</option>-->