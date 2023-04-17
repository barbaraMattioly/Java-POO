import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.ListIterator;

public class Lista {
    LinkedList<Pizza> listaElementos;

    Lista(){
        this.listaElementos = new LinkedList<>();
    }

    /*
     * Adiciona um item na lista
     * @param novoElemento - Elemento a ser adicionada
     * @return TRUE se elemento foi adicionada com sucesso na lista e FALSE caso contrário
     */
    public boolean adicionarElemento(Pizza novoElemento){
        return this.listaElementos.add(novoElemento);
    }

    /*
     * Obtém o valor total da compra
     * @return valor total da compra atual
     */
    public BigDecimal obterValorTotalCompra(){
        ListIterator<Pizza> iterador = listaElementos.listIterator(0);
        BigDecimal valorTotal = new BigDecimal(0);

        while(iterador.hasNext()){
            Pizza pizza = iterador.next();
            valorTotal = valorTotal.add(pizza.calcularValorTotal());
        }
        
        return valorTotal;
    }

    /*
     * Obtém a nota da compra
     * @return nota da compra com a descrição e valor de todas as pizzas
     */
    public String obterNotaCompra(){
        ListIterator<Pizza> iterador = listaElementos.listIterator(0);
        String notaCompra = "";

        while(iterador.hasNext()){
            Pizza pizza = iterador.next();
            notaCompra += iterador.nextIndex() + "- " + pizza.gerarNota() + "\n";
        }
        
        return notaCompra;        
    }

    public int tamanhoLista(){
        return listaElementos.size();
    }

}
