import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        Pizza pizza = new Pizza();
        int quantidadeAdicionais;
        String notaDeCompra;

        System.out.println("---------------------------------------------------------------");
        System.out.println("Valor da pizza básica (contém queijo e calabresa): R$25,00");
        System.out.println("Valor por ingrediente adicional (máximo 8 ingredientes): R$4,00");
        System.out.println("---------------------------------------------------------------");
        System.out.print("Quantidade de ingredientes adicionais: ");
        quantidadeAdicionais = scanner.nextInt();

        pizza.adicionarAcrescimos(quantidadeAdicionais);
        pizza.calcularValorTotal();
        notaDeCompra = pizza.gerarNota();
        System.out.println(notaDeCompra);
        
        scanner.close();
    }
}
