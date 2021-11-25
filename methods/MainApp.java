package com.hibernateemployee.methods;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernateemployee.entity.Employee;

import net.bytebuddy.build.Plugin.Factory;

public class MainApp {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		try {
			List<Employee> e=new ArrayList<>();
			Employee e1=new Employee("Raman","Singhaniya","ramanS@gmail.com","Male",DateUtils.parseDate("20/01/1997"));
			Employee e2=new Employee("Shyam","Pathak","shyamP@gmail.com","Male",DateUtils.parseDate("10/11/1970"));
			Employee e3=new Employee("Scooby","Singh","scoobyS@gmail.com","Male",DateUtils.parseDate("20/01/1997"));
			Employee e4=new Employee("Shilpa","Pandey","shiplaP@gmail.com","Female",DateUtils.parseDate("05/07/1999"));
			Employee e5=new Employee("Arsheen","Kaur","arsheenK@gmail.com","Female",DateUtils.parseDate("13/03/2000"));
			e.add(e1);
			e.add(e2);
			e.add(e3);
			e.add(e4);
			e.add(e5);

			// Saving the 5 objects
			/*for(Employee li:e)
			{
				Session session=factory.getCurrentSession();
				session.beginTransaction();
				session.save(li);
				session.getTransaction().commit();				
			}*/
			
			// retrieving all employees
			Session session=factory.getCurrentSession();
			session.beginTransaction();
			List<Employee> list=session.createQuery("from Employee",Employee.class).getResultList();
			session.getTransaction().commit();
			for(Employee a:list)
			{
				System.out.println(a);
			}
			
			// updating a employee
			
			
			// Deleting without using query
			// Employee myEmployeeObject=session.get(Employee.class, 1000); // here 1000 is id//primaryKey
			// session.delete(myEmployeeObject);
			
			
			// Deleting some employees using query
			/*
			Session session2=factory.getCurrentSession();
			session2.beginTransaction();
			session2.createQuery("delete Employee e where e.id>1005").executeUpdate();
			session2.getTransaction().commit();
			*/
			
			// Updating using query
			/*
			Session session3=factory.getCurrentSession();
			session3.beginTransaction();
			session3.createQuery("update Employee e set last_name='Karan' where e.id=1000").executeUpdate();
			session3.getTransaction().commit();
			*/
			// other way
			Session session3=factory.getCurrentSession();
			session3.beginTransaction();
			Employee myEmployeeObject=session3.get(Employee.class, 1000); // here 1000 is id//primaryKey
			myEmployeeObject.setFirstName("Chaman");
			session3.getTransaction().commit();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			factory.close();
		}
		

	}

}
