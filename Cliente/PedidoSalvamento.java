/**
  * Realiza o salvamento dos desenhos feitos pelo usuário.
  *
  * @author             Rodrigo
  * @author             Pedro
  * @author             Leonardo
  */

public class PedidoSalvamento extends Comunicado {
  private double idCliente; // vai ser o ip
  private Desenho desenho;

/**
  * Construtor do pedido de Salvamento
  *
  * @param idClient     id do cliente solicitante
  * @param des          Objeto desenho solicitado para salvamento.
  * @author             Rodrigo
  * @author             Pedro
  * @author             Leonardo
  */
  public PedidoSalvamento(double idCliente, Desenho des) {
    this.idCliente = idCliente;
    this.desenho = des;
  }

/**
  * Define o desenho da classe Desenho
  *
  * @param des      Objeto desenho
  * @author         Rodrigo
  * @author         Pedro
  * @author         Leonardo
  */
  public PedidoSalvamento(Desenho des) {
    this.desenho = des;
  }
  
/**
  * define o id do cliente que realizara o salvamento
  *
  * @param idClient   id do cliente requisitante.
  * @author           Rodrigo
  * @author           Pedro
  * @author           Leonardo
  */
  public PedidoSalvamento(double idCliente) {
    this.idCliente = idCliente;
  }

 
  public PedidoSalvamento() {
  }

  /**
  * Retorna o id do cliente requisitante
  *
  * @return           id do cliente requisitante.
  * @author           Rodrigo
  * @author           Pedro
  * @author           Leonardo
  */
  public double getIdCliente() {
    return this.idCliente;
  }

    /**
  * Retorna o id do cliente requisitante
  *
  * @return          Desenho solicitado.
  * @author          Rodrigo
  * @author          Pedro
  * @author          Leonardo
  */
  public Desenho getDesenho() {
    return this.desenho;
  }
}