package com.ani.eshopbackend.dao;

import java.util.List;

import com.ani.eshopbackend.model.Supplier;

public interface SupplierDao {

	boolean saveSupplier(Supplier supplier);
	boolean deleteSupplier(Supplier supplier);
	Supplier getSupplier(int Supplier);
	
	List<Supplier> getSupplier();
	
}
