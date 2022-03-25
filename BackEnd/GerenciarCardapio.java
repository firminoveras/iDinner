import java.util.ArrayList;

public class GerenciarCardapio extends Cardapio{

    public GerenciarCardapio(ArrayList<String> comidaPrincipal, ArrayList<String> bebidas, ArrayList<String> sobremesas,
            ArrayList<String> acompanhamentos) {
        super(comidaPrincipal, bebidas, sobremesas, acompanhamentos);
    }

    public static void main(String[] args) {
        
        // Pratos Principais
        add.comidaPrincipal("1. R$ 02,00 ----- Coxinha");
        add.comidaPrincipal("2. R$ 02,00 ----- Pastel");
        add.comidaPrincipal("3. R$ 02,00 ----- Enroladinho");
        add.comidaPrincipal("4. R$ 02,00 ----- Kibe");
        add.comidaPrincipal("5. R$ 11,90 ----- Big Jumbo");
        add.comidaPrincipal("6. R$ 12,90 ----- Big Chedar");
        add.comidaPrincipal("7. R$ 14,90 ----- Chicken Premium");
        add.comidaPrincipal("8. R$ 16,90 ----- Big Bacon");
        add.comidaPrincipal("9. R$ 11,90 ----- Big Jumbo");
        add.comidaPrincipal("10. R$ 17,90 ----- Big Frango I");
        add.comidaPrincipal("11. R$ 18,90 ----- Big Frango II");
        add.comidaPrincipal("12. R$ 21,90 ----- Big Vegan");
        add.comidaPrincipal("13. CANCELAR PEDIDO PRINCIPAL.");

        // Bebidas
        add.bebidas("1. R$ 03,00 ----- Refrigerante Lata");
        add.bebidas("2. R$ 05,00 ----- Refrigerante 500ml");
        add.bebidas("3. R$ 07,00 ----- Refrigerante 1L");
        add.bebidas("4. R$ 10,00 ----- Refrigerante 2L");
        add.bebidas("5. R$ 08,00 ----- Milk Shake");
        add.bebidas("6. CANCELAR BEBIDA.");

        // Sobremesas
        add.sobremesas("1. R$ 02,50 ----- Cookies");
        add.sobremesas("2. R$ 03,00 ----- Cupcake");
        add.sobremesas("3. R$ 04,00 ----- Brownie");
        add.sobremesas("4. R$ 06,00 ----- Sunday");
        add.sobremesas("5. R$ 08,00 ----- Cheesecake");
        add.sobremesas("6. CANCELAR SOBREMESA.");

        // Acompanhamentos
        add.acompanhamentos("1. R$ 05,00 ----- Fritas (Pequena)");
        add.acompanhamentos("2. R$ 08,00 ----- Fritas (Media)");
        add.acompanhamentos("3. R$ 10,00 ----- Fritas (Grande)");
        add.acompanhamentos("4. R$ 10,00 ----- Chips de Abobrinha");
        add.acompanhamentos("5. R$ 10,00 ----- Cebola Empanada");
        add.acompanhamentos("6. R$ 10,00 ----- Salada da Casa");
        add.acompanhamentos("7. CANCELAR ACOMPANHAMENTO.");
    }
}