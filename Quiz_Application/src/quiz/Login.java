package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    private JTextField tfName;
    private JButton btnNext, btnExit;

    private final Color PRIMARY_COLOR = new Color(51, 153, 255); 
    private final Color TEXT_COLOR = new Color(50, 50, 50);

    public Login() {
        setTitle("Quiz Application - Login");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); 

        int width = 1000;
        int height = 500;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        Image i = i1.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH); 
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(0, 0, 500, 500);
        add(image);

        JLabel heading = new JLabel("Smart Minds Quiz");
        heading.setBounds(600, 60, 400, 45);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 40)); // Segoe UI is a standard, clean Windows font
        heading.setForeground(PRIMARY_COLOR);
        add(heading);

        JLabel nameLabel = new JLabel("Enter Your Name:");
        nameLabel.setBounds(650, 150, 300, 20);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        nameLabel.setForeground(TEXT_COLOR);
        add(nameLabel);

        tfName = new JTextField();
        tfName.setBounds(600, 200, 300, 30);
        tfName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        tfName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY)); // Modern underline style
        add(tfName);

        btnNext = new JButton("Next");
        btnNext.setBounds(600, 270, 120, 30);
        btnNext.setBackground(PRIMARY_COLOR);
        btnNext.setForeground(Color.WHITE);
        btnNext.setFocusPainted(false); 
        btnNext.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNext.addActionListener(this);

        btnNext.setOpaque(true);
        btnNext.setContentAreaFilled(true);
        btnNext.setBorderPainted(false);
        add(btnNext);

        btnExit = new JButton("Exit");
        btnExit.setBounds(780, 270, 120, 30);
        btnExit.setBackground(new Color(255, 102, 102)); // Soft Red
        btnExit.setForeground(Color.WHITE);
        btnExit.setFocusPainted(false);
        btnExit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExit.addActionListener(this);
        btnExit.setOpaque(true);
        btnExit.setContentAreaFilled(true);
        btnExit.setBorderPainted(false);
        add(btnExit);

        setSize(width, height);
        setLocationRelativeTo(null);
        setUndecorated(true); 
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            String name = tfName.getText();
            if(name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name to continue.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            } else {
                setVisible(false);
                new Rules(name);
            }
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
        
        new Login();
    }
}