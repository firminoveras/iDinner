import java.util.ArrayList;

public abstract class Cardapio{
    private ArrayList<String> comidaPrincipal;
    private ArrayList<String> bebidas;
    private ArrayList<String> sobremesas;
    private ArrayList<String> acompanhamentos;

    public Cardapio(ArrayList<String> comidaPrincipal, ArrayList<String> bebidas,
            ArrayList<String> sobremesas, ArrayList<String> acompanhamentos) {
        this.comidaPrincipal = comidaPrincipal;
        this.bebidas = bebidas;
        this.sobremesas = sobremesas;
        this.acompanhamentos = acompanhamentos;
    }

    public ArrayList<String> getComidaPrincipal() {
        return comidaPrincipal;
    }

    public void setComidaPrincipal(ArrayList<String> comidaPrincipal) {
        this.comidaPrincipal = comidaPrincipal;
    }

    public ArrayList<String> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<String> bebidas) {
        this.bebidas = bebidas;
    }

    public ArrayList<String> getSobremesas() {
        return sobremesas;
    }

    public void setSobremesas(ArrayList<String> sobremesas) {
        this.sobremesas = sobremesas;
    }

    public ArrayList<String> getAcompanhamentos() {
        return acompanhamentos;
    }

    public void setAcompanhamentos(ArrayList<String> acompanhamentos) {
        this.acompanhamentos = acompanhamentos;
    }

    @Override
    public String toString() {
        return "Cardapio [acompanhamentos=" + acompanhamentos + ", bebidas=" + bebidas + ", comidaPrincipal="
                + comidaPrincipal + ", sobremesas=" + sobremesas + "]";
    }

    public abstract void imprimir();

    public void imprimirCardapio(){
        System.out.println("PRATOS PRINCIPAIS:\n");
        for(i=0;i<pratoPrincipal;i++){
            System.out.println(comidaPrincipal(i));
        }

        System.out.println("BEBIDAS:\n");
        for(i=0;i<bebidas;i++){
            System.out.println(bebidas(i));
        }

        System.out.println("ACOMPANHAMENTOS:\n");
        for(i=0;i<acompanhamentos;i++){
            System.out.println(acompanhamentos(i));
        }

        System.out.println("SOBREMESAS:\n");
        for(i=0;i<sobremesas;i++){
            System.out.println(sobremesas(i));
        }
    }
}