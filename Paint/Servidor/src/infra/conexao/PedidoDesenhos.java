package src.infra.conexao;

public class PedidoDesenhos extends Comunicado {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private double idCliente; // vai ser o ip

  public PedidoDesenhos(double idCliente) {
    this.idCliente = idCliente;
  }

  public double getIdCliente() {
    return this.idCliente;
  }
}