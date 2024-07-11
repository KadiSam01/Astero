package Project;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends JPanel implements ActionListener, KeyListener {
    private BufferedImage image;
    private Player player;
    private Asteroids asteroids;
    private Health health;
    //Random asteroidx = new Random();
    //Random asteroidY = new Random();
    //int AstX = asteroidx.nextInt(100);
    //int AstY = asteroidY.nextInt(1000);
    Timer time = new Timer(15,this);
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(String imagePath) {
        try{
            this.image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Game() {
        setImage("Project/images/space.jpg");
        time.start();
        //health = new Health(player);
        player = new Player("Project/images/upward.png","Project/images/down.png","Project/images/left.png","Project/images/right.png",5,5,5);
        //asteroids.add(new Asteroids(player,5,5,5,"Project/images/asteroid.png"));
        asteroids = new Asteroids(player,5,5,5,"Project/images/asteroid.png");
        player.setX(5);
        player.setY(5);
        player.setSpeed(5);
        setFocusable(true);
        requestFocusInWindow();
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getImage(),getX(),getY(),null);
        player.drawPlayer(g);
        asteroids.create_asteroids(g);
    }

    public void actionedPerformed(){
        player.update();
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        /*int code = e.getKeyCode();
        switch (code){
            case KeyEvent.VK_D:
                player.move("R");
                break;
            case KeyEvent.VK_A:
                player.move("L");
                break;
            case KeyEvent.VK_W:
                player.move("U");
                break;
            case KeyEvent.VK_S:
                player.move("D");
                break;
        }*/
        player.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        actionedPerformed();
        repaint();
    }
}
