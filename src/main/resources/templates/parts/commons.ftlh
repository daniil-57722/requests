<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="/static/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <title>ЖКХ Онлайн</title>
    </head>
    <body>
    <#include "navbar.ftlh">

    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js" integrity="sha384-GNFwBvfVxBkLMJpYMOABq3c+d3KnQxudP/mGPkzpZSTYykLBNsZEnG2D9G/X/+7D" crossorigin="anonymous" async></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    <div class="container mt-5">
        <#nested>
    </div>
    </body>
    </html>
</#macro>
<#macro feedback>
    <div class="fixed-bottom d-flex justify-content-end">
        <button class="btn btn-primary mb-3 me-3" type="button" data-bs-toggle="modal" data-bs-target="#modalFeedback"
                aria-expanded="false" aria-controls="collapseExample">✩
        </button>
    </div>
    <div class="modal fade" id="modalFeedback" tabindex="-1" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 id="exampleModalLongTitle">Написать отзыв</h5>
                </div>
                <form method="post" action="/feedback/save">
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="text" class="form-label">Текст отзыва</label>
                            <textarea class="form-control" id="text" name="feedbackText" rows="3"></textarea>
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
</#macro>