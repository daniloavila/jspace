<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>

<p>
  <b>Name:</b>
   ${user.name}
</p>
<p>
  <b>Password:</b>
   ${user.password}
</p>
<p>
  <b>Email:</b>
   ${user.email}
</p>

<a href="<c:url value="/users/${user.id}/edit"/>">Edit</a>
<a href="<c:url value="/users"/>">Back</a>

</body>
