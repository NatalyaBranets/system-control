<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en-US">
<jsp:include page="basic/head.jsp">
    <jsp:param name="title" value="New K-PAC"/>
</jsp:include>
<body>
<div id="myModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">&times;</span>

        <form method="post" action="http://localhost:8080/kpacs/create" id="newKpac">
            <div class="container">
                <h1>New K-PAC</h1>
                <p>Please fill in this form to create k-pac.</p>
                <hr>

                <label for="title"><b>Title</b></label>
                <input type="text" name="title" id="title" maxlength="250" required>

                <label for="description"><b>Description</b></label>
                <input type="text" name="description" id="description" maxlength="2000" required>
                <hr>

                <div class="button-container" style="justify-content: center;">
                    <button type="submit" class="submitbtn">Submit</button>
                </div>
            </div>
        </form>

    </div>

</div>

<jsp:include page="basic/modal.jsp"/>
</body>
</html>
