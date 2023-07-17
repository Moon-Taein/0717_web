<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대륙 선택</title>
</head>
<body>
	<header>
		<h2>국가를 선택하세요!</h2>
	</header>
	
	<main>
		<fieldset>
		<legend>레전드다</legend>
		<form action="country2.jsp" method="post">
			<select name="continent">
				<option value="North America">북미</option>
				<option value="Asia">아시아</option>
				<option value="Africa">아프리카</option>
				<option value="Europe">유럽</option>
				<option value="South America">남미</option>
				<option value="Antarctica">남극</option>
			</select>
			<input type="submit">
		</form>
		</fieldset>
	</main>
	
	<footer>
		<h3>선택하시면 넘어갑니다</h3>
	</footer>
</body>
</html>