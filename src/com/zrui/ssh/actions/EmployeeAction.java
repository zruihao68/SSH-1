package com.zrui.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;







import javax.servlet.http.HttpServletResponse;







import net.sf.json.JSONArray;




import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.zrui.ssh.entities.Employee;
import com.zrui.ssh.service.DepartmentService;
import com.zrui.ssh.service.EmployeeSerice;
import com.zrui.ssh.util.JsonDateValueProcessor;

public class EmployeeAction extends ActionSupport implements RequestAware,ModelDriven<Employee>,Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmployeeSerice empserice;
	
	private String page; //当前第几页
	private String rows; //每页显示的行数
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public void setEmpserice(EmployeeSerice empserice) {
		this.empserice = empserice;
	}
	private Integer id;
	public void setId(Integer id) {
		this.id = id;
	}
	
	private InputStream inputStream;
    public InputStream getInputStream() {
        return inputStream;
    }
	
    private DepartmentService departmentService;
    
    public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
    
    //查询出部门信息
    public String input(){
    	request.put("departments", departmentService.getAll());
    	return "input";
    }
    
    public void prepareInput(){
		if(id!=null){
		model=empserice.onequery(id);
		}
		
	}
    private String result;
    
    public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	private Map<String,Object> dataMap;
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void easyUI() throws IOException{
		
//    	result = JSONArray.fromObject(empserice.getAll()).toString();
//    	
//	    dataMap = new HashMap<String,Object>();
//		Employee emp = new Employee();
//		
//		emp.setLastName("aa");
//		emp.setEmail("aa@163.com");
//		emp.setBirth(new Date());
//		emp.setCreateTime(new Date());
//    	dataMap.put("employee", emp);
    	
//    	return "easyUI";
		//查询全部
		/*HttpServletResponse response=ServletActionContext.getResponse();  //
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//处理日期类型转换
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd"));
		//将List 转换成JSON
		String json =   JSONArray.fromObject(empserice.getAll(),jsonConfig).toString();
		out.println(json.toString());
		out.flush();
		out.close();*/
	
		HttpServletResponse response=ServletActionContext.getResponse();  //
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//处理日期类型转换
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd"));
		//将List 转换成JSON
		 JSONObject jobj = new JSONObject();//new一个JSON
         jobj.accumulate("total",empserice.getAll().size() );//total代表一共有多少数据
         jobj.accumulate("rows", empserice.pageAll(page, rows),jsonConfig);//row是代表显示的页的数据
		out.println(jobj.toString());
		out.flush();
		out.close();
    }
	//删除 --- Ajax
	public String delete(){
		 try {
			empserice.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("utf-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		return "ajax-success";
	}
	private String lastName;
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//Ajax验证
	public String ajaxUser() throws UnsupportedEncodingException{
	
		
			 if(empserice.getName(lastName)){
				 inputStream = new ByteArrayInputStream("1".getBytes("utf-8"));
			 }else{
				 inputStream = new ByteArrayInputStream("0".getBytes("utf-8"));
				 
			 }
		return "ajax-success";
	}
	
	
	
	
	
	//查询
	public  String list(){
	
		request.put("employees", empserice.getAll());
		
		return "list";
	}
	Map<String,Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
		
	}
	
	//保存插入
	public String save(){
		if(id==null){
			model.setCreateTime(new Date());
		}
			empserice.save(model);
		return "save";
	}
	
	public void prepareSave(){
		if(id == null ){
		model = new Employee();
		}else{
			model=empserice.onequery(id);
		}
	}
     

	

	
	@Override
	public void prepare() throws Exception {}
	
	private Employee model;
	@Override
	public Employee getModel() {
		
		return model;
	}
	
}
