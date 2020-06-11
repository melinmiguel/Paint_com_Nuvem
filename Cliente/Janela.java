import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.*;
import java.io.*;
import java.util.*;

/**
 * Programa de inicialização e execução da janela.
 * 
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
public class Janela extends JFrame {
  protected static final long serialVersionUID = 1L;

  protected JButton btnPonto = new JButton("Ponto"), btnLinha = new JButton("Linha"),
      btnCirculo = new JButton("Circulo"), btnElipse = new JButton("Elipse"), btnQuadrado = new JButton("Quadrado"),
      btnRetangulo = new JButton("Retangulo"), btnTexto = new JButton("Texto"), btnFont = new JButton("Fontes"),
      btnCores = new JButton("Preenchimento"), btnCoresBorda = new JButton("Borda"), btnAbrir = new JButton("Abrir"),
      btnSalvar = new JButton("Salvar"), btnApagar = new JButton("Apagar"), btnSair = new JButton("Sair");

  protected MeuJPanel pnlDesenho = new MeuJPanel();

  protected JLabel statusBar1 = new JLabel("Mensagem:"), statusBar2 = new JLabel("Coordenada:");

  protected boolean esperaPonto, esperaInicioReta, esperaFimReta, esperaInicioCirculo, esperaFimCirculo,
      esperaInicioElipse, esperaFimElipse, esperaInicioQuadrado, esperaFimQuadrado, esperaInicioRetangulo,
      esperaFimRetangulo, esperaInicioTexto, esperaFimTexto;

  protected Color corAtual = Color.BLACK;
  protected Color corAtualBorda = Color.BLACK;
  protected Ponto p1;

  protected Vector<Figura> figuras = new Vector<Figura>();

/**
  * Cria a janela de desenho.
  * @return            Janela para desenho
  * @author            Professor
  */
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
      btnCoresBorda.setIcon(new ImageIcon(btnCoresImg));
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
    btnCoresBorda.addActionListener(new MudaCorBorda());
    btnTexto.addActionListener(new DesenhoDeTexto());
    btnAbrir.addActionListener(new Abrir());
    btnSalvar.addActionListener(new Salvar());

    // btnFont.addActionListener(new AlterarFonte()); //JFontChooser não está no
    // Java.Swing

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
    pnlBotoes.add(btnCoresBorda);
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


    private static final long serialVersionUID = 1L;
  /**
  * Cria o Jpanel com a área de desenho do programa.
  *
  * @author            Professor
  */
    public MeuJPanel() {
      super();

      this.addMouseListener(this);
      this.addMouseMotionListener(this);
    }

  /**
  * Inicializa os Graphics para desenho no Jpanel.
  *
  * @author            Professor
  */
    public void paint(Graphics g) {
      for (int i = 0; i < figuras.size(); i++)
        figuras.get(i).torneSeVisivel(g);
    }

  /**
  * Aguarda a ininicialização e finalização dos desenhos que serão feitos no Jpanel
  *
  * @param MouseEvent  Evento de movimento do mouse             
  * @author            Professor
  */

    public void mousePressed(MouseEvent e) {
      if (esperaPonto) {
        figuras.add(new Ponto(e.getX(), e.getY(), corAtual));
        figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        esperaPonto = true;
      } else if (esperaInicioReta) {
        p1 = new Ponto(e.getX(), e.getY(), corAtual);
        esperaInicioReta = false;
        esperaFimReta = true;
        statusBar1.setText("Mensagem: clique o ponto final da reta");
      } else if (esperaFimReta) {
        esperaInicioReta = true;
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
        esperaInicioCirculo = true;
        esperaFimCirculo = false;
        figuras.add(new Circulo(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, corAtualBorda));
        figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        statusBar1.setText("Mensagem:");
      } else if (esperaInicioElipse) {
        p1 = new Ponto(e.getX(), e.getY(), corAtual);
        esperaInicioElipse = false;
        esperaFimElipse = true;
        statusBar1.setText("Mensagem: clique o ponto final da elipse");
      } else if (esperaFimElipse) {
        esperaInicioElipse = true;
        esperaFimElipse = false;
        figuras.add(new Elipse(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, corAtualBorda));
        figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        statusBar1.setText("Mensagem:");
      } else if (esperaInicioQuadrado) {
        p1 = new Ponto(e.getX(), e.getY(), corAtual);
        esperaInicioQuadrado = false;
        esperaFimQuadrado = true;
        statusBar1.setText("Mensagem: clique o ponto final da Quadrado");
      } else if (esperaFimQuadrado) {
        esperaInicioQuadrado = true;
        esperaFimQuadrado = false;
        figuras.add(new Quadrado(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, corAtualBorda));
        figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        statusBar1.setText("Mensagem:");
      } else if (esperaInicioRetangulo) {
        p1 = new Ponto(e.getX(), e.getY(), corAtual);
        esperaInicioRetangulo = false;
        esperaFimRetangulo = true;
        statusBar1.setText("Mensagem: clique o ponto final da retangulo");
      } else if (esperaFimRetangulo) {
        esperaInicioRetangulo = true;
        esperaFimRetangulo = false;
        figuras.add(new Retangulo(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, corAtualBorda));
        figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        statusBar1.setText("Mensagem:");
      } else if (esperaInicioTexto) {
        p1 = new Ponto(e.getX(), e.getY(), corAtual);
        esperaInicioTexto = false;
        esperaFimTexto = true;
        statusBar1.setText("Mensagem: digite o texto");
      } else if (esperaFimTexto) {
        esperaInicioTexto = true;
        esperaFimTexto = false;
        String a = JOptionPane.showInputDialog("Digite Sua Frase");
        figuras.add(new Texto(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, a));
        figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        statusBar1.setText("Mensagem:");
      } 
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
  
  /**
  * Obersva a movimentação do mouse pelo Jpanel
  *
  * @param  MouseEvent Evento de movimento do Mouse             
  * @author            Professor
  */
    public void mouseMoved(MouseEvent e) {
      statusBar2.setText("Coordenada: " + e.getX() + "," + e.getY());
    }
  }
  
  /**
  * Aceita o primeiro clIque do desenho do e aguarda a finalização.
  *
  * @param ActionEvent Ação automática da classe          
  * @author            Professor
  */
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
  
  /**
  * Aceita o primeiro clIque do desenho do e aguarda a finalização.
  *
  * @param ActionEvent Ação automática da classe            
  * @author            Professor
  */
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
  
  /**
  * Aceita o primeiro clIque do desenho do e aguarda a finalização.
  *
  * @param ActionEvent Ação automática da classe             
  * @author            Professor
  */
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
  
  /**
  * Aceita o primeiro clIque do desenho do e aguarda a finalização.
  *
  * @param ActionEvent Ação automática da classe             
  * @author            Professor
  */
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
  
  /**
  * Aceita o primeiro clIque do desenho do e aguarda a finalização.
  *
  * @param ActionEvent Ação automática da Classe             
  * @author            Professor
  */
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
  
  /**
  * Aceita o primeiro clIque do desenho do e aguarda a finalização.
  *
  * @param  ActionEvent Ação automática da classe             
  * @author             Professor
  */
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
  
  /**
  * Aceita o primeiro clIque do desenho do e aguarda a finalização.
  *
  * @param  ActionEvent Ação automática da classe            
  * @author             Professor
  */
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
  
  /**
  * Abre a paleta de cores para mudar a cor interna do desenho.
  *
  * @param ActionEvent Ação automática da classe             
  * @author            Rodrigo
  * @author            Pedro
  * @author            Leonardo
  */
  protected class MudaCor implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      corAtual = JColorChooser.showDialog(pnlDesenho, "Paleta de cores - Preenchimento", corAtual);
    }
  }

  /**
  * Abre a paleta de cores para mudar a cor externa do desenho.
  *
  * @param ActionEvent Ação automática da classe             
  * @author            Rodrigo
  * @author            Pedro
  * @author            Leonardo
  */
  protected class MudaCorBorda implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      corAtualBorda = JColorChooser.showDialog(pnlDesenho, "Paleta de cores para - Borda", corAtual);
    }
  }

  /*
   * protected class AlterarFonte implements ActionListener { public
   * JFontChooser(java.awt.Font font){ //fontAtual = JFontChooser
   * 
   * JlFontChooser fontChooser = new JFontChooser();
   * 
   * } }
   */ // COMANDO NÃO ESTÁ SENDO EXTRAIDO DO SWING.
 
  /**
  * Realiza o fechamento da janela.
  *
  * @param WindowEvent Evento automática da classe             
  * @author            Rodrigo
  * @author            Pedro
  * @author            Leonardo
  */
  protected class FechamentoDeJanela extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
      System.exit(0);
    }
  }

  /**
  * Realiza o abertura de um arquivo de desenho do tipo .fga
  *
  * @param ActionListener Ação automática da classe        
  * @author               Rodrigo
  * @author               Pedro
  * @author               Leonardo
  */
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
      
      try {
        
        FileReader arq = new FileReader(selectedFile.getAbsolutePath());
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine(); 
        
        StringTokenizer itens = new StringTokenizer(linha, ",");
       
        figuras.clear();
        pnlDesenho.repaint();

        while (itens.hasMoreTokens()) {
            String item = itens.nextToken();
            //array = item.split(",");
          
          if((item.contains("ponto"))) {
            String array1[] = new String[3];
                  array1 = item.split(":");
                  int x = Integer.parseInt(array1[1]);
                  int y = Integer.parseInt(array1[2]);

                  String fimProg = array1[5].toString();
                  //fimProg = fimProg.replace("].fga", "");
                  
                  Color cor = new Color(Integer.parseInt(array1[3]), // R
                  Integer.parseInt(array1[4]), // G
                  Integer.parseInt(fimProg.replace("].fga", ""))); // B
                 
                  figuras.add(new Ponto(x, y, cor));
                  figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
          }

        if((item.contains("linha"))) {
          String array1[] = new String[3];
            
            array1 = item.split(":");
            int x1 = Integer.parseInt(array1[1]);
            int y1 = Integer.parseInt(array1[2]);
            int x2 = Integer.parseInt(array1[3]);
            int y2 = Integer.parseInt(array1[4]);

            String fimProg = array1[7].toString();
            //fimProg = fimProg.replace("].fga", "");
            
            Color cor = new Color(Integer.parseInt(array1[5]), // R
            Integer.parseInt(array1[6]), // G
            Integer.parseInt(fimProg.replace("].fga", ""))); // B

          figuras.add(new Linha(x1, y1, x2, y2, cor));
          figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        }


        if((item.contains("circulo"))) {
          String array1[] = new String[3];
            
            array1 = item.split(":");
            int x1 = Integer.parseInt(array1[1]);
            int y1 = Integer.parseInt(array1[2]);
            int x2 = Integer.parseInt(array1[3]);
            int y2 = Integer.parseInt(array1[4]);

            String fimProg = array1[7].toString();
            //fimProg = fimProg.replace("].fga", "");
            
            Color cor = new Color(Integer.parseInt(array1[5]), // R
            Integer.parseInt(array1[6]), // G
            Integer.parseInt(fimProg.replace("].fga", ""))); // B

            figuras.add(new Circulo(x1, y1, x2, y2, cor, corAtualBorda));
            figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        }

        if((item.contains("elipse"))) {
          String array1[] = new String[3];
            
            array1 = item.split(":");
            int x1 = Integer.parseInt(array1[1]);
            int y1 = Integer.parseInt(array1[2]);
            int x2 = Integer.parseInt(array1[3]);
            int y2 = Integer.parseInt(array1[4]);

            String fimProg = array1[7].toString();
            //fimProg = fimProg.replace("].fga", "");
            
            Color cor = new Color(Integer.parseInt(array1[5]), // R
            Integer.parseInt(array1[6]), // G
            Integer.parseInt(fimProg.replace("].fga", ""))); // B

            figuras.add(new Elipse(x1, y1, x2, y2, cor, corAtualBorda));
            figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        }

        if((item.contains("quadrado"))) {
          String array1[] = new String[3];
            
            array1 = item.split(":");
            int x1 = Integer.parseInt(array1[1]);
            int y1 = Integer.parseInt(array1[2]);
            int x2 = Integer.parseInt(array1[3]);
            int y2 = Integer.parseInt(array1[4]);

            String fimProg = array1[7].toString();
            //fimProg = fimProg.replace("].fga", "");
            
            Color cor = new Color(Integer.parseInt(array1[5]), // R
            Integer.parseInt(array1[6]), // G
            Integer.parseInt(fimProg.replace("].fga", ""))); // B

            figuras.add(new Quadrado(x1, y1, x2, y2, cor, corAtualBorda));
            figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        }

        if((item.contains("retangulo"))) {
          String array1[] = new String[3];
            
            array1 = item.split(":");
            int x1 = Integer.parseInt(array1[1]);
            int y1 = Integer.parseInt(array1[2]);
            int x2 = Integer.parseInt(array1[3]);
            int y2 = Integer.parseInt(array1[4]);

            String fimProg = array1[7].toString();
            //fimProg = fimProg.replace("].fga", "");
            
            Color cor = new Color(Integer.parseInt(array1[5]), // R
            Integer.parseInt(array1[6]), // G
            Integer.parseInt(fimProg.replace("].fga", ""))); // B

            figuras.add(new Retangulo(x1, y1, x2, y2, cor, corAtualBorda));
            figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        }

        if((item.contains("texto"))) {
          String array1[] = new String[3];
          
            
            array1 = item.split(":");
            String frase = array1[1];
            int x1 = Integer.parseInt(array1[2]);
            int y1 = Integer.parseInt(array1[3]);
            int x2 = Integer.parseInt(array1[4]);
            int y2 = Integer.parseInt(array1[5]);
            
            String fimProg = array1[8].toString();
            //fimProg = fimProg.replace("].fga", "");
            
            Color cor = new Color(Integer.parseInt(array1[6]), // R
            Integer.parseInt(array1[7]), // G
            Integer.parseInt(fimProg.replace("].fga", ""))); // B


        figuras.add(new Texto(x1, y1, x2, y2, cor, frase));
        figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
        }
      }
    
      arq.close();
      }
      
      catch (IOException p) {
          System.err.printf("Erro na abertura do arquivo: %s.\n",
            p.getMessage());
      }

  statusBar1.setText("Mensagem: arquivo selecionado " + selectedFile.getAbsolutePath());  
      }
    }
    }
  
  /**
  * Realiza o salvamento de um arquivo de desenho do tipo .fga
  *
  * @param ActionlISTENER Ação automática da classe            
  * @author               Rodrigo
  * @author               Pedro
  * @author               Leonardo
  */
 protected class Salvar implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Figuras (.fga)", "fga");
    fileChooser.setFileFilter(filter);
    int result = fileChooser.showSaveDialog(null);
    if (result == 0) {
    String content = figuras.toString();
    File selectedFile = fileChooser.getSelectedFile();
	    if (selectedFile.exists()){
	      int resposta = JOptionPane.showConfirmDialog(null, "Deseja substituir o arquivo existente?", "title", JOptionPane.YES_NO_OPTION);
	      if (resposta == 0) {
	        try {
	          FileWriter fw = new FileWriter(selectedFile.getPath());
	          fw.write(content);
	          fw.flush();
	          fw.close();
	          statusBar1.setText("Mensagem: arquivo salvo em: " + selectedFile.getAbsolutePath());
	        } catch (Exception e2) {
	          JOptionPane.showMessageDialog(null, e2.getMessage());
          }
          System.out.println("aqui ele aceita substituir");
	      } 
      if (resposta != 0) { 
        Salvar salvar = new Salvar(); //PRECISA INSTANCIA!!!!
        salvar.actionPerformed(e);    //E DEPOIS EU DOU O START NO PERFORMED PQP! ISSO É ALGO MT UTIL PRA MINHA VIDA TIO!de qualquer um em java takeoparauba kkkk
        System.out.println("aqui ele não aceita substituir");
      }
    }
    try {
      FileWriter fw = new FileWriter(selectedFile.getPath());
      fw.write(content + ".fga");
      fw.flush();
      fw.close();
      statusBar1.setText("Mensagem: arquivo salvo em: " + selectedFile.getAbsolutePath());
    } catch (Exception e2) {
      JOptionPane.showMessageDialog(null, e2.getMessage());
    }
}
    if (result == 1)
        {}//não faz nada, por que o usuário desistiu (se eu não colocar, ele abre novamente o Jfile)

}}}


