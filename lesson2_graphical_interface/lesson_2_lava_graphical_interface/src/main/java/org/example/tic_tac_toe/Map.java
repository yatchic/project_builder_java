package org.example.tic_tac_toe;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private static final Random RANDOM = new Random();
    private static final int DOT_PADDING = 5;
    private static final int HUMAN_DOT = 1;
    private static final int AI_DOT = 2;
    private static final int EMPTY_DOT = 0;

    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил компьютер!";
    private static final String MSG_DRAW = "Ничья!";

    private int[][] field;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLen;
    private int cellWidth;
    private int cellHeight;
    private int gameOverType;
    private boolean isGameOver;
    private boolean isInitialized;

    public Map() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isGameOver || !isInitialized) return;
                update(e);
            }
        });
    }

    void startNewGame(int mode, int sizeX, int sizeY, int winLen) {
        this.fieldSizeX = sizeX;
        this.fieldSizeY = sizeY;
        this.winLen = winLen;
        initMap();
        isGameOver = false;
        isInitialized = true;
        repaint();
    }

    private void initMap() {
        field = new int[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!isValidCell(cellX, cellY)) return;
        if (!isEmptyCell(cellX, cellY)) return;

        field[cellY][cellX] = HUMAN_DOT;
        repaint();

        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) return;
        aiTurn();
        repaint();
        checkEndGame(AI_DOT, STATE_WIN_AI);
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private boolean checkEndGame(int dot, int gameOverType) {
        if (checkWin(dot)) {
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isMapFull()) {
            this.gameOverType = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }

    private boolean checkWin(int dot) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (checkLine(x, y, 1, 0, winLen, dot)) return true;
                if (checkLine(x, y, 0, 1, winLen, dot)) return true;
                if (checkLine(x, y, 1, 1, winLen, dot)) return true;
                if (checkLine(x, y, 1, -1, winLen, dot)) return true;
            }
        }
        return false;
    }

    private boolean checkLine(int x, int y, int dx, int dy, int len, int dot) {
        final int endX = x + (len - 1) * dx;
        final int endY = y + (len - 1) * dy;
        if (endX < 0 || endY < 0 || endX >= fieldSizeX || endY >= fieldSizeY) return false;
        for (int i = 0; i < len; i++) {
            int currX = x + i * dx;
            int currY = y + i * dy;
            if (field[currY][currX] != dot) return false;
        }
        return true;
    }

    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    private void aiTurn() {
        int[] move = findWinningMove(AI_DOT);
        if (move == null) move = findWinningMove(HUMAN_DOT);
        if (move == null) {
            do {
                move = new int[]{RANDOM.nextInt(fieldSizeX), RANDOM.nextInt(fieldSizeY)};
            } while (!isEmptyCell(move[0], move[1]));
        }
        field[move[1]][move[0]] = AI_DOT;
    }

    private int[] findWinningMove(int dot) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) {
                    field[y][x] = dot;
                    boolean isWin = checkWin(dot);
                    field[y][x] = EMPTY_DOT;
                    if (isWin) return new int[]{x, y};
                }
            }
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
        if (isGameOver) showMessageGameOver(g);
    }

    private void render(Graphics g) {
        if (!isInitialized) return;

        cellWidth = getWidth() / fieldSizeX;
        cellHeight = getHeight() / fieldSizeY;

        g.setColor(Color.BLACK);
        for (int y = 1; y < fieldSizeY; y++) {
            int posY = y * cellHeight;
            g.drawLine(0, posY, getWidth(), posY);
        }
        for (int x = 1; x < fieldSizeX; x++) {
            int posX = x * cellWidth;
            g.drawLine(posX, 0, posX, getHeight());
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == EMPTY_DOT) continue;
                if (field[y][x] == HUMAN_DOT) {
                    g.setColor(Color.BLUE);
                } else {
                    g.setColor(Color.RED);
                }
                g.fillOval(
                        x * cellWidth + DOT_PADDING,
                        y * cellHeight + DOT_PADDING,
                        cellWidth - DOT_PADDING * 2,
                        cellHeight - DOT_PADDING * 2
                );
            }
        }
    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, getHeight() / 2 - 30, getWidth(), 60);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        switch (gameOverType) {
            case STATE_DRAW -> g.drawString(MSG_DRAW, 180, getHeight() / 2 + 10);
            case STATE_WIN_AI -> g.drawString(MSG_WIN_AI, 50, getHeight() / 2 + 10);
            case STATE_WIN_HUMAN -> g.drawString(MSG_WIN_HUMAN, 30, getHeight() / 2 + 10);
        }
    }
}
