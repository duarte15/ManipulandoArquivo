package manipulando;
/**
 * Manipulando Arquivos em Java
 * 
 * @author Raphael Varela
 * @version 27/05/2015
 */
import java.io.*;
import java.util.Scanner;
public class Arquivos {
    
    public static void main(String[] args) {
        
        int opcao=0;
        Scanner leitorTerminal = new Scanner(System.in);
        
        do{           
            System.out.println("\n*** Atenção! todos os arquivos são criados/salvos e lidos/buscados sa Desktop ***\n");
            System.out.println("-------------------------------------");
            System.out.println("Informe a opção que deseja realizar:");
            System.out.println("-------------------------------------");
            System.out.println("1 - Criar/Salvar um arquivo em disco");
            System.out.println("2 - Ler/Buscar um arquivo do disco");
            System.out.println("3 - Sair do programa");
            System.out.println("-------------------------------------");
            System.out.print("=> ");
            
            opcao = leitorTerminal.nextInt();
            
            switch(opcao){
                
                case 1: salvaArquivo();
                    break;
                case 2: lerArquivo();
                    break;
                case 3: System.out.println("Obrigada por utilizar o programa");
                    break;
                default: System.out.println("Opção não implementada.");
                    break;
            }
            
        }while(opcao != 3);
    }
    
    public static void salvaArquivo(){
        
        Scanner leitorTerminal = new Scanner(System.in);
        
        System.out.println("-------------------------------------");
        System.out.println("Informe o conteúdo do seu arquivo:");
        System.out.println("-------------------------------------");
        
        String conteudoDoArquivo = leitorTerminal.nextLine();
        
        System.out.println("-------------------------------------");
        System.out.println("Informe o nome do arquivo que deseja salvar no disco:");
        System.out.println("-------------------------------------");
        
        String nomeDoArquivo = leitorTerminal.next();
        
        String caminhoDoArquivo = "C:\\Users\\" + System.getProperty("user.name").toString() + "\\Desktop\\" + nomeDoArquivo + ".txt";
        
        try{
            FileWriter objEscritor = new FileWriter(caminhoDoArquivo, false);
            
            objEscritor.write(conteudoDoArquivo.toString());
            objEscritor.close();
            
            System.out.println("\n-------------------------------------");
            System.out.println("Arquivo salvo com sucesso no diretório descrito abaixo");
            System.out.println("-------------------------------------");
            System.out.println(caminhoDoArquivo);
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void lerArquivo(){
        
        Scanner leitorTerminal = new Scanner(System.in);
        
        System.out.println("\n-------------------------------------");
        System.out.println("Informe o nome do arquivo que deseja ler do disco:");
        System.out.println("-------------------------------------");
        
        String nomeDoArquivo = leitorTerminal.next();  
        
        String caminhoDoArquivo = "C:\\Users\\" + System.getProperty("user.name").toString() + "\\Desktop\\" + nomeDoArquivo + ".txt";
        
        try{
            
            FileReader arquivoParaLeitura = new FileReader(caminhoDoArquivo);
            
            BufferedReader leitorArquivo = new BufferedReader(arquivoParaLeitura);
            
            String linha = leitorArquivo.readLine();
            
            while(linha != null){
                System.out.println(linha);
                linha = leitorArquivo.readLine();
            }
            
            System.out.println("\n");
            leitorArquivo.close();
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
