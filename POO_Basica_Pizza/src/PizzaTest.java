import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class PizzaTest {
    private static final BigDecimal VALORBASE = new BigDecimal(25.0);
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
    public void deveCalcularPrecoPizzaCorretoDeAcordoComNumeroDeAcrescimos() {
        pizza.adicionarAcrescimos(4);
        pizza.adicionarAcrescimos(2);
        assertEquals(pizza.calcularValorTotal(), BigDecimal.valueOf(49));
    }

    @Test
    public void deveRetornarValorBasePizzaAoTentarAdicionarMaisDeOitoAdicionais(){
        pizza.adicionarAcrescimos(15);
        assertEquals(pizza.calcularValorTotal(), VALORBASE);
    }

    @Test
    public void deveRetornarValorBaseAoCalcularValorDaPizzaCasoQuantidadeDeAdicionaisSejaMenorQueOito(){
        pizza.adicionarAcrescimos(-3);
        assertEquals(pizza.calcularValorTotal(), VALORBASE);
    }

    @Test
    public void deveGerarNotaComDescricaoValor(){
        pizza.adicionarAcrescimos(5);
        pizza.calcularValorTotal();
        assertEquals(pizza.gerarNota(), "Valor pizza: R$45 | Descrição: 5 acréscimos");
    }

    @Test
    public void deveRetornarDescricaoComIngredientesZeroEValorBaseCasoNumeroDeAdicionaisSejaMaiorQueOito(){
        pizza.adicionarAcrescimos(10);
        pizza.calcularValorTotal();
        assertEquals(pizza.gerarNota(), "Valor pizza: R$25 | Descrição: 0 acréscimos");
    }

}
