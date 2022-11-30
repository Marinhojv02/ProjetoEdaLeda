public class Dado {
    //dados lista
    int numPassword;
    String password;
    int length;
    String data;
    String dataFormatada;

    //constructor
    public Dado(int numPassword, String password, int length, String data) {
        this.numPassword = numPassword;
        this.password = password;
        this.length = length;
        this.data = data;
        ConverteData();
    }

    //converte data para habilitar comparacao
    public void ConverteData(){
        this.dataFormatada = data.replace("-", "");
        this.dataFormatada = data.replace(":", "");
        this.dataFormatada = data.replace(" ", "");
    }

    //gets
    public int getNumPassword() {
        return numPassword;
    }
    public String getPassword() {
        return password;
    }
    public int getLength() {
        return length;
    }
    public String getData() {
        return data;
    }
    public String getDataFormatada(){
        return dataFormatada;
    }
}
