package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;


public class Fase extends JPanel implements ActionListener {
    private Image fundo;
    private Player player;
    private Timer timer;

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
    }

    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
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
            g.dispose();
        }

        @Override
        public void actionPerformed (ActionEvent e){
            player.update();
            List<Shoot> shootList = player.getShootList();
            for (int i = 0; i < shootList.size(); i++) {
                Shoot m = shootList.get(i);
                if (m.isVisivil()) {
                    m.update();
                } else
                    shootList.remove(i);
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
            repaint();
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
