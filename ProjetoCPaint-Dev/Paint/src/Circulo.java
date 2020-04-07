import java.awt.*;
import java.util.*;

public class Circulo extends Figura {
  protected Ponto p1, p2;

  public Circulo(int x1, int y1, int x2, int y2) {
    this(x1, y1, x2, y2, Color.BLACK);
  }

  public Circulo(int x1, int y1, int x2, int y2, Color cor) {
    super(cor);

    this.p1 = new Ponto(x1, y1, cor);
    this.p2 = new Ponto(x2, y2, cor);
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

  public void setP1(int x, int y) {
    this.p1 = new Ponto(x, y, this.getCor());
  }

  public void setP2(int x, int y) {
    this.p2 = new Ponto(x, y, this.getCor());
  }

  public Ponto getP1() {
    return this.p1;
  }

  public Ponto getP2() {
    return this.p2;
  }

  public void torneSeVisivel(Graphics g) {
    int tamanho = calculaTamanho();
    int raio = calculaRaio(tamanho);
    int eixoX = calculaEixoX(raio);
    int eixoY = calculaEixoY(raio);

    g.setColor(this.cor);
    g.fillOval(eixoX, eixoY, tamanho, tamanho);
  }

  public String toString() {
    return "r:" + this.p1.getX() + ":" + this.p1.getY() + ":" + this.p2.getX() + ":" + this.p2.getY() + ":"
        + this.getCor().getRed() + ":" + this.getCor().getGreen() + ":" + this.getCor().getBlue();
  }

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

  private int calculaRaio(int tamanho) {
    return tamanho / 2;
  }

  private int calculaEixoX(int raio) {
    return ((this.p1.getX() + this.p2.getX()) / 2) - raio;
  }

  private int calculaEixoY(int raio) {
    return ((this.p1.getY() + this.p2.getY()) / 2) - raio;

  }
}