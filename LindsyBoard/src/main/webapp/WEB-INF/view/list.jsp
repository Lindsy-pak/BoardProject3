<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Abril+Fatface&family=Oleo+Script&family=Trirong:wght@500&display=swap');
	*{margin:0; padding:0; background: #E1F3E3;}
	a{
	text-decoration: none;
	color: black;
	}
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

	table, tr, th, td {
		text-align: center;
		border: 2px solid #fff;
		border-collapse: collapse;
		margin-left: 35%;
	}
	table tr th {
		background: #8DA993;
		color:white;
	}
	table {
		justify-content: center;
		width:200px;
		margin-top: 20px;
		}
		
</style>
</head>
<body>
	<div id="wrap">
		<div id="intro">Fucking JSP World</div>

		<section>
			<table>
				<tr>
					<th>No.</th>
					<th>Title</th>
					<th>DateTime</th>
				</tr>
 				<c:forEach var="table" items="${data}">
					<tr onclick="moveToDetail(${table.boardNum})">
						<td>${table.boardNum}</td>
						<td>${table.title}</td>
						<td>${table.regidate}</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<div><a href="/write"><input type="button" value="Write"></a></div>
		</section>
	</div>
	<script>
		function moveToDetail(boardNum) {
			location.href="/detail?boardNum=" + boardNum;
		}
	</script>
</body>
</html>