package org.example.tic_tac_toe;



import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 230;

    private JSlider sliderSize;
    private JSlider sliderWin;
    private JRadioButton pvc;
    private JRadioButton pvp;

    public SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        JLabel lblMode = new JLabel("Выберите режим игры:");
        pvc = new JRadioButton("Человек vs Компьютер", true);
        pvp = new JRadioButton("Человек vs Человек");
        ButtonGroup bgMode = new ButtonGroup();
        bgMode.add(pvc);
        bgMode.add(pvp);

        sliderSize = new JSlider(3, 10, 3);
        sliderWin = new JSlider(3, 10, 3);
        JButton btnStart = new JButton("начать");

        setLayout(new GridLayout(8, 1));
        add(lblMode);
        add(pvc);
        add(pvp);
        add(new JLabel("Размер поля: " + sliderSize.getValue()));
        add(sliderSize);
        add(new JLabel("Длина для победы: " + sliderWin.getValue()));
        add(sliderWin);
        add(btnStart);

        sliderSize.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();
            ((JLabel) getComponent(3)).setText("Размер поля: " + source.getValue());
            sliderWin.setMaximum(source.getValue());
        });

        btnStart.addActionListener(e -> {
            int mode = pvc.isSelected() ? 0 : 1;
            gameWindow.startNewGame(mode, sliderSize.getValue(), sliderSize.getValue(), sliderWin.getValue());
            setVisible(false);
        });
    }
}
