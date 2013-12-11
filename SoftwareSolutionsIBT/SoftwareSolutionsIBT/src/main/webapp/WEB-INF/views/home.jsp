<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>${webappRoot}/resources/css/bootstrap.min.css"  rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>${webappRoot}//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet" >
    <title>Home</title>
</head>
<body>
	<div class="page-header text-center">
	  <h1>Software Solutions Issue and Bug Tracker</h1>
	</div>
	<div id="main-content">
      	<div class="container well well-lg">
      		 <div class="row">
      		 	<div class="span12">
      		 		<ul class="nav nav-tabs well well-lg">
					  <li><a href="#">Home</a></li>
                      <sec:authorize access="hasRole('admin')">
                      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Add <span class="caret"></span></a>
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
							<li><a href="showTargetChanges">View Target Changes</a></li>
							<li><a href="showTargetFile">View Target Files</a></li>
					    </ul>
					  </li>
                      <sec:authorize ifNotGranted="admin">
                            <li><a href="login" >Login</a></li>
                      </sec:authorize>
                      <sec:authorize ifAnyGranted="admin">
                            <li><a href="<c:url value="/j_spring_security_logout" />" >Logout</a></li>
                      </sec:authorize>
					</ul>
				</div>
      		 </div>
			 <div class="row">
				<div class="span12 text-center">
			    	<h1>${message} ${username}</h1>
				</div>
			</div>
		</div>
	</div>




    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=request.getContextPath()%>${webappRoot}/resources/js/jquery-2.0.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>${webappRoot}/resources/js/bootstrap.min.js"></script>
</body>
</html>
