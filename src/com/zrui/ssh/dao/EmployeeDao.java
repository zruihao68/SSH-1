package com.zrui.ssh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zrui.ssh.entities.Employee;


public class EmployeeDao extends BaseDao{
	
	
	//eid
	public Employee onequery(Integer id){
	
		
		return (Employee) getSession().get(Employee.class, id);
	}
	//ajax 验证
	public Employee getName(String name){
		String hql = "FROM Employee e WHERE e.lastName = ?";
		return (Employee) getSession().createQuery(hql).setString(0, name).uniqueResult();
	}
	
	
	//save
	public void save(Employee  employee){
		getSession().saveOrUpdate(employee);
	}
	
	//删除
	public void delete(Integer id){
		String hql="DELETE FROM Employee e WHERE e.id=?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
		
	}
	
	//查询
	public List<Employee> getAll(){
		String hql = "FROM Employee e left join fetch e.department ";
		return getSession().createQuery(hql).list();
	}
	
	//分页
	public List<Employee> pageAll(String page,String rows){
		//当为缺省值的时候进行赋值
        int currentpage = Integer.parseInt((page == null || page == "0") ? "1": page);//第几页
        int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10": rows);//每页多少行
         
        List<Employee> list = getSession().createQuery("FROM Employee e left join fetch e.department")
                       .setFirstResult((currentpage - 1) * pagesize).setMaxResults(pagesize).list();
 
        return list;
		
	}
	
	
	
	
	
}
