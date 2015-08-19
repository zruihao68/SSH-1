<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'easyUI.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript"   src="easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
	<script type="text/javascript"   src="easyui/plugins/jquery.datagrid.js"></script>
	<script type="text/javascript"src="http://www.jeasyui.com/easyui/jquery.edatagrid.js"></script>
	
  </head>
  <script type="text/javascript">
  $(function(){
 

 
 
  
  	$('#tt').datagrid({    
    url:'emp-easyUI',
    destroyUrl:'emp-delete',
    width:400,
    nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
    fitColumns:true,//允许表格自动缩放，以适应父容器
    toolbar:"#toolbar",
    pageSize : 2,//默认选择的分页是每页5行数据
    pageList : [ 2, 4, 8, 16 ],//可以选择的分页集合
    columns:[[    
        {field:'lastName',title:'名称',width:100},    
        {field:'email',title:'邮箱'},    
        {field:'birth',title:'生日',align:'right'},
        {field:'department',title:'部门',width:100,
        	 formatter:function(value,rec){
      			// return ((Object)( rec.department).departmentName);
     			return ((Object)(value).departmentName);
     		 }
        
        }   
      ]],   
      pagination : true,//分页
      rownumbers : true//行数
   
    });  
  
  	
  
 
  
});
function showBox(){
  	 $("#dlg").dialog("open").dialog('setTitle', 'New User'); ;
     $("#fm").form("clear");
     
      document.getElementById("hidtype").value="submit";
  	}

 function saveuser(){
 	$("form:first").submit();
 }
  
  	
  </script>
  
  <body>
    <table id="tt"></table>
    <div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#tt').edatagrid('addRow')">新建</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#tt').edatagrid('destroyRow')">删除</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#tt').edatagrid('saveRow')">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#tt').edatagrid('cancelRow')">撤销</a>
    </div> 
    
    <div id="dlg" class="easyui-dialog" style="width: 400px; height: 280px; padding: 10px 20px;"
       closed="true" buttons="#dlg-buttons"> 
       <div class="ftitle"> 
           信息编辑 
       </div> 
       <form id="fm" method="post" action="emp-save"> 
       <div class="fitem"> 
           <label> 
               名称
           </label> 
           <input name="lastName" class="easyui-validatebox" required="true" /> 
       </div> 
       <div class="fitem"> 
           <label> 
               邮箱</label> 
           <input name="email" class="easyui-validatebox" required="true" /> 
       </div> 
       <div class="fitem"> 
           <label> 
               生日</label> 
           <input name="birth" class="easyui-datebox" required="true" /> 
       </div> 
       <div class="fitem"> 
           <label> 
               部门</label> 
           <input name="department.departmentName" class="easyui-validatebox" required="true" /> 
       </div> 
        <input type="hidden" name="action" id="hidtype" /> 
       <input type="hidden" name="id" id="Nameid" /> 
       </form> 
   </div>
 <div id="dlg-buttons"> 
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveuser()" iconcls="icon-save">保存</a> 
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg').dialog('close')"
            iconcls="icon-cancel">取消</a> 
    </div>
       
  </body>
</html>
