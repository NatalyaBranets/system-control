<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en-US">
<jsp:include page="basic/head.jsp">
    <jsp:param name="title" value="K-PAC Sets"/>
</jsp:include>

<body>
    <jsp:include page="basic/header.jsp">
        <jsp:param name="headerName" value="K-PAC Sets"/>
    </jsp:include>

    <div class="button-container">
        <button id="modalButton" class="new-button">New K-PAC Set</button>
    </div>

    <jsp:include page="basic/grid.jsp"/>
    <script>
        const grid = new dhx.Grid("grid", {
            columns: [
                {
                    width: 505,
                    id: "id",
                    header: [{text: "ID"}, {content: "inputFilter"}],
                    editable: false,
                    tooltip: false
                },
                {
                    width: 505,
                    id: "title",
                    header: [{text: "Title"}, {content: "inputFilter"}],
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
            data: loadData(${kPacSetList}),
            selection: "row"
        });

        grid.events.on("cellDblClick", function (row, column, e) {
            window.open("set/"+row.id, '_blank').focus();
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
            const httpRequest = new XMLHttpRequest();
            httpRequest.open("GET", "/sets/delete/" + id);
            httpRequest.send();
            httpRequest.onload = () => {
                if (httpRequest.readyState === 4 && httpRequest.status === 200) {
                    location.reload();
                } else {
                    console.log("Failed to remove kPacSet!");
                }
            }
        }
    </script>

    <jsp:include page="new_kPacSet.jsp"/>
</body>
</html>
