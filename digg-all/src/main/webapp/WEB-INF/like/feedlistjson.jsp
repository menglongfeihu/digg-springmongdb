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
            <json:property name="count" value="${count}"></json:property>
			<json:property name="currPage" value="${currPage}"></json:property>
			<json:property name="totalPage" value="${totalPage}"></json:property>
			<json:property name="size" value="${size}"></json:property>
			<json:array  name="feedList" var="item" items="${feedList}">
				<json:object>
					<json:property name="feedId" value="${item.vid}"></json:property>
                    <json:property name="createDate" >
                        <fmt:formatDate value="${item.createDate}" pattern="yyyy年MM月dd日HH点mm分ss秒" />
                    </json:property>
				</json:object>
			</json:array>
		</json:object>

	</c:when>
	<c:otherwise>
		${callback}(
		<json:object>
			<json:property name="status" value="${status}"></json:property>
			<json:property name="statusText" value="${statusText}"></json:property>
            <json:property name="count" value="${count}"></json:property>
			<json:property name="currPage" value="${currPage}"></json:property>
			<json:property name="totalPage" value="${totalPage}"></json:property>
			<json:property name="size" value="${size}"></json:property>
			<json:array  name="feedList" var="item" items="${feedList}">
				<json:object>
					<json:property name="feedId" value="${item.vid}"></json:property>
                    <json:property name="createDate" >
                        <fmt:formatDate value="${item.createDate}" pattern="yyyy年MM月dd日HH点mm分ss秒" />
                    </json:property>
				</json:object>
			</json:array>
		</json:object>
			)
	</c:otherwise>
</c:choose>

