public class PedidoSalvamento extends Comunicado {
  private double idCliente; // vai ser o ip
  private Desenho desenho;

  public PedidoSalvamento(double idCliente, Desenho des) {
    this.idCliente = idCliente;
    this.desenho = des;
  }

  public PedidoSalvamento(Desenho des) {
    this.desenho = des;
  }

  public PedidoSalvamento(double idCliente) {
    this.idCliente = idCliente;
  }

  public PedidoSalvamento() {
  }

  public double getIdCliente() {
    return this.idCliente;
  }

  public Desenho getDesenho() {
    return this.desenho;
  }
}