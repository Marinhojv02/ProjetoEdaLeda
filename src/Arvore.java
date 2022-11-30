import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Arvore {
    Dado elemento;
    Arvore pai;
    Arvore esquerda;
    Arvore direita;

    //construtor
    public Arvore(){
        this.elemento = null;
        this.esquerda = null;
        this.direita = null;
    }

    public Arvore(Dado elemento){
        this.elemento = elemento;
        this.esquerda = null;
        this.direita = null;
    }

    //funcionalidades
    
    //inserir na arvore: 3 maneiras de inserir, primeiro considerando a senha, depois o tamanho depois a data
        //inserir considerando a senha
    public void inserirPassword(Dado novo){
        if(isEmpty()){
            this.elemento = novo;
        }else{
            Arvore novaArvore = new Arvore(novo);
            if(novo.getPassword().compareTo(elemento.getPassword()) < 0){
                if(this.esquerda == null){
                    this.esquerda = novaArvore;
                }else{
                    this.esquerda.inserirPassword(novo);
                }
            }else if(novo.getPassword().compareTo(elemento.getPassword()) >= 0){
                if(this.direita == null){
                    this.direita = novaArvore;
                }else{
                    this.direita.inserirPassword(novo);
                }
            }  
        }
    }
        //inserir considerando o tamanho
    public void inserirLength(Dado novo) {
        if(isEmpty()){
            this.elemento = novo;
        }else{
            Arvore novaArvore = new Arvore(novo);
            if(novo.getLength() < elemento.getLength()){
                if(this.esquerda == null){
                    this.esquerda = novaArvore;
                }else{
                    this.esquerda.inserirLength(novo);
                }
            }else if(novo.getLength() > elemento.getLength()){
                if(this.direita == null){
                    this.direita = novaArvore;
                }else{
                    this.direita.inserirLength(novo);
                }
            }else{
                if(novo.getPassword().compareTo(elemento.getPassword()) < 0){
                    if(this.esquerda == null){
                        this.esquerda = novaArvore;
                    }else{
                        this.esquerda.inserirLength(novo);
                    }
                }else if(novo.getPassword().compareTo(elemento.getPassword()) >= 0){
                    if(this.direita == null){
                        this.direita = novaArvore;
                    }else{
                        this.direita.inserirLength(novo);
                    }
                }
            }
        }
    }  
        //inserir considerando a data
    public void inserirDate(Dado novo) {
        if(isEmpty()){
            this.elemento = novo;
        }else{
            Arvore novaArvore = new Arvore(novo);
            if(novo.getDataFormatada().compareTo(elemento.getDataFormatada()) < 0){
                if(this.esquerda == null){
                    this.esquerda = novaArvore;
                }else{
                    this.esquerda.inserirDate(novo);
                }
            }else if(novo.getDataFormatada().compareTo(elemento.getDataFormatada()) > 0){
                if(this.direita == null){
                    this.direita = novaArvore;
                }else{
                    this.direita.inserirDate(novo);
                }
            }else{
                if(novo.getPassword().compareTo(elemento.getPassword()) < 0){
                    if(this.esquerda == null){
                        this.esquerda = novaArvore;
                    }else{
                        this.esquerda.inserirDate(novo);
                    }
                }else if(novo.getPassword().compareTo(elemento.getPassword()) >= 0){
                    if(this.direita == null){
                        this.direita = novaArvore;
                    }else{
                        this.direita.inserirDate(novo);
                    }
                }
            }
        }
    }  

    //imprimir
    public void imprimeInOrdem(){
        if(!isEmpty()){
            if(this.esquerda != null){
                this.esquerda.imprimeInOrdem();
            }
            System.out.print(this.elemento.getPassword() + " -> ");
            
            if(this.direita != null){
                this.direita.imprimeInOrdem();
            }
        }
    }

    //insere no csv
        //metodo para verificar se ja existe 
    public void criaCSV(String nomeArquivo) throws IOException{
        File product = new File(nomeArquivo);//determina onde será escrito
        if(product.exists()){
            product.delete();
        }

        FileWriter escritor = new FileWriter(product, true);//escreve em arquivo
        BufferedWriter bufEscritor = new BufferedWriter(escritor);// escreve as informações no arquivo
        
        bufEscritor.write("Índice,Password, Length, Date");//escreve os títulos
        bufEscritor.newLine();//new line no arquivo

        escreveCSV(bufEscritor);

        bufEscritor.close();// fecha o escritor do buffer
        escritor.close();// fecha o escritor de arquivo
        
    }
        public void escreveCSV(BufferedWriter bufEscritor) throws IOException{
           
            if(!isEmpty()){
                if(this.esquerda != null){
                    this.esquerda.escreveCSV(bufEscritor);
                }
                //inserir
                bufEscritor.write(this.elemento.getNumPassword()+","+this.elemento.getPassword()+","+this.elemento.getLength()+","+this.elemento.getData());//escreve e  concatena as informações no arquvio.
                bufEscritor.newLine();
                
                if(this.direita != null){
                    this.direita.escreveCSV(bufEscritor);
                }
            }
        }

    //isEmpty
    public boolean isEmpty(){
        return (elemento == null);
    }
    
    //gets e sets
    public Dado getElemento() {
        return elemento;
    }
    public void setElemento(Dado elemento) {
        this.elemento = elemento;
    }

    public Arvore getEsquerda() {
        return esquerda;
    }
    public void setEsquerda(Arvore esquerda) {
        this.esquerda = esquerda;
    }

    public Arvore getDireita() {
        return direita;
    }
    public void setDireita(Arvore direita) {
        this.direita = direita;
    }

      
}
