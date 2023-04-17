public class Beneficio {
    private String descricao;
    private double valorBeneficio;
    
    public Beneficio(String descricao, double valorBeneficio){
        this.descricao = descricao;
        this.valorBeneficio = valorBeneficio;
    }

    public double getValorBeneficio() {
        return this.valorBeneficio;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
