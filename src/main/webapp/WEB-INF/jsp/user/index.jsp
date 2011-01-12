<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
<h1>Listing Users</h1>

<table>
  <tr>
   <th>Nome</th>
   <th>email</th>
   <th>Permissão</th>
   <th></th>
   <th></th>
  </tr>

<c:forEach items="${userList}" var="user">
  <tr>
    <td>
      ${user.name}
    </td>
    <td>
      ${user.email}
    </td>
    <td>
      ${user.role}
    </td>
    <td><a href="<c:url value="/users/${user.id}"/>">show</a></td>
    <td><a href="<c:url value="/users/${user.id}/edit"/>">edit</a></td>
    <td>
      <form action="<c:url value="/users/${user.id}"/>" method="post">
    	  <input type="hidden" name="_method" value="delete"/>
    	  <button type="submit" onclick="return confirm('Are you sure?')">destroy</button>
	  </form>
	</td>
  </tr>
</c:forEach>
</table>

<br />
<a href="<c:url value="/users/new"/>">New User</a> 
</body>
