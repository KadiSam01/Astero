package Project;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Asteroids extends JPanel {
    private Player player;
    private int x;
    private int y;
    private int speed;
    private int size;
    private BufferedImage image;

    public Asteroids(){
        super();
    }
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


    public Asteroids(Player player, int x, int y, int size,String image) {
       // this.asteroids = new ArrayList<>();
        this.player = player;
        this.x = x;
        this.y = y;
        this.size = size;
       this.setImage("Project/images/asteroids.png");
    }


    public void create_asteroids(Graphics g){
       // g.drawImage(getImage(),320,55,null);
      //  g.drawImage(getImage(),400,105,null);
        g.drawImage((getImage() ), (int) (Math.random()*getX()*500),(int)(Math.random()*getY()*200),null);
    }
    public void move(){
       random(50,10);
    }

    public void collision_check(){
        //checks if the asteroids hits the player
    }

    public void proceed(){
        //it will check the number of asteroids and see if there are any left, if none
       // the player may proceed
    }


    public Player getPlayer() {
        return player;
    }

    @Override
    public int getX() {
        return x;
    }
    @Override
    public int getY() {
        return y;
    }

    public int random(int x, int y){
        return (int) (Math.random() * getX() + getY());
    }

    public int getSpeed() {
        return speed;
    }

    public boolean void_check(){
        return false;
        //check to see if the asteroids goes out of the screen
    }

    public void idk(){

    }
}
