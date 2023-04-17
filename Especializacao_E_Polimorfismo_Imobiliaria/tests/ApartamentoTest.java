import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ApartamentoTest {
    Apartamento apartamentoSemBeneficios, apartamentoMaisDeTrintaAnos, apartamentoComBeneficios;
    Beneficio piscina, elevador, salaJogos;
    LinkedList<Beneficio> listaBeneficios = new LinkedList<Beneficio>();

    @BeforeEach
    public void prepare(){
        apartamentoSemBeneficios = new Apartamento("Av. Professor Mario Werneck",750000, 2003, 1100);
        apartamentoMaisDeTrintaAnos = new Apartamento("Av. Professor Mario Werneck",350000, 1957, 1000);
        apartamentoComBeneficios = new Apartamento("Av. Professor Mario Werneck",1200000, 2022, 3000);

        piscina = new Beneficio("Piscina Aquecida", 100);
        elevador = new Beneficio("Elevador", 100);
        salaJogos = new Beneficio("Sala de Jogos Gigante", 100);

        listaBeneficios.add(piscina);
        listaBeneficios.add(elevador);
        listaBeneficios.add(salaJogos);
    }

    @Test
    public void deveRetornarValorAluguelApartamentoSemBeneficiosCorreto(){
        assertEquals(new BigDecimal(3500), apartamentoSemBeneficios.calcularValorAluguel());
    }

    @Test
    public void deveCalcularValorAluguelComMaximoPadraoCasoDescontoExcedaTrintaCorreto(){
        assertEquals(new BigDecimal(1980), apartamentoMaisDeTrintaAnos.calcularValorAluguel());
    }

    @Test
    public void deveCalcularValorAluguelComBeneficiosCorreto(){
        for (Beneficio beneficio : listaBeneficios) {
            apartamentoComBeneficios.adicionarBeneficio(beneficio);
        }
        assertEquals(new BigDecimal(8100), apartamentoComBeneficios.calcularValorAluguel());
    }

    @Test
    public void deveRetornarValorRecebidoPelaImobiliariaComAluguelCorreto(){
        assertEquals(new BigDecimal(420.00).setScale(2, RoundingMode.HALF_EVEN), apartamentoSemBeneficios.calcularValorComissaoImobiliaria());
    }

    @Test
    public void deveExibirDescricaoCorreta(){
        for (Beneficio beneficio : listaBeneficios) {
            apartamentoComBeneficios.adicionarBeneficio(beneficio);
        }

        String descricaoEsperada = "Apartamento aluguel valor: 8100\nEndereço: Av. Professor Mario Werneck\nBenefícios Imóvel: \n- Piscina Aquecida\n- Elevador\n- Sala de Jogos Gigante";

        assertEquals(descricaoEsperada, apartamentoComBeneficios.mostrarDescricaoImovel());
    }
}
