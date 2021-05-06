<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
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
		<div><input type="button" value="Back" onclick="goToBack()"></div>
		<section>
				<div>title</div><br>
				<div>${data.title}</div>
				<br>
				<div>contents</div><br>
				<div>${data.contents}</div>
				<br>
				<span>
					<a href="/mod?boardNum=${param.boardNum}"><input type="submit" value="Modify"></a>
					<a href="/del?boardNum=${param.boardNum}"><input type="button" value="Delete"></a>
				</span>
		</section>
	</div>
	<script>
		function goToBack() {
			history.back();
	}
	</script>

</body>
</html>