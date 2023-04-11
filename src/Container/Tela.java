package Container;

import Model.Fase;

import javax.swing.*;

public class Tela extends JFrame {
    public Tela(){
        add(new Fase());
        setTitle("Primeiro GAME");
        setSize(1024,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Tela();
    }
}
