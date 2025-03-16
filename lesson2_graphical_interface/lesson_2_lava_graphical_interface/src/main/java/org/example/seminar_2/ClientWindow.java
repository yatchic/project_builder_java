package org.example.seminar_2;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ClientWindow extends JFrame {
    private JTextField tfLogin = new JTextField("User");
    private JTextField tfIP = new JTextField("127.0.0.1");
    private JTextField tfPort = new JTextField("8189");
    private JTextArea taChat = new JTextArea();
    private JTextField tfMessage = new JTextField();
    private JButton btnConnect = new JButton("Connect");
    private JButton btnSend = new JButton("Send");
    private static final String HISTORY_FILE = "chat_history.txt";

    public ClientWindow() {
        setTitle("Chat Client");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel connectionPanel = new JPanel(new GridLayout(1, 4));
        connectionPanel.add(new JLabel("IP:"));
        connectionPanel.add(tfIP);
        connectionPanel.add(new JLabel("Port:"));
        connectionPanel.add(tfPort);


        JPanel messagePanel = new JPanel(new BorderLayout());
        messagePanel.add(new JScrollPane(taChat), BorderLayout.CENTER);
        messagePanel.add(tfMessage, BorderLayout.SOUTH);
        messagePanel.add(btnSend, BorderLayout.EAST);


        setLayout(new BorderLayout());
        add(connectionPanel, BorderLayout.NORTH);
        add(messagePanel, BorderLayout.CENTER);


        loadChatHistory();


        btnSend.addActionListener(e -> sendMessage());
        tfMessage.addActionListener(e -> sendMessage());

        setVisible(true);
    }

    private void sendMessage() {
        String message = tfMessage.getText().trim();
        if (!message.isEmpty()) {
            taChat.append(tfLogin.getText() + ": " + message + "\n");
            saveToFile(message);
            tfMessage.setText("");
        }
    }

    private void saveToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE, true))) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadChatHistory() {
        File file = new File(HISTORY_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    taChat.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ClientWindow();
    }
}
