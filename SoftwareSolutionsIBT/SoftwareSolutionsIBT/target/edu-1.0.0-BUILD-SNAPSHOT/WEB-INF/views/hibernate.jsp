<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Systems</title>
</head>
<body>

<h1>List of All Releases</h1>
<ul>
    <c:forEach var="s" items="${releases}">
        <li>${s.name} - ${s.id} - ${s.system.name}</li>
    </c:forEach>
</ul>


<h1>List of All Systems</h1>
<ul>
    <c:forEach var="s" items="${systems}">
        <li>${s.id} - ${s.name} - ${s.issueTrackerUrl} - ${s.programmingLang}</li>
    </c:forEach>
</ul>

<h1>List of All Systems With Releases</h1>
<ul>
    <c:forEach var="s" items="${systemsWithReleases}">
        <li>
                ${s.id} - ${s.name} - ${s.issueTrackerUrl} - ${s.programmingLang}. Releases:
            <c:forEach var="t" items="${s.releases}">${t.name}, </c:forEach>
        </li>
    </c:forEach>
</ul>
</body>
</html>