package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    
    JButton btnPlayAgain, btnExit;

    Score(String name, int score) {
        setBounds(400, 150, 750, 550);

        java.net.URL bgUrl = ClassLoader.getSystemResource("icons/back.jpg");
        if (bgUrl == null) {
            bgUrl = ClassLoader.getSystemResource("icons/back.png");
        }

        if (bgUrl != null) {
            ImageIcon bgIcon = new ImageIcon(bgUrl);
            Image bgImg = bgIcon.getImage().getScaledInstance(750, 550, Image.SCALE_SMOOTH);
            JLabel background = new JLabel(new ImageIcon(bgImg));
            setContentPane(background);
            background.setLayout(null);
        } else {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
        }

        setUndecorated(true);
        setLocationRelativeTo(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60, 200, 200, 150);
        add(image);

        JLabel heading = new JLabel("Thank you " + name + " for playing!");
        heading.setBounds(100, 80, 700, 30);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 26));
        heading.setForeground(new Color(30, 144, 255));
        add(heading);

        JLabel lblScore = new JLabel("Your Score: " + score);
        lblScore.setBounds(350, 200, 300, 30);
        lblScore.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblScore.setForeground(new Color(199, 21, 133)); // Nice accent color
        add(lblScore);

        String status = (score >= 50) ? "Great Job! You Passed." : "Better luck next time!";
        JLabel lblStatus = new JLabel(status);
        lblStatus.setBounds(350, 240, 300, 30);
        lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblStatus);

        btnPlayAgain = new JButton("Play Again");
        btnPlayAgain.setBounds(350, 300, 120, 30);
        btnPlayAgain.setBackground(new Color(30, 144, 255));
        btnPlayAgain.setForeground(Color.WHITE);
        btnPlayAgain.setFocusPainted(false);
        btnPlayAgain.addActionListener(this);
        btnPlayAgain.setOpaque(true);
        btnPlayAgain.setContentAreaFilled(true);
        btnPlayAgain.setBorderPainted(false);
        add(btnPlayAgain);

        btnExit = new JButton("Exit");
        btnExit.setBounds(500, 300, 120, 30);
        btnExit.setBackground(new Color(255, 102, 102));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFocusPainted(false);
        btnExit.addActionListener(this);
        btnExit.setOpaque(true);
        btnExit.setContentAreaFilled(true);
        btnExit.setBorderPainted(false);
        add(btnExit);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnPlayAgain) {
            setVisible(false);
            new Login();
        } else {
            System.exit(0);
        }
    }
}