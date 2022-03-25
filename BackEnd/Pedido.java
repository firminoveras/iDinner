import java.util.ArrayList;

public class Pedido extends Cardapio{
    
    private Cliente consumidor;
    private int pratoPrincipal;
    private int bebida;
    private int acompanhamento;
    private int sobremesa;
    private int mesa;

    public Pedido(ArrayList<String> comidaPrincipal, ArrayList<String> bebidas, ArrayList<String> sobremesas,
            ArrayList<String> acompanhamentos, Cliente consumidor, int pratoPrincipal, int bebida, int acompanhamento,
            int sobremesa, int mesa) {
        super(comidaPrincipal, bebidas, sobremesas, acompanhamentos);
        this.consumidor = consumidor;
        this.pratoPrincipal = pratoPrincipal;
        this.bebida = bebida;
        this.acompanhamento = acompanhamento;
        this.sobremesa = sobremesa;
        this.mesa = mesa;
    }

    public Pedido(){
        super();
        this.consumidor = new Cliente("-","-","-","-","-","-","-");
        this.pratoPrincipal = 0;
        this.bebida = 0;
        this.acompanhamento = 0;
        this.sobremesa = 0;
        this.mesa = 0;
    }

    public Cliente getConsumidor(){
        return consumidor;
    }

    public void setConsumidor(Cliente consumidor){
        this.consumidor = consumidor;
    }
  
    public int getPratoPrincipal(){
        return pratoPrincipal;
    }

    public void setPratoPrincipal(int pratoPrincipal){
        this.pratoPrincipal = pratoPrincipal;
    }

    public int getBebida(){
        return bebida;
    }

    public void setBebida(int bebida){
        this.bebida = bebida;
    }

    public int getAcompanhamento(){
        return acompanhamento;
    }

    public void setAcompanhamento(int acompanhamento){
        this.acompanhamento = acompanhamento;
    }

    public int getSobremesa(){
        return sobremesa;
    }

    public void setSobremesa(int sobremesa){
        this.sobremesa = sobremesa;
    }

    public int getMesa(){
        return mesa;
    }

    public void setMesa(int mesa){
        this.mesa = mesa;
    }

    @Override
    public String toString(){
        return consumidor+"\n\n"+"Prato Principal: "+pratoPrincipal+"\nBebida: "+bebida+"\nAcompanhamento: "+acompanhamento+"\nSobremesa: "+sobremesa+"\nMesa: "+mesa;
    }

    public void fazerPedido(){
        pratoPrincipal = JOptionPane.showInputDialog("Insira o numero do prato que deseja: \n");
        bebida = JOptionPane.showInputDialog("Insira o numero do prato que deseja: \n");
        sobremesa = JOptionPane.showInputDialog("Insira o numero do prato que deseja: \n");
        acompanhamento = JOptionPane.showInputDialog("Insira o número do prato que deseja: \n");
        mesa = JOptionPane.showInputDialog("Informe o numero da sua mesa: \n");
    }

    public void imprimir(){
        System.out.println("CLIENTE: "+cliente.getNome);
        System.out.println(comidaPrincipal(pratoPrincipal-1));
        System.out.println(bebidas(bebida-1));
        System.out.println(sobremesas(sobremesa-1));
        System.out.println(acompanhamentos(acompanhamento-1));
        System.out.println("MESA: "+pedido.getMesa);
    }
}