package com.bendy5410.games;

import javax.swing.*;
import java.awt.*;
public class MainWindow extends Loading{
    protected static void pan(Graphics k) {
        k.drawImage(Loading.smile_over, (int) (Loading.xer2), (int) (Loading.yer2), null);
        k.drawImage(Loading.smile_over, (int) (Loading.xer2), (int) (Loading.yer2), null);
        k.drawImage(Loading.smile_over, (int) (Loading.xer2), (int) (Loading.yer2), null);
        k.drawImage(Loading.smile_over, (int) (Loading.xer2), (int) (Loading.yer2), null);
        k.drawImage(Loading.smile_over, (int) (Loading.xer2), (int) (Loading.yer2), null);
    }
    public void main() {

    }
    protected static class GameField extends JPanel{

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            try {
                new OnRepaint(g);
            } catch (Exception e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}
