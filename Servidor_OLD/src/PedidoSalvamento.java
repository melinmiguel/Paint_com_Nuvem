public class PedidoSalvamento extends Comunicado {
  private double idCliente; // vai ser o ip
  private Desenho desenho;

  
  /**
	 * Construtor do pedido de salvamento
	 * 
   * @param IdClient id do cliente
   * @param des   objeto desenho solicitado
	 * @author     Leonardo
	 * @author     Rodrigo
	 * @author     Pedro
	 */
  public PedidoSalvamento(double idCliente, Desenho des) {
    this.idCliente = idCliente;
    this.desenho = des;
  }

  /**
	 * Define valor para o desenho
	 * 
   * @param des objeto solicitado.
	 * @author     Leonardo
	 * @author     Rodrigo
	 * @author     Pedro
	 */
  public PedidoSalvamento(Desenho des) {
    this.desenho = des;
  }

    /**
	 * Define valor do client
	 * 
   * @param idClient ID do client
	 * @author     Leonardo
	 * @author     Rodrigo
	 * @author     Pedro
	 */
  public PedidoSalvamento(double idCliente) {
    this.idCliente = idCliente;
  }

  public PedidoSalvamento() {
  }

    /**
	 * Retorna o id do client
	 * 
   * @return idClient ID do client
	 * @author     Leonardo
	 * @author     Rodrigo
	 * @author     Pedro
	 */
  public double getIdCliente() {
    return this.idCliente;
  }

      /**
	 * Retorna os desenhos
	 * 
   * @return desenho solicitado.
	 * @author     Leonardo
	 * @author     Rodrigo
	 * @author     Pedro
	 */
  public Desenho getDesenho() {
    return this.desenho;
  }
}