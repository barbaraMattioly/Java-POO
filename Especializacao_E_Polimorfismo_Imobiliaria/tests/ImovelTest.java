import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ImovelTest {
    Imovel imovel;
    Beneficio piscina, elevador, salaJogos;
    LinkedList<Beneficio> listaBeneficios = new LinkedList<Beneficio>();

    @BeforeEach
    public void prepare(){
        imovel = new Imovel("Rua Claudio Manoel, 1162", 620000, 2000);
        
        piscina = new Beneficio("Piscina Aquecida", 100);
        elevador = new Beneficio("Elevador", 100);
        salaJogos = new Beneficio("Sala de Jogos Gigante", 150);

        listaBeneficios.add(piscina);
        listaBeneficios.add(elevador);
        listaBeneficios.add(salaJogos);
    }

    @Test
    public void deveRetornarIdadeCorretaDoImovel(){
        assertEquals(23, imovel.calcularIdadeImovel());
    }

    @Test
    public void deveAdicionarBeneficiosAoImovel(){
        for (Beneficio beneficio : listaBeneficios) {
            imovel.adicionarBeneficio(beneficio);
        }

        assertEquals(3, listaBeneficios.size());        
    }

    @Test
    public void deveRetornarValorTotalBeneficios(){
        for (Beneficio beneficio : listaBeneficios) {
            imovel.adicionarBeneficio(beneficio);
        }

        assertEquals(350, imovel.calcularValorTotalBeneficios());
    }

    @Test
    public void deveRetornarZeroCasoNaoExistamBeneficios(){
        assertEquals(0, imovel.calcularValorTotalBeneficios());
    }

    @Test
    public void deveRetornarStringDeImovelSemBeneficiosCasoNaoExistamBeneficios(){
        assertEquals("Esse imóvel não possui benefícios adicionais", imovel.mostrarBeneficios());
    }

    @Test
    public void deveRetornarDescricaoDosBeneficiosCasoExista(){
        for (Beneficio beneficio : listaBeneficios) {
            imovel.adicionarBeneficio(beneficio);
        }

        String stringEsperada = "Benefícios Imóvel: \n- Piscina Aquecida\n- Elevador\n- Sala de Jogos Gigante";
        assertEquals(stringEsperada, imovel.mostrarBeneficios());
    }
}
