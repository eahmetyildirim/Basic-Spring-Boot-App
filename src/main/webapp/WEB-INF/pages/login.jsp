<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="header.jsp"/>
</head>

<body>
<div class="container text-center">
    <div>
        <h2>Lütfen giriş yapınız</h2>
        <br/>
    </div>
    <div>
        <h4><a href="/oauth2/authorization/google">Google ile giriş yap</a></h4>
    </div>
    <div class="row">
        <div class="col-md-12">
            <a class="btn btn-lg btn-google btn-block text-uppercase btn-outline" href="/oauth2/authorization/google"><img src="https://img.icons8.com/color/16/000000/google-logo.png"> Giriş Yap yada Kayıt Ol</a>

        </div>
    </div>
</div>
</body>
</html>