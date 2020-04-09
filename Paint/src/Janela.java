import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.*;
import java.io.*;
import java.util.*;
import java.lang.Object.*;


public class Janela extends JFrame {
  protected static final long serialVersionUID = 1L;

  protected JButton btnPonto = new JButton("Ponto"), btnLinha = new JButton("Linha"),
      btnCirculo = new JButton("Circulo"), btnElipse = new JButton("Elipse"), btnQuadrado = new JButton("Quadrado"),
      btnRetangulo = new JButton("Retangulo"), btnTexto = new JButton("Texto"), btnFont = new JButton("Fontes"), btnCores = new JButton("Cores"),
      btnAbrir = new JButton("Abrir"), btnSalvar = new JButton("Salvar"), btnApagar = new JButton("Apagar"),
      btnSair = new JButton("Sair"); 

  protected MeuJPanel pnlDesenho = new MeuJPanel();

  protected JLabel statusBar1 = new JLabel("Mensagem:"), statusBar2 = new JLabel("Coordenada:");

  protected boolean esperaPonto, esperaInicioReta, esperaFimReta, esperaInicioCirculo, esperaFimCirculo,
      esperaInicioElipse, esperaFimElipse, esperaInicioQuadrado, esperaFimQuadrado, esperaInicioRetangulo,
      esperaFimRetangulo, esperaInicioTexto, esperaFimTexto;

  protected Color corAtual = Color.BLACK;
  protected Ponto p1;

  protected Vector<Figura> figuras = new Vector<Figura>();

  private File salvaArquivo;

