package com.jdc.entity;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	Scanner sc = new Scanner(System.in);

	public void addData() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernat.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		while (true) {
			Session session = factory.openSession();

			System.out.println("Enter all Details...");
			System.out.println("Enter Name : ");
			String name = sc.next();
			System.out.println("Enter City : ");
			String city = sc.next();
			System.out.println("Enter Dept : ");
			String dept = sc.next();
			Employee e1 = new Employee(name, city, dept);
			Transaction tx = session.beginTransaction();

			session.save(e1);
			tx.commit();
			session.close();

			System.out.println("Want to add another...? [Y / N]");
			String opt = sc.next();
			if (opt.equalsIgnoreCase("N")) {
				break;
			}
		}

		System.out.println("All Data inserted Successfully....");
	}

	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	
	public void fetchData() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernat.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		while(true) {
			Session session = factory.openSession();

			System.out.println("Enter id : ");
			int id = sc.nextInt();

			Employee emp = session.get(Employee.class, id);

			System.out.println(">>>>  "+emp.getId() + "  " + emp.getName() + "  " + emp.getCity() + "  " + emp.getDept()+"  <<<<");
			
			System.out.println("Want to get another data ....? [Y / N]");
			String opt1 = sc.next();
			
			if(opt1.equalsIgnoreCase("N")) {
				break;
			}
		}
		
		System.out.println("Thank You !");
	}

	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	

	public static void main(String[] args) {
		
		Test t = new Test();
		
		// t.addData();
		// t.fetchData();
		
	}
}
