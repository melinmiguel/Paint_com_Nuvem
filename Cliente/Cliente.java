import java.net.*;
import java.io.*;

public class Cliente {
	public static final String HOST_PADRAO = "localhost";
	public static final int PORTA_PADRAO = 3000;

	public static void main(String[] args) {
		if (args.length > 2) {
			System.err.println("Uso esperado: java Cliente [HOST [PORTA]]\n");
			return;
		}

		Socket conexao = null;
		try {
			String host = Cliente.HOST_PADRAO;
			int porta = Cliente.PORTA_PADRAO;

			if (args.length > 0)
				host = args[0];

			if (args.length == 2)
				porta = Integer.parseInt(args[1]);

			conexao = new Socket(host, porta);
		} catch (Exception erro) {
			System.err.println("Indique o servidor e a porta corretos!\n");
			return;
		}

		ObjectOutputStream transmissor = null;
		try {
			transmissor = new ObjectOutputStream(conexao.getOutputStream());
		} catch (Exception erro) {
			System.err.println("Indique o servidor e a porta corretos!\n");
			return;
		}

		ObjectInputStream receptor = null;
		try {
			receptor = new ObjectInputStream(conexao.getInputStream());
		} catch (Exception erro) {
			System.err.println("Indique o servidor e a porta corretos!\n");
			return;
		}

		Parceiro servidor = null;
		try {
			servidor = new Parceiro(conexao, receptor, transmissor);
		} catch (Exception erro) {
			System.err.println("Indique o servidor e a porta corretos!\n");
			return;
		}

		TratadoraDeComunicadoDeDesligamento tratadoraDeComunicadoDeDesligamento = null;
		try {
			tratadoraDeComunicadoDeDesligamento = new TratadoraDeComunicadoDeDesligamento(servidor);
		} catch (Exception erro) {
		} // sei que servidor foi instanciado

		tratadoraDeComunicadoDeDesligamento.start();

		char opcao = ' ';
		do {
			System.out.print("Pegar [D]senhos, [S]alvar desenho, [T]erminar): ");

			try {
				opcao = Character.toUpperCase(Teclado.getUmChar());
			} catch (Exception erro) {
				System.err.println("Opcao invalida!\n");
				continue;
			}

			if ("DST".indexOf(opcao) == -1) {
				System.err.println("Opcao invalida!\n");
				continue;
			}

			try {
				switch (opcao) {
					case 'D':
						servidor.receba (new PedidoDesenhos(192));
						Comunicado comunicado = null;
						do
						{
							comunicado = (Comunicado)servidor.espie ();
						}
						while (!(comunicado instanceof Desenhos));
						Desenhos desenhos = (Desenhos)servidor.envie ();
						System.out.println ("Recebi os desenhos");
						break;
						
						case 'S':
						double idClient = 192;
						Desenho desenho = new Desenho("bandeira", "hoje", "hoje");

						servidor.receba (new PedidoSalvamento (idClient));
						System.out.println ("instância com idClient");
						
						servidor.receba (new PedidoSalvamento ());
						System.out.println ("instância");
						
						servidor.receba (new PedidoSalvamento (desenho));
						System.out.println ("instância com desenho");

						servidor.receba (new PedidoSalvamento (idClient, desenho));
						System.out.println ("instância com idClient e desenho");
						break;

					default:
						break;
				}
			} catch (Exception erro) {
				System.err.println("Erro de comunicacao com o servidor;");
				System.err.println("Tente novamente!");
				System.err.println("Caso o erro persista, termine o programa");
				System.err.println("e volte a tentar mais tarde!\n");
			}
		} while (opcao != 'T');

		try {
			servidor.receba(new PedidoParaSair());
		} catch (Exception erro) {
		}

		System.out.println("Obrigado por usar este programa!");
		System.exit(0);
	}
}
