<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Oleo+Script&family=Trirong:wght@500&display=swap');
	*{margin:0; padding:0; background: #E1F3E3;}

	#wrap {
		margin-top: 45px;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-content: center;
		text-align: center;
	}
	#intro{
		font-size: 80px;
		font-weight: 900;
		font-family: 'Trirong', serif;
		color: #8DA993;
	}
</style>
</head>
<body>
	<div id="wrap">
		<div id="intro">Fucking JSP World</div>
		<br>
		<input type="button" value="Back" onclick="goToBack()">
		<section>
			<form action="/write" method="post">
				<input type="hidden" name="boardNum" value="${param.boardNum}">
				<div>title</div>
				<div><input type="text" name="title"></div>
				<br>
				<div><textarea name="contents" rows="10" cols="30"></textarea></div>
				<span>
				<input type="submit" value="Submit">
				<input type="reset" value="Reset">
				</span>
			</form>
		</section>
	</div>
	<script>
		function goToBack() {
			history.back();
	}
	</script>
</body>
</html>