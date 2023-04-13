package Model;

import javax.swing.*;
import java.awt.*;


public class Shoot {
    private Image imagem;
    private Image image;
    private int x;
    private int y;
    private int largura;
    private int altura;
    private boolean isVisivil;
    private static final int LARGURA = 938;

    public Shoot(int x, int y) {
        this.x = x;
        this.y = y;
        isVisivil = true;
    }

    public void load() {
        ImageIcon ref = new ImageIcon("images/simples.png");
        imagem = ref.getImage();
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }

    public void load2() {
        ImageIcon ref = new ImageIcon("images/duplo.png");
        image = ref.getImage();
        this.largura = image.getWidth(null);
        this.altura = image.getHeight(null);
    }

    public void update() {
        int VELOCIDADE = 3;
        this.x += VELOCIDADE;
        if (this.x > LARGURA) {
            isVisivil = false;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisivil() {
        return isVisivil;
    }

    public Image getImagem() {
        return imagem;
    }

    public Image getImage() {
        return image;
    }

    public void setVisivil(boolean visivil) {
        isVisivil = visivil;
    }
}
