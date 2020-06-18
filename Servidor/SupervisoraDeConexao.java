import java.io.*;
import java.net.*;
import java.util.*;

import bd.daos.Desenhos;

public class SupervisoraDeConexao extends Thread {
    private double valor = 0;
    private Parceiro usuario;
    private Socket conexao;
    private ArrayList<Parceiro> usuarios;

    /**
	 * Monitora o status da conexão.
	 * 
     * @param conexao   conexão solicitada
     * @param usuarios  usuários conectados
	 * @author     Leonardo
	 * @author     Rodrigo
	 * @author     Pedro
	 */
    public SupervisoraDeConexao(Socket conexao, ArrayList<Parceiro> usuarios) throws Exception {
        if (conexao == null)
            throw new Exception("Conexao ausente");

        if (usuarios == null)
            throw new Exception("Usuarios ausentes");

        this.conexao = conexao;
        this.usuarios = usuarios;
    }

/**
	 * Inicializa o transmissor
	 * 
	 * @author     Leonardo
	 * @author     Rodrigo
	 * @author     Pedro
	 */
    public void run() {

        ObjectOutputStream transmissor;
        try {
            transmissor = new ObjectOutputStream(this.conexao.getOutputStream());
        } catch (Exception erro) {
            return;
        }

        ObjectInputStream receptor = null;
        try {
            receptor = new ObjectInputStream(this.conexao.getInputStream());
        } catch (Exception err0) {
            try {
                transmissor.close();
            } catch (Exception falha) {
            } // so tentando fechar antes de acabar a thread

            return;
        }

        try {
            this.usuario = new Parceiro(this.conexao, receptor, transmissor);
        } catch (Exception erro) {
        } // sei que passei os parametros corretos

        try {
            synchronized (this.usuarios) {
                this.usuarios.add(this.usuario);
            }

            for (;;) {
                Comunicado comunicado = this.usuario.envie();

                if (comunicado == null)
                    return;

                else if (comunicado instanceof PedidoSalvamento) {
                    PedidoSalvamento pedidoSalvamento = (PedidoSalvamento) comunicado;
                    Desenhos.incluir(pedidoSalvamento.getDesenho(), "192.168.15.120");
                    
                    System.out.println("Salvou o desenho!");
                    
                } else if (comunicado instanceof PedidoDesenhos) {
                    // this.usuario.receba(new Desenhos());
                    System.out.println("Retornou os desenhos para clinte!");
                } else if (comunicado instanceof PedidoParaSair) {
                    synchronized (this.usuarios) {
                        this.usuarios.remove(this.usuario);
                    }
                    this.usuario.adeus();
                    System.out.println("Desconectou o cliente!");
                }
            }
        } catch (Exception erro) {
            try {
                transmissor.close();
                receptor.close();
            } catch (Exception falha) {
            } // so tentando fechar antes de acabar a thread

            return;
        }
        
    }


    
}



