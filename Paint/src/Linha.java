import java.awt.*;
import java.util.*;

/**
 * Classe que instâcia e calcula a linha, com seu posicionamento e tamanho.
 * 
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
public class Linha extends Figura {
  protected Ponto p1, p2;

 /**
 * Construtor da Linha, recebendo as coordenadas de entrada.
 * 
 * @param x1  valor X do eixo 1
 * @param y1  valor Y do eixo 1
 * @param x2  valor X do eixo 2
 * @param y2  valor Y do eixo 2
 * 
 * @author    Leonardo
 * @author    Rodrigo
 * @author    Pedro
 */
  public Linha(int x1, int y1, int x2, int y2) {
    this(x1, y1, x2, y2, Color.BLACK);
  }

/**
 * Construtor da Linha, recebendo as coordenadas de entrada.
 * 
 * @param x1  valor X do eixo 1
 * @param y1  valor Y do eixo 1
 * @param x2  valor X do eixo 2
 * @param y2  valor Y do eixo 2
 * @param cor Cor da linha
 * 
 * @author    Leonardo
 * @author    Rodrigo
 * @author    Pedro
 */
  public Linha(int x1, int y1, int x2, int y2, Color cor) {
    super(cor);

    this.p1 = new Ponto(x1, y1, cor);
    this.p2 = new Ponto(x2, y2, cor);
  }

  public Linha(String s) {
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

/**
 *Define a coordenada 1.
 * 
 * @param x valor X do eixo 1
 * @param y valor Y do eixo 1
 * 
 * @author  Leonardo
 * @author  Rodrigo
 * @author  Pedro
 */
  public void setP1(int x, int y) {
    this.p1 = new Ponto(x, y, this.getCor());
  }

/**
 *Define a coordenada 2.
 * 
 * @param x valor X do eixo 2
 * @param y valor Y do eixo 2
 * 
 * @author  Leonardo
 * @author  Rodrigo
 * @author  Pedro
 */
  public void setP2(int x, int y) {
    this.p2 = new Ponto(x, y, this.getCor());
  }

/**
 *Retorna a coordenada 1.
 * 
 * @return Coordenada 1
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
  public Ponto getP1() {
    return this.p1;
  }

/**
 *retorna a coordenada 2.
 * 
 * @return Coordenada 2
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
  public Ponto getP2() {
    return this.p2;
  }

/**
 *Torna A Linha visível no Jpanel.
 * 
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
  public void torneSeVisivel(Graphics g) {
    g.setColor(this.cor);
    g.drawLine(this.p1.getX(), this.p1.getY(), // ponto inicial
        this.p2.getX(), this.p2.getY()); // ponto final
  }

/**
 *Salva um token com as informações da Linha.
 * 
 * @return String com os dados da Linha
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
  public String toString() {
    return "linha:" + this.p1.getX() + ":" + this.p1.getY() + ":" + this.p2.getX() + ":" + this.p2.getY() + ":"
        + this.getCor().getRed() + ":" + this.getCor().getGreen() + ":" + this.getCor().getBlue();
  }
}