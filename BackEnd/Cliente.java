public class Cliente{
    
    private String nome;
    private String dataNascimento;
    private String genero;
    private String email;
    private String telefone;

    public Cliente(String nome, String dataNascimento, String genero, String email, String telefone) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.email = email;
        this.telefone = telefone;
    }

        public Cliente() {
        this.nome = "-";
        this.dataNascimento = "-";
        this.genero = "-";
        this.email = "-";
        this.telefone = "-";
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getDataNascimento(){
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    
    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }
    
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    @Override
    public String toString(){
        return "DADOS DO CLIENTE\nNome: "+nome+"\nData de Nascimento: "+dataNascimento+"\nGenero: "+genero+"\n"+"Email: "+email+"\n"+"Telefone: "+telefone;
    }

    public void registrarCliente(){
        cliente.setNome(JOptionPane.showInputDialog("Informe seu nome: "));
        cliente.setDataNascimento(JOptionPane.showInputDialog("Data de Nascimento: "));
        cliente.setGenero(JOptionPane.showInputDialog("Informe seu genero: "));
        cliente.setEmail(JOptionPane.showInputDialog("E-mail: "));
        cliente.setTelefone(JOptionPane.showInputDialog("Telefone: "));
    }
}