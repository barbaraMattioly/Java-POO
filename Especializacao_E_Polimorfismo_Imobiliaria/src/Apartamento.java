import java.math.BigDecimal;

public class Apartamento extends Imovel {
    private static final double PORCENTAGEM_ALIQUOTA = 0.4;
    private static final int PORCENTAGEM_DESCONTO_IDADE = 5;

    private double taxaCondominio;
    

    public Apartamento(String endereco, double valorVenda, int anoConstrucao, double taxaCondominio){
        super(endereco, valorVenda, anoConstrucao);
        this.taxaCondominio = taxaCondominio;
    }

    public double getTaxaCondominio(){
        return this.taxaCondominio;
    }
    
    /**
     *  Calcula o valor de aluguel do apartamento de acordo com:
     *  (((valorVenda * aliquota) + valorBeneficios) - porcentagemDescontoImovel) + taxaCondominio
     * 
     * @return Valor de aluguel do apartamento
     */
    public BigDecimal calcularValorAluguel(){
        double valorAluguelAliquota = this.valorVenda * (PORCENTAGEM_ALIQUOTA/100);
        
        int percentualDesconto = obterPercentualDesconto();
        if(percentualDesconto > this.PORCENTAGEM_DESCONTO_MAXIMO)
            percentualDesconto = this.PORCENTAGEM_DESCONTO_MAXIMO;

        double valorDesconto = ((valorAluguelAliquota + this.calcularValorTotalBeneficios()) * percentualDesconto)/100;
        double valorAluguel = (valorAluguelAliquota + this.calcularValorTotalBeneficios()) - valorDesconto + taxaCondominio;

        return new BigDecimal(valorAluguel);
    }

    /**
     * Calcular o percentual de desconto que será aplicado no valor do aluguel (5% a cada 5 anos) dado por:
     * ((idadeDoImovel/5)*5)
     * 
     * @return Percentual de desconto que será aplicado no valor do aluguel
     */
    private int obterPercentualDesconto(){
        int percentualDesconto = (this.calcularIdadeImovel() / 5) * PORCENTAGEM_DESCONTO_IDADE;

        return percentualDesconto;
    }

    /**
     * Retorna o valor recebido pela imobiliária por um aluguel (12% de comissão)
     * 
     * @return valor recebido pela imobiliária pelo aluguel
     */
    public BigDecimal calcularValorComissaoImobiliaria(){
        BigDecimal valorComissao = calcularValorAluguel().multiply(this.PORCENTAGEM_COMISSAO);
        return valorComissao;
    }

    /**
     * Monta uma descrição com o valor do aluguel, endereço e benefícios
     * 
     * @return String com dados do imóvel sendo alugado
     */
    public String mostrarDescricaoImovel(){
        StringBuilder descricao = new StringBuilder();
        descricao.append("Apartamento aluguel valor: " + this.calcularValorAluguel());
        descricao.append("\nEndereço: " + this.endereco);
        descricao.append("\n" + this.mostrarBeneficios());

        return descricao.toString();
    }
}
