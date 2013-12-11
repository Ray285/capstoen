<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
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
					  <li><a href="#">Account</a></li>
					  <li class="dropdown">
					    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
					      Add <span class="caret"></span>
					    </a>
					    <ul class="dropdown-menu">
					    	<li><a href="addSystem">Add New System</a></li>
							<li><a href="addRelease">Add Release</a></li>
							<li><a href="addReport">Add Report</a></li>
							<li><a href="addRevision">Add Revision</a></li>
							<li><a href="addTargetChange">Add Target Change</a></li>
							<li><a href="addTargetFile">Add Target File</a></li>
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
      		 </div>
			 <div class="row">
				<div class="span12 text-center">
			    	<h1>Welcome "username"</h1>
				</div>
			</div>
		</div>
	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="resources/js/jquery-2.0.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
