package mdereq;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class tela_matriz {

	public tela_matriz(){
		/*um GridLayout com 4 linha e 3 colunas
		* o GridLayout também pode especificar o intervalo veritical
		* e horizontal entre as células*/
		GridLayout layout = new GridLayout(6, 6);

		//instancia um objeto do JPanel
		JPanel pane = new JPanel(layout);
      
		pane.setBorder(borda);
        
		pane.add(new Label("            "));
		pane.add(new Label("Col 2 Lin 1"));
		pane.add(new Label("Col 3 Lin 1"));
		pane.add(new Label("Col 4 Lin 1"));
		pane.add(new Label("Col 1 Lin 2"));
		pane.add(new Label("Col 2 Lin 2"));
		pane.add(new Label("Col 3 Lin 2"));
		pane.add(new Label("Col 4 Lin 2"));
		pane.add(new Label("Col 1 Lin 3"));
		pane.add(new Label("Col 2 Lin 3"));
		pane.add(new Label("Col 3 Lin 3"));
		pane.add(new Label("Col 4 Lin 3"));
		pane.add(new Label("Col 1 Lin 1"));
		pane.add(new Label("Col 2 Lin 1"));
		pane.add(new Label("Col 3 Lin 1"));
		pane.add(new Label("Col 4 Lin 1"));
		pane.add(new Label("Col 1 Lin 2"));
		pane.add(new Label("Col 2 Lin 2"));
		pane.add(new Label("Col 3 Lin 2"));
		pane.add(new Label("Col 4 Lin 2"));
		pane.add(new Label("Col 1 Lin 3"));
		pane.add(new Label("Col 2 Lin 3"));
		pane.add(new Label("Col 3 Lin 3"));
		pane.add(new Label("Col 4 Lin 3"));
		pane.add(new Label("Col 1 Lin 1"));
		pane.add(new Label("Col 2 Lin 1"));
		pane.add(new Label("Col 3 Lin 1"));
		pane.add(new Label("Col 4 Lin 1"));
		pane.add(new Label("Col 1 Lin 2"));
		pane.add(new Label("Col 2 Lin 2"));
		pane.add(new Label("Col 3 Lin 2"));
		pane.add(new Label("Col 4 Lin 2"));
		pane.add(new Label("Col 1 Lin 3"));
		pane.add(new Label("Col 2 Lin 3"));
		pane.add(new Label("Col 3 Lin 3"));
		pane.add(new Label("Col 4 Lin 3"));

		JFrame frame = new JFrame("Testanto Interface");

		frame.setContentPane(pane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
}

public static void main(String[] args){
	tela_matriz e = new tela_matriz();
}
}

/*
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;





public class tela_matriz extends Component{
	/**
	 * 
	 */
/*
	private static final long serialVersionUID = 1L;
	int lado;
	// tamanho do lado de cada quadrado, em pixels
	int matriz[][];
	// a matriz do quebra-cabeca;
	int linVazia,colVazia;
	// coordenadas da casa vazia
	Dimension tam;
	//
	MouseListener m;

	public tela_matriz(int tamanho){
		tam = new Dimension(tamanho, tamanho);
		lado = tamanho/4; // sao 4 quadrados em cada linha
		matriz = new int[4][4];
/* ***
*
O código abaixo usa uma classe local anônima para gerar o ouvinte de eventos de mouse.
*
O ouvinte será referenciado pela variável m.
*
Essa classe é sub-classe de MouseAdapter, e só redefine o método MouseReleased.
*
Os demais métodos da interface MouseListener continuarão vazios.
*** 
	
		m = new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				int colClic = e.getX()/lado;
				int linClic = e.getY()/lado;
				if (colClic < 4 &&  linClic<4 && colVazia==colClic && (Math.abs(linVazia-linClic)==1) || linVazia == linClic && (Math.abs(colVazia-colClic)==1)){
						matriz[linVazia][colVazia]= matriz[linClic][colClic];
						matriz[linVazia=linClic][colVazia=colClic]=0;
						repaint();
				}
			}
		};
		for (int lin =0;lin<4;lin++)
			for (int col=0; col<4; col++)
				matriz[3-col][3-lin] = 4*lin + col + 1;
		linVazia=colVazia=0;	
		matriz[0][0]=0;
		addMouseListener(m);
	} // fim do construtor

	void desenhaQuadr(Graphics g, int lin, int col) {
// somente o quadrado "vazio" nao será desenhado (e ficará preto)
// note que a grade não precisa ser desenhada. Apenas nao é preenchida com nada.
		if(matriz[lin][col] !=0){
			g.clearRect(col*lado+1, lin*lado+1, lado-2, lado-2);
			g.drawString(new Integer(matriz[lin][col]).toString(),col*lado+ lado/2-4,lin*lado+lado/2+4);
		}
	}

	public void paint(Graphics g) {
		g.fillRect(0,0,lado*4, lado*4); // pinta tudo de preto
		for(int lin=0; lin<4;lin++)
			for(int col=0; col<4; col++)
				desenhaQuadr(g,lin,col);
	}

	public Dimension getPreferredSize() {
		return tam;
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame ("Quebra-cabeca");
		f.setSize(400,420);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new tela_matriz(400));
		f.setVisible(true);
	}
} */



