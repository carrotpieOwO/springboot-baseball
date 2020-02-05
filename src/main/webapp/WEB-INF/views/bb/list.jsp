<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<h2>PLAYER LIST</h2>



	<table border="1">
		<tr>
			<th>구단</th>
			<th>선수명</th>
			<th style="width: 300px">상세보기</th>
		</tr>
		<tr>
			<td><c:forEach var="team" items="${teams}">
					<button onclick="team(${team.id})">${team.name}</button>
					<br />
				</c:forEach>
			<td>
				<ul id="players"></ul>
			</td>
			<td id="detail"></td>

		</tr>
	</table>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script>

		 function team(team_id){ 
			 $.ajax({
					type : 'GET',
					url : '/bb/'+ team_id,
					dataType : 'json'
				}).done(function(players) {
					var res = "";

					for (var i = 0; i < players.length; i++) {
						var name = players[i].name;
						var id = players[i].id;
					
						res += "<li class='player'><button onclick='detail("+id+")'>" + name + "</button></li>";
					}
					$('.player').remove();
					$('#players').html(res);

				});
	}; 

				 function detail(id){ 
				$.ajax({
					type : 'GET',
					url : '/bb/detail/'+ id,
					dataType : 'json'
				}).done(function(detail) {
					console.log(detail);
					var res = "";
					var name = detail.name;
					var height = detail.height;
					var salary = detail.salary;
					var teamName = detail.teamName;
			
						res += "이름: "+name+"<br/>";
						res += "키: "+height+"<br/>";
						res += "연봉: "+salary+" 만원 <br/>";
						res += "소속팀: "+teamName; 
					
					$('.detail').remove();
					$('#detail').html(res);
			
				});
			}; 
		

		</script>
</body>
</html>
​
