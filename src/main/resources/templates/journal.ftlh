<#import "parts/commons.ftlh" as c>
<@c.page>
    <h3> Заявки журнала <i> ${journal.getName()} </i></h3>



    <div class="modal fade mt-3" id="modalJournal" tabindex="-1" aria-labelledby="exampleModalCenterTitle"
         aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 id="exampleModalLongTitle">Добавить заявку</h5>
                </div>
                <form method="post" action="/request/save">
                    <div class="modal-body">
                        <div class="mb-3">
                            <h5>Заявка</h5>
                            <input type="text" name="serviceName" placeholder="Название услуги" class="form-control"/>
                            <textarea class="form-control mt-3" id="text" name="description" rows="3"
                                      placeholder="Описание"></textarea>
                            <hr>
                            <h5>Заказчик</h5>
                            <input type="text" name="requester" placeholder="ФИО заказчика" class="form-control"/>
                            <div class="row mt-3 mb-3">
                                <div class="col-sm">
                                    <input type="text" name="requesterPhone" placeholder="Телефон"
                                           class="form-control"/>
                                </div>
                                <div class="col-sm">
                                    <input type="text" name="requesterPersonalAccount" placeholder="Лицевой счет"
                                           class="form-control"/>
                                </div>
                            </div>
                            <input type="text" name="requesterAddress" placeholder="Адрес" class="form-control"/>
                            <hr>
                            <h5><label for="exampleDataList" class="form-label">Исполнитель</label></h5>
                            <input class="form-control" list="datalistOptions" id="exampleDataList"
                                   placeholder="Наименование компании" name="companyName">
                            <datalist id="datalistOptions">
                                <#if companies??>
                                <#list companies as company>
                                <#if company.company()??>
                                <option value="${company.company()}">
                                    </#if>
                                    </#list>
                                    </#if>
                            </datalist>
                            <input type="hidden" name="idJournal" value="${journal.getJournalId()}"/>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" data-dismiss="modal">Сохранить</button>
                            </div>
                        </div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="accordion accordion-flush" id="accordionExample">
        <#if requests ??>
            <#list requests as request>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingOne">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseOne${request.getRequestId()}"
                                aria-controls="collapseOne${request.getRequestId()}">
                            ${request.getServiceName()}
                        </button>
                    </h2>
                    <div id="collapseOne${request.getRequestId()}" class="accordion-collapse collapse"
                         aria-labelledby="headingOne"
                         data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <h5><b>Название:</b> ${request.getServiceName()}</h5>
                            <hr>
                            <p><b>Заявитель:</b> ${request.getRequester()}</p>
                            <p><b>Телефон: </b>${request.getRequesterPhone()}</p>
                            <p><b>Номер лицевого счета:</b> ${request.getRequesterPersonalAccount()}</p>
                            <p><b>Адрес:</b> ${request.getRequesterAddress()}
                            <p><b>Описание услуги:</b> ${request.getDescription()}</p>
                            <p><b>Исполнитель:</b> ${request.getCompany().getCompanyName()}</p>
                            <p><b>Статус: </b> ${request.getStatus().getStatusName()}</p>
                            <div class="row">
                                <#if request.getStatus().getStatusName()=="Открыт">
                                    <div class="col-sm-10">
                                        <form method="post" action="/request/done">
                                            <input type="hidden" name="idRequest" value="${request.getRequestId()}">
                                            <input type="hidden" name="idJournal" value="${journal.getJournalId()}"/>
                                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                            <button type="submit" class="btn btn-outline-success">Отметить завершенным</button>
                                        </form>
                                    </div>
                                </#if>
                                <div class="col">
                                    <form method="post" action="/request/delete">
                                        <input type="hidden" name="idRequest" value="${request.getRequestId()}">
                                        <input type="hidden" name="idJournal" value="${journal.getJournalId()}"/>
                                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                        <button type="submit" class="btn btn-outline-danger">Удалить</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </#list>
        </#if>
        <button class="btn btn-primary mt-3 me-3" type="button" data-bs-toggle="modal" data-bs-target="#modalJournal"
                aria-expanded="false" aria-controls="collapseExample">Добавить заявку
        </button>
    </div>
</@c.page>