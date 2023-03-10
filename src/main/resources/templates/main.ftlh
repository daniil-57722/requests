<#import "parts/commons.ftlh" as c>
<@c.page>
    <div class="row">
        <div class="col-11">
            <h3>Журналы</h3>
        </div>
        <div class="col">
            <button disabled class="badge bg-secondary rounded-pill" data-bs-toggle="tooltip"
                    title="На данной странице отображен список Ваших журналов с количеством открытых заявок в каждом, а также можно создать новый журнал">
                ?
            </button>
        </div>
    </div>
    <div class="modal fade" id="modalJournal" tabindex="-1" aria-labelledby="exampleModalCenterTitle"
         aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 id="exampleModalLongTitle">Добавить журнал</h5>
                </div>
                <form method="post" action="/journal/add">
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="text" class="form-label">Название</label>
                            <textarea class="form-control" id="text" name="journalName" rows="3"></textarea>
                        </div>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" data-dismiss="modal">Сохранить</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <ul class="list-group list-group-flush mt-3">
        <#if journals??>
            <#list journals as journal>
                <a href="/journal/${journal.getJournalId()}"
                   class="list-group-item list-group-item-action d-flex justify-content-between align-items-center"
                   aria-current="true">
                    ${journal.getName()}
                    <span class="badge bg-primary rounded-pill">${journal.getOpenRequestCount()}</span>
                </a>
            </#list>
        </#if>
    </ul>

    <button class="btn btn-primary mt-3 me-3" type="button" data-bs-toggle="modal" data-bs-target="#modalJournal"
            aria-expanded="false" aria-controls="collapseExample">Добавить журнал
    </button>




</@c.page>