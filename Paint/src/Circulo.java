import java.awt.*;
import java.util.*;

/**
 * Classe que instâcia e calcula os circulos, com seu posicionamento e tamanho.
 * 
 * 
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
public class Circulo extends Figura {
  protected Ponto p1, p2;
  protected Color corBorda;

/**
 * Construtor do Circulo, recebendo as coordenadas de entrada.
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
  public Circulo(int x1, int y1, int x2, int y2) {
    this(x1, y1, x2, y2, Color.BLACK, Color.BLACK);
  }

 /**
 * Construtor do Circulo, recebendo as coordenadas de entrada.
 * 
 * @param x1                valor X do eixo 1
 * @param y1                valor Y do eixo 1
 * @param x2                valor X do eixo 2
 * @param y2                valor Y do eixo 2
 * @param corPreenchimento  cor do preenchimento
 * @param corBorda          cor da borda
 * 
 * @author                  Leonardo
 * @author                  Rodrigo
 * @author                  Pedro
 */
  public Circulo(int x1, int y1, int x2, int y2, Color corPreenchimento, Color corBorda) {
    super(corPreenchimento);
    this.corBorda = corBorda;

    this.p1 = new Ponto(x1, y1, cor); //cordenadas x e y do primeiro local
    this.p2 = new Ponto(x2, y2, cor); //cordenadas x e y do segundo local
  }

  public Circulo(String s) {
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
 *Torna o circulo visível no Jpanel.
 * 
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
  public void torneSeVisivel(Graphics g) {
    int tamanho = calculaTamanho();
    int raio = calculaRaio(tamanho);
    int eixoX = calculaEixoX(raio);
    int eixoY = calculaEixoY(raio);

    g.setColor(this.cor);
    g.fillOval(eixoX, eixoY, tamanho, tamanho);

    g.setColor(this.corBorda);
    g.drawOval(eixoX, eixoY, tamanho, tamanho);
  }
  
/**
 *Salva um token com as informações do circulo.
 * 
 * @return String com os dados do circulo
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
  public String toString() {
    return "circulo:" + this.p1.getX() + ":" + this.p1.getY() + ":" + this.p2.getX() + ":" + this.p2.getY() + ":"
        + this.getCor().getRed() + ":" + this.getCor().getGreen() + ":" + this.getCor().getBlue();
  }

/**
 *Calcula o tamanho do Circulo
 * 
 * @return tamanho do circulo
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
  private int calculaTamanho() {
    int tamanho;
    int tamanhoX;
    int tamanhoY;
    if (this.p1.getX() > this.p2.getX())
      tamanhoX = this.p1.getX() - this.p2.getX();
    else
      tamanhoX = this.p2.getX() - this.p1.getX();

    if (this.p1.getY() > this.p2.getY())
      tamanhoY = this.p1.getY() - this.p2.getY();
    else
      tamanhoY = this.p2.getY() - this.p1.getY();

    if (tamanhoX > tamanhoY)
      tamanho = tamanhoX;
    else
      tamanho = tamanhoY;

    return tamanho;
  }

/**
 *Calcula o raio do circulo.
 * 
 * @param tamanho Tamanho do circulo calculado
 * @return        Raio do Circulo
 * @author        Leonardo
 * @author        Rodrigo
 * @author        Pedro
 */
  private int calculaRaio(int tamanho) {
    return tamanho / 2;
  }
  
/**
 *Calcula o eixo X
 * 
 * @param raio  Raio calculado do circulo
 * @return      Eixo X do circulo
 * @author      Leonardo
 * @author      Rodrigo
 * @author      Pedro
 */
  private int calculaEixoX(int raio) {
    return ((this.p1.getX() + this.p2.getX()) / 2) - raio;
  }

/**
 *calcula o eixo Y
 * 
 * @param raio  Raio calculado do circulo
 * @return      Eixo Y do circulo
 * @author      Leonardo
 * @author      Rodrigo
 * @author      Pedro
 */
  private int calculaEixoY(int raio) {
    return ((this.p1.getY() + this.p2.getY()) / 2) - raio;

  }
}