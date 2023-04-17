import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;

public class Pedido {
    //#region ATRIBUTOS e CONSTANTES
    public static final Logger logger = Logger.getLogger(Pizza.class.getName());
    private static int proximoId = 1;

    private int idPedido;
    private Lista pizzas;
    private BigDecimal valorTotalCompra;
    //#endregion

    //Construtor inicial pedido
    Pedido(){
        this.idPedido = proximoId;
        proximoId++;
        this.pizzas = new Lista();
        this.valorTotalCompra = new BigDecimal(0);
    }

    //#region MÉTODOS

    /*
     * Adiciona pizza na lista somente se quantidade de pizzas já adicionadas for menor que 10
     * @return TRUE se pizza foi adicionada com sucesso na lista e FALSE caso contrário
     */
    public boolean adicionarPizza(int quantidadeAdicionais){
        if(quantidadeDePizzasAdicionadasValida()){
            Pizza novaPizza = new Pizza();
            novaPizza.adicionarAcrescimos(quantidadeAdicionais);
            novaPizza.calcularValorTotal();
            return this.pizzas.adicionarElemento(novaPizza);
        }
        
        logger.log(Level.WARNING, "O numero maximo de pizzas por pedido e 10, nao foram adicionadas mais pizzas");
        return false;
    }

    /*
     * Valida a quantidade de pizzas adicionadas no pedido
     * @return TRUE se quantidade de pizzas for menor que o máximo e FALSE caso contrário
     */    
    private boolean quantidadeDePizzasAdicionadasValida(){
        return pizzas.tamanhoLista() < 10;
    }

    /*
     * Obtém o valor total do pedido (somatório do valor de todas as pizzas)
     * @return valorTotalCompra
     */  
    public BigDecimal obterValorTotalPedido(){
        this.valorTotalCompra = pizzas.obterValorTotalCompra();
        return valorTotalCompra;
    }

    /*
     * Obtém a nota fiscal com a descrição e valor de cada pizza e o valor total do pedido
     * @return notaCompra
     */  
    public String obterNotaCompra(){
        String notaCompra = pizzas.obterNotaCompra();
        String valorPedido = "\nValor Total Pedido: R$" + obterValorTotalPedido();

        return notaCompra.concat(valorPedido);
    }

    /*
     * Retorna o id único do pedido
     * @return idPedido
     */
    public int getidPedido(){
        return this.idPedido;
    }
    //#endregion
}
