package Project;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player{
    //make player a triangle
    private int x, y, vx, vy, speed, width, height;
    private boolean health_damaged;
    private String direction, upward, downward, left, right;
    private BufferedImage image;
    public Player(String upward, String downward, String left, String right,int x, int y, int speed) {
        this.setX(x);
        this.setY(y);
        this.setImage(upward);
        this.setSpeed(speed);
        this.setWidth(60);
        this.setHeight(100);
        this.setDirection("U");
        this.setUpward(upward);
        this.setDownward(downward);
        this.setLeft(left);
        this.setRight(right);

    }

    //private KeyListener key;

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    /*public Player(){
        this.x = 50;
        this.y = 100;
        this.setDirection("U");

    }*/



    /*public Player(String upward, String downward, String left, String right){
        this.setUpward(upward);
        this.setDownward(downward);
        this.setRight(right);
        this.setLeft(left);
    }*/





    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public void drawPlayer(Graphics g) {
        switch(getDirection()) {
            case "R":
                setImage(getRight());
                break;
            case "L":
                setImage(getLeft());
                break;
            case "U":
                setImage(getUpward());
                break;
            case "D":
                setImage(getDownward());
                break;
        }
        g.drawImage(getImage(),getX(),getY(),getWidth(),getHeight(),null);
    }

    public void move(String direction){
        switch (direction){
            case "R":
                setVx(getSpeed());
                setVy(0);
                setDirection("R");
                break;
            case "U":
                setVx(0);
                setVy(-getSpeed());
                setDirection("U");
                break;
            case "L":
                setVx(-getSpeed());
                setVy(0);
                setDirection("L");
                break;
            case "D":
                setVx(0);
                setVy(getSpeed());
                setDirection("D");
                break;
        }
    }
    public void stop() {
        setVx(0);
        setVy(0);
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }


    public boolean isHealth_damaged() {
        return health_damaged;
    }

    public void setHealth_damaged(boolean health_damaged) {
        this.health_damaged = health_damaged;
    }


    public String getUpward() {
        return upward;
    }

    public void setUpward(String upward) {
        this.upward = upward;
    }

    public String getDownward() {
        return downward;
    }

    public void setDownward(String downward) {
        this.downward = downward;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
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

    /*public void move_right(){

    }


    public void move_left(){


    }

    public void move_up(){


    }

    public void move_down(){


    }*/




    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
//key press player movement

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code){
            case KeyEvent.VK_D:
                move("R");
                break;
            case KeyEvent.VK_A:
                move("L");
                break;
            case KeyEvent.VK_W:
                move("U");
                break;
            case KeyEvent.VK_S:
                move("D");
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch(code) {
            case KeyEvent.VK_D:
            case KeyEvent.VK_A:
            case KeyEvent.VK_W:
            case KeyEvent.VK_S:
                stop();
                break;
        }
    }
    //updates the position
    public void update(){
        if(this.getX() < 0){
            setVx(0);
            setVy(0);
        }
        if(this.getX() > 895 - getWidth()){
            setVy(0);
            setX(895 - getWidth());
        }
        if (getY() < 0) {
            setVy(0);
            setY(0);
        }
        if (getY() > 650 - getHeight()) {
            setVy(0);
            setY(648 - getHeight());
        }
        setX(getX()+getVx());
        setY(getY()+getVy());
    }


    public boolean damage_check(){

        //checks if the asteroids hits the player
        return false;
    }
}
