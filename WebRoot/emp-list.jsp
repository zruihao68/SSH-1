<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
  <script type="text/javascript">
  	$(function(){
  		$(".delete").click(function(){
  			var $tr = $(this).parent().parent();
  			var name = $(this).next(":input").val();
  			var con=confirm("你确定要"+name+ "删除！");
  			if(con){
  				//删除 执行Ajax
  				var url = this.href;
  				var args = {"time": new Date()};
  				$.post(url,args,function(data){
  				
  				 if(data==1){
  				 	$tr.remove();
  				 }
  				});
  				
  			}
  			return false;
  		});
  	
  	});
  
  
  </script>
  
  <body>
    <h4>Employee list Page</h4>
    <s:if test="#request.employees == null||#request.employees.size()==0">
    	没有员工信息
    </s:if>
    <s:else>
    	<table border="1"  cellpadding="10" cellspacing="0">
    		<tr>
    			<th>ID</th>
    			<th>LASTNAM</th>
    			<th>EMAIL</th>
    			<th>BIRTH</th>
    			<th>createtime</th>
    			<th>dept</th>
    			<th>delete</th>
    		</tr>
    		<s:iterator value="#request.employees">
    		<tr>
    			<td>${id }</td>
    			<td>${lastName }</td>
    			<td>${email }</td>
    			<td>${birth }</td>
    			<td>${createTime }</td>
    			<td>${department.departmentName}</td>
    		
    			<td>
    				<a href="emp-delete?id=${id}" class="delete">delete</a>
    				<input type="hidden" value="${lastName}"/>
    			</td>
    			<td>
    				<a href="emp-input?id=${id}">Eid</a>
    			</td>
    		</tr>
    	</s:iterator>
    	</table>
    </s:else>
  </body>
</html>
