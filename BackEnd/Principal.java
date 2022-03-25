import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Principal{
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao iDinner. Aqui voce pode fazer seu pedido direto pelo nosso aplicativo!\n");
        System.out.println("Primeiro, vamos criar o seu registro de cliente!");

        Cliente c = new Cliente();
        c.registrarCliente();

        int aux=0;

        while(aux!=3){
            aux = JOptionPane.showInputDialog("Insira o que voce deseja fazer:\n 1 - Visualizar cardapio.\n2 - Fazer Pedido.\n3 - Fechar Aplicativo.");
            if(aux==1){
                Pedido p = new Pedido();
                p.fazerPedido();
                p.pedido.imprimir();
            }
            else if(aux==2){
                Cardapio ca = new Cardapio();
                ca.imprimirCardapio();
            }
            else{
                System.out.println("Obrigado e volte sempre!");
            }
        }
    }
}