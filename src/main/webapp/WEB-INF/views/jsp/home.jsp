<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="basic/head.jsp">
    <jsp:param name="title" value="Welcome to System Control"/>
</jsp:include>

<body>

<div id="home">
<div class="bgimg">
    <div class="topleft">
        <p>SYSTEM CONTROLS</p>
    </div>
    <div class="title middle title-container">
        <h1>WELCOME TO SYSTEM CONTROL</h1>
        <hr>
        <ul class="nav">
            <li><a href="${pageContext.request.contextPath}/kpacs">K-PACs</a></li>
            <li><a href="${pageContext.request.contextPath}/sets">K-PAC Sets</a></li>
        </ul>
    </div>
</div>
</div>

</body>
</html>
