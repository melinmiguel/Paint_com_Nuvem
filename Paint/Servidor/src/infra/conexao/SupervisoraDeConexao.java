package src.infra.conexao;

import java.io.*;
import java.net.*;
import java.util.*;

import src.infra.banco.Desenhos;

public class SupervisoraDeConexao extends Thread {
    private Parceiro usuario;
    private Socket conexao;
    private ArrayList<Parceiro> usuarios;

    public SupervisoraDeConexao(Socket conexao, ArrayList<Parceiro> usuarios) throws Exception {
        if (conexao == null)
            throw new Exception("Conexao ausente");

        if (usuarios == null)
            throw new Exception("Usuarios ausentes");

        this.conexao = conexao;
        this.usuarios = usuarios;
    }

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

                if (comunicado instanceof PedidoDesenhos) {
                    // Desenhos desenhos =
                    // src.infra.banco.BD.DESENHOS.selecionaDesenhosPorIdCliente("primeiro");
                    // // PedidoDesenhos pedidoDesenhos = (PedidoDesenhos) comunicado;
                    // // this.desenhos = pedidoDesenhos.getDesenhos();
                    // this.usuario.receba(this.desenhos);

                } else if (comunicado instanceof PedidoSalvamento) {
                    PedidoSalvamento pedidoSalvamento = (PedidoSalvamento) comunicado;
                    pedidoSalvamento.SalvarDesenho();

                } else if (comunicado instanceof PedidoParaSair) {
                    synchronized (this.usuarios) {
                        this.usuarios.remove(this.usuario);
                    }
                    this.usuario.adeus();
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
