package Infra.conexao;

import java.io.*;
import java.net.*;

public class Servidor {
	private int porta;

	public Servidor() {
		this.porta = 12345;
	}

	public Servidor(int porta) {
		this.porta = porta;
	}

	public void executa() throws IOException {
		ServerSocket serverSocket = new ServerSocket(this.porta);
		System.out.println("Porta " + this.porta + " aberta!");

		while (true) {
			Socket clienteSocket = serverSocket.accept();

			try {
				Thread tc = new trataConexao(clienteSocket, this);
				System.out.println("Nova conexao com o cliente " + clienteSocket.getInetAddress().getHostAddress());
				tc.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
