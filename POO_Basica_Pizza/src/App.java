import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Pedido pedido = null;
        int opcao = 0;

        do{
            menu();
            opcao = scanner.nextInt();
            switch(opcao){
                case 1:
                    if(pedido == null){
                        pedido = new Pedido();                        
                        adicionarPizza(pedido);
                    }else{
                        System.out.println("Voce deve finalizar o pedido anterior para iniciar um novo!");
                    }
                    break;
                case 2:
                    if(pedido == null){
                        System.out.println("Voce deve primeiro iniciar o pedido (opcao 1)");
                    }
                    else{
                        adicionarPizza(pedido);
                    }
                    break;
                case 3:
                    exibirValorAtual(pedido);                    
                    break;
                case 4:
                    finalizarPedido(pedido);
                    pedido = null;
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opçao invalida, tente novamente");
            }
            pausa();
        }while(opcao != 5);
    
        scanner.close();
    }

    private static void menu(){
        limparTela();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Valor da pizza básica (contém queijo e calabresa): R$25,00");
        System.out.println("Valor por ingrediente adicional (máximo 8 ingredientes): R$4,00");
        System.out.println("---------------------------------------------------------------");
        System.out.println("1- Iniciar pedido");
        System.out.println("2- Adicionar pizza");
        System.out.println("3- Mostrar valor total atual do pedido");
        System.out.println("4- Finalizar pedido e gerar nota");
        System.out.println("5- Sair");
        System.out.print("\nDigite a ação que deseja executar: ");
    }

    private static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void pausa() {
        System.out.println("\nPressione 'enter' para continuar");
        scanner.nextLine(); //esvazia o buffer do teclado
        scanner.nextLine();
    }

    private static void adicionarPizza(Pedido pedido){
        System.out.print("Quantidade de ingredientes adicionais: ");
        int quantidadeAdicionais = scanner.nextInt();
        pedido.adicionarPizza(quantidadeAdicionais);
    }

    private static void exibirValorAtual(Pedido pedido){
        if(pedido == null){
            System.out.println("Nao existe nenhum pedido em andamento");
        }else{
            System.out.println("Valor do pedido atual: " + pedido.obterValorTotalPedido());
        }
    }

    private static void finalizarPedido(Pedido pedido){
        if(pedido == null){
            System.out.println("Nao existe nenhum pedido para ser finalizado");
        }else{
            pedido.obterValorTotalPedido();
            System.out.println(pedido.obterNotaCompra());
            System.out.println("!!! COMPRA ATUAL FINALIZADA !!!");
        }
    }
}
