package com.silverxmary.bikerental.service;

import com.silverxmary.bikerental.model.BikePack;

public interface BikeService {

	
	public abstract BikePack bikePack1(String nombre, int tiempo);
	public abstract BikePack bikePack2();
	public abstract BikePack bikePack3();
	public abstract BikePack bikePack4();
	
	public BikePack selectService(int pack);
	
}
