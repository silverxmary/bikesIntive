package com.silverxmary.bikerental.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.silverxmary.bikerental.model.BikePack;

@Service
@Transactional
public class BikeServiceImpl implements BikeService{

	public BikePack bikePack1(String nombre, int time) {
		BikePack selectPack = new BikePack(nombre,time, false);
		return selectPack;
	}

	public BikePack bikePack2() {
		// TODO Auto-generated method stub
		return null;
	}

	public BikePack bikePack3() {
		// TODO Auto-generated method stub
		return null;
	}

	public BikePack bikePack4() {
		// TODO Auto-generated method stub
		return null;
	}

	public BikePack selectService(int pack) {
		// TODO Auto-generated method stub
		return null;
	}

}
