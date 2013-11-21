<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
    <title>System Information</title>
</head>
<body>
		<div class="page-header text-center">
		  <h1>System Information</h1>
		</div>
        <div class="container">
        	<div class="row">
        		<div class="span12">
	        		<!-- Table -->
			        <table class="table well well-lg">
			          <thead>
			            <tr>
			              <th>Release</th>
			              <th>Issue Tracker ID</th>
			         	  <th>Title</th>
			              <th>Description</th>
			              <th>Type</th>
			            </tr>
			          </thead>
			          <tbody>
			            <tr>
					      <td>${release}</td>			          
					      <td>${issueid}</td>
					  	  <td>${title}</td>
					      <td>${description}</td>
					      <td>${type}</td>
			            </tr>
			          </tbody>
			        </table>
        		</div>
        	</div>
        	<div class="row">
        		<div class="span12">
					<a href="index" class="btn"><i class="glyphicon glyphicon-home"></i> Home</a>
        		</div>
        	</div>
		</div>



	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="resources/js/jquery-2.0.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>