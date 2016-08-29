<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main"/>
    <title>Persons</title>
  </head>
  <body>
  <g:each in="${athletes}" var="athlete" status="i">
    <h3>${i+1}. ${athlete.name}</h3>
    <p>
      Aqui era pra ter um atributo.
    </p>
    <br/>
  </g:each>
  </body>
</html>
