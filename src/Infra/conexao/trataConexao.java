package Infra.conexao;

import java.io.*;
import java.net.*;

import Infra.BD.BD;
import Infra.BD.Usuario;
import Infra.conexao.Solicitacao;
import Model.Partida;
import Model.Lista;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class trataConexao extends Thread {

	private Socket s;
	private Solicitacao sol;
	private ObjectInputStream i = null;
	private ObjectOutputStream o = null;
	private boolean disconectar = false;
	private Servidor server;

	public trataConexao(Socket ss, Servidor servidor) {
		this.s = ss;
		this.server = servidor;
	}


	public void run() {
		String result = "ERR";
		try {
			i = new ObjectInputStream(s.getInputStream());
			o = new ObjectOutputStream(s.getOutputStream());

			sol = (Solicitacao) i.readObject();
			System.out.println(sol.toString());

			switch(sol.getComando()){
				case "CON":
				break;

				case "DES":
				break;

				case "FIC":
				break;

				case "SAV":
				break;

				case "NEW":
				break;

				case "UPD":
				break;

				case "ERR":
				break;

			}

		} catch (IOException e) {
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// try {
			// } catch (IOException e) {
			// 	e.printStackTrace();
			// }
		}
	}
}