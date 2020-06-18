import bd.daos.Desenhos;
import bd.dbos.Desenho;

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
  public PedidoSalvamento(int idCliente, Desenho des) {
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
   try
        {
            Desenhos.incluir (new Desenho ("1","Desenho 1","21/07/04","21/07/04","\"[elipse:422:89:975:546:0:0:0, quadrado:500:212:598:276:255:51:51, retangulo:731:202:892:286:255:51:51, circulo:585:359:774:385:0:204:153].fga\""));
            System.out.println ("Desenho incluido com sucesso!");
        }
        catch (Exception erro)
        {
			erro.printStackTrace();
            System.out.println (erro.getMessage());
        }
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