<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'medal.label', default: 'Medal')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <center>
        <a href="#list-medal" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create">Nova Medalha</g:link></li>
            </ul>
        </div>
        <div id="list-medal" class="content scaffold-list" role="main">
            <h1>Lista de Medalhas</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${medalList}" />

            <div class="pagination">
                <g:paginate total="${medalCount ?: 0}" />
            </div>
        </div>
    </center>
    </body>
</html>