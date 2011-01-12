<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty errors}">
	<c:forEach items="${errors}" var="error">
		 ${error.category} - ${error.message}<br />
	</c:forEach>
</c:if>

<form action="<c:url value="/users"/>" method="post">
  
  <c:if test="${not empty user.id}">
    <input type="hidden" name="user.id" value="${user.id}"/>
    <input type="hidden" name="_method" value="put"/>
  </c:if>

  <div class="field">
    Name:<br />
    <input type="text" name="user.name" value="${user.name}"/>
  </div>
  <div class="field">
    Password:<br />
    <input type="password" name="user.password" value="${user.password}"/>
  </div>
  <div class="field">
    Email:<br />
    <input type="text" name="user.email" value="${user.email}"/>
  </div>
  <div class="field">
  	Permissão: <br />
  	<select name="user.role">
  		<option value="MEMBER">Membro</option>
  		<option value="ADMIN">Admin</option>
  	</select>
  </div>
  <div class="actions">
    <button type="submit">send</button>
  </div>
</form>

<a href="<c:url value="/users"/>">Back</a>

