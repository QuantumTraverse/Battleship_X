public class ship {
    private int health;
    private int size;
    private positioner[] coords;
    public ship(int health, positioner[] position){
        this.health = health;
        size = health;
        coords = position;
    }
    public positioner[] getPosition() {
        return coords;
    }
    public void takeDamage() {
        health--;
    }
    public boolean testAlive() {
        if(health <=0)
            return true;
        return false;
    }
}
