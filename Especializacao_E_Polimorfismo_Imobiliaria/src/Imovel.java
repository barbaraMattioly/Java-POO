import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.LinkedList;

public class Imovel {
    protected final BigDecimal PORCENTAGEM_COMISSAO = new BigDecimal(0.12).setScale(2, RoundingMode.HALF_EVEN);

    protected final int PORCENTAGEM_DESCONTO_MAXIMO = 30;

    protected String endereco;
    protected double valorVenda;
    private int anoConstrucao;
    private LinkedList<Beneficio> beneficios = new LinkedList<Beneficio>();

    public Imovel(String endereco, double valorVenda, int anoConstrucao){
        this.endereco = endereco;
        this.valorVenda = valorVenda;
        this.anoConstrucao = anoConstrucao;
    }

    public int getAnoConstrucao(){
        return this.anoConstrucao;
    }

    /**
     * Calcula a idade do imóvel (ano atual - ano de construção)
     * 
     * @return Idade do imóvel (Anos)
     */
    protected int calcularIdadeImovel(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) - anoConstrucao;
    }

    /**
     * Adiciona beneficio como piscina, elevador e etc ao imóvel
     * @param beneficio a ser adicionado
     */
    public void adicionarBeneficio(Beneficio beneficio){        
        beneficios.add(beneficio);
    }

    /**
     * Calcula o valor total a ser adicionado pelos beneficios
     * 
     * @return valorTotal BENEFICIOS
     */
    protected double calcularValorTotalBeneficios(){
        double valorTotalBeneficios = 0;

        for (Beneficio beneficio : beneficios){
            valorTotalBeneficios += beneficio.getValorBeneficio();
        }

        return valorTotalBeneficios;
    }

    /**
     * Exibe todos os benefícios do imóvel
     * 
     * @return string com descrição de todos os benefícios
     */
    public String mostrarBeneficios(){
        StringBuilder textoBeneficios = new StringBuilder();

        if(beneficios.size() == 0){
            return "Esse imóvel não possui benefícios adicionais";
        }

        textoBeneficios.append("Benefícios Imóvel: ");

        for (Beneficio beneficio : beneficios){            
            textoBeneficios.append("\n- " + beneficio.getDescricao());
        }

        return textoBeneficios.toString();
    }
}
