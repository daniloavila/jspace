<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<link href="<c:url value="/scripts/uploadify/uploadify.css"/>" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="<c:url value="/scripts/uploadify/jquery.uploadify.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/scripts/uploadify/swfobject.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/javascripts/upload.js"/>"></script>
</head>

<body>
	<c:forEach var="error" items="${errors}">
	    ${error.category} - ${error.message}<br />
	</c:forEach>

	<input id="file_upload" name="file_upload" type="file" />

	<form action="<c:url value="/upload" /> " method="post" enctype="multipart/form-data">
		War: <input type="file" name="war" id="file">
		<input type="submit" />
	</form>
</body>