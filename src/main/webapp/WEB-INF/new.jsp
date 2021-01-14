<%--
  Created by IntelliJ IDEA.
  User: pccorner
  Date: ١٣/٠١/٢٠٢١
  Time: ٠٦:٢٧ م
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>New Question</title>
</head>
<body>
<div>
    <h1>What is your question</h1>
    <form:form action="/" method="post" modelAttribute="newQuest">
        <div>
            <form:label path="question">Question</form:label>
            <form:errors path="question"/>
            <form:textarea path="question"></form:textarea>
        </div>
        <div>
            <form:label path="tags">Tags</form:label>
            <form:errors path="tags"/>
            <form:input path="tags"/>
        </div>
        <button>Submit</button>
    </form:form>
</div>
</body>
</html>
