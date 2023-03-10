<#import "parts/commons.ftlh" as c>
<@c.page>

    <h3>Список пользователей</h3>
    <form class="row g-2" method="post" action="/user/found">
        <div class="col-auto">
            <input type="text" name="username" class="form-control">
        </div>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <div class="col-auto">
            <button class="btn btn-outline-primary" type="submit">Найти</button>
        </div>
    </form>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>Логин</th>
            <th>ФИО</th>
            <th>Роль</th>
            <th></th>
        </tr>
        </thead>
        <tr>
            <#list users as user>
            <#if user.getRole().getRoleName()=="Администратор">
        <tr class="table-secondary">
            <#else>
        <tr>
            </#if>
            <td>${user.getLogin()}</td>
            <td>${user.getFullName()}</td>
            <td>${user.getRole().getRoleName()}</td>
            <td><a href="/user/${user.getUserId()}" class="btn btn-outline-success">Изменить</a></td>
        </tr>
        </#list>
    </table>
</@c.page>