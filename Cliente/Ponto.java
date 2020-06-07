import java.awt.*;
import java.util.*;

/**
 * Classe que instâcia e calcula o ponto, com seu posicionamento.
 * 
 * 
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
public class Ponto extends Figura {
  protected int x, y;

/**
 * Construtor do Ponto, recebendo as coordenadas de entrada.
 * 
 * @param x   valor X 
 * @param y   valor Y 
 * 
 * @author    Leonardo
 * @author    Rodrigo
 * @author    Pedro
 */
  public Ponto(int x, int y) {
    this(x, y, Color.BLACK);
  }

 /**
 * Construtor do Ponto, recebendo as coordenadas de entrada.
 * 
 * @param x    valor X do eixo 
 * @param y    valor Y do eixo 
 * @param cor  cor do preenchimento
 * 
 * @author     Leonardo
 * @author     Rodrigo
 * @author     Pedro
 */
  public Ponto(int x, int y, Color cor) {
    super(cor);

    this.x = x;
    this.y = y;
  }

  public Ponto(String s) {
    StringTokenizer quebrador = new StringTokenizer(s, ":");

    quebrador.nextToken();

    this.x = Integer.parseInt(quebrador.nextToken());
    this.y = Integer.parseInt(quebrador.nextToken());

    this.cor = new Color(Integer.parseInt(quebrador.nextToken()), // R
        Integer.parseInt(quebrador.nextToken()), // G
        Integer.parseInt(quebrador.nextToken())); // B
  }

/**
 *Define o eixo X da cordenada.
 * 
 * @param x Valor X
 * 
 * @author  Leonardo
 * @author  Rodrigo
 * @author  Pedro
 */
  public void setX(int x) {
    this.x = x;
  }

/**
 *Define o eixo Y da cordenada.
 * 
 * @param y Valor Y
 * 
 * @author  Leonardo
 * @author  Rodrigo
 * @author  Pedro
 */
  public void setY(int y) {
    this.y = y;
  }

/**
 *retorna a coordenada X.
 * 
 * @return Coordenada X
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
  public int getX() {
    return this.x;
  }

 /**
 *retorna a coordenada Y.
 * 
 * @return Coordenada Y
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
  public int getY() {
    return this.y;
  }

/**
 *Torna o Ponto visível no Jpanel.
 * 
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
  public void torneSeVisivel(Graphics g) {
    g.setColor(this.cor);
    g.drawLine(this.x, this.y, this.x, this.y);
  }

/**
 *Salva um token com as informações do Ponto.
 * 
 * @return String com os dados do Ponto
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
  public String toString() {
    return "ponto:" + this.x + ":" + this.y + ":" + this.getCor().getRed() + ":" + this.getCor().getGreen() + ":"
        + this.getCor().getBlue();
  }
}