package com.takeo;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.takeo.entity.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      //step 1: Create configuration object
    	Configuration cfg=new Configuration();
    	
    	System.out.println(cfg.getProperty("hibernate.connection.driver_class"));
    	
    	cfg.configure("com\\takeo\\config\\hibernate.cfg.xml");
    	
    	System.out.println(cfg.getProperty("hibernate.connection.driver_class"));
    	
    	
    	//step 2: Build session Object
    	SessionFactory factory=cfg.buildSessionFactory();
    	
    	//step 3: Open Session Object
    	Session ses=factory.openSession();
    	
    	Transaction tx=ses.beginTransaction();
    	
    	//Step 4: to perform Persistence
    	
    	Product pro=new Product();  //Transient Object
    	
    //	pro.setPname("TV");
    //	pro.setQty(25);
    //	pro.setPrice(25000);
    	
  //  	Integer id=(Integer)ses.save(pro); //persistence state
    	
    	
    	//Using HQL
    	Query q=ses.createQuery("from Product");
    	
    	List <Product>  productInfo= q.getResultList();
    	
    	productInfo.forEach(
    			p->{
    			System.out.println(p.getPid()+"\t"+ p.getPname()+"\t"+p.getQty()+"\t"+p.getPrice());
    			}
    			);
    	
    	
    	tx.commit();
    	ses.close();  //detached state factory
    	factory.close();
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}
