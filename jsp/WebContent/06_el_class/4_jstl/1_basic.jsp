<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- 변수선언 -->
<c:set var='gender' value='male'></c:set>

<!-- 조건문 -->
<c:if test="${gender eq 'male' }">당신은 남자입니다.</c:if>
<c:if test="${gender eq 'female' }">당신은 여자입니다.</c:if>

<!-- age 변수 선언 (값은 아무거나 지정) -->
<c:set var='age' value='25'></c:set>

<c:choose>
	<c:when test="${age le 10 }">어린이 입니다</c:when>	
	<c:when test="${age gt 10 and age lt 20 }">청소년 입니다</c:when>	
	<c:otherwise>성인입니다</c:otherwise>
</c:choose>

<c:set var='sum' value='0'/>
<c:forEach var='i' begin='1' end='100'>
	<c:set var='sum' value='${sum+i}'/>
</c:forEach>
<hr/>
1~100 까지의 합 : ${sum} <br/>

<!-- 1~100 까지의 홀수의 합과 짝수의 합 출력 -->
<c:set var='evenSum' value='0'></c:set>
<c:set var='oddSum' value='0'></c:set>
<c:forEach var='i' begin='1' end='100'>
	<c:if test="${i mod 2 eq 0 }">
		<c:set var='evenSum' value="${evenSum + i }"></c:set>
	</c:if>
	
	<c:if test="${i mod 2 eq 1 }">
		<c:set var='oddSum' value="${oddSum + i }"></c:set>
	</c:if>
</c:forEach>
<hr/>
1~100 까지<br/>
짝수 합 : ${evenSum }<br/>
홀수 합 : ${oddSum }<br/>
</body>
</html>