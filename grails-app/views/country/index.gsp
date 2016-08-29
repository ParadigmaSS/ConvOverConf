<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'country.label', default: 'Country')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <center>
        <a href="#list-country" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create">Novo País</g:link></li>
            </ul>
        </div>
        <div id="list-country" class="content scaffold-list" role="main">
            <h1>Lista de Países</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${countryList}" />

            <div class="pagination">
                <g:paginate total="${countryCount ?: 0}" />
            </div>
        </div>
        </center>
    </body>
</html>