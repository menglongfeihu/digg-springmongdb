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
			<json:array  name="likelist" var="item" items="${likeList}">
				<json:object>
					<json:property name="vid" value="${item.vid}"></json:property>
					<json:property name="upCount" value="${item.upCount}"></json:property>
					<json:property name="isLiked" value="${item.isLiked}"></json:property>
				</json:object>
			</json:array>
		</json:object>

	</c:when>
	<c:otherwise>
		${callback}(
		<json:object>
			<json:property name="status" value="${status}"></json:property>
			<json:property name="statusText" value="${statusText}"></json:property>
			<json:array  name="likelist" var="item" items="${likeList}">
				<json:object>
					<json:property name="vid" value="${item.vid}"></json:property>
					<json:property name="upCount" value="${item.upCount}"></json:property>
					<json:property name="isLiked" value="${item.isLiked}"></json:property>
				</json:object>
			</json:array>
		</json:object>
			)
	</c:otherwise>
</c:choose>

