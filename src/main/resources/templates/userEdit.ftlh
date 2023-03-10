<#import "parts/commons.ftlh" as c>
<@c.page>
    <h3>Редактирование данных</h3>
    <br>
    <form action="/user" method="post">
        <input type="text" style="width: 300px" name="username" class="form-control" value="${user.getFullName()}">
        <div class="form-check form-switch mt-2">
            <input class="form-check-input" type="checkbox" id="flexSwitchCheckChecked"
                   name="admin" ${(user.getRole().getRoleName() == "Администратор")?string("checked", "")}>
            <label class="form-check-label" for="flexSwitchCheckChecked">Администратор</label>
        </div>
        <input type="hidden" value="${user.getUserId()}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button class="btn btn-primary mt-2" type="submit">Сохранить</button>
    </form>
    <div class="col">
        <form method="post" action="/user/${user.getUserId()}">
            <input type="hidden" name="user" value="${user.getUserId()}">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit" class="btn btn-outline-danger mt-2">Удалить</button>
        </form>
    </div>
</@c.page>