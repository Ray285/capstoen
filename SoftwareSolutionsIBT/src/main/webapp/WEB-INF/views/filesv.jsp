<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<option value="">-- Select report</option>
<c:forEach var="s" items="${files}">
    <option value="${s.id}">${s.name}</option>
</c:forEach>