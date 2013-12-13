<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="<%=request.getContextPath()%>${webappRoot}/resources/css/bootstrap.min.css"  rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>${webappRoot}//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet" >
    <title>Login Page</title>
</head>
<body onload='document.f.j_username.focus();'>
<div class="page-header text-center">
    <h1>Login with Username and Password </h1>
</div>
<div class="container">

<div class="row span12 well well-lg">
    <ul class="nav nav-tabs well well-lg">
        <li><a href="home">Home</a></li>
</div>

<c:if test="${not empty error}">
<div class="row span12 errorblock alert alert-danger">
    Your login attempt was not successful, try again.<br /> Caused By:
        ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
</div>
</c:if>

<div class="row span12 well well-lg">
    <form name='f' action="<c:url value="/j_spring_security_check" />"
          method='POST'>

        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='j_username' value=''>
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='j_password' />
                </td>
            </tr>
        </table>

                <input type="submit" class="btn btn-primary" value="submit"/>



               <input type="submit" class="btn btn-primary" value="reset"/>



    </form>
</div>

</div>
</body>
</html>