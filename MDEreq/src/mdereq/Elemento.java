package mdereq;

import java.io.BufferedReader;
import java.io.IOException;

import utilities.Tool;

public class Elemento {
	private  String name;
	private  String type;
	private  String XMIid;
	private  String clientDependency;
	private  String client;
	private  String supplier;
	
	public String getName(){
		return this.name;
	}
		
	public String getType(){
		return this.type;
	}
	
	public String getXMIid(){
		return this.XMIid;
	}
		
	public String getClientDependeny(){
		return this.clientDependency;
	}
	
	public String getClient(){
		return this.client;
	}
	
	public String getSupplier(){
		return this.supplier;
	}

	public void load(BufferedReader bf, String line) throws IOException {
		this.XMIid = Tool.manipulate(line, "xmi:id="); 
		this.type = Tool.manipulate(line, "xmi:type=");
		this.clientDependency = Tool.manipulate(line, "clientDependency=");
		this.client = Tool.manipulate(line, "client=");
		this.supplier = Tool.manipulate(line, "supplier=");
		this.name =  Tool.getTrieID(this.XMIid);

		if(!(line.contains("/>"))){
			line= bf.readLine();
			while(line.contains("<nestedClassifier")) {
				String key;
				key = Tool.manipulate(line, "xmi:id");
				Ligacao lig = new Ligacao("decompoe", key , this.XMIid );
				Tool.putTrieLigacao(key, lig);
				line= bf.readLine();
				
			}
		}
	}

	public void printProp(){	
		System.out.printf("Elemento: %s Tipo: %s \n" , 
				this.name, this.type);
	}
}
