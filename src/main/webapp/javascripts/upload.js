$(document).ready(function(){
	$('#file_upload').uploadify({
		'uploader'  : '/scripts/uploadify/uploadify.swf',
		'cancelImg' : '/scripts/uploadify/cancel.png',
		'folder'    : '/scripts/uploads',
		'auto'      : true
	});	
});
