import bd.daos.Desenhos;
import bd.dbos.Desenho;
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
  public PedidoDesenhos(int idCliente) {
    this.idCliente = idCliente;
	 Desenhos.getDesenho (new Desenho ());
  }

  
    /**
	 * retorna o id co client
	 * 
   * @return idClient id do client
	 * @author     Leonardo
	 * @author     Rodrigo
	 * @author     Pedro
	 */
  public int getIdCliente() {
    return this.idCliente;
  }
}