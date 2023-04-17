import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

public class PedidoTest {
    Pedido pedido;

    @BeforeEach
    public void prepare(){
        pedido = new Pedido();
    }

    @Test
    public void deveRetornarVerdadeiroCasoConsigaAdicionarUmaPizzaNaLista(){
        assertTrue(pedido.adicionarPizza(8));
    }

    @Test
    public void deveRetornarVerdadeiroAoAdicionarPizzasNaListaCasoQuantidadeSejaValida(){
        boolean pizzasAdicionadas = false;

        for(int i = 0; i < 10; i++){
            if(pedido.adicionarPizza(5))
                pizzasAdicionadas = true;
            else
                pizzasAdicionadas = false;
        }

        assertTrue(pizzasAdicionadas);
    }

    @Test
    public void deveRetornarFalsoAoAdicionarAUltimaPizzaCasoTenteAdicionarMaisPizzasQueOMaximo(){
        boolean pizzaAdicionada = false;

        for(int i = 1; i <= 11; i++){
            if(pedido.adicionarPizza(5))
                pizzaAdicionada = true;
            else
                pizzaAdicionada = false;
        }

        assertFalse(pizzaAdicionada);
    }

    @Test
    public void deveRetornarValorTotalCompra(){
        for(int i = 0; i < 10; i++){
            pedido.adicionarPizza(2);
        }

        assertEquals(pedido.obterValorTotalPedido(), new BigDecimal(330));
    }

    @Test
    public void deveExibirNotaDeCompraPizza(){
        pedido.adicionarPizza(8);
        pedido.adicionarPizza(1);
    
        String notaCompraEsperada = "1- Valor pizza: R$57 | Descrição: 8 acréscimos\n2- Valor pizza: R$29 | Descrição: 1 acréscimos\n\nValor Total Pedido: R$86";
        assertEquals(pedido.obterNotaCompra(), notaCompraEsperada);
    }

}
