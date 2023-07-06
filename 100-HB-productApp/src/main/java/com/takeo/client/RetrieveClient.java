package com.takeo.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.takeo.entity.Product;

public class RetrieveClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//step 1: Create Configuration Object
		Configuration cfg=new Configuration();
		
		cfg.configure("com\\takeo\\config\\hibernate.cfg.xml");
		
		//step 2: Build Session Factory
		SessionFactory factory=cfg.buildSessionFactory();
		
		//step 3: Open The session
		
		Session ses=factory.openSession();
		
		Transaction tx=ses.beginTransaction();
		
		//step 4: Persistence operations
		
		Product pro= ses.get(Product.class, 1);
		
		if(pro != null)
			System.out.println(pro.getPid()+"\t"+pro.getPname()+"\t"+pro.getQty()+"\t"+pro.getPrice());
		
		
		
	/*	
		//OR we can use Load method as well
		Product pro1=ses.load(Product.class, 1);
		
		System.out.println(pro.getPid()+"\t"+pro.getPname()+"\t"+pro.getQty()+"\t"+pro.getPrice());
		
		*/
		ses.close();
		
		factory.close();
		
		

	}

}
