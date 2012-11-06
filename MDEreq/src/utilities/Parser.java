package utilities;

import mdereq.Elemento;
import mdereq.Ligacao;
import mdereq.Requisito;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Parser {

	public static void loadXMI(String inputFileName)throws IOException {
		String line, key, value;
		BufferedReader bf = new BufferedReader(new FileReader(inputFileName));
		while (bf.ready()) {
			line = bf.readLine();
			key = Tool.manipulate(line, "xmi:id");
									
			/*
			 * Requisito
			 */
			
			if (line.contains("<Requirements:Requirement")) {
						
				String text = Tool.manipulate(line, "text=");
				String baseClass = Tool.manipulate(line, "base_Class=");
				Requisito req = new Requisito(key, text, baseClass);
				Tool.putTrieRequisito(baseClass, req);  //inserindo com a chave da classe base
			}
			
			/*
			 * As ligações dos requisitos
			 */
						
			if (line.contains("<Requirements:DeriveReqt")) {
				value = Tool.manipulate(line, "base_Abstraction=");
				Ligacao lig = new Ligacao("DeriveReqt", key , value );
				Tool.putTrieLigacao(value, lig);  //inserindo com a chave da abstraçao base
			}
			
			if (line.contains("<Requirements:Satisfy")) {
				value = Tool.manipulate(line, "base_Abstraction=");
				Ligacao lig = new Ligacao("Satisfy", key , value );
				Tool.putTrieLigacao(value, lig);
				
			}
			
			if (line.contains("<Requirements:Copy")) {
				value = Tool.manipulate(line, "base_Abstraction=");
				Ligacao lig = new Ligacao("Copy", key , value );
				Tool.putTrieLigacao(value, lig);
			}
			
			if (line.contains("<Requirements:Verify")) {
				value = Tool.manipulate(line, "base_Abstraction=");
				Ligacao lig = new Ligacao("Verify", key , value );
				Tool.putTrieLigacao(value, lig);
			}
						
			if (!(line.contains("/>"))){
				if(line.contains("uml:Class")){
					Elemento elem = new Elemento();
					elem.load(bf,line);
				    Tool.putTrieElemento(key, elem);  //inserindo com a chave do xmi:id da linha lida
				}
			}
			
			
			if (line.contains("uml:Abstraction")){
				Elemento elem = new Elemento();
				elem.load(bf,line);
				Tool.putTrieElemento(key, elem);
			
			}
		   		       
		}
	   		
	}
	
}
