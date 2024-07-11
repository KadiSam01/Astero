package Project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainBackGround extends JFrame {
    private JPanel contentPane;
    private ImageIcon image;
    private JLabel label;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainBackGround background = new MainBackGround();
                    background.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainBackGround() {
        setTitle("Asteroids");
        image = new ImageIcon(this.getClass().getResource("images/space.jpg"));
        label = new JLabel(image);
        label.setSize(650,450);
        setBounds(100, 100, 900, 675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new Game();
        JPanel panel = new Game();
        contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
    }
}
