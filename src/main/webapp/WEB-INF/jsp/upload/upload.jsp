<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<form action="<c:url value="/upload" /> " method="post" enctype="multipart/form-data">
		War: <input type="file" name="war" id="file">
		<input type="submit" />
	</form>
</body>