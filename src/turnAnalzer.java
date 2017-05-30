import java.util.ArrayList;
public class turnAnalzer {
    private static ship [] shipArray;
    private static ArrayList<positioner> shots = new ArrayList<>();
    public turnAnalzer(positioner shot, String shotType, ship [] shipArray){
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
            if(shotType.equals("Nukes")) {
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
            //FlaK
            boat.testAlive();
        }
    }
    public void shotsCreator(positioner shot, String shotType) {
        shots.add(shot);
        if(shotType.equals("QuadGun")) {
            
        }
    }
}
