package mdereq;

public class Ligacao {

	private  String name;
	private  String XMIid;
	private  String baseAbstraction;
	
	public Ligacao(String name, String XMIid, String baseAbstraction){
		this.name = name;
		this.XMIid = XMIid;
		this.baseAbstraction = baseAbstraction;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getXMIid(){
		return this.XMIid;
	}
	
	public String getBaseAbstraction(){
		return this.baseAbstraction;
	}
	
	public void printProp(){	
		System.out.println("Ligação: " + this.name + "  #  XMI:id = "+ this.XMIid + "  #  base_abstraction" + this.baseAbstraction+ "------------------------");
	}

}
