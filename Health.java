package Project;

public class Health {
    private int health;
    private Player player;

    public Health(int health, Player player) {
        this.health = health;
        this.player = player;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void damage(){
        int damage = this.getHealth() - 1;
    }
    public String toString(){
        return String.valueOf(this.health);
    }
}
