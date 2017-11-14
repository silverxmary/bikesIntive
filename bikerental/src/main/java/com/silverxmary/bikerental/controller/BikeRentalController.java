package com.silverxmary.bikerental.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.silverxmary.bikerental.dao.BikeServiceDAO;
import com.silverxmary.bikerental.model.BikePack;
import com.silverxmary.bikerental.model.BikePackForm;
import com.silverxmary.bikerental.service.BikeService;


@Controller
public class BikeRentalController {
	
	//@Autowired
	private BikeService bikeService;
	//@Autowired
	private BikeServiceDAO bikeServiceDao;
	
//home
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", "true");
		return mv;
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", "true");
		return mv;
	}
	
	@RequestMapping(value = {"contact"})
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", "true");
		return mv;
	}
	@RequestMapping(value = {"listServices"})
	public ModelAndView listServices(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Services");
		mv.addObject("userClickServices", "true");
		return mv;
	}
	
	@RequestMapping(value = {"/selectpack/{service}"}, method = RequestMethod.GET)
	public ModelAndView selectpack(@PathVariable(value="service")  String service)  {
		ModelAndView mv = new ModelAndView("amountPreview");
		mv.addObject("packForm",new BikePack());
		mv.addObject("service", service);
		mv.addObject("title", "Services");
		return mv;// Statements

	}
	
	
	
	@RequestMapping(value = {"/check"}, method = RequestMethod.POST)
	public ModelAndView checkPack(@ModelAttribute("amountPreview")BikePack packForm,  Model model){
		BikePack selectPack = new BikePack(packForm.getNombre(),(int)packForm.getRentTime(),false);
		//BikePack res = bikeService.bikePack1(packForm.getNombre(),(int)packForm.getRentTime());
		ModelAndView mv = new ModelAndView("checkout");
		mv.addObject("nombre",selectPack.getNombre());
		mv.addObject("singlePack","true");
		mv.addObject("precio",selectPack.getPrecio());	    		
		 return mv; 

	}	
	
	
	////
	@RequestMapping(value = {"/famPack"}, method = RequestMethod.GET)
	public ModelAndView famPack()  {
		ModelAndView mv = new ModelAndView("amountPreview");
		mv.addObject("service", "4");
		mv.addObject("title", "Services");
		return mv;// Statements

	}

	@RequestMapping(value = {"/selectPacks"}, method = RequestMethod.GET)
	public ModelAndView famPack(@RequestParam("choose") String choosed)  {
		List<BikePack> packs = new ArrayList<BikePack>();
		BikePackForm  bikePackForm = new BikePackForm();
		ModelAndView mv = new ModelAndView("page");
		for (int i = 0;  i < Integer.parseInt(choosed); i++) {
			packs.add(new BikePack());
			}		
		bikePackForm.setBikePacksFam(packs);
		mv.addObject("userFamServ", "true");
		mv.addObject("service", "4");
		mv.addObject("title", "Services");
		mv.addObject("famPacksForm", bikePackForm);
		return mv;// Statements

	}
	
	
	
	@RequestMapping(value = {"/checkFamPack"}, method = RequestMethod.POST)
	public ModelAndView checkFamPack(@ModelAttribute("page")BikePackForm famPacksForm,  Model model){
		//BikePack selectPack = new BikePack(packForm.getNombre(),(int)packForm.getRentTime());
		Double precioFin =0.0;
		ModelAndView mv = new ModelAndView("checkout");
		List<BikePack> bikePack = famPacksForm.getBikePacksFam();
		List<BikePack> packs = new ArrayList<BikePack>();
		BikePackForm  bikePackForm = new BikePackForm();
		for (BikePack bp : bikePack) {
			//System.out.printf("%s \t %s \n", bp.getNombre(), bp.getRentTime());
			BikePack selectPack = new BikePack(bp.getNombre(),(int)bp.getRentTime(),true);
			precioFin=precioFin+selectPack.getPrecio();
			packs.add(selectPack);
		}
		
		bikePackForm.setBikePacksFam(packs);
		mv.addObject("famPacksForm", bikePackForm);
		mv.addObject("famPack", "true");
		//ModelAndView mv = new ModelAndView("checkout");
		mv.addObject("precioFin",precioFin);
		//mv.addObject("precio",selectPack.getPrecio());	    		
		 return mv; 

	}	
		
	
	//test/algun texto
		@RequestMapping(value = {"/test2/{greeting}"})
		public ModelAndView test2(@PathVariable(value="greeting", required=false)String greeting){
			if(greeting==null){
				greeting="HEllo test2";
			}
			ModelAndView mv = new ModelAndView("page");
			mv.addObject("greeting", greeting);
			return mv;
		}
	/*@RequestMapping(value = {"/checkout/{packForm}"})
		public ModelAndView checkout(@PathVariable(value="packForm", required=false)BikePack pack){
			//if(packForm==null){
			//	packForm="";
			//}
			ModelAndView mv = new ModelAndView("checkout");
			mv.addObject("service", packForm. );
			mv.addObject("greeting", greeting);
			return mv;
		}*/
}

