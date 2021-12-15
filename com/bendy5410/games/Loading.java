package com.bendy5410.games;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
public class Loading extends JFrame{
    public static boolean ispause;
    protected static Loading root;
    public static int bx = 0;
    public static int by = 0;
    public static long timer;
    public static Image background;
    public static Image smile;
    public static Image gamer_over;
    public static Image smile_over;
    public static Image lol;
    public static Image load1;
    public static Image load2;
    public static Image menu_button_play;
    public static Image menu_button_easy;
    public static Image menu_button_normal;
    public static Image menu_button_hard;
    public static Image menu_button_really_hard;
    public static Image menu;
    public static Image ready;
    public static int difficulty = 0;
    public static int button1_x = 100;
    public static int button2_x = 480;
    public static int button3_x = 850;
    public static int button4_x = 1200;
    public static int buttons_y = 700;
    public static int menu_pos_x = 600;
    public static int menu_pos_y = 400;
    public static float xer = 200;
    public static float yer = -500;
    public static float xer2 = 400;
    public static float yer2 = -700;
    public static float fps = 300;
    public static int score;
    public static boolean ovga = false;
    public static int yh = -100;
    public static int xh = -100;
    public static float fps_on_paused = 0;
    public static Image pause;
    public static boolean is_load = true;
    public static boolean is_menu = true;
    public static boolean is_ready = true;
    public static File music1;
    public static Clip clip1;
    public static void main(String[] args) throws Exception {
        background = ImageIO.read(MainWindow.class.getResourceAsStream("images/background.jpg"));
        smile = ImageIO.read(MainWindow.class.getResourceAsStream("images/happy.png"));
        gamer_over = ImageIO.read(MainWindow.class.getResourceAsStream("images/game_over.png"));
        smile_over = ImageIO.read(MainWindow.class.getResourceAsStream("images/sad.png"));
        lol = ImageIO.read(MainWindow.class.getResourceAsStream("images/background_faus2.jpg"));
        pause = ImageIO.read(MainWindow.class.getResourceAsStream("images/pause.png"));
        load1 = ImageIO.read(Loading.class.getResourceAsStream("images/loading1.png"));
        load2 = ImageIO.read(Loading.class.getResourceAsStream("images/loading2.png"));
        menu_button_play = ImageIO.read(Loading.class.getResourceAsStream("images/button_play.png"));
        menu_button_easy = ImageIO.read(Loading.class.getResourceAsStream("images/button_easy.png"));
        menu_button_normal = ImageIO.read(Loading.class.getResourceAsStream("images/button_normal.png"));
        menu_button_hard = ImageIO.read(Loading.class.getResourceAsStream("images/button_hard.png"));
        menu_button_really_hard = ImageIO.read(Loading.class.getResourceAsStream("images/button_really_hard.png"));
        menu = ImageIO.read(Loading.class.getResourceAsStream("images/menu.jpg"));
        ready = ImageIO.read(Loading.class.getResourceAsStream("images/ready.png"));
        music1 = new File("src/com/bendy5410/games/music/music.wav");
        AudioInputStream ais = AudioSystem.getAudioInputStream(music1);
        clip1 = AudioSystem.getClip();
        clip1.open(ais);
        clip1.setFramePosition(0);
        root = new Loading();
        root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        root.setLocation(-8, 0);
        root.setSize(2000, 830);
        root.setBackground(Color.black);
        root.setResizable(false);
        MainWindow.GameField repaint = new MainWindow.GameField();
        root.setTitle("Smile!");
        root.setIconImage(smile);
        root.add(repaint);
        root.setVisible(true);
        timer = System.nanoTime();
        root.setExtendedState(JFrame.NORMAL);
        MainWindow start = new MainWindow();
        start.main();
    }
}
