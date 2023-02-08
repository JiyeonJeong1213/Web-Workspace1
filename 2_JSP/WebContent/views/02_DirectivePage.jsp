<%@ page import="java.util.ArrayList, java.util.Date" %> <!-- import는 따로 빼기 권장 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> <%-- errorPage="error500.jsp" --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 지시어</title>
</head>
<body>
	<h1>page지시어</h1>
	
	<% 
		// ArrayList 사용
		// 지시어 부분에 import="java.util.ArrayList" 추가시 에러는 없어짐
		ArrayList<String> list = new ArrayList<>();	
		list.add("Servlet");
		list.add("JSP");
		
		Date today = new Date();
	%>
	
	<p>
		리스트의 길이 : <%= list.size() %> <br>
		0번 인덱스의 값 : <%= list.get(0) %> <br>
		1번 인덱스의 값 : <%= list.get(1) %> <br>
		현재 날짜 : <%= today %>
	</p>
	
	<%-- <%= list.get(10) %> 에러 남 --%>
	<!-- 페이지지시어에서 errorPage추가해 주거나(잘 안쓰임) web.xml에서 처리해줄 수 있음(권장) -->

</body>
</html>