<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>${webappRoot}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>${webappRoot}//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
    <title>Revisions</title>
</head>
<body>
<div class="page-header text-center">
    <h1>Revisions</h1>
</div>
<div class="container">
    <div class="row  well well-lg">
        <ul class="nav nav-tabs well well-lg">
            <li><a href="home">Home</a></li>
            <sec:authorize access="hasRole('admin')">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        Add <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/edu/addSystem">Add New System</a></li>
                        <li><a href="/edu/addRelease">Add Release</a></li>
                        <li><a href="/edu/addReport">Add Report</a></li>
                        <li><a href="/edu/addRevision">Add Revision</a></li>
                        <li><a href="/edu/addChanges">Add Target Change</a></li>
                        <li><a href="/edu/addFile">Add Target File</a></li>
                    </ul>
                </li>
            </sec:authorize>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    View <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="showSystems">View Systems</a></li>
                    <li><a href="showReleases">View Releases</a></li>
                    <li><a href="showReports">View Reports</a></li>
                    <li><a href="showRevisions">View Revisions</a></li>
                    <li><a href="showTargetFile">View Target Files</a></li>
                    <li><a href="showTargetChanges">View Target Changes</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="row">
        <!-- Table -->
        <table class="table well well-lg">
            <thead>
            <tr>
                <th>System</th>
                <th>Revision Name</th>
                <th>Version Control System ID</th>
                <th>Comment</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="s" items="${revisions}">
                <tr><td>${s.report.release.system.name}</td><td>${s.name}</td><td>${s.vcsid}</td><td>${s.comment}</td></tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=request.getContextPath()%>${webappRoot}/resources/js/jquery-2.0.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=request.getContextPath()%>${webappRoot}/resources/js/bootstrap.min.js"></script>
</body>
</html>