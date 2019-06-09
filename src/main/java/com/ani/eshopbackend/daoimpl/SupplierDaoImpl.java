package com.ani.eshopbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ani.eshopbackend.dao.SupplierDao;
import com.ani.eshopbackend.model.Supplier;

@Component(value="suppDaoImpl")
public class SupplierDaoImpl implements SupplierDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean saveSupplier(Supplier supplier) {
		System.out.println("---------------------"+sessionFactory);
		System.out.println("from saveSupplier supId= "+supplier.getSupplierId());
		

		Session session=sessionFactory.openSession();
		if(supplier.getSupplierId()==0)
		{
	    int id=(int)(Math.random()*10000);
	   	supplier.setSupplierId(id);
		}
		session.saveOrUpdate(supplier);
		Transaction transaction=session.beginTransaction();
		
		try {
		
			transaction.commit();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			session.close();
		
		}
		
		
		
		
		
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		System.out.println("Supplier Id="+supplier);
		  
		Session session=sessionFactory.openSession();
		//Supplier supplier=getSupplier(supplier);
		session.delete(supplier);
		Transaction transaction=session.beginTransaction();
	    transaction.commit();
	    session.close();
		return false;
		
	}

	@Override
	public Supplier getSupplier(int supplierId) {

		Session session=sessionFactory.openSession();
		Supplier supplier=session.get(Supplier.class,supplierId);
		System.out.println("from SupplierDaoimpl "+supplierId);

		session.close();
		return supplier;
		
	}

	@Override
	public List<Supplier> getSupplier() {
		Session session=sessionFactory.openSession();
		 Query query=session.createQuery("from  com.ani.eshopbackend.model.Supplier");
		 List<Supplier> listSupplier=query.list();
		 /*for(Supplier sup:listSupplier)
		 {
			Supplier supplier=sup;
			System.out.println("id = "+ supplier.getSupplierId());
			System.out.println("Name = "+ supplier.getSupplierName());
			System.out.println("Description = "+ supplier.getSupplierDescription());
		 }*/
		 session.close();
		 return listSupplier;
		
	}

}
