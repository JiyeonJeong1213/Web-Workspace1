<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String pizza = (String)request.getAttribute("pizza");
	String[] toppings = (String[])request.getAttribute("toppings");
	String[] sides = (String[])request.getAttribute("sides");
	int price = (int)request.getAttribute("price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>
<style>
	* {font-weight:bold;}
	#pizza {color:red;}
	#toppings {color:green;}
	#sides {color:blue;}
	#finish {color:pink;}
	#price {text-decoration: underline;}
</style>
</head>
<body>
	<h1>주문 내역</h1>
	피자는 <span id="pizza"><%= pizza %></span>,
	토핑은 
	<% 
		if(toppings==null){ %>
			<span id="toppings">없음</span>,
		<%}else{%>
			<span id="toppings"><%= String.join(", ", toppings) %></span>,
		<%}
	%>
	사이드는
	<% if(sides==null) { %>
		<span id="sides">없음</span>
	<% } else { %>
		<span id="sides"><%= String.join(",",sides) %></span>
	<%}%>을/를 주문하셨습니다.
	
	<br><br>
	
	총합 : <span id="price"><%= price %>원</span>
	
	<h1 id="finish">즐거운 식사시간 되세요~</h1>
</body>
</html>