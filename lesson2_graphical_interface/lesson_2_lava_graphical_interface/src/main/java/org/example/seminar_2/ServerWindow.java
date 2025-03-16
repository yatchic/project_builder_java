package org.example.seminar_2;

import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame {
    private boolean isServerWorking = false;
    private JButton btnStart = new JButton("Start Server");
    private JButton btnStop = new JButton("Stop Server");
    private JTextArea log = new JTextArea();

    public ServerWindow() {
        setTitle("Chat Server");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(btnStart);
        buttonPanel.add(btnStop);
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(log), BorderLayout.CENTER);

        btnStart.addActionListener(e -> startServer());
        btnStop.addActionListener(e -> stopServer());

        add(panel);
        setVisible(true);
    }

    private void startServer() {
        isServerWorking = true;
        log.append("Server started.\n");
    }

    private void stopServer() {
        isServerWorking = false;
        log.append("Server stopped.\n");
    }


}
