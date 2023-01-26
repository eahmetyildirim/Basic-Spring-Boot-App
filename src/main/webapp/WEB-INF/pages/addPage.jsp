<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <title>Yazı Ekle</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
<form:form method="post" action="save-page"   modelAttribute="page">

    <form:label path="title" cssClass="form-label">Başlık</form:label>
    <form:input path="title" cssClass="form-control"></form:input>

    <form:label path="description" cssClass="form-label">Açıklama</form:label>
    <form:input path="description" cssClass="form-control"></form:input>

    <form:label path="category" cssClass="form-label">Programlama Dili</form:label><br/>
    <form:select path="category" cssClass="form-select" title="Category" multiple="false">
        <form:options items="${categoryMapList}" />
    </form:select>

    <br/>
    <form:label path="solution" cssClass="form-label">Çözüm</form:label>
    <form:textarea cssClass="form-control" path="solution" cols="25" rows="5"/><br/>
    <form:button class="btn btn-block btn-danger">Ekle</form:button>
</form:form>
</div>
</body>
</html>
