import java.util.logging.Level;
import java.util.logging.Logger;

public class Pizza {
    //#region ATRIBUTOS
    private static final double VALORBASE;
    private static final double VALORACRESCIMOS;
    private double valor;
    private int quantidadeIngredientesAdicionais;
    private String descricao;
    private boolean quantidadeIngredientesAdicionaisValida;

    static{
        VALORBASE = 25.00;
        VALORACRESCIMOS = 4.00;
    }
    //endregion

    //#region CONSTRUTOR
    public Pizza(){
        this.valor = 0.0;
        this.quantidadeIngredientesAdicionais = 0;
        this.descricao = "";
        this.quantidadeIngredientesAdicionaisValida = false;
    }
    //endregion
    
    //#region MÉTODOS
    public boolean adicionarAcrescimos(int quantidadeIngredientesAdicionais) {
        Logger logger = Logger.getLogger(Pizza.class.getName());
        if(quantidadeIngredientesAdicionais > 8 || quantidadeIngredientesAdicionais < 0){
            logger.log(Level.WARNING, "O número máximo de adicionais permitidos é 8!");
            return false;
        }
        
        this.quantidadeIngredientesAdicionaisValida = true;
        this.quantidadeIngredientesAdicionais = quantidadeIngredientesAdicionais;
        return true;
    }

    public double calcularValorTotal(){
        if(quantidadeIngredientesAdicionaisValida){
            if(quantidadeIngredientesAdicionais == 0){
                this.valor = VALORBASE;
                return VALORBASE;
            }

            double valorCalculado = VALORBASE+(VALORACRESCIMOS*quantidadeIngredientesAdicionais);
            this.valor = valorCalculado;

            return valorCalculado;
        }
        return 0;
    }

    public String gerarNota(){
        if(quantidadeIngredientesAdicionaisValida){
            this.descricao = "Valor a ser pago: R$" + this.valor + " |" + " Descrição: " + this.quantidadeIngredientesAdicionais + " acréscimos";
            return descricao;
        }
        return "";
    }
    //endregion

}
