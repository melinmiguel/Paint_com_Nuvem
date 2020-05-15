package Infra.conexao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import javax.swing.*;

public class Cliente extends JFrame implements ActionListener, KeyListener {

    private static final long serialVersionUID = 1L;
    private Socket socket;
    private OutputStream ou;
		private String ip; 
		private int porta; 

    public Cliente() throws IOException{
			this.ip = "127.0.0.1";
			this.porta = 12345;
    }

    public void conectar() throws IOException{
        socket = new Socket(this.ip, this.porta);
        ou = socket.getOutputStream();
    }

    public static void main(String []args) throws IOException{

        Cliente app = new Cliente();
        app.conectar();
    }
}
