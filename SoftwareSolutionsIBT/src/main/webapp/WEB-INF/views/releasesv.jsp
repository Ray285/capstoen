<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<option value="">-- Select release</option>
<c:forEach var="s" items="${releases}">
    <option value="${s.id}">${s.name}</option>
</c:forEach>