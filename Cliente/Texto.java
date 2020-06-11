import java.awt.*;
import java.util.*;


/**
 * Realiza a execução de textos no painel de desenho.
 * 
 * 
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
public class Texto extends Figura {
  protected Ponto p1, p2;
  protected String frase;

/**
 * Construtor do Texto, recebendo as coordenadas de entrada, cor e texto.
 * 
 * @param x1            valor X 
 * @param y1            valor Y 
 * @param x2            valor X 
 * @param y2            valor Y 
 * @param cor           Cor das letras
 * @param textoEscrito  String que deverá ser desenhada.
 * 
 * @author              Leonardo
 * @author              Rodrigo
 * @author              Pedro
 */
  public Texto(int x1, int y1, int x2, int y2, Color cor, String textoEscrito) {
    super(cor);

    this.p1 = new Ponto(x1, y1, cor);
    this.p2 = new Ponto(x2, y2, cor);
    this.frase = textoEscrito;
    
  }

  public Texto(String s) {
    StringTokenizer quebrador = new StringTokenizer(s, ":");

    quebrador.nextToken();

    int x1 = Integer.parseInt(quebrador.nextToken());
    int y1 = Integer.parseInt(quebrador.nextToken());

    int x2 = Integer.parseInt(quebrador.nextToken());
    int y2 = Integer.parseInt(quebrador.nextToken());

    Color cor = new Color(Integer.parseInt(quebrador.nextToken()), // R
        Integer.parseInt(quebrador.nextToken()), // G
        Integer.parseInt(quebrador.nextToken())); // B

    this.p1 = new Ponto(x1, y1, cor);
    this.p2 = new Ponto(x2, y2, cor);
    this.cor = cor;
  }

  public void setP1(int x, int y) {
    this.p1 = new Ponto(x, y, this.getCor());
  }

  public void setP2(int x, int y) {
    this.p2 = new Ponto(x, y, this.getCor());
  }

/**
 *Retorna o eixo X da cordenada.
 * 
 * @author  Leonardo
 * @author  Rodrigo
 * @author  Pedro
 */
  public Ponto getP1() {
    return this.p1;
  }

/**
 *Retorna o eixo Y da cordenada.
 * 
 * @author  Leonardo
 * @author  Rodrigo
 * @author  Pedro
 */
  public Ponto getP2() {
    return this.p2;
  }

  
/**
 *Salva um token com as informações do Texto.
 * 
 * @return String com os dados do texto
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
  public String toString() {
    return "texto:" + this.frase + ":" + this.p1.getX() + ":" + this.p1.getY() + ":" + this.p2.getX() + ":" + this.p2.getY() + ":"
        + this.getCor().getRed() + ":" + this.getCor().getGreen() + ":" + this.getCor().getBlue();
  }

/**
 *Torna o Texto visível no Jpanel.
 * 
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
  public void torneSeVisivel(Graphics g) {
    String texto = this.frase;

    g.setColor(this.cor);
    g.drawString(texto, this.p1.getX(), this.p1.getY());
  }
}