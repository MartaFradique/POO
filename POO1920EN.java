package base2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

// Notas:
// Não altere o código apresentado
// Deve completar o código da alinea 2
// Comentar código para garantir que vai executando parcialmente

public class POO1920ENDD {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream fl = new PrintStream(new File("POO_1920ENDD.txt"));
		test(System.out); // executa e escreve na consola
		test(fl); // executa e escreve no ficheiro
		fl.close();
	}

	private static void test(PrintStream out) {
		alinea1(out); 
		alinea2(out);
	}

	/**
	 *  alínea 1
	 */
	private static void alinea1(PrintStream out) {
		out.println("\nAlínea 1) ----------------------------------\n");

		Loja loja = new Loja("Loja POO1920 Online", "poo1920@commerce.pt");

		Livro livro1 = new Livro("Modern Java in Action",45.0);
		livro1.add(new Autor("Raoul-Gabriel Urma", 1970));
		livro1.add(new Autor("Alan Mycroft", 1980));
		livro1.add(new Autor("Mario Fusco", 1980));
		livro1.setStock(100);
		out.println(livro1.getTitulo() + " tem " + livro1.getLista().size() + " autores");
		
		List<Autor> lista = Arrays.asList(new Autor("Autor X", 1968)); 
		
		Livro livro2 = new Livro("Java 8 - POO e Construções Funcionais",23.0, lista);
		livro2.addStock(450);
		out.println(livro2.getTitulo() + " tem " + livro2.numeroAutores() + " autores");

		out.println("TOTAL DE PRODUTOS DO MERCADO: " + loja.totalItems());
													   // tipo, marca, modelo, potência, preço	
		Electrodomestico electr1 = new Electrodomestico("Frigorífico", "Siemens","XPTO",1000,780 );
		Electrodomestico electr2 = new Electrodomestico("Fogão","Meireles","XYZ",423); // tipo, marca, modelo, preço
		electr1.setClasse(ClasseEnergetica.A);
		
		//  
		Telemovel tlm1 = new Telemovel("iPhone","Model X",860.0 );
		tlm1.addNota("Muito bom"); tlm1.addNota("Quase esgotado");
		
		//
		Electrodomestico tv1=new Electrodomestico("Televisor","LG","MODEL X",450);
		Electrodomestico tv2=new Electrodomestico("Televisor","SONY","KXV",470);
		tv1.setClasse(ClasseEnergetica.A);
		tv1.addStock(5);
		
		//  descriço de um produto
		out.println("Descrição de tv2 :"+tv2.getDescricao());
		//  adicionar à  Loja
		loja.add(livro1); loja.add(livro2); loja.add(electr1); 
		loja.add(electr2); loja.add(tlm1); loja.add(tv1); loja.add(tv2);
 		
		//
		tlm1.addStock(2);
				
		out.println("AUTORES DE " + livro1.getTitulo() + ": " + livro1.autores());
		
		out.println("TOTAL DE PRODUTOS DO MERCADO: " + loja.totalItems());
 
		// vender alguns produtos
		if (!tlm1.vender(5)) 
			out.printf("Unidades insuficientes! Só tem %d em stock.\n",tlm1.getStock());

		if (livro2.vender(150))
			out.printf("Vendidos %d unidades de \"%s\". Passou a ter %d\n", 150,livro2.getTitulo(),livro2.getStock());
		
		out.println("TOTAL DE PRODUTOS DO MERCADO: " + loja.totalItems());
		out.println();
		
		//  lista todos os produtos, com preços, numa tabela
		out.println(loja);  
		
		
		// informação sobre alguns produtos
		out.println("Informação sobre Frigorífico:");
		// acesso directo a um Produto dada uma string contendo tipo, nome e marca
		out.println(loja.getProdutoPelaDescricao("Frigorífico:Siemens/XPTO"));
		out.println("Informação sobre Telemóvel:");
		// no caso de Telemóveis acesso apenas por marca(uppercase)/modelo
		out.println(loja.getProdutoPelaDescricao("IPHONE/Model X"));
		
	}
	

	private static void alinea2(PrintStream out) {
		out.println("\nAlínea 2) ----------------------------------\n");
	
		Loja loja = null;

		// TODO:   código em falta 		
		
		if (loja != null) {

			//  reordenar para obter informação dos produtos por ordem da sua descrição
			loja.reorder();
			
			out.println(loja);
		 

			out.println("Todos os produtos com preço após desconto superior a 500 Euros:");
			
			List<Produto> prods=loja.produtosPrecoFinalSuperiorA(500.0);
			
			// TODO:  COMPLETAR ...
			 
			out.println("Lista de Electrodomésticos com Classe B:");
			out.println(loja.electrodomesticosClasseX("B"));
				 
		}
	}
	
}