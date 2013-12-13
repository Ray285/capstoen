<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<option value="">-- Select report</option>
<c:forEach var="s" items="${reports}">
    <option value="${s.id}">${s.title}</option>
</c:forEach>