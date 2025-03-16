package org.example.tic_tac_toe;


import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static final int WINDOW_WIDTH = 555;
    private static final int WINDOW_HEIGHT = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    private JButton btnStart = new JButton("новая игра");
    private JButton btnExit = new JButton("выход");
    private Map map;
    private SettingsWindow settings;

    public GameWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setTitle("крестики нолики");
        setResizable(false);

        map = new Map();
        settings = new SettingsWindow(this);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.add(btnStart);
        bottomPanel.add(btnExit);

        btnExit.addActionListener(e -> System.exit(0));
        btnStart.addActionListener(e -> settings.setVisible(true));

        add(bottomPanel, BorderLayout.SOUTH);
        add(map);
        setVisible(true);
    }

    void startNewGame(int mode, int sizeX, int sizeY, int winLen) {
        map.startNewGame(mode, sizeX, sizeY, winLen);
    }
}
