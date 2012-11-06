package utilities;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import mdereq.Elemento;
import mdereq.Ligacao;
import mdereq.Requisito;

public class Tool {
	
	private static TreeMap<String, String> trieID = new TreeMap<String, String>();
	
	private static TreeMap<String, Ligacao> trieLigacao = new TreeMap<String, Ligacao>();  
	
	private static TreeMap<String, Requisito> trieRequisito = new TreeMap<String, Requisito>();
	
	private static TreeMap<String, Elemento> trieElemento = new TreeMap<String, Elemento>();
		
	private static Object trieAux = new TreeMap<String, Object>();
	/*
	 * Trie ID
	 */
	public static void putTrieID(String key, String value){
		trieID.put(key, value);
	}
	
	public static String getTrieID(String key){
		return trieID.get(key);
	}
	
	/*
	 * Trie ligações
	 */
	public static void putTrieLigacao(String key, Ligacao ligacao){
		trieLigacao.put(key, ligacao);
	}
	
	public static Ligacao getTrieLigacao(String key){
		return trieLigacao.get(key);
	}
	
	/*
	 * Trie Requisitos
	 */
	
	public static void putTrieRequisito(String key, Requisito requisito){
		trieRequisito.put(key, requisito);
	}
	
	public static Requisito getTrieRequisito(String key){
		return key == null ? null : trieRequisito.get(key);
	}
	
	/*
	 * Trie Elementos
	 */
	
	public static void putTrieElemento(String key, Elemento elemento){
		trieElemento.put(key, elemento);
	}
	
	public static Elemento getTrieElemento(String key){
		return key == null ? null : trieElemento.get(key);
	}
	
	/*
	 * manipulate: Return a substring of key from String str.
	 */
	public static String manipulate(String str, String key) {
		int n = str.indexOf(key);
		if (n == -1) {
			return "";
		}
		int x = str.indexOf("\"", n);
		int x1 = str.indexOf("\"", x + 1);
		return str.substring(x + 1, x1);
	}

	
	public static void loadXMI(String inputFileName) throws IOException {
		String line, key, value;
		BufferedReader bf = new BufferedReader(new FileReader(inputFileName));
		while (bf.ready()) {
			line = bf.readLine();
			key = Tool.manipulate(line, "xmi:id");
			if (key != null) {
				value = Tool.manipulate(line, "name=");
				if(value != ""){
					trieID.put(key, value);
				}
			}
		}
	}

	public static void printRequisitos() {
		System.out.println("DENTRO DO TOOL");
        Iterator<Requisito> it = trieRequisito.values().iterator();
       
        while(it.hasNext()) {
            Requisito req = (Requisito) it.next();
            req.printProp();
           
        }
 
	}
	
	public static void printElementos() {
		System.out.println("DENTRO DO TOOL");
        Iterator<Elemento> it = trieElemento.values().iterator();
       
        while(it.hasNext()) {
            Elemento elem = (Elemento) it.next();
            elem.printProp();
           
        }
 
	}
	
	public static void printLigacoes() {
		System.out.println("DENTRO DO TOOL");
        Iterator<Ligacao> it = trieLigacao.values().iterator();
       
        while(it.hasNext()) {
            Ligacao lig = (Ligacao) it.next();
            lig.printProp();
           
        }
 
	}
	
	public static void combinacao(){
		System.out.println("##########  combinações ############");
        Iterator<Requisito> it_req = trieRequisito.values().iterator();
        Iterator<Ligacao> it_lig = trieLigacao.values().iterator();
      
        String key1,key2;
        int i=0;
        while(it_lig.hasNext()) {
        	Ligacao lig = (Ligacao) it_lig.next();
            key2 = lig.getBaseAbstraction();
            i++;
           //System.out.println("------- ligaçao -------"  + i);
           // lig.printProp();
           // System.out.println("\n\n CHAVE : " + key2);
            
            if(lig.getName().equals("decompoe")){
                System.out.println("REQUISITO: " + trieRequisito.get(lig.getBaseAbstraction()).getName() + "  | LIGAÇÃO: " + lig.getName()+ "  | REQUISITO : " + trieRequisito.get(lig.getXMIid()).getName());
            }
            else{
            	if(trieElemento.containsKey(key2)){
            		Elemento elem = trieElemento.get(key2);
            		if (elem.getType().equals("uml:Abstraction")) {
            			loadAbstraction(elem);
               	 	}
            		if (elem.getType().equals("uml:Class")) {
            			elem = trieElemento.get(elem.getClientDependeny());
            			loadAbstraction(elem);
            		}
            	}
            }
        }
	}

	private static void loadAbstraction(Elemento elem) {
		String x = elem.getSupplier();  //REQUISITO DE ENTRADA 
		String y = elem.getClient();    //REQUISITO DE SAIDA
		 System.out.print("REQUISITO : ");
		 if(elem.getType().equals("uml:Abstraction")){
			 System.out.print( trieRequisito.get(y).getName() );
		 	 System.out.print( "  | LIGAÇÃO: " + elem.getName()); 	
		 	 System.out.print("  | REQUISITO : ");
			 System.out.println(trieRequisito.get(x).getName());
		 }
	}
	
}
