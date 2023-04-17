import java.math.BigDecimal;
import java.util.LinkedList;

public class Imobiliaria {
    private LinkedList<Proprietario> proprietarios = new LinkedList<Proprietario>();
    private String nome;

    public Imobiliaria(String nome){
        this.nome = nome;
    }

    public LinkedList<Proprietario> getProprietarios(){
        return this.proprietarios;
    }

    /**
     * Adiciona um proprietario a lista de proprietarios
     * 
     * @param proprietario proprietario a ser adicionado
     */
    public void adicionarProprietario(Proprietario proprietario){
        proprietarios.add(proprietario);
    }

    /**
     * Retorna uma string com todos os imóveis com ano de construção igual ao recebido
     * 
     * @param ano Ano de Construção
     * @return String com todos os imóveis do ano passado como parâmetro
     */
    public String buscarImoveisAnoConstrucao(int ano){
        StringBuilder desc = new StringBuilder();

        desc.append("Imóveis do ano: " + ano + " na imobiliária " + this.nome);
        for(Proprietario proprietario : proprietarios){
            desc.append(proprietario.obterImoveisAnoConstrucao(ano));
        }

        return desc.toString();
    }

    /**
     * Calcula o ganho total da imobiliária com todos os imóveis
     * 
     * @return Ganho total arrecadado pela imobiliária com todos os imóveis
     */
    public BigDecimal calcularGanhoTotal(){
        BigDecimal ganhoTotal = new BigDecimal(0);
        
        for(Proprietario proprietario : proprietarios){
            ganhoTotal = ganhoTotal.add(proprietario.calcularValorArrecadadoImobiliaria());
        }

        return ganhoTotal;
    }
    
}
