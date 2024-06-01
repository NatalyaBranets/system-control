<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en-US">
<jsp:include page="basic/head.jsp">
    <jsp:param name="title" value="K-PAC Set"/>
</jsp:include>

<body>
    <jsp:include page="basic/header.jsp">
        <jsp:param name="headerName" value="K-PAC Set"/>
    </jsp:include>

    <jsp:include page="basic/grid.jsp"/>

    <script>
        const grid = new dhx.Grid("grid", {
            columns: [
                {   width: 218,
                    id: "id",
                    header: [{text: "ID"}]
                },
                {
                    width: 500,
                    id: "title",
                    header: [{text: "Title"}]},
                {
                    width: 500,
                    id: "description",
                    header: [{text: "Description"}]}
            ],
            data: load(${kPacSet}),
            selection: "row",
        });

        function load(data) {
            return data['kpacs'];
        }

    </script>
</body>
</html>
