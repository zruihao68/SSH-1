package com.zrui.ssh.service;

import java.util.List;

import com.zrui.ssh.dao.DepartmentDao;
import com.zrui.ssh.entities.Department;

public class DepartmentService {

	
   private	DepartmentDao departmentdao;
   public void setDepartmentdao(DepartmentDao departmentdao) {
	this.departmentdao = departmentdao;
   }
   
   //返回查询部门
   public List<Department> getAll(){
	   return departmentdao.getAll();
   }
}