  public Janela() {
    super("Editor Gráfico");

    try {
      Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));
      btnPonto.setIcon(new ImageIcon(btnPontoImg));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Arquivo ponto.jpg não foi encontrado", "Arquivo de imagem ausente",
          JOptionPane.WARNING_MESSAGE);
    }

    try {
      Image btnLinhaImg = ImageIO.read(getClass().getResource("resources/linha.jpg"));
      btnLinha.setIcon(new ImageIcon(btnLinhaImg));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Arquivo linha.jpg não foi encontrado", "Arquivo de imagem ausente",
          JOptionPane.WARNING_MESSAGE);
    }

    try {
      Image btnCirculoImg = ImageIO.read(getClass().getResource("resources/circulo.jpg"));
      btnCirculo.setIcon(new ImageIcon(btnCirculoImg));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Arquivo circulo.jpg não foi encontrado", "Arquivo de imagem ausente",
          JOptionPane.WARNING_MESSAGE);
    }

    try {
      Image btnElipseImg = ImageIO.read(getClass().getResource("resources/elipse.jpg"));
      btnElipse.setIcon(new ImageIcon(btnElipseImg));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Arquivo elipse.jpg não foi encontrado", "Arquivo de imagem ausente",
          JOptionPane.WARNING_MESSAGE);
    }

    try {
      Image btnCoresImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
      btnCores.setIcon(new ImageIcon(btnCoresImg));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Arquivo cores.jpg não foi encontrado", "Arquivo de imagem ausente",
          JOptionPane.WARNING_MESSAGE);
    }

    try {
      Image btnAbrirImg = ImageIO.read(getClass().getResource("resources/abrir.jpg"));
      btnAbrir.setIcon(new ImageIcon(btnAbrirImg));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Arquivo abrir.jpg não foi encontrado", "Arquivo de imagem ausente",
          JOptionPane.WARNING_MESSAGE);
    }

    try {
      Image btnSalvarImg = ImageIO.read(getClass().getResource("resources/salvar.jpg"));
      btnSalvar.setIcon(new ImageIcon(btnSalvarImg));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Arquivo salvar.jpg não foi encontrado", "Arquivo de imagem ausente",
          JOptionPane.WARNING_MESSAGE);
    }

    try {
      Image btnApagarImg = ImageIO.read(getClass().getResource("resources/apagar.jpg"));
      btnApagar.setIcon(new ImageIcon(btnApagarImg));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Arquivo apagar.jpg não foi encontrado", "Arquivo de imagem ausente",
          JOptionPane.WARNING_MESSAGE);
    }

    try {
      Image btnSairImg = ImageIO.read(getClass().getResource("resources/sair.jpg"));
      btnSair.setIcon(new ImageIcon(btnSairImg));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Arquivo sair.jpg não foi encontrado", "Arquivo de imagem ausente",
          JOptionPane.WARNING_MESSAGE);
    }

    try {
      Image btnQuadradoImg = ImageIO.read(getClass().getResource("resources/quadrado.jpg"));
      btnQuadrado.setIcon(new ImageIcon(btnQuadradoImg));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Arquivo quadrado.png não foi encontrado", "Arquivo de imagem ausente",
          JOptionPane.WARNING_MESSAGE);
    }

    try {
      Image btnRetanguloImg = ImageIO.read(getClass().getResource("resources/retangulo.jpg"));
      btnRetangulo.setIcon(new ImageIcon(btnRetanguloImg));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Arquivo retangulo.png não foi encontrado", "Arquivo de imagem ausente",
          JOptionPane.WARNING_MESSAGE);
    }

    try {
      Image btnTextoImg = ImageIO.read(getClass().getResource("resources/texto.jpg"));
      btnTexto.setIcon(new ImageIcon(btnTextoImg));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Arquivo texto.png não foi encontrado", "Arquivo de imagem ausente",
          JOptionPane.WARNING_MESSAGE);
    }
    
    try {
      Image btnFonte = ImageIO.read(getClass().getResource("resources/fontes.jpg"));
      btnFont.setIcon(new ImageIcon(btnFonte));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "Arquivo Fonte.png não foi encontrado", "Arquivo de imagem ausente",
          JOptionPane.WARNING_MESSAGE);
    }

    btnPonto.addActionListener(new DesenhoDePonto());
    btnLinha.addActionListener(new DesenhoDeReta());
    btnCirculo.addActionListener(new DesenhoDeCirculo());
    btnElipse.addActionListener(new DesenhoDeElipse());
    btnQuadrado.addActionListener(new DesenhoDeQuadrado());
    btnRetangulo.addActionListener(new DesenhoDeRetangulo());
    btnCores.addActionListener(new MudaCor());
    btnTexto.addActionListener(new DesenhoDeTexto());
    btnAbrir.addActionListener(new Abrir());
    btnSalvar.addActionListener(new Salvar());

    //btnFont.addActionListener(new AlterarFonte()); //JFontChooser não está no Java.Swing

    JPanel pnlBotoes = new JPanel();
    FlowLayout flwBotoes = new FlowLayout();
    pnlBotoes.setLayout(flwBotoes);

    pnlBotoes.add(btnAbrir);
    pnlBotoes.add(btnSalvar);
    pnlBotoes.add(btnPonto);
    pnlBotoes.add(btnLinha);
    pnlBotoes.add(btnCirculo);
    pnlBotoes.add(btnElipse);
    pnlBotoes.add(btnQuadrado);
    pnlBotoes.add(btnRetangulo);
    pnlBotoes.add(btnTexto);
    pnlBotoes.add(btnFont);
    pnlBotoes.add(btnCores);
    pnlBotoes.add(btnApagar);
    pnlBotoes.add(btnSair);

    JPanel pnlStatus = new JPanel();
    GridLayout grdStatus = new GridLayout(1, 2);
    pnlStatus.setLayout(grdStatus);

    pnlStatus.add(statusBar1);
    pnlStatus.add(statusBar2);

    Container cntForm = this.getContentPane();
    cntForm.setLayout(new BorderLayout());
    cntForm.add(pnlBotoes, BorderLayout.NORTH);
    cntForm.add(pnlDesenho, BorderLayout.CENTER);
    cntForm.add(pnlStatus, BorderLayout.SOUTH);

    this.addWindowListener(new FechamentoDeJanela());

    this.setSize(700, 500);
    this.setVisible(true);
  }

  protected class MeuJPanel extends JPanel implements MouseListener, MouseMotionListener {
    public MeuJPanel() {
      super();

      this.addMouseListener(this);
      this.addMouseMotionListener(this);
    }

    public void paint(Graphics g) {
      for (int i = 0; i < figuras.size(); i++)
        figuras.get(i).torneSeVisivel(g);
    }

    public void mousePressed(MouseEvent e) {
      if (esperaPonto) {
        figuras.add(new Ponto(e.getX(), e.getY(), corAtual));
        figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        esperaPonto = false;
      } else if (esperaInicioReta) {
        p1 = new Ponto(e.getX(), e.getY(), corAtual);
        esperaInicioReta = false;
        esperaFimReta = true;
        statusBar1.setText("Mensagem: clique o ponto final da reta");
      } else if (esperaFimReta) {
        esperaInicioReta = false;
        esperaFimReta = false;
        figuras.add(new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual));
        figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        statusBar1.setText("Mensagem:");
      } else if (esperaInicioCirculo) {
        p1 = new Ponto(e.getX(), e.getY(), corAtual);
        esperaInicioCirculo = false;
        esperaFimCirculo = true;
        statusBar1.setText("Mensagem: clique o ponto final do circulo");
      } else if (esperaFimCirculo) {
        esperaInicioCirculo = false;
        esperaFimCirculo = false;
        figuras.add(new Circulo(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual));
        figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        statusBar1.setText("Mensagem:");
      } else if (esperaInicioElipse) {
        p1 = new Ponto(e.getX(), e.getY(), corAtual);
        esperaInicioElipse = false;
        esperaFimElipse = true;
        statusBar1.setText("Mensagem: clique o ponto final da elipse");
      } else if (esperaFimElipse) {
        esperaInicioElipse = false;
        esperaFimElipse = false;
        figuras.add(new Elipse(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual));
        figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        statusBar1.setText("Mensagem:");
      } else if (esperaInicioQuadrado) {
        p1 = new Ponto(e.getX(), e.getY(), corAtual);
        esperaInicioQuadrado = false;
        esperaFimQuadrado = true;
        statusBar1.setText("Mensagem: clique o ponto final da Quadrado");
      } else if (esperaFimQuadrado) {
        esperaInicioQuadrado = false;
        esperaFimQuadrado = false;
        figuras.add(new Quadrado(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual));
        figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        statusBar1.setText("Mensagem:");
      } else if (esperaInicioRetangulo) {
        p1 = new Ponto(e.getX(), e.getY(), corAtual);
        esperaInicioRetangulo = false;
        esperaFimRetangulo = true;
        statusBar1.setText("Mensagem: clique o ponto final da retangulo");
      } else if (esperaFimRetangulo) {
        esperaInicioRetangulo = false;
        esperaFimRetangulo = false;
        figuras.add(new Retangulo(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual));
        figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        statusBar1.setText("Mensagem:");
      } else if (esperaInicioTexto) {
        p1 = new Ponto(e.getX(), e.getY(), corAtual);
        esperaInicioTexto = false;
        esperaFimTexto = true;
        statusBar1.setText("Mensagem: digite o texto");
      } else if (esperaFimTexto) { //FOI ALTERADO DAQUI ATÉ vvvvvvvvv
        esperaInicioTexto = false;
        esperaFimTexto = false;
       // JFontChooser fontChooser = new JFontChooser();
        String a = JOptionPane.showInputDialog("Digite Sua Frase"); //adicionado e modificado o metogo texto para receber o texto.
        figuras.add(new Texto(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, a));
        figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        statusBar1.setText("Mensagem:");
      }// AQUI, PODE SUSBSTITUIR DO ARQUIVO ANTIDO ESSA PARTE ^^^^
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
      statusBar2.setText("Coordenada: " + e.getX() + "," + e.getY());
    }
  }

  protected class DesenhoDePonto implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      esperaPonto = true;
      esperaInicioReta = false;
      esperaFimReta = false;
      esperaInicioCirculo = false;
      esperaFimCirculo = false;
      esperaInicioElipse = false;
      esperaFimElipse = false;
      esperaInicioQuadrado = false;
      esperaFimQuadrado = false;
      esperaInicioRetangulo = false;
      esperaFimRetangulo = false;
      esperaInicioTexto = false;
      esperaFimTexto = false;

      statusBar1.setText("Mensagem: clique o local do ponto desejado");
    }
  }

  protected class DesenhoDeReta implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      esperaPonto = false;
      esperaInicioReta = true;
      esperaFimReta = false;
      esperaInicioCirculo = false;
      esperaFimCirculo = false;
      esperaInicioElipse = false;
      esperaFimElipse = false;
      esperaInicioQuadrado = false;
      esperaFimQuadrado = false;
      esperaInicioRetangulo = false;
      esperaFimRetangulo = false;
      esperaInicioTexto = false;
      esperaFimTexto = false;

      statusBar1.setText("Mensagem: clique o ponto inicial da reta");
    }
  }

  protected class DesenhoDeCirculo implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      esperaPonto = false;
      esperaInicioReta = false;
      esperaFimReta = false;
      esperaInicioCirculo = true;
      esperaFimCirculo = false;
      esperaInicioElipse = false;
      esperaFimElipse = false;
      esperaInicioQuadrado = false;
      esperaFimQuadrado = false;
      esperaInicioRetangulo = false;
      esperaFimRetangulo = false;
      esperaInicioTexto = false;
      esperaFimTexto = false;

      statusBar1.setText("Mensagem: clique o ponto inicial do circulo");
    }
  }

  protected class DesenhoDeElipse implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      esperaPonto = false;
      esperaInicioReta = false;
      esperaFimReta = false;
      esperaInicioCirculo = false;
      esperaFimCirculo = false;
      esperaInicioElipse = true;
      esperaFimElipse = false;
      esperaInicioQuadrado = false;
      esperaFimQuadrado = false;
      esperaInicioRetangulo = false;
      esperaFimRetangulo = false;
      esperaInicioTexto = false;
      esperaFimTexto = false;

      statusBar1.setText("Mensagem: clique o ponto inicial do circulo");
    }
  }

  protected class DesenhoDeQuadrado implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      esperaPonto = false;
      esperaInicioReta = false;
      esperaFimReta = false;
      esperaInicioCirculo = false;
      esperaFimCirculo = false;
      esperaInicioElipse = false;
      esperaFimElipse = false;
      esperaInicioQuadrado = true;
      esperaFimQuadrado = false;
      esperaInicioRetangulo = false;
      esperaFimRetangulo = false;
      esperaInicioTexto = false;
      esperaFimTexto = false;

      statusBar1.setText("Mensagem: clique o ponto inicial do quadrado");
    }
  }

  protected class DesenhoDeRetangulo implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      esperaPonto = false;
      esperaInicioReta = false;
      esperaFimReta = false;
      esperaInicioCirculo = false;
      esperaFimCirculo = false;
      esperaInicioElipse = false;
      esperaFimElipse = false;
      esperaInicioQuadrado = false;
      esperaFimQuadrado = false;
      esperaInicioRetangulo = true;
      esperaFimRetangulo = false;
      esperaInicioTexto = false;
      esperaFimTexto = false;

      statusBar1.setText("Mensagem: clique o ponto inicial do retangulo");
    }
  }

  protected class DesenhoDeTexto implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      esperaPonto = false;
      esperaInicioReta = false;
      esperaFimReta = false;
      esperaInicioCirculo = false;
      esperaFimCirculo = false;
      esperaInicioElipse = false;
      esperaFimElipse = false;
      esperaInicioQuadrado = false;
      esperaFimQuadrado = false;
      esperaInicioRetangulo = false;
      esperaFimRetangulo = false;
      esperaInicioTexto = true;
      esperaFimTexto = false;

      statusBar1.setText("Mensagem: clique o ponto inicial do texto");
    }
  }

  protected class MudaCor implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      corAtual = JColorChooser.showDialog(pnlDesenho, "Paleta de cores", corAtual);
    }
  }

  
 /* protected class AlterarFonte implements ActionListener {
    public JFontChooser(java.awt.Font font){
      //fontAtual = JFontChooser
      
      JlFontChooser fontChooser = new JFontChooser();
      
    }
  }*/ //COMANDO NÃO ESTÁ SENDO EXTRAIDO DO SWING.

  protected class FechamentoDeJanela extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
      System.exit(0);
    }
  }

  protected class Abrir implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Figuras (.fga)", "fga");
      fileChooser.setFileFilter(filter);
      int result = fileChooser.showOpenDialog(null);
      if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFile = fileChooser.getSelectedFile();
      System.out.println(selectedFile.toPath());
      selectedFile.toString();
      
      // StringTokenizer itens = new StringTokenizer(selectedFile.toString(), ",");
      // int qntItens = itens.countTokens();
      // for (int i = 0; i<qntItens; i++)
      // {
      //   itens.get(itens.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
      //   itens.nextToken();
      // }
      //TA DANDO PROBLEMA AQUI, PRECISA REPENSAR COMO FAZER ESSA LÓGICA DE APRESENTAR OS DESENHOS.
      statusBar1.setText("Mensagem: arquivo selecionado " + selectedFile.getAbsolutePath());
     }
    }
  }
 
 protected class Salvar implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Figuras (.fga)", "fga");
    fileChooser.setFileFilter(filter);
    int result = fileChooser.showSaveDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
    String content = figuras.toString();
    File selectedFile = fileChooser.getSelectedFile();
    
    if (selectedFile.exists()){
      int resposta = JOptionPane.showConfirmDialog(null, "Deseja substituir o arquivo existente?", "title", JOptionPane.YES_NO_OPTION);
      if (resposta == JOptionPane.YES_OPTION) {
        try {
          FileWriter fw = new FileWriter(selectedFile.getPath());
          fw.write(content);
          fw.flush();
          fw.close();
          statusBar1.setText("Mensagem: arquivo salvo em: " + selectedFile.getAbsolutePath());
        } catch (Exception e2) {
          JOptionPane.showMessageDialog(null, e2.getMessage());
        }
      } 
      else { 
        btnSalvar.addActionListener(new Salvar());
      }}
}
}}}


