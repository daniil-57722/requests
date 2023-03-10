<#include "security.ftlh">
<#import "logIn.ftlh" as l>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">🎧</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">Главная</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/main">Заявки</a>
                </li>
                <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/user">Список пользователей</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/registration">Зарегистрировать работника</a>
                </li>
                </#if>
            </ul>
            <div class="navbar-text me-3">${name}</div>
            <@l.logout />
        </div>
    </div>
</nav>