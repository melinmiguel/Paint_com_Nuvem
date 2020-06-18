import java.net.*;
import java.util.*;

	/**
	 * Aceita a conexão do cliente criando uma Thread
	 * 
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */

public class AceitadoraDeConexao extends Thread
{
    private static final int PORTA_PADRAO = 3000;

    private ServerSocket        pedido;
    private ArrayList<Parceiro> usuarios;
    
    /**
	 * Construtora da conexão do cliente criando uma Thread
	 * 
     * @param escolha numero do cliente
     * @param usuarios array list de usuários
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
    public AceitadoraDeConexao
    (String escolha, ArrayList<Parceiro> usuarios)
    throws Exception
    {
        int porta = AceitadoraDeConexao.PORTA_PADRAO;

        if (escolha!=null)
        {
            try
            {
                porta = Integer.parseInt(escolha);
                this.pedido = new ServerSocket (porta);
            }
            catch (Exception  erro)
            {
                throw new Exception ("Porta invalida");
            }
        }

        if (usuarios==null)
            throw new Exception ("Usuarios ausentes");

        this.usuarios = usuarios;
    }

    /**
	 * Inicia a classe, deixando-a rodando com as conexões ativas.
	 * 
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
    public void run ()
    {
        for(;;)
        {
            Socket conexao=null;
            try
            {
                conexao = this.pedido.accept();
            }
            catch (Exception erro)
            {
                continue;
            }

            SupervisoraDeConexao supervisoraDeConexao=null;
            try
            {
                supervisoraDeConexao =
                new SupervisoraDeConexao (conexao, usuarios);
            }
            catch (Exception erro)
            {} // sei que passei parametros corretos para o construtor
            supervisoraDeConexao.start();
        }
    }
}
