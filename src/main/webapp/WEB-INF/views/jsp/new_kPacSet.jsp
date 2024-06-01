<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html lang="en-US">
<jsp:include page="basic/head.jsp">
    <jsp:param name="title" value="New K-PAC Set"/>
</jsp:include>
<body>
<div id="myModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">&times;</span>

        <form method="post" action="http://localhost:8080/sets/create" id="newKpacSet">
            <div class="container">
                <h1>New K-PAC Set</h1>
                <p>Please fill in this form to create k-pac set.</p>
                <hr>

                <label for="title"><b>Title</b></label>
                <input type="text" name="title" id="title" maxlength="250" required>

                <label><b>K-PACs</b></label>
                <div id="kpacsSelectionContainer"></div>

                <div class="button-container" style="justify-content: center;">
                    <button type="submit" class="submitbtn">Submit</button>
                </div>
            </div>
        </form>
    </div>

</div>
<jsp:include page="basic/modal.jsp"/>

<script>

    function loadKpacs() {
        let data = ${kPacList};
// <div style="display: flex; flex-direction: column; max-height: 5em; overflow: auto; border: 1px solid black">
        var checkBoxes = '';
        if (Array.isArray(data) && data.length > 0) {
            data.forEach(function (item) {
                checkBoxes += '<label> <input type="checkbox" name="kPacIds" value="' + item.id + '"/>' + item['title'] + '</label>';
            });
        } else {
            checkBoxes = '<p>K-Pacs are not created.</p>';
        }
        document.getElementById("kpacsSelectionContainer").innerHTML = checkBoxes;
    }

    document.addEventListener("DOMContentLoaded", function () {
        loadKpacs();
    });

</script>

</body>
</html>