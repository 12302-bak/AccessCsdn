package com.csdn.access;

import java.util.ArrayList;
import java.util.List;

public class Start_access extends Thread {
	//private String name;
	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < 1000; i++) {
			new Start_access((new Integer(i)).toString()).start();
			Thread.sleep(2000);
		}
	    System.out.println("Program has done!");
	}
	
	public Start_access(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void run(){
		access(this.getName());
		//System.out.println(this.getName());
	}
	public void access(String str){
		List<String> listUrl=new ArrayList<String>();
		Get_Link gk=new Get_Link();
		listUrl=gk.get_link_list();
	    System.out.println("---Thread name "+str+" Accessing is begin---");
	    Go_access ga=new Go_access();
		for(int j=0;j<10000000;j++){
	    	//System.out.println("  \t \t Thread cycle\t"+(++j)+" accessed");
	    	ga.go_access_link(listUrl);
		}
	}
}
