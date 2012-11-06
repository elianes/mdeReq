package mdereq;

import java.io.BufferedReader;

import utilities.Tool;

public class Requisito {
	
	private  String name;
	private  String text;
	private  String XMIid;
	private  String baseClass;
	
    public Requisito(String key, String text, String baseClass) {
    	this.XMIid = key; 
		this.text = text;
		this.baseClass = baseClass;
		this.name =  Tool.getTrieID(baseClass);
	}

	public String getName(){
		return this.name;
	}
	
	public String getText(){
		return this.text;
	}
	
	public String getXMIid(){
		
		return this.XMIid;
	}
	
	public String getBaseClass(){
		
		return this.baseClass;
	}
	
	public void printProp(){	
		System.out.printf("\t\tRequisito: %s Texto: %s \n" , 
				this.name, this.text);
	}
	
}
