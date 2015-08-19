package com.zrui.ssh.service;

import java.util.List;

import com.zrui.ssh.dao.EmployeeDao;
import com.zrui.ssh.entities.Department;
import com.zrui.ssh.entities.Employee;

public class EmployeeSerice {
	
	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	//查询操作
	public List<Employee> getAll(){
		return employeeDao.getAll();
	}
	//删除
	public void delete(Integer id){
		employeeDao.delete(id);
	}
	//save
	public void save(Employee  employee){
		employeeDao.save(employee);
	}
	
	//eid
	public Employee onequery(Integer id){
		return employeeDao.onequery(id);
	}
	
	public boolean getName(String name){
		boolean atr = employeeDao.getName(name)==null;
		return atr;
	}
	
	public List<Employee> pageAll(String page,String rows){
		return employeeDao.pageAll(page, rows);
		
	}
	
}
