import com.opencsv.CSVReader;

import java.io.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TrabalhoComArvores {
    public static void main(String[] args) {

        long tempoInicial;//variável para iniciar o tempo em ms
        long tempoFinal;// variável pra finalizar o tempo em ms

        System.out.println("execução iniciada");
        tempoInicial = System.currentTimeMillis();//inicia o tempo

        Arvore arvorePassword = new Arvore();
        Arvore arvoreLength = new Arvore();
        Arvore arvoreDate = new Arvore();
    
        //path dos arquivos

            //path e nome do arquivo original para começar a execução
        String arquivocsv = "arquivos/passwords.csv";

            //path e nome do arquivo final, gerado ao terminar a execução
        String ArquivoSenhasCSV = "arquivos/PasswordOrdenada.csv";
        String ArquivoLengthCSV = "arquivos/LengthOrdenada.csv";
        String ArquivoDateCSV = "arquivos/DateOrdenada.csv";

        CSVReader reader = null;
        try {
            //abre o csv
            reader = new CSVReader(new FileReader(arquivocsv));
            String[] nextLine; //armazena linhas do CSV

            nextLine = reader.readNext(); //pula a primeira linha para evitar erro

            //Lê uma linha por vez e adiciona à fila na posição ja ordenada
            while ((nextLine = reader.readNext()) != null) {
                arvorePassword.inserirPassword(new Dado(Integer.parseInt(nextLine[0]), nextLine[1], nextLine[1].length(), nextLine[3]));
                arvoreLength.inserirLength(new Dado(Integer.parseInt(nextLine[0]), nextLine[1], nextLine[1].length(), nextLine[3]));
                arvoreDate.inserirDate(new Dado(Integer.parseInt(nextLine[0]), nextLine[1], nextLine[1].length(), nextLine[3]));
            }
        }
        catch (FileNotFoundException e){// exceções 
          System.out.println("Arquivo não encontrado: \n" + e.getMessage());// exceções 
        }catch (ArrayIndexOutOfBoundsException e){// exceções 
            System.out.println("Indice não encontrado: \n" + e.getMessage());// exceções 
        }catch( IOException e){// exceções 
            System.out.println("IO Erro: \n" + e.getMessage());// exceções 
        }finally {
          if(reader != null){
              try{
                reader.close();//fecha o csv
                }catch(IOException e){
                  System.out.println("IO Erro: \n" + e.getMessage());// exceções
                }
            }
        }

        try {
            arvorePassword.criaCSV(ArquivoSenhasCSV);
            arvoreLength.criaCSV(ArquivoLengthCSV);
            arvoreDate.criaCSV(ArquivoDateCSV);
        } catch (IOException e) {
            e.printStackTrace();
        }

        tempoFinal = System.currentTimeMillis()-tempoInicial;

        System.out.println("execução terminada em: "+ tempoFinal+" ms");

    }
}