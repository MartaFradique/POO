package aula05;
import java.util.Scanner;

public class Ex3 {
	public static Scanner sc = new Scanner(System.in);
    public static Utilizador[] Utilizadores = new Utilizador[100];
    public static Livro[] Livros = new Livro[100];
    public static int userCount = 0;
    public static int livroCount = 0;
    
    public static void main(String[] args) {
    	int n;
    	do {
            System.out.println("1 - inscrever utilizador");
            System.out.println("2 - remover utilizador");
            System.out.println("3 - imprimir lista de utilizadores");
            System.out.println("4 - registar um novo livro");
            System.out.println("5 - imprimir lista de livros");
            System.out.println("6 - emprestar");
            System.out.println("7 - devolver");
            System.out.println("8 - sair");

            n = Integer.parseInt(sc.nextLine());

            switch (n) {
                case (1):
                	inscrever();
                	break;
                case (2):
                    remover();
                    break;
                case (3):
                    imprimirUtilizadores();
                    break;
                case (4):
                    registar();
                    break;
                case (5):
                	imprimirLivros();
                    break;
                case (6):
                    emprestar();
                    break;
                case (7):
                    devolver();
                    break;

            }
        } while (n != 8);
    }
    
    public static void inscrever() {
    	System.out.println("Insira o nome do utilizador:");
         String nome = sc.nextLine();
         System.out.println("Insira o número mecanográfico:");
         int nMec = sc.nextInt();
         sc.nextLine();
         System.out.println("Insira o curso:");
         String curso = sc.next();
         sc.nextLine();
         Utilizadores[userCount] = new Utilizador(nome, nMec, curso);
         userCount++;
    }
    
    public static void remover() {
    	System.out.println("Insira o número mecanográfico do aluno que pretende remover:");
        int nMec = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < userCount; i++) {
            if (Utilizadores[i].getnMec() == nMec) {
            	for(int c =0; c<3; c++) {
            		for (int u = 0; u < livroCount; u++) {
            			if (Livros[u].getId() ==Utilizadores[i].getLivros()[c]) {
                    		if(Utilizadores[i].getLivros()[c]!=0) {
                    			Utilizadores[i].setLivro(0,c);
                    			Livros[u].setDisponibilidade("Disponível");
                    		}
                    	}
                    }
                }
         
            	for (int u = i; u < userCount - 1; u++) {
                    Utilizadores[u] = Utilizadores[u + 1];
                }
                Utilizadores[userCount - 1] = null;
                userCount--;
                break;
            }
        }
    }
    
    public static void imprimirUtilizadores() {
        for (Utilizador u : Utilizadores) {
        	if(u!=null) {
            System.out.println(u);
        	}
        }
    }
    
    public static void registar() {
    	System.out.println("Insira o título do livro:");
        String titulo = sc.nextLine();
        System.out.println("Insira o tipo de emprestimo do livro ('CONDICIONAL'/'NORMAL'):");
        String tipoEmprestimo = sc.nextLine();
        Livros[livroCount] = new Livro(titulo, tipoEmprestimo);
        livroCount++;
    }
    
    public static void imprimirLivros() {
        for (Livro u : Livros) {
        	if(u!=null) {
                System.out.println(u);
                }
        }
    }
    
    public static void emprestar() {
    	System.out.println("Insira o número mecanográfico do utilizador:");
        int nMec =sc.nextInt();
        sc.nextLine();
        System.out.print("Insira o ID do livro: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < livroCount; i++) {
            if (Livros[i].getId() == id) {
            	if ((Livros[i].getDisponibilidade() == "Disponível") && !(Livros[i].getTipoEmprestimo().equals("CONDICIONAL"))) {
            		for (int u = 0; u < userCount; u++) {
                        if (Utilizadores[u].getnMec() == nMec) {
                        	if (Utilizadores[u].getLivros()[0] == 0) {
                                Utilizadores[u].setLivro(Livros[i].getId(), 0);
                                Livros[i].setDisponibilidade("Indisponível");
                        	}
                            else if (Utilizadores[u].getLivros()[1] == 0) {
                                Utilizadores[u].setLivro(Livros[i].getId(),1);
                                Livros[i].setDisponibilidade("Indisponível");
                            }
                            else if (Utilizadores[u].getLivros()[2] == 0) {
                                Utilizadores[u].setLivro(Livros[i].getId(),2);
                                Livros[i].setDisponibilidade("Indisponível");
                            }
                            else {
                            	System.out.println("Nao pode requisitar mais livros!");
                            }
                        	break;
                        }
                    }
                } 
            	else {
                    System.out.println("Não se pode requisitar");
                }
            }
        }
    }
    
    public static void devolver() {
    	System.out.println("Insira o número mecanográfico do utilizador:");
    	int nMec = Integer.parseInt(sc.nextLine());
    	System.out.println("Insira o ID do livro que quer devolver:");
    	int id = Integer.parseInt(sc.nextLine());
    	for (int i = 0; i < userCount; i++) {
            if (Utilizadores[i].getnMec() == nMec) {
            	for (int u = 0; u < livroCount; u++) {
                    if (Livros[u].getId() == id) {
                    	for(int c =0; c<3; c++) {
                    		if(Utilizadores[i].getLivros()[c]==Livros[u].getId()) {
                    			Utilizadores[i].setLivro(0,c);
                    			Livros[u].setDisponibilidade("Disponível");
                    			break;
                    		}
                    	}
                    }
                }
            }
        }
    }
    
}
