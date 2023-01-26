<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="header.jsp"/>
  <title>${category.name}</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
<div class="row row-cols-1 row-cols-md-3 g-4">
  <div class="col-12 text-center">
    <h4>${category.name}</h4>
  </div>
<c:forEach items="${category.pageList}" var="page">
  <div class="col-4">
    <div class="card h-100">
      <div class="card-body">
        <h5 class="card-title">${page.title} - ${category.name}</h5>
        <p class="card-text">${page.description}</p>
        <a href="/sayfa/${category.url}/${page.url}" class="card-link">Detay</a>

      </div>
      <div class="card-footer">
        <small class="text-muted">page.createdDate</small>
      </div>
    </div>
  </div>
</c:forEach>
</div>
</div>
</body>
</html>
