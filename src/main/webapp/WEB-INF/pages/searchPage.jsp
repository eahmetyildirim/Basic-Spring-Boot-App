<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <jsp:include page="header.jsp"/>
    <title>Arama Sonuçları</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <div class="col-12">
            <h3>Çözümler</h3>
        </div>
            <c:forEach items="${pageList}" var="page">
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

    </div>
</div>
</body>
</html>
