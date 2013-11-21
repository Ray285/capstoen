<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>${webappRoot}/resources/css/bootstrap.min.css"  rel="stylesheet" type="text/css">
    <%--<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">--%>
	<link a href="<%=request.getContextPath()%>${webappRoot}//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet"/>
	<title>Reports Manager</title>
</head>
<body>	
	<div class="page-header text-center">
  		<h1>Reports Manager</h1>
	</div>
	<div class="container">
		<div class="row span12 well well-lg">
      		 		<ul class="nav nav-tabs well well-lg">
					  <li><a href="index">Home</a></li>
					  <li><a href="#">Account</a></li>
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
					  <li class="dropdown">
					  	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
					      View <span class="caret"></span>
					    </a>
					    <ul class="dropdown-menu">
							<li><a href="showSystems">View Systems</a></li>
							<li><a href="showReleases">View Releases</a></li>
							<li><a href="showReports">View Reports</a></li>
							<li><a href="showRevisions">View Revisions</a></li>
							<li><a href="showTargetChanges">View Target Changes</a></li>
							<li><a href="showTargetFile">View Target Files</a></li>
					    </ul>
					  </li>
					</ul>
		</div>
    	<div class="row span12 well well-lg">
				<form:form id="report" action="addReports" method="POST">
					<table class="table well well-lg">
                        <tr>
                            <td><form:label path="name">System Name</form:label></td>
                            <td><form:select path="name" required="required">
                                <form:option value="">-- Select system</form:option>
                                <form:option value="Apache Lucene">Apache Lucene</form:option><form:option value="8">Hibernate</form:option><form:option value="9">Apache Derby</form:option><form:option value="10">Netbeans - Editor</form:option><form:option value="11">OpenJPA</form:option><form:option value="12">Apache Cocoon</form:option><form:option value="49">PowerPoint</form:option>
                            </form:select> <a href="/edu/addSystem">Add new system</a></td>
                        </tr>
                        <tr>
                            <td><form:label path="release">Release Name</form:label></td>
                            <td><form:select path="release" required="required">
                                <form:option value="">-- Select release</form:option>
                                <form:option value="{@release}">{@release}</form:option>
                            </form:select> <a href="/edu/addRelease">Add new system release</a></td>
                        </tr>
						<tr>
							<td><form:label path="issueid">Issue Tracker ID</form:label></td>
							<td><form:input path="issueid" required="required" type="text" class="form-control"/></td>
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

</body>
</html>