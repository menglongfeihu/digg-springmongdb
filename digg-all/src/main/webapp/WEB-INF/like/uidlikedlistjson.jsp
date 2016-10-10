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
					<json:property name="count" value="${item.upCount}"></json:property>
                    <c:choose>
                        <c:when test="${empty item.updateDate}">
                            <json:property name="createDate" value="${item.createDate}"></json:property>
                        </c:when>
                        <c:otherwise>
                            <json:property name="createDate" value="${item.updateDate}"></json:property>
                        </c:otherwise>
                    </c:choose>
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
					<json:property name="count" value="${item.upCount}"></json:property>
                    <c:choose>
                        <c:when test="${empty item.updateDate}">
                            <json:property name="createDate" value="${item.createDate}"></json:property>
                        </c:when>
                        <c:otherwise>
                            <json:property name="createDate" value="${item.updateDate}"></json:property>
                        </c:otherwise>
                    </c:choose>
				</json:object>
			</json:array>
		</json:object>
			)
	</c:otherwise>
</c:choose>

