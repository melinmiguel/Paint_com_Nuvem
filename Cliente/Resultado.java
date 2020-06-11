public class Resultado extends Comunicado
{
    private double valorResultante;

/**
 * classe que define o valorResultante da classe.
 * 
 * @param  valorResultante  define o valor da resultante.
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
    public Resultado (double valorResultante)
    {
        this.valorResultante = valorResultante;
    }

/**
 * Retorna o valor da resultante
 * 
 * @return valor da Resultante
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
    public double getValorResultante ()
    {
        return this.valorResultante;
    }
    
/**
 * Transforma os dados em uma string
 * 
 * @return objeto no formato string
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
    public String toString ()
    {
		return (""+this.valorResultante);
	}

}
