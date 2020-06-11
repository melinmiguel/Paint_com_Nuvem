import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.Semaphore;

/**
 * Cria a conexão entre o client e o servidor.
 *
 * @author Rodrigo
 * @author Pedro
 * @author Leonardo
 */
public class Parceiro {
    private Socket conexao;
    private ObjectInputStream receptor;
    private ObjectOutputStream transmissor;

    private Comunicado proximoComunicado = null;

    private Semaphore mutEx = new Semaphore(1, true);

    /**
     * Construtor do objeto Parceiro, o qual fara a realização da conexão.
     *
     * @param conexao     Socket de conexão do servidor
     * @param receptor    objectImput de transmissão
     * @param transmissor objectImput de recebimento
     * @author Rodrigo
     * @author Pedro
     * @author Leonardo
     */
    public Parceiro(Socket conexao, ObjectInputStream receptor, ObjectOutputStream transmissor) throws Exception // se
                                                                                                                 // parametro
                                                                                                                 // nulos
    {
        if (conexao == null)
            throw new Exception("Conexao ausente");

        if (receptor == null)
            throw new Exception("Receptor ausente");

        if (transmissor == null)
            throw new Exception("Transmissor ausente");

        this.conexao = conexao;
        this.receptor = receptor;
        this.transmissor = transmissor;
    }

    /**
     * Construtor do objeto Parceiro, o qual fara a realização da conexão.
     *
     * @param x Objeto comunicado
     * @author Rodrigo
     * @author Pedro
     * @author Leonardo
     */
    public void receba(Comunicado x) throws Exception {
        try {
            this.transmissor.writeObject(x);
            this.transmissor.flush();
        } catch (IOException erro) {
            throw new Exception("Erro de transmissao");
        }
    }

    /**
     * Monitora o status da conexão entre client e servidor
     *
     * @author Rodrigo
     * @author Pedro
     * @author Leonardo
     */
    public Comunicado espie() throws Exception {
        try {
            this.mutEx.acquireUninterruptibly();
            if (this.proximoComunicado == null)
                this.proximoComunicado = (Comunicado) this.receptor.readObject();
            this.mutEx.release();
            return this.proximoComunicado;
        } catch (Exception erro) {
            throw new Exception("Erro de recepcao");
        }
    }

    /**
     * realiza a transmissão para o receptor
     *
     * @author Rodrigo
     * @author Pedro
     * @author Leonardo
     */
    public Comunicado envie() throws Exception {
        try {
            if (this.proximoComunicado == null)
                this.proximoComunicado = (Comunicado) this.receptor.readObject();
            Comunicado ret = this.proximoComunicado;
            this.proximoComunicado = null;
            return ret;
        } catch (Exception erro) {
            throw new Exception("Erro de recepcao");
        }
    }

    /**
     * Desconecta o client do servidor.
     *
     * @author Rodrigo
     * @author Pedro
     * @author Leonardo
     */
    public void adeus() throws Exception {
        try {
            this.transmissor.close();
            this.receptor.close();
            this.conexao.close();
        } catch (Exception erro) {
            throw new Exception("Erro de desconexao");
        }
    }
}