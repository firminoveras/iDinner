public class Endereco{
    private String cep;
    private String rua;
    private String bairro;
    private int numCasa;

    public Endereco(String cep, String rua, String bairro, int numCasa){
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.numCasa = numCasa;
    }

    public Endereco(){
        cep = "-";
        rua = "-";
        bairro = "-";
        numCasa = 0;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    @Override
    public String toString() {
        return "ENDERECO DO CLIENTE:\nBairro: " + bairro + "\nCep: " + cep + "\nNumero da Casa: " + numCasa + "\nRua: " + rua;
    }
}