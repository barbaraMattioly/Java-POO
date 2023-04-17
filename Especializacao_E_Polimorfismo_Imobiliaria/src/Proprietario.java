import java.math.BigDecimal;
import java.util.LinkedList;

public class Proprietario {    
    //#region
    private LinkedList<Imovel> imoveis = new LinkedList<Imovel>();
    private String nome;
    private String endereco;  
    //#endregion

    /**
     * Construtor da classe proprietário que recebe nome e endereço
     * 
     * @param nome Nome do proprietário
     * @param endereco Endereço do proprietário
     */
    public Proprietario(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }

    public LinkedList<Imovel> getListaImoveis(){
        return this.imoveis;
    }

    /**
     * Adiciona um imóvel a lista de imóveis
     * 
     * @param imovel Imóvel a ser adicionado
     */
    public void adicionarImovel(Imovel imovel){
        imoveis.add(imovel);
    }

    /**
     * Calcula o valor total (bruto) arrecadado com os aluguéis de suas propriedades
     * 
     * @return Valor total arrecadado
     */
    public BigDecimal calcularValorTotalArrecadado(){
        BigDecimal valorTotalArrecadado = new BigDecimal(0);
        for (Imovel imovel : imoveis){
            if(imovel.getClass().getSimpleName().equals("Apartamento")){
                Apartamento apartamento = (Apartamento) imovel;
                valorTotalArrecadado = valorTotalArrecadado.add(apartamento.calcularValorAluguel());
            }
            else{
                Casa casa = (Casa) imovel;
                valorTotalArrecadado = valorTotalArrecadado.add(casa.calcularValorAluguel());
            }
        }
        return valorTotalArrecadado;
    }

    /**
     * Calcula o valor total (líquido) arrecadado com os aluguéis de suas propriedades
     * valorBruto - valorCondominio(prédio) - valorSeguro(casa)
     * 
     * @return Valor liquido recebido pelo proprietário
     */
    public BigDecimal calcularValorLiquido(){
        BigDecimal valorLiquido = new BigDecimal(0);
        for (Imovel imovel : imoveis){
            if(imovel.getClass().getSimpleName().equals("Apartamento")){
                Apartamento apartamento = (Apartamento) imovel;
                valorLiquido = valorLiquido.add((apartamento.calcularValorAluguel()).subtract(new BigDecimal(apartamento.getTaxaCondominio())));
            }
            else{
                Casa casa = (Casa) imovel;
                valorLiquido = valorLiquido.add((casa.calcularValorAluguel()).subtract(new BigDecimal(casa.getValorAnualSeguroMensal())));
            }
        }
        return valorLiquido;
    }

    /**
     * Calcula o valor que a imobiliária recebera com o imóvel do proprietário
     * 
     * @return valor que a imobiliária receberá
     */
    public BigDecimal calcularValorArrecadadoImobiliaria(){
        BigDecimal valorLiquido = new BigDecimal(0);
        for (Imovel imovel : imoveis){
            if(imovel.getClass().getSimpleName().equals("Apartamento")){
                Apartamento apartamento = (Apartamento) imovel;
                valorLiquido = valorLiquido.add(apartamento.calcularValorComissaoImobiliaria());
            }
            else{
                Casa casa = (Casa) imovel;
                valorLiquido = valorLiquido.add(casa.calcularValorComissaoImobiliaria());
            }
        }
        return valorLiquido;        
    }

    /**
     * Exibe todos os imóveis do proprietário
     * 
     * @return String com todos os imóveis do proprietário
     */
    public String exibirImoveis(){
        StringBuilder descImoveis = new StringBuilder();

        descImoveis.append("Proprietário: " + this.nome + "\nEndereço: " + this.endereco);

        for (Imovel imovel : imoveis){            
            if(imovel.getClass().getSimpleName().equals("Apartamento")){
                Apartamento apartamento = (Apartamento) imovel;
                descImoveis.append("\n" + apartamento.mostrarDescricaoImovel());
            }
            else{
                Casa casa = (Casa) imovel;
                descImoveis.append("\n" + casa.mostrarDescricaoImovel());
            }
        }

        return descImoveis.toString();
    }

    /**
     * Retorna uma string com todos os imóveis do proprietário com ano de construção igual ao recebido
     * 
     * @param ano Ano de Construção
     * @return String com todos os imóveis do ano passado como parâmetro
     */
    public String obterImoveisAnoConstrucao(int ano){
        StringBuilder descImoveis = new StringBuilder();

        for(Imovel imovel : imoveis){
            if(imovel.getAnoConstrucao() == ano){
                descImoveis.append("\nNome Propietário: " + this.nome);
                if(imovel.getClass().getSimpleName().equals("Apartamento")){
                    Apartamento apartamento = (Apartamento) imovel;
                    descImoveis.append("\n" + apartamento.mostrarDescricaoImovel());
                }
                else{
                    Casa casa = (Casa) imovel;
                    descImoveis.append("\n" + casa.mostrarDescricaoImovel());
                }
            }
        }

        return descImoveis.toString();
    }
}
