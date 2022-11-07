<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	float message = 
	(float) request.getAttribute("message");
	float message2 = 
	(float) request.getAttribute("message2");
	float message3 = 
	(float) request.getAttribute("message3");
	String string = 
			request.getParameter("string");
%>
<body>
<h1>元の文章</h1>
<p><%=string %></p>
<h2>Sentiment</h2>

<P>negative<%=message %></P>
<P>neutral<%=message2 %></P>
<P>positive<%=message3 %></P>


</body>
</html>