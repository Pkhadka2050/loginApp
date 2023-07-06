package com.takeo.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.takeo.entity.Product;

public class UpdateClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Step 1: Creating Configuration onject
		Configuration cfg=new Configuration();
		
		cfg.configure("com\\\\takeo\\\\config\\\\hibernate.cfg.xml");
		
		//step 2: Build Session Factory
		SessionFactory factory=cfg.buildSessionFactory();
		
		//setp 3: Open the session
		Session ses=factory.openSession();
		 Transaction tx=ses.beginTransaction();
		 
		 //step 4: persistense error
		 Product pro=new Product();
		 
		 pro.setPid(4);
		 pro.setPname("Laptop");
		 pro.setQty(20);
		 pro.setPrice(50000);
		 
		 
		 
		 Object obj=ses.merge(pro);
		 
		 Product product=(Product)obj;
		 
		 System.out.println(pro.getPid()+"\t"+pro.getPname()+"\t"+pro.getQty()+"\t"+pro.getPrice());
		 
		 tx.commit();
		
		 
		 
		 
		 //Or we can do this as well saveorupdate method
		 
		 /*
		 ses.saveOrUpdate(pro);
		 
		 tx.commit();
		*/

	}

}
