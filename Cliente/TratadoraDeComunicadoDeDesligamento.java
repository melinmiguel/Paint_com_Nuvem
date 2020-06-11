import java.net.*;


/**
 * realiza o desligamento da comincação entre cliente e servidor.
 * 
 * 
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
public class TratadoraDeComunicadoDeDesligamento extends Thread
{
    private Parceiro servidor;

/**
 * Realiza o desligamento da comincação entre cliente e servidor.
 * 
 * @param servidor  id do servidor da conexão.
 * @author          Leonardo
 * @author          Rodrigo
 * @author          Pedro
 */
    public TratadoraDeComunicadoDeDesligamento (Parceiro servidor) throws Exception
    {
        if (servidor==null)
            throw new Exception ("Porta invalida");

        this.servidor = servidor;
    }

/**
 * Realiza o monitoramento se a conexão foi desativada.
 * 
 * @author          Leonardo
 * @author          Rodrigo
 * @author          Pedro
 */
    public void run ()
    {
        for(;;)
        {
			try
			{
				if (this.servidor.espie() instanceof ComunicadoDeDesligamento)
				{
					System.out.println ("\nO servidor vai ser desligado agora;");
				    System.err.println ("volte mais tarde!\n");
				    System.exit(0);
				}
			}
			catch (Exception erro)
			{}
        }
    }
}
