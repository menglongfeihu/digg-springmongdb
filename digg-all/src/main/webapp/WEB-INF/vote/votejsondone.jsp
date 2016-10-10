<%@page language="java" %><%@include file="../includes/includes.jsp"%>
<%
	String encode=request.getParameter("encode");
	if(encode==null){
	    encode="UTF-8";
	}
	response.setContentType("text/html;charset="+encode);
%>




<c:choose>
	<c:when test="${empty callback}">
		<json:object>
			<json:property name="status" value="${status}"></json:property>
			<json:property name="statusText" value="${statusText}"></json:property>
			<json:property name="playerUid" value="${playerUid}"></json:property>
			<json:property name="voteCount" value="${voteCount}"></json:property>
			<json:property name="isAwarded" value="${isAwarded}"></json:property>
		</json:object>
	</c:when>
	<c:otherwise>
	${callback}(
		<json:object>
			<json:property name="status" value="${status}"></json:property>
			<json:property name="statusText" value="${statusText}"></json:property>
			<json:property name="playerUid" value="${playerUid}"></json:property>
			<json:property name="voteCount" value="${voteCount}"></json:property>
			<json:property name="isAwarded" value="${isAwarded}"></json:property>
		</json:object>
		)
	</c:otherwise>
</c:choose>

