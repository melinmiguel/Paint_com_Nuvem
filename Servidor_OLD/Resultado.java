import bd.daos.Desenhos;
import bd.dbos.Desenho;
public class Resultado extends Comunicado
{
    private double valorResultante;

    /**
	 * Define o valor da resultante.
	 * 
     * @param valorResultante valor da resultante.
	 * @author     Leonardo
	 * @author     Rodrigo
	 * @author     Pedro
	 */
    public Resultado (double valorResultante)
    {
        this.valorResultante = valorResultante;
    }

    /**
	 * retorna o valor da Resultante
	 * 
     * @return valorResultante valor da resultante.
	 * @author     Leonardo
	 * @author     Rodrigo
	 * @author     Pedro
	 */
    public double getValorResultante ()
    {
        return this.valorResultante;
    }
    
    /**
	 * Retorna os valores em formato string
	 * 
     * @return String com os dados da classe.
	 * @author     Leonardo
	 * @author     Rodrigo
	 * @author     Pedro
	 */
    public String toString ()
    {
		return (""+this.valorResultante);
	}

}
