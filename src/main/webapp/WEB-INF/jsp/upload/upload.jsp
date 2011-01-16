<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<link href="<c:url value="/scripts/uploadify/uploadify.css"/>" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="<c:url value="/javascripts/jquery.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/scripts/uploadify/swfobject.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/scripts/uploadify/jquery.uploadify.min.js"/>"></script>
</head>

<script type="text/javascript">
$(document).ready(function() {
  $('#file_upload').uploadify({
    'uploader'  : '/scripts/uploadify/uploadify.swf',
    'script'    : '/scripts/uploadify/uploadify.php',
    'cancelImg' : '/scripts/uploadify/cancel.png',
    'folder'    : '/scripts/uploadify/upload',
    'auto'      : true
  });
});
</script>
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