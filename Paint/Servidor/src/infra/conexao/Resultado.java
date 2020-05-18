package src.infra.conexao;

public class Resultado extends Comunicado {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private double valorResultante;

    public Resultado(double valorResultante) {
        this.valorResultante = valorResultante;
    }

    public double getValorResultante() {
        return this.valorResultante;
    }

    public String toString() {
        return ("" + this.valorResultante);
    }

}
