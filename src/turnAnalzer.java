import java.util.ArrayList;
public class turnAnalzer {
    private static ship [] shipArray;
    private static ArrayList<positioner> shots = new ArrayList<>();
    public turnAnalzer(positioner shot, String shotType, ship[] shipArray){
        this.shipArray = shipArray;
        shotsCreator(shot, shotType);
        shootSys(shotType);
    }
    public static void shootSys(String shotType){
        for(ship boat: shipArray) {
            if(shotType.equals("Normal")) {
                for (positioner coords : boat.getPosition()) {
                    for(positioner shot : shots) {
                        if (coords.equals(shot)) {
                            boat.takeDamage();
                        }
                    }
                }
            }
            if(shotType.equals("Flare")) {
                for (positioner coords : boat.getPosition()) {
                    for(positioner shot : shots) {
                        if (coords.equals(shot)) {
                            boat.takeDamage();
                        }
                    }
                }
            }
            if(shotType.equals("QuadGun")) {
                for (positioner coords : boat.getPosition()) {
                    for(positioner shot : shots) {
                        if (coords.equals(shot)) {
                            boat.takeDamage();
                        }
                    }
                }
            }
            if(shotType.equals("Nuke")) {
                for (positioner coords : boat.getPosition()) {
                    for(positioner shot : shots) {
                        if (coords.equals(shot)) {
                            boat.takeDamage();
                        }
                    }
                }
            }
            if(shotType.equals("Aircraft")) {
                for (positioner coords : boat.getPosition()) {
                    for(positioner shot : shots) {
                        if (coords.equals(shot)) {
                            boat.takeDamage();
                        }
                    }
                }
            }
            //FlaK doesn't do anything unless you are Kim Jong Un
            //if(!boat.testAlive()) {
                //create pop-up window declaring boat sunk
            //}
        }
    }
    public void shotsCreator(positioner shot, String shotType) {
        shots.add(shot);
        if(shotType.equals("QuadGun")) {
            shot.changeXPosition(1);
            shots.add(shot);
            shot.changeYPosition(1);
            shots.add(shot);
            shot.changeXPosition(-1);
            shots.add(shot);
        }
        if(shotType.equals("Nuke")) {
            shots.remove(0);
            shot.changeXPosition(-2);
            shot.changeYPosition(-2);
            for(int i = -2; i <= 2; i++) {
                for(int i = -2; i <= 2; i++) {
                    shots.add(shot);
                    shot.changeXPosition(1);
                }
                shot.changeYPosition(1);
            }
        }
        if(shotType.equals("Aircraft")) {
            shots.remove(0);
            shot.changeXPosition(-2);
            shot.changeYPosition(-1);
            for(int i = -1; i <= 1; i++) {
                for(int i = -2; i <= 2; i++) {
                    if(Math.random() > 0.5) {
                        shots.add(shot);
                    }
                    shot.changeXPosition(1);
                }
                shot.changeYPosition(1);
            }
        }
    }
}
