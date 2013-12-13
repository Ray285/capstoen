<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>${webappRoot}/resources/css/bootstrap.min.css"  rel="stylesheet" type="text/css">
    <%--<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">--%>
	<link a href="<%=request.getContextPath()%>${webappRoot}//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet"/>
	<title>Add Report</title>
</head>
<body>	
	<div class="page-header text-center">
  		<h1>Add Report</h1>
	</div>
	<div class="container">
		<div class="row span12 well well-lg">
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
                                    <li><a href="/edu/addFile">Add Target File</a></li>
                                    <li><a href="/edu/addChanges">Add Target Change</a></li>
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
    	<div class="row span12 well well-lg">
				<form:form modelAttribute="report" action="showReports" method="POST">
					<table class="table well well-lg">
                        <tr>
                            <td><label >System Name</label></td>
                            <td><select id="systemselect" required="required" type="text">
                                <option value="">-- Select system</option>
                                <c:forEach var="s" items="${systems}">
                                    <option value="${s.id}">${s.name}</option>
                                </c:forEach>
                            </select> <a href="/edu/addSystem">Add new system</a></td>
                        </tr>
                        <tr>
                            <td><label>Release Name</label></td>
                            <td><select name="releaseid" id="releaseselect" required="required" type="text">

                            </select> <a href="/edu/addRelease">Add new system release</a></td>
                        <tr>
						<tr>
							<td><form:label path="id">Issue ID</form:label></td>
							<td><form:input path="id" required="required" type="text" class="form-control"/></td>
						</tr>
						<tr>
							<td><form:label path="title">Title</form:label></td>
							<td><form:textarea path="title" required = "required" type = "text"/></td>
						</tr>
						<tr>
							<td><form:label path="description">Description</form:label></td>
							<td><form:textarea path="description" required = "required" type = "text"/></td>
						</tr>					
						<tr>
							<td><form:label path="type">Type</form:label></td>
							<td><form:select path="type" name="type" required="required">
									<form:option value="Bug">Bug</form:option>
									<form:option value="Enhancement" selected="selected">Enhancement</form:option>
								</form:select>
							</td>
						</tr>
					</table>
					<input type="submit" class="btn btn-primary" value="Submit"/>
				</form:form>
		</div>
	</div>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=request.getContextPath()%>${webappRoot}/resources/js/jquery-2.0.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>${webappRoot}/resources/js/bootstrap.min.js"></script>

    <c:url var="findReleasesURL" value="/edu/getreleases" />
    <script type="text/javascript">

        $(document).ready(function() {
//            alert("jQuery installed correctly!");
        });

        $("#systemselect").change(function(event) {

            var SystemId = $(this).val();
//            alert("System id to be passed: " + SystemId);
            $.ajax({
                url: '${findReleasesURL}',
                data: {
                    "SystemId": SystemId
                },
                type: "GET",
                success: function(response) {
//                    alert("Success");
                    $("#releaseselect").html( response );
                }
            });
        });

    </script>


</body>
</html>