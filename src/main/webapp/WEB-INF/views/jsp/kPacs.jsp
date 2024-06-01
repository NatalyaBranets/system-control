<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en-US">
<jsp:include page="basic/head.jsp">
    <jsp:param name="title" value="K-PACs"/>
</jsp:include>

<body>
    <jsp:include page="basic/header.jsp">
        <jsp:param name="headerName" value="K-PACs"/>
    </jsp:include>

    <div class="button-container">
        <button  id="modalButton" class="new-button">New K-PAC</button>
    </div>

    <jsp:include page="basic/grid.jsp"/>

    <script>
        const grid = new dhx.Grid("grid", {
        columns: [
            {   width: 200,
                id: "id",
                header: [{text: "ID"}, {content: "inputFilter"}],
                editable: false,
                tooltip: false
            },
            {
                width: 270,
                id: "title",
                header: [{text: "Title"}, {content: "inputFilter"}],
                editable: false,
                tooltip: false
            },
            {
                width: 270,
                id: "description",
                header: [{text: "Description"}, {content: "inputFilter"}],
                editable: false,
                tooltip: false
            },
            {
                width: 270,
                id: "creationDate",
                header: [{text: "Creation Date"}, {content: "comboFilter"}],
                editable: false,
                tooltip: false
            },
            {
                width: 208,
                id: "deleteIcon",
                header: [{text: "Delete"}],
                editable: false,
                sortable: false,
                htmlEnable: true,
                tooltip: false
            },
            ],
            data: loadData(${kPacsList}),
            selection: "row"
        });

        function loadData(data) {
            if (Array.isArray(data)) {
              data.forEach(
                item => item['deleteIcon'] = '<img src="../../../resources/grid_trial/samples/common/favicon/icons-delete-24.png" ' +
                    'onclick="remove(' + item.id + ')" class="deleteIcon"/>');
                return data;
            }
        }

        function remove(id) {
            var httpRequest = new XMLHttpRequest();
            httpRequest.open("GET", "/kpacs/delete/" + id);
            httpRequest.send();
            httpRequest.onload = () => {
                if (httpRequest.readyState === 4 && httpRequest.status === 200) {
                    location.reload();
                } else {
                    console.log("Failed to remove kPacs");
                }
            }
        }
    </script>

    <jsp:include page="new_kPac.jsp"/>
</body>
</html>
