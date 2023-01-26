<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <title></title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<!-- BreadCrumb Başı-->

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Ana Sayfa</a></li>
        <c:forEach items="${breadcrumb}" var="entry">
        <li class="breadcrumb-item"><a href="/${entry.value}">${entry.key}</a></li>
        </c:forEach>
    </ol>
</nav>
<!-- BreadCrumb Sonu-->

<div class="container">
    <div class="blog-post mx-auto">
            <h2 class="blog-post-title">${page.title}</h2>
        <p class="blog-post-meta">${page.createdDate} by <a href="#">${page.user.fullName}</a></p>
        <p>${page.description}</p>
        <hr>
        <h3>Çözüm</h3>
        <div class="card">
            <div class="card-body mx-auto">
            <pre><code>${page.solution}</code></pre>
            </div>
        </div>

    </div>

</div>


</body>
</html>
