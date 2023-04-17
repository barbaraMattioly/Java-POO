import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CasaTest {
    Casa casaSemBeneficios, casaMaisDeTrintaPorCentoDesconto, casaComBeneficios;
    Beneficio piscina, elevador, salaJogos;
    LinkedList<Beneficio> listaBeneficios = new LinkedList<Beneficio>();

    @BeforeEach
    public void prepare(){
        casaSemBeneficios = new Casa("Av. Professor Mario Werneck",750000, 2010, 12000);
        casaMaisDeTrintaPorCentoDesconto = new Casa("Av. Professor Mario Werneck",350000, 1957, 6000);
        casaComBeneficios = new Casa("Av. Professor Mario Werneck",1200000, 2022, 24000);

        piscina = new Beneficio("Piscina Aquecida", 100);
        elevador = new Beneficio("Elevador", 100);
        salaJogos = new Beneficio("Sala de Jogos Gigante", 100);

        listaBeneficios.add(piscina);
        listaBeneficios.add(elevador);
        listaBeneficios.add(salaJogos);
    }

    @Test
    public void deveRetornarValorAluguelCasaSemBeneficiosCorreto(){
        assertEquals(new BigDecimal(4000), casaSemBeneficios.calcularValorAluguel());
    }

    @Test
    public void deveCalcularValorAluguelComMaximoPadraoCasoDescontoExcedaTrintaCorreto(){
        assertEquals(new BigDecimal(1725), casaMaisDeTrintaPorCentoDesconto.calcularValorAluguel());
    }

    @Test
    public void deveCalcularValorAluguelComBeneficiosCorreto(){
        for (Beneficio beneficio : listaBeneficios) {
            casaComBeneficios.adicionarBeneficio(beneficio);
        }
        assertEquals(new BigDecimal(8300), casaComBeneficios.calcularValorAluguel());
    }

    @Test
    public void deveRetornarValorRecebidoPelaImobiliariaComAluguelCorreto(){
        assertEquals(new BigDecimal(480).setScale(2, RoundingMode.HALF_EVEN), casaSemBeneficios.calcularValorComissaoImobiliaria());
    }

    @Test
    public void deveExibirDescricaoCorreta(){
        for (Beneficio beneficio : listaBeneficios) {
            casaComBeneficios.adicionarBeneficio(beneficio);
        }

        String descricaoEsperada = "Casa aluguel valor: 8300\nEndereço: Av. Professor Mario Werneck\nBenefícios Imóvel: \n- Piscina Aquecida\n- Elevador\n- Sala de Jogos Gigante";

        assertEquals(descricaoEsperada, casaComBeneficios.mostrarDescricaoImovel());
    }
}
