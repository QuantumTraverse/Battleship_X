import java.util.ArrayList;
public class turnAnalzer {
    private static ship [] shipArray;
    private static ArrayList<positioner> shots = new ArrayList<>();
    private static ArrayList<positioner> internalIrradiatedArea;
    public turnAnalzer(positioner shot, String shotType, ship[] shipArray, ArrayList<positioner> irradiatedArea){
        this.shipArray = shipArray;
        internalIrradiatedArea = irradiatedArea;
        shotsCreator(shot, shotType);
        shootSys(shotType);
        irradiationCheck();
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
                for(int k = -2; k <= 2; k++) {
                    shots.add(shot);
                    internalIrradiatedArea.add(shot);
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
                for(int k = -2; k <= 2; k++) {
                    if(Math.random() > 0.5) {
                        shots.add(shot);
                    }
                    shot.changeXPosition(1);
                }
                shot.changeYPosition(1);
            }
        }
    }
    public void irradiationCheck() {
        for(ship boat : shipArray) {
            for(positioner position : boat.getPosition())
                for(positioner spot : internalIrradiatedArea) {
                    if (position.equals(spot)) {
                        boat.takeDamage();
                    }
                }
        }
    }
}
