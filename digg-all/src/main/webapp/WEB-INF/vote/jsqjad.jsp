<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="../includes/includes.jsp"%>

<html>
	<head>
		<title>急速前进后台</title>
  	</head>
  	<body>
  
  	<table width="100%" border="0" cellpadding="2" cellspacing="0">
  		<tr>
  			<td width="60%">
		  	<c:if test="${m == 'u'}">
		  		<c:if test="${status == '-1'}">
		 		 	添加优胜组合
			  		<form action = "/voting/adedit.do" method = "post">
						<table width="100%" border="0" cellpadding="2" cellspacing="0">
			  				<tr>
			  					<td>期数：</td>
								<td>
									<select name = "issue">
										<option value ="0">请选择期数</option>
					  					<option value ="1">第一期</option>
					  					<option value ="2">第二期</option>
					  					<option value ="3">第三期</option>
					  					<option value ="4">第四期</option>
					  					<option value ="5">第五期</option>
					  					<option value ="6">第六期</option>
					  					<option value ="7">第七期</option>
					  					<option value ="8">第八期</option>
					  					<option value ="9">第九期</option>
					  					<option value ="10">第十期</option>
									</select>
								</td>
				  			</tr>
				  		
				  			<tr>
				  				<td>优胜组合：</td>
					  			<td>
									<select name = "winner">
										<option value ="0">请选择优胜组合</option>
						  				<option value ="1">钟汉良&钟秀萍</option>
						  				<option value ="2">李小鹏&李安琪</option>
						  				<option value ="3">张铁林&张月亮</option>
						  				<option value ="4">金大川&刘畅</option>
						  				<option value ="5">辰亦儒&周韦彤</option>
						  				<option value ="6">郑伊健&陈小春</option>
						  				<option value ="7">刘云&应采儿</option>
						  				<option value ="8">白举纲&关晓彤</option>
									</select>
					  			</td>
				  			</tr>
				  			<tr>
					  			<td>优胜组合图片:</td>
					  			<td width="75%"><input style="width:60%;" name = "winnerimg" type = "text" value="" /></td>
							</tr>	
					  		<tr>
					  			<td>淘汰组合：</td>
					  			<td>
									<select name = "loser">
										<option value ="0">请选择淘汰组合</option>
						  				<option value ="1">钟汉良&钟秀萍</option>
						  				<option value ="2">李小鹏&李安琪</option>
						  				<option value ="3">张铁林&张月亮</option>
						  				<option value ="4">金大川&刘畅</option>
						  				<option value ="5">辰亦儒&周韦彤</option>
						  				<option value ="6">郑伊健&陈小春</option>
						  				<option value ="7">刘云&应采儿</option>
						  				<option value ="8">白举纲&关晓彤</option>
									</select>
								</td>
					  		</tr>
					  		<tr>
						  		<td align="left"><input name = "submit" type = "submit" value="提交优胜及淘汰组合数据"/></td>
						  		<td><font size="2" color="red">提交数据前请先 check数据正确</font></td>
					  		</tr>
				  		</table>
			  		</form>
				</c:if>
				
				<c:if test="${status == '0'}">
					<font color="red">提交数据有误，请检查后重新提交</font>
				</c:if>
			  	<c:if test="${status == '1'}">
			  		<table width="100%" border="0" cellpadding="2" cellspacing="0">
				  		<tr>
						  	<td>你提交的信息</td>
						  	<td></td>
				  		</tr>
				  		<tr>
						  	<td>期数：</td>
						  	<td>${issue}</td>
				  		</tr>
				  		<tr>
						  	<td>优胜组合id：</td>
						  	<td>${winner}</td>
				 	 	</tr>
				 	 	<tr>
						  	<td>优胜组合图片链接：</td>
						  	<td>${winnerimg}</td>
				 	 	</tr>
				 	 	<tr>
						  	<td>淘汰组合id：</td>
						  	<td>${loser}</td>
					  	</tr>
			  		</table>
			  		<form action = "/voting/sendWM.do" method = "post">
			  		给投票给优胜组合的手机发短信
			  			<table>
				  			<tr>
				  				<td>期数：</td>
					  			<td>
					  				<input name = "issue" type = "text" value="${issue}" readOnly/>
					  			</td>
				  			</tr>
				  			<tr>
				  				<td>优胜组合id</td>
					  			<td>
					  				<input name = "winner" type = "text" value="${winner}" readOnly/>
					  			</td>
				  			</tr>
				  			<tr>
					  			<td>
					  				<input name = "submit" type = "submit" value="给投票给优胜组合的手机发短信"/>
					  			</td>
					  			<td><font size="1" color="red">提交数据前请先 check数据正确</font></td>
				  			</tr>
			  			</table>
			  		</form>
			  	</c:if>	
			</c:if>
		
		  	<c:if test="${m == 'g'}">
				<table>
					<tr>
						<td>
						<c:if test="${status == '0'}">
						  		短信发送成功
							</c:if>
							
							<c:if test="${status == '-1'}">
						  		参数不正确
							</c:if>
							
							<c:if test="${status == '-2'}">
						  		winner组参数不对
							</c:if>
							
							<c:if test="${status == '-3'}">
						  		获取投票冠军组的手机列表为空
							</c:if>
							
							<c:if test="${status == '-4'}">
						 		 短信发送失败
							</c:if>
						</td>
					</tr>
					<tr>
						<td>
						应该发送短信条数：${smscount}
						</td>
					</tr>
					<tr>
						<td>
						发送短信成功条数：${smssuccount}	
						</td>
					</tr>	
				</table>
		  	</c:if>

			</td>
  			<td valign="top" width="40%">
  			各组合id与名称对应数据
				<table width="100%" border="0" cellpadding="2" cellspacing="0">
					<tr>
					  	<td align="center">组合id</td>
					  	<td>组合名称</td>
				  	</tr>
				  	<tr>
						<td align="center">1</td>
						<td>钟汉良&钟秀萍 </td>
				  	</tr>
				  	<tr>
					  	<td align="center">2</td>
					  	<td>李小鹏&李安琪  </td>
				  	</tr>
				  	<tr>
					  	<td align="center">3</td>
					 	<td>张铁林&张月亮</td>
				  	</tr>
				  	<tr>
					  	<td align="center">4</td>
					  	<td>金大川&刘畅 </td>
				  	</tr>
				  	<tr>
					  	<td align="center">5</td>
					  	<td>辰亦儒&周韦彤  </td>
				  	</tr>
				  	<tr>
					  	<td align="center">6</td>
					  	<td>郑伊健&陈小春  </td>
				  	</tr>
				  	<tr>
					  	<td align="center">7</td>
					  	<td>刘云&应采儿 </td>
				  	</tr>
				  	<tr>
					  	<td align="center">8</td>
					  	<td>白举纲&关晓彤 </td>
				  	</tr>
		  		</table>
  			</td>
  		</tr>
	</table>  
	</body>
</html>