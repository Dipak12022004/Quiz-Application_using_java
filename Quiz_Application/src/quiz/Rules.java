package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton btnStart, btnBack;

    Rules(String name) {
        this.name = name;
        java.net.URL bgUrl = ClassLoader.getSystemResource("icons/back.jpg");
        if (bgUrl == null) {
            bgUrl = ClassLoader.getSystemResource("icons/back.png");
        }

        if (bgUrl != null) {
            ImageIcon bgIcon = new ImageIcon(bgUrl);
            Image bgImg = bgIcon.getImage().getScaledInstance(800, 650, Image.SCALE_SMOOTH);
            JLabel background = new JLabel(new ImageIcon(bgImg));
            setContentPane(background);
            background.setLayout(null);
        } else {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
        }

        JLabel heading = new JLabel("Welcome " + name + " to Quiz test!");
        heading.setBounds(150, 70, 700, 30);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 255));
        add(heading);

        JLabel subHeading = new JLabel("Please read the rules carefully before starting.");
        subHeading.setBounds(50, 120, 700, 30);
        subHeading.setFont(new Font("Segoe UI", Font.BOLD, 16));
        subHeading.setForeground(Color.RED);  
        add(subHeading);

        JLabel rules = new JLabel();
        rules.setBounds(50, 100, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>" +
                "<body style='padding: 10px;'>" +
                "<p>1. Participation in the quiz is free and open to all.</p><br>" +
                "<p>2. There are a total of 10 questions.</p><br>" +
                "<p>3. You have 15 seconds to answer each question.</p><br>" +
                "<p>4. No cell phones or secondary devices allowed.</p><br>" +
                "<p>5. Do not switch tabs or minimize the window.</p><br>" +
                "<p>6. Good luck and have fun!</p>" +
            "</body>" +
            "</html>"
        );

        rules.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230), 2));
        add(rules);

        btnBack = new JButton("Back");
        btnBack.setBounds(250, 500, 100, 30);
        btnBack.setBackground(new Color(30, 144, 255));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(this);
        btnBack.setOpaque(true);
        btnBack.setContentAreaFilled(true);
        btnBack.setBorderPainted(false);
        add(btnBack);

        btnStart = new JButton("Start Quiz");
        btnStart.setBounds(400, 500, 120, 30);
        btnStart.setBackground(new Color(30, 144, 255));
        btnStart.setForeground(Color.WHITE);
        btnStart.setFocusPainted(false);
        btnStart.addActionListener(this);
        btnStart.setOpaque(true);
        btnStart.setContentAreaFilled(true);
        btnStart.setBorderPainted(false);
        add(btnStart);

        setSize(800, 650);
        setLocationRelativeTo(null); 
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }
}