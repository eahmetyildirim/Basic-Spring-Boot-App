<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="header.jsp"/>
</head>
<head/>
<body>

<div class="row row-cols-1 row-cols-md-3 g-4">
    <div class="col-12">
    <h4>Yazılar</h4>
    </div>
<c:forEach items="${categoryList}" var="category">
  <c:forEach items="${category.pageList}" var="page">
  <div class="col-4">
    <div class="card h-100">
      <div class="card-body">
        <h5 class="card-title">${page.title} - ${category.name}</h5>
        <p class="card-text">${page.description}</p>
        <a href="sayfa/${category.url}/${page.url}" class="card-link">Detay</a>

      </div>

      <div class="card-footer">
        <small class="text-muted">${page.createdDate} tarihinde oluşturuldu</small>
      </div>
    </div>
  </div>
  </c:forEach>
</c:forEach>
</div>

</body>
</html>
