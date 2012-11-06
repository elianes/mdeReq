package utilities;

import java.io.IOException;

import mdereq.Requisito;
import mdereq.tela_matriz;

public class Main {

	public static void main(String[] args) throws IOException  {

		String inputFileName = "model.uml";
		//inputFileName = "in/" + inputFileName;
		
		Tool.loadXMI(inputFileName);

		Parser.loadXMI(inputFileName);
		
		Model.run();
		
	}

}
