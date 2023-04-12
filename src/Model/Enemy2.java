package Model;

import javax.swing.*;
import java.awt.*;

public class Enemy2 {
    private Image imagem;
    private Image image;
    private int x,y;
    private int largura, altura;
    private boolean isVisivil;
    private  static final int LARGURA = 938;

    private  static int VELOCIDADE = 3;

    public Enemy2(int x, int y){
        this.x = x;
        this.y = y;
        isVisivil = true;
    }
    public void load(){
        ImageIcon ref = new ImageIcon("images/simples.png");
        imagem = ref.getImage();
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }

    public void load2(){
        ImageIcon ref = new ImageIcon("images/duplo.png");
        image = ref.getImage();
        this.largura = image.getWidth(null);
        this.altura = image.getHeight(null);
    }

    public void update(){
        this.x += VELOCIDADE;
        if(this.x > LARGURA){
            isVisivil = false;
        }
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

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int VELOCIDADE) {
        Enemy2.VELOCIDADE = VELOCIDADE;
    }

    public Image getImagem() {
        return imagem;
    }

    public Image getImage() {
        return image;
    }
}
