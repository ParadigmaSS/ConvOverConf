<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'modality.label', default: 'Modality')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <center>
        <a href="#list-modality" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create">Nova Modalidade</g:link></li>
            </ul>
        </div>
        <div id="list-modality" class="content scaffold-list" role="main">
            <h1>Lista de Modalidades</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${modalityList}" />

            <div class="pagination">
                <g:paginate total="${modalityCount ?: 0}" />
            </div>
        </div>
    </center>
    </body>
</html>