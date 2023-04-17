import java.math.BigDecimal;

public class Casa extends Imovel{
    private static final double PORCENTAGEM_ALIQUOTA = 0.5;
    private static final int PORCENTAGEM_DESCONTO_IDADE = 10;

    private double valorAnualSeguro;
    

    public Casa(String endereco, double valorVenda, int anoConstrucao, double valorAnualSeguro){
        super(endereco, valorVenda, anoConstrucao);
        this.valorAnualSeguro = valorAnualSeguro;
    }

    public double getValorAnualSeguroMensal(){
        return this.valorAnualSeguro/12;
    }
    /**
     *  Calcula o valor de aluguel da casa de acordo com:
     *  (((valorVenda * aliquota) + valorBeneficios) - porcentagemDescontoImovel) + (valorAnualSeguro/12)
     * 
     * @return Valor de aluguel da casa
     */
    public BigDecimal calcularValorAluguel(){
        double valorAluguelAliquota = this.valorVenda * (PORCENTAGEM_ALIQUOTA/100);
        
        int percentualDesconto = obterPercentualDesconto();
        if(percentualDesconto > this.PORCENTAGEM_DESCONTO_MAXIMO)
            percentualDesconto = this.PORCENTAGEM_DESCONTO_MAXIMO;

        double valorDesconto = ((valorAluguelAliquota + this.calcularValorTotalBeneficios()) * percentualDesconto)/100;
        double valorAluguel = (valorAluguelAliquota + this.calcularValorTotalBeneficios()) - valorDesconto + (valorAnualSeguro/12);

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
        descricao.append("Casa aluguel valor: " + this.calcularValorAluguel());
        descricao.append("\nEndereço: " + this.endereco);
        descricao.append("\n" + this.mostrarBeneficios());

        return descricao.toString();
    }
}
