import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ImobiliariaTest {
    Imobiliaria imobiliaria;
    Proprietario proprietario1, proprietario2;
    Imovel imovel1, imovel2, imovel3;
    LinkedList<Imovel> listaImoveis = new LinkedList<Imovel>();
    LinkedList<Proprietario> listaProprietarios = new LinkedList<Proprietario>();

    @BeforeEach
    public void prepare(){
        imobiliaria = new Imobiliaria("Casas Brasil");

        imovel1 = new Apartamento("Av. Professor Mario Werneck",750000, 2003, 1100);
        imovel2 = new Casa("Av. Professor Mario Werneck",350000, 1957, 6000);
        imovel3 = new Casa("Av. Professor Mario Werneck",750000, 2003, 12000);

        proprietario1 = new Proprietario("Barbara", "Londres");
        proprietario2 = new Proprietario("Luiz", "Brasil");

        listaImoveis.add(imovel1);
        listaImoveis.add(imovel2);
        listaImoveis.add(imovel3);

        listaProprietarios.add(proprietario1);
        listaProprietarios.add(proprietario2);
    }

    @Test
    public void deveAdicionarProprietarioALista(){
        for (Proprietario proprietario : listaProprietarios) {
            imobiliaria.adicionarProprietario(proprietario);
        }

        assertEquals(2, imobiliaria.getProprietarios().size());
    }

    @Test
    public void deveCalcularValorTotalArrecadadoCorreto(){
        for (Proprietario proprietario : listaProprietarios) {
            imobiliaria.adicionarProprietario(proprietario);
        }

        proprietario1.adicionarImovel(imovel1);
        proprietario2.adicionarImovel(imovel2);
        proprietario2.adicionarImovel(imovel3);

        assertEquals(new BigDecimal(1062.00).setScale(2, RoundingMode.HALF_EVEN), imobiliaria.calcularGanhoTotal());
    }
}