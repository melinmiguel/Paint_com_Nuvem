/**
  * Solicita desenhos para o servidor.
  *
  * @author             Rodrigo
  * @author             Pedro
  * @author             Leonardo
  */
public class PedidoDesenhos extends Comunicado {
  private double idCliente; // vai ser o ip

/**
  * transmite desenhos para o id de cliente selecionado
  *
  * @param  idClient    numero identificador do cliente solicitante.
  * @author             Rodrigo
  * @author             Pedro
  * @author             Leonardo
  */
  public PedidoDesenhos(double idCliente) {
    this.idCliente = idCliente;
  }

/**
  * retorna o ID do cliente solicitante.
  *
  * @author             Rodrigo
  * @author             Pedro
  * @author             Leonardo
  */
  public double getIdCliente() {
    return this.idCliente;
  }
}