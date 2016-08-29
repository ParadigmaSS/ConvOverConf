<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'athlete.label', default: 'Athlete')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <center>
        <a href="#list-athlete" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create">Novo Atleta</g:link></li>
            </ul>
        </div>
        <div id="list-athlete" class="content scaffold-list" role="main">
        
            <h1>Atletas cadastrados</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${athleteList}" />

            <div class="pagination">
                <g:paginate total="${athleteCount ?: 0}" />
            </div>
        
        </div>
        </center>
    </body>
</html>