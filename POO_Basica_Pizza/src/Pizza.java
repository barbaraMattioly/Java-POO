import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pizza {
    //#region ATRIBUTOS e CONSTANTES
    private static final BigDecimal VALOR_BASE = new BigDecimal(25.0);
    private static final BigDecimal VALOR_ACRESCIMOS = new BigDecimal(4.0);
    private static final int MAXIMO_ADICIONAIS = 8;
    private static final int MINIMO_ADICIONAIS = 0;

    private BigDecimal valor;
    private int quantidadeIngredientesAdicionais;
    //endregion

    //#region CONSTRUTOR
    public Pizza(){
        this.valor = new BigDecimal (0.0);
        this.quantidadeIngredientesAdicionais = 0;
    }
    //endregion
    
    //#region MÉTODOS
    private boolean validarAcrescimos(int quantidadeIngredientesAdicionais){
        int quantidadeAdicionaisAposAdicao = this.quantidadeIngredientesAdicionais + quantidadeIngredientesAdicionais;
        if(quantidadeAdicionaisAposAdicao > MAXIMO_ADICIONAIS || quantidadeAdicionaisAposAdicao < MINIMO_ADICIONAIS)
            return false;
        return true;
    }

    public void adicionarAcrescimos(int quantidadeIngredientesAdicionais) {
        Logger logger = Logger.getLogger(Pizza.class.getName());
        
        if(!validarAcrescimos(quantidadeIngredientesAdicionais)){
            logger.log(Level.WARNING, "O numero maximo de adicionais permitidos e 8! Nao foram adicionados mais adicionais");
            return;
        }
        
        this.quantidadeIngredientesAdicionais += quantidadeIngredientesAdicionais;
    }

    private BigDecimal calcularValorAdicionais(){
        BigDecimal quantidadeAdicionais = new BigDecimal(this.quantidadeIngredientesAdicionais);
        return quantidadeAdicionais.multiply(VALOR_ACRESCIMOS);
    }

    public BigDecimal calcularValorTotal(){
        BigDecimal valorCalculado = VALOR_BASE.add(calcularValorAdicionais());
        this.valor = valorCalculado;

        return valorCalculado;
    }

    public String gerarNota(){
        return /*"Pizza: " + getIdPizza() + " | */"Valor pizza: R$" + this.valor + " |" + " Descrição: " + this.quantidadeIngredientesAdicionais + " acréscimos";
    }
    //endregion

}
