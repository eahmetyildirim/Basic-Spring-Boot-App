<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="header.jsp"/>
</head>
<head/>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container text-center">
    <div class="row">
        <div class="col-9">
            <jsp:include page="yazilar.jsp"/>
        </div>
        <div class="col-3">
            <jsp:include page="kategoriler.jsp"/>
        </div>

</div>
</body>
</html>