package Infra.conexao;

import java.io.IOException;

public class RodarServidor {
	public static void main(String[] args) throws IOException {
		// new Servidor().executa();

		Servidor servidor = new Servidor();
		servidor.executa();

	}
}
