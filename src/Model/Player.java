package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private int x, y;
    private int dx, dy;
    private Image imagem;
    private int height, width;
    private List<Shoot> shootList;
    private List<Shoot> shoot;


    public Player() {
        this.x = 100;
        this.y = 100;
        shootList = new ArrayList<>();
        shoot = new ArrayList<>();
    }

    public void load() {
        ImageIcon ref = new ImageIcon("images/naveAmarela.png");
        imagem = ref.getImage();
        height = imagem.getHeight(null);
        width = imagem.getWidth(null);
    }

    public void update() {
        x += dx;
        y += dy;

        if (y < 0) {
            y = 0;
        }
        if (y > 700) {
            y = 700;
        }

        if (x < 0) {
            x = 0;
        }
        if (x > 900) {
            x = 900;
        }


    }

    public void simpleShot() {
        this.shootList.add(new Shoot(x + width, y + (height / 2)));
    }

    public void dobleShot() {
        this.shoot.add(new Shoot(x + width, y + (height / 3)));

    }


    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        if (codigo == KeyEvent.VK_SPACE) {
            simpleShot();
        }
        if (codigo == KeyEvent.VK_B) {
            dobleShot();
        }


        if (codigo == KeyEvent.VK_UP) {
            dy = -3;
        }

        if (codigo == KeyEvent.VK_DOWN) {
            dy = 3;
        }

        if (codigo == KeyEvent.VK_LEFT) {
            dx = -3;

        }
        if (codigo == KeyEvent.VK_RIGHT) {
            dx = 3;

        }
    }


    public void keyRelease(KeyEvent event) {


        int c = event.getKeyCode();
        if (c == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (c == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        if (c == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (c == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }

    public List<Shoot> getShootList() {
        return shootList;
    }

    public List<Shoot> getShoot() {
        return shoot;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}