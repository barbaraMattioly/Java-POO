import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class PizzaTest {
    private static final double VALORBASE = 25;
    Pizza pizza;

    @BeforeEach
    public void prepare(){
        pizza = new Pizza();
    }

    @Test
    public void deveCalcularPrecoPizzaSemAcrescimos() {
        pizza.adicionarAcrescimos(0);
        assertEquals(pizza.calcularValorTotal(), VALORBASE);
    }

    @Test
    public void deveCalcularPrecoPizzaDeAcordoComNumeroDeAcrescimos() {
        pizza.adicionarAcrescimos(4);
        assertEquals(pizza.calcularValorTotal(), 41);
    }

    @Test
    public void deveRetornarFalsoAoTentarAdicionarMaisDeOitoAdicionais(){
        assertFalse(pizza.adicionarAcrescimos(9));
    }

    @Test
    public void deveRetornarVerdadeiroAoTentarAdicionarUmNumeroDeAdicionaisEntreZeroOito(){
        assertTrue(pizza.adicionarAcrescimos(8));
    }

    @Test
    public void deveRetornarZeroAoCalcularValorDaPizzaCasoQuantidadeDeAdicionaisSejaMaiorQueOito(){
        pizza.adicionarAcrescimos(15);
        assertEquals(pizza.calcularValorTotal(), 0);
    }

    @Test
    public void deveGerarNotaComDescricaoValor(){
        pizza.adicionarAcrescimos(5);
        pizza.calcularValorTotal();
        assertEquals(pizza.gerarNota(), "Valor a ser pago: R$45.0 | Descrição: 5 acréscimos");
    }

    @Test
    public void deveRetornarDescricaoVaziaCasoNumeroDeAdicionaisSejaMaiorQueOito(){
        pizza.adicionarAcrescimos(10);
        pizza.calcularValorTotal();
        assertEquals(pizza.gerarNota(), "");
    }

}
