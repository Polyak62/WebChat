<%--
  Created by IntelliJ IDEA.
  User: Анатолий
  Date: 21.08.2021
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat</title>
</head>
<body>
<h1>Общий чат</h1>
<textarea disabled id="windowMessage"></textarea>
<h2>Введите свое сообщение</h2>
<form method="post" action="${pageContext.request.contextPath}/message">
    <label><input name="message"></label><br>
    <input type="submit" value="Отправить" id="ButtonSend"><br>
</form>
<form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Exit"/>
</form>
<script>
    setInterval(() => fetch('http://localhost:8080/webChatApp_war/message').then(response=>response.json())
    .then(commits=>parseMessage(commits)).then(finalMessage=>document.getElementById("windowMessage").value=finalMessage), 100);
    function parseMessage(messages) {
        let mes = "";
        for (let i = 0; i < messages.length; i++){
            mes = mes + '['+ messages[i].user.name+']'+ ':'+ " " + messages[i].text + "\n";
        }
        console.log(mes);
        return mes;
            }
</script>
</body>
</html>
