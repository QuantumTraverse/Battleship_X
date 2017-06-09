public class ship {
    private int health;
    private int size;
    private String orientation;
    private positioner[] coords;
    public ship(int health, positioner position, String orientation){
        this.health = health;
        size = health;
        this.orientation = orientation;
        coords = new positioner[size];
        coordFiller(position);
    }
    public void coordFiller(positioner position) {
        coords[0] = position;
        if(orientation.equals("right")) {
            for (int i = 1; i < coords.length; i++) {
                position.changeXPosition(1);
                coords[i] = position;
            }
        }
        else if(orientation.equals("up")) {
            for (int i = 1; i < coords.length; i++) {
                position.changeYPosition(1);
                coords[i] = position;
            }
        }
        else System.out.println("Error");
    }
    public positioner[] getPosition() {
        return coords;
    }
    public void mover(String orientation) {
        if(orientation.equals("right")) {
            for (positioner position : coords) {
                position.changeXPosition(1);
            }
        }
        else if(orientation.equals("left")) {
            for (positioner position : coords) {
                position.changeXPosition(-1);
            }
        }
        else if(orientation.equals("down")) {
            for (positioner position : coords) {
                position.changeYPosition(1);
            }
        }
        else if(orientation.equals("up")) {
            for (positioner position : coords) {
                position.changeYPosition(-1);
            }
        }
        else System.out.println("Error");
    }
    public String getOrientation() {
        return orientation;
    }
    public void takeDamage() {
        health--;
    }
    public boolean testAlive() {
        if(health > 0)
            return true;
        return false;
    }
}
