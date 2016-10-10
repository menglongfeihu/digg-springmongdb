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
			<json:property name="page" value="${page}"></json:property>
			<json:property name="size" value="${size}"></json:property>
			<json:property name="totalPage" value="${totalPage}"></json:property>
			<json:property name="totalSize" value="${totalSize}"></json:property>
			<json:array  name="voteList" var="item" items="${voteList}">
				<json:object>
					<json:property name="uid" value="${item.uid}"></json:property>
					<json:property name="voteCount" value="${item.voteCount}"></json:property>
					<json:property name="district" value="${item.district}"></json:property>
				</json:object>
			</json:array>
		</json:object>

	</c:when>
	<c:otherwise>
		${callback}(
		<json:object>
			<json:property name="status" value="${status}"></json:property>
			<json:property name="statusText" value="${statusText}"></json:property>
			<json:property name="page" value="${page}"></json:property>
			<json:property name="size" value="${size}"></json:property>
			<json:property name="totalPage" value="${totalPage}"></json:property>
			<json:property name="totalSize" value="${totalSize}"></json:property>
			<json:array  name="voteList" var="item" items="${voteList}">
				<json:object>
					<json:property name="uid" value="${item.uid}"></json:property>
					<json:property name="voteCount" value="${item.voteCount}"></json:property>
					<json:property name="district" value="${item.district}"></json:property>
				</json:object>
			</json:array>
		</json:object>
			)
	</c:otherwise>
</c:choose>

