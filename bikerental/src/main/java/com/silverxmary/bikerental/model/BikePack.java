package com.silverxmary.bikerental.model;

import javax.persistence.*;

@Entity
public class BikePack {

	
	//private Long id;
	private String nombre;
	private double precio;
	private int rentTime;

	public  BikePack() {
		// TODO Auto-generated constructor stub
	}
	
	public  BikePack(String nombre, int rentTime, boolean serv4) {
		this.nombre=nombre;
		this.rentTime=rentTime;
		setPrecio(rentTime, nombre, serv4); 
		
	}

	
	/*@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}*/
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(int time, String nombre, boolean serv4) {
		int calc=0;
			
			if(nombre.equalsIgnoreCase("1")){
				calc = 5*time;
			}else if(nombre.equalsIgnoreCase("2")){
				calc = 20*time;
			}else if(nombre.equalsIgnoreCase("3")){
				calc = 60*time;
			}
			if(serv4)
				this.precio=calc - (calc*0.30);
			else 
				this.precio=calc;
	}
	
	public int getRentTime() {
		return rentTime;
	}
	public void setRentTime(int rentTime) {
		this.rentTime = rentTime;
	}
	

}
