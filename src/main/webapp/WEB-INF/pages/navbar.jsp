<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Bitirme Project</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/">Ana Sayfa</a>
      </li>
      <li>
        <a class="nav-link" href="/add-page">Yazı Ekle</a>
      </li>

    </ul>
    <form:form action="/search" method="get"  cssClass="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" name="searchKey" placeholder="Arama" aria-label="Arama">
      <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Bul"/>
    </form:form>


    <security:authorize access="isAuthenticated()">
    <div class="text-center p-3">
    Hoşgeldiniz <security:authentication property="principal.name"/>
      <a href="/logout">Çıkış Yap</a>
    </div>
    </security:authorize>

    <security:authorize access="isAnonymous()">
    <div class="text-center p-3">
      <a href="/giris-yap">Giriş Yap </a>
    </div>
    </security:authorize>

  </div>
</nav>
