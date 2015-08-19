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
    
    <title>My JSP 'emp-input.jsp' starting page</title>
    
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
  		$("#lastname").change(function(){
  			//	alert("aa");
  			var name = $(this).val();
  			name = $.trim(name);
  			if(name != ""){
  			
  			$("#lastname").nextAll("font").remove();
  			  //	alert("执行Ajax");
  			  	 var url = "emp-ajaxUser";
  			  	 var args= {"lastName":name,"time":new Date()};
  				 $.post(url,args,function(data){
  				 	if(data=="1"){
  					$("#lastname").after("<font color='green'>"+name+"可用</font>");
  					}else if(data == "0"){
  					$("#lastname").after("<font color='red'>"+name+"不可用</font>");	
  					}
  				 });
  			}else{
  				alert("lastname不能为空！");
  			}
  		});	
  	});
  
  
  
  
  </script>
  <body>
    	<h3>INPUT Page</h3>
    	<s:form action="emp-save">
    		<s:hidden name="id"></s:hidden>
    		<s:textfield name="lastName" label="LastName" id="lastname"></s:textfield>
    		<s:textfield name="email" label="Email"></s:textfield>
    		<s:textfield name="birth" label="Birth"></s:textfield>
    		<s:select list="#request.departments" listKey="id" 
    				listValue="departmentName" name="department.id" label="Department"></s:select>
    		<s:submit></s:submit>
    	</s:form>
    	
  </body>
</html>
