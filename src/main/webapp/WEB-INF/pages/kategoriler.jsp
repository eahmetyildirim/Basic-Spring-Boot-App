<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div class="col-12">
    <h4>Kategoriler</h4>
</div>
<ol class="list-group list-group-numbered">
    <c:forEach items="${categoryList}" var="category">
        <c:if test="${category.pageList.size()>0}">
            <li class="list-group-item d-flex justify-content-between align-items-start">
                <div class="ms-2 me-auto">
                    <a href="kategoriler/${category.url}"><div class="fw-bold">${category.name}</div></a>
                </div>
                <span class="badge bg-primary rounded-pill">${category.pageList.size()}</span>
            </li>
        </c:if>
    </c:forEach>

</ol>
</body>
</html>
