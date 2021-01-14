<%--
  Created by IntelliJ IDEA.
  User: pccorner
  Date: ١٤/٠١/٢٠٢١
  Time: ٠٦:٠٧ ص
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Question Profile</title>
</head>
<body>
<div>
    <h1>${ question.question }?</h1>
    <h3>Tags:</h3>
    <ul>
        <c:forEach items="${ question.tags }" var="tag">
            <li>${ tag.subject }</li>
        </c:forEach>
    </ul>
    <h3>Answers:</h3>
    <ul>
        <c:forEach items="${ question.answers }" var="answer">
            <li>${ answer.answer }</li>
        </c:forEach>
    </ul>
    <h3>Add your answer:</h3>
    <form:form action="/answers" method="post" modelAttribute="answer">
        <div>
            <form:label path="answer">Answer</form:label>
            <form:errors path="answer"/>
            <form:textarea path="answer"></form:textarea>
        </div>
        <form:hidden path="question" value="${ question.id }"/>
        <button>Answer it!</button>
    </form:form>
</div>
</body>
</html>
