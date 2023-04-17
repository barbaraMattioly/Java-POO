import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ProprietarioTest {
    Proprietario proprietario;
    Imovel imovel1, imovel2, imovel3;
    Beneficio piscina, elevador, salaJogos;
    LinkedList<Imovel> listaImoveis = new LinkedList<Imovel>();

    @BeforeEach
    public void prepare(){
        proprietario = new Proprietario("Barbara", "Canadá");

        imovel1 = new Apartamento("Av. Professor Mario Werneck, 1200",750000, 2003, 1100);
        imovel2 = new Casa("Av. Professor Mario Werneck",350000, 1957, 6000);
        imovel3 = new Casa("Av. Professor Mario Werneck",750000, 2010, 12000);

        listaImoveis.add(imovel1);
        listaImoveis.add(imovel2);
        listaImoveis.add(imovel3);
    }

    @Test
    public void deveAdicionarImovelALista(){
        for (Imovel imovel : listaImoveis) {
            proprietario.adicionarImovel(imovel);
        }

        assertEquals(3, proprietario.getListaImoveis().size());
    }

    @Test
    public void deveRetornarValorTotalArrecadadoCorreto(){
        for (Imovel imovel : listaImoveis) {
            proprietario.adicionarImovel(imovel);
        }

        assertEquals(new BigDecimal(9225), proprietario.calcularValorTotalArrecadado());
    }

    @Test
    public void deveRetornarValorLiquidoCorreto(){
        for (Imovel imovel : listaImoveis) {
            proprietario.adicionarImovel(imovel);
        }
        
        assertEquals(new BigDecimal(6625), proprietario.calcularValorLiquido());
    }
}
