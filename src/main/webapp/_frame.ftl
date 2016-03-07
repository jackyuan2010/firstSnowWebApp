[#if _r.user??]
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

	<title>My First Snow And Brite WebApp</title>

	<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css" type="text/css" />

    [@webBundle path="/common/js/" type="js" /]
    <script type='text/javascript' src='/bootstrap/js/bootstrap.min.js'></script>
    [@webBundle path="/js/" type="js" /]

	[@webBundle path="/css/" type="css" /]

</head>

<body>
	[@includeFrameContent /]
</body>

</html>
[#-- if no user, we include the loginform --]
[#else]
[@includeTemplate name="loginform.ftl"/]
[/#if]