package com.bendy5410.games;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OnRepaint extends Loading{

    public static MainWindow.GameField repaint;
    public static int time1;
    public static boolean game_over = false;
    public OnRepaint(Graphics g){
        if(time1 >= 1716){
            if(!is_menu) {
                Loading.is_load = false;
                repaint = new MainWindow.GameField();
                long time = System.nanoTime();
                float timer2 = (time - timer) * 0.000000001f;
                timer = time;
                if(!is_menu) {
                    yer2 = yer2 + fps * timer2;
                    yer = yer + fps * timer2;
                }
                g.drawImage(background, bx, by, Color.decode("#000000"), null);
                g.drawImage(smile, (int) (xer), (int) (yer), null);
                g.drawImage(smile_over, (int) (xer2), (int) (yer2), null);
                MainWindow.pan(g);
                game_over = yer > root.getHeight();
                if (ovga && !is_ready || game_over && !is_menu && !is_ready) {
                    g.drawImage(gamer_over, 30, -10, null);
                    xer2 = 9000;
                    yer2 = -1000000000;
                    clip1.stop();
                }
                if (score >= 20){
                    is_menu = true;
                } else if (score <= -1) {
                    bx = (int) (Math.random() * xh);
                    by = (int) (Math.random() * yh);
                    bx = (int) (Math.random() * -xh);
                    by = (int) (Math.random() * -yh);
                    int lx = (int) (Math.random() * xh / (xer + fps * timer2));
                    xer = xer + lx * timer2;
                    xer = xer - fps * timer2;
                    if (xer <= root.getWidth()) {
                        xer = xer + fps * timer2;
                    } else if (xer >= root.getWidth()) {
                        xer = xer - fps * timer2;
                    }
                    root.setTitle("Smile! Ваш счёт поймоных смайликов = " + score);
                    g.drawImage(lol, bx, by, Color.decode("#000000"), null);
                    g.drawImage(smile, (int) (xer), (int) (yer), null);
                    g.drawImage(smile_over, (int) (xer2), (int) (yer2), null);
                    root.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    if (ovga && !is_ready || game_over && !is_menu && !is_ready) {
                        g.drawImage(gamer_over, 30, -10, null);
                        xer2 = 9000;
                        yer2 = -1000000000;
                        root.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        clip1.stop();
                    }
                } else if (score >= 5) {
                    bx = (int) (Math.random() * xh);
                    by = (int) (Math.random() * yh);
                    bx = (int) (Math.random() * -xh);
                    by = (int) (Math.random() * -yh);
                    int lx = (int) (Math.random() * xh / (xer + fps * 3000));
                    xer = xer + lx;
                    clip1.start();
                    root.setTitle("Smile! Ваш счёт поймоных смайликов = " + score);
                    g.drawImage(lol, bx, by, null);
                    g.drawImage(smile, (int) (xer), (int) (yer), null);
                    g.drawImage(smile_over, (int) (xer2), (int) (yer2), null);
                    root.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    if (ovga && !is_ready || game_over && !is_menu && !is_ready) {
                        g.drawImage(gamer_over, 30, -10, null);
                        xer2 = 9000;
                        yer2 = -1000000000;
                        root.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        clip1.stop();
                    }
                }
                root.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (!OnRepaint.ispause) {
                            int x = e.getX();
                            int y = e.getY();
                            float xi = xer + smile.getWidth(null);
                            float yi = yer + smile.getHeight(null);
                            int x2 = e.getX();
                            int y2 = e.getY();
                            float xi2 = xer2 + smile_over.getWidth(null);
                            float yi2 = yer2 + smile_over.getHeight(null);
                            boolean is_poop = x >= xer && x <= xi && y >= yer && y <= yi;
                            boolean is_poop_over = x2 >= xer2 && x2 <= xi2 && y2 >= yer2 && y2 <= yi2;
                            if (is_poop) {
                                yer = -800;
                                yer2 = -700;
                                xer = (int) (Math.random() * (root.getWidth() - smile.getHeight(null)));
                                xer2 = (int) (Math.random() * (root.getWidth() - smile_over.getHeight(null)));
                                xh = xh + 30;
                                yh = yh + 30;
                                if(difficulty == 0){
                                    fps_on_paused = fps;
                                    fps = fps_on_paused + 20;
                                }
                                if(difficulty == 1){
                                    fps_on_paused = fps;
                                    fps = fps_on_paused + 50;
                                }
                                if(difficulty == 2){
                                    fps_on_paused = fps;
                                    fps = fps_on_paused + 100;
                                }
                                if(difficulty == 3){
                                    fps_on_paused = fps;
                                    fps = fps_on_paused + 200;
                                }
                                score++;
                                root.setTitle("Smile! Ваш счёт поймоных смайликов = " + score);
                            } else if (is_poop_over) {
                                root.setTitle("Зачем ты нажал на грустный смайлик?");
                                ovga = true;
                                xer = 1000000;
                            }
                        }
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });
                root.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            if(!ovga && !is_ready) {
                                score = 0;
                                xer = 700;
                                xer2 = 100;
                                root.setTitle("Smile! Ваш счёт поймоных смайликов = " + score);
                                yer = -800;
                                yer2 = -700;
                                ovga = false;
                                fps = 300;
                                bx = 0;
                                by = 0;
                                yh = -30;
                                xh = -30;
                            }
                            if(is_ready){
                                is_ready = false;
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_F1) {
                            ovga = true;
                        }
                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            if (!MainWindow.ispause) {
                                fps = 0;
                                MainWindow.ispause = true;
                                g.drawImage(MainWindow.pause, bx, by, null);
                            }
                        }
                        if(e.getKeyCode() == KeyEvent.VK_SPACE){
                            if (MainWindow.ispause) {
                                fps = fps_on_paused;
                                MainWindow.ispause = false;
                            }
                        }
                        if (e.getKeyCode() == KeyEvent.VK_0) {
                            is_menu = true;
                        }
                    }
                });
            }
            if(is_menu){
                g.drawImage(menu, 0, 0, null);
                g.drawImage(menu_button_play, menu_pos_x, menu_pos_y, null);
                g.drawImage(menu_button_easy, button1_x, buttons_y, null);
                g.drawImage(menu_button_normal, button2_x, buttons_y, null);
                g.drawImage(menu_button_hard, button3_x, buttons_y, null);
                g.drawImage(menu_button_really_hard, button4_x, buttons_y, null);
                root.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {}
                    @Override
                    public void mousePressed(MouseEvent e) {
                        int x = e.getX();
                        int y = e.getY();
                        float xib = menu_pos_x + menu_button_play.getWidth(null);
                        float yib = menu_pos_y + menu_button_play.getHeight(null);
                        float xibe = button1_x + menu_button_easy.getWidth(null);
                        float yibe = buttons_y + menu_button_easy.getHeight(null);
                        float xibn = button2_x + menu_button_normal.getWidth(null);
                        float yibn = buttons_y + menu_button_normal.getHeight(null);
                        float xibh = button3_x + menu_button_hard.getWidth(null);
                        float yibh = buttons_y + menu_button_hard.getHeight(null);
                        float xibrh = button4_x + menu_button_really_hard.getWidth(null);
                        float yibrh = buttons_y + menu_button_easy.getHeight(null);
                        boolean is_play_press = x >= menu_pos_x && x <= xib && y >= menu_pos_y && y <= yib;
                        boolean is_easy_press = x >= button1_x && x <= xibe && y >= buttons_y && y <= yibe;
                        boolean is_normal_press = x >= button2_x && x <= xibn && y >= buttons_y && y <= yibn;
                        boolean is_hard_press = x >= button3_x && x <= xibh && y >= buttons_y && y <= yibh;
                        boolean is_really_hard_press = x >= button4_x && x <= xibrh && y >= buttons_y && y <= yibrh;
                        if(is_play_press & is_menu){
                            is_menu = false;
                            is_ready = true;
                            score = 0;
                            xer = 700;
                            xer2 = 100;
                            root.setTitle("Smile! Ваш счёт поймоных смайликов = " + score);
                            yer = -600;
                            yer2 = -400;
                            ovga = false;
                            game_over = false;
                            fps = 300;
                            bx = 0;
                            by = 0;
                            yh = -30;
                            xh = -30;
                        }
                        if(is_easy_press & is_menu){
                            difficulty = 0;
                            root.setTitle("Smile easy!");
                        }
                        if(is_normal_press & is_menu){
                            difficulty = 1;
                            root.setTitle("Smile normal!");
                        }
                        if(is_hard_press & is_menu){
                            difficulty = 2;
                            root.setTitle("Smile hard!");
                        }
                        if(is_really_hard_press & is_menu){
                            difficulty = 3;
                            root.setTitle("Smile really hard!");
                        }
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        root.setCursor(Cursor.HAND_CURSOR);
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        root.setCursor(Cursor.DEFAULT_CURSOR);
                    }
                });
            }
        } else {
            time1++;
            g.drawImage(Loading.load1, 0, 0, null);
            g.drawImage(Loading.load2, 0, 0, null);
        }
    }
}
