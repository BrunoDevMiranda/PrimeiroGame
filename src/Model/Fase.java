package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class Fase extends JPanel implements ActionListener {
    private Image fundo;
    private Player player;
    private Timer timer;
    private List<Enemy1> enemy1;
    private boolean inPlay;

    public Fase() {

        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon ref = new ImageIcon("images/estrelado.png");
        fundo = ref.getImage();
        player = new Player();
        player.load();
        addKeyListener(new TecladoAdapter());
        timer = new Timer(1, this);
        timer.start();
        initEnemy();
        inPlay = true;
    }

    public void initEnemy() {
        int condernadas[] = new int[40];
        enemy1 = new ArrayList<Enemy1>();
        for (int i = 0; i < condernadas.length; i++) {
            int x = (int) (Math.random() * 8000 + 1024);
            int y = (int) (Math.random() * 650 + 30);
            enemy1.add(new Enemy1(x, y));
        }
    }

    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        if (inPlay == true) {
            graphics.drawImage(fundo, 0, 0, null);
            graphics.drawImage(player.getImagem(), player.getX(), player.getY(), this);
            List<Shoot> shootList = player.getShootList();
            List<Shoot> shoot = player.getShoot();
            for (int i = 0; i < shootList.size(); i++) {
                Shoot m = shootList.get(i);
                m.load();
                graphics.drawImage(m.getImagem(), m.getX(), m.getY(), this);
            }

            for (int i = 0; i < shoot.size(); i++) {
                Shoot m = shoot.get(i);
                m.load2();
                graphics.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }

            for (int index = 0; index < enemy1.size(); index++) {
                Enemy1 in = enemy1.get(index);
                in.load();
                graphics.drawImage(in.getImagem(), in.getX(), in.getY(), this);
            }
        } else {
            ImageIcon gameOver = new ImageIcon("images/gameOver.png");
            graphics.drawImage(gameOver.getImage(), 0, 0, null);

        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        List<Shoot> shootList = player.getShootList();
        for (int i = 0; i < shootList.size(); i++) {
            Shoot m = shootList.get(i);
            if (m.isVisivil()) {
                m.update();
            } else
                shootList.remove(i);
        }

        for (int index = 0; index < enemy1.size(); index++) {
            Enemy1 in = enemy1.get(index);
            if (in.isVisivil()) {
                in.update();

            } else {
                enemy1.remove(index);
            }

        }

        repaint();


        List<Shoot> shoot = player.getShoot();
        for (int i = 0; i < shoot.size(); i++) {
            Shoot m = shoot.get(i);
            if (m.isVisivil()) {
                m.update();
            } else
                shoot.remove(i);
        }
        checkColision();
        repaint();
    }


    public void checkColision() {
        Rectangle formNave = player.getBounds();
        Rectangle formEnemy1;
        Rectangle formShoot;
        for (int i = 0; i < enemy1.size(); i++) {
            Enemy1 tempEnemy1 = enemy1.get(i);
            formEnemy1 = tempEnemy1.getBounds();
            if (formNave.intersects(formEnemy1)) {
                player.setVisivel(false);
                tempEnemy1.setVisivil(false);
                inPlay = false;
            }
        }
        List<Shoot> shoots = player.getShoot();
        for (int j = 0; j < shoots.size(); j++) {
            Shoot tempShoot = shoots.get(j);
            formShoot =tempShoot.getBounds();
            for (int k = 0; k < enemy1.size(); k++) {
                Enemy1 tempEnemy1 = enemy1.get(k);
                formEnemy1 = tempEnemy1.getBounds();
                if (formShoot.intersects(formEnemy1)){
                    tempEnemy1.setVisivil(false);
                    tempShoot.setVisivil(false);

                }
            }

        }
    }

    private class TecladoAdapter extends KeyAdapter {


        public void keyPressed(KeyEvent evente) {
            player.keyPressed(evente);
        }


        public void keyReleased(KeyEvent e) {
            player.keyRelease(e);
        }


    }


}
