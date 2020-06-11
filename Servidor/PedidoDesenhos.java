public class PedidoDesenhos extends Comunicado {
  private double idCliente; // vai ser o ip


  /**
	 * Solicita um desenho para o client
	 * 
   * @param idClient codigo do cliente solicitante
	 * @author     Leonardo
	 * @author     Rodrigo
	 * @author     Pedro
	 */
  public PedidoDesenhos(double idCliente) {
    this.idCliente = idCliente;
  }

  
    /**
	 * retorna o id co client
	 * 
   * @return idClient id do client
	 * @author     Leonardo
	 * @author     Rodrigo
	 * @author     Pedro
	 */
  public double getIdCliente() {
    return this.idCliente;
  }
}