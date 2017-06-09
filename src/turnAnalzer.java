import java.util.ArrayList;
public class turnAnalzer {
    private static ship [] shipArray;
    private static ArrayList<positioner> shots = new ArrayList<>();
    private static ArrayList<positioner> internalIrradiatedArea;
    private static int[] gunTimer;
    public turnAnalzer(positioner shot, String shotType, ship[] shipArray, ArrayList<positioner> irradiatedArea, int[] gunTimer){
        this.shipArray = shipArray;
        internalIrradiatedArea = irradiatedArea;
        this.gunTimer = gunTimer;
        shotsCreator(shot, shotType);
        shootSys(shotType);
        irradiationCheck();
        ager();
    }
    public static void shootSys(String shotType){
        for(ship boat: shipArray) {
            if(shotType.equals("Normal Missile")) {
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
                gunTimer[0] = 4;
            }
            if(shotType.equals("QuadGun")) {
                for (positioner coords : boat.getPosition()) {
                    for(positioner shot : shots) {
                        if (coords.equals(shot)) {
                            boat.takeDamage();
                        }
                    }
                }
                gunTimer[1] = 6;
            }
            if(shotType.equals("Nuke")) {
                for (positioner coords : boat.getPosition()) {
                    for(positioner shot : shots) {
                        if (coords.equals(shot)) {
                            boat.takeDamage();
                        }
                    }
                }
                gunTimer[2] = 13;
            }
            if(shotType.equals("Aircraft Barrage")) {
                for (positioner coords : boat.getPosition()) {
                    for(positioner shot : shots) {
                        if (coords.equals(shot)) {
                            boat.takeDamage();
                        }
                    }
                }
                gunTimer[3] = 8;
            }
            //FlaK works as if you are Kim Jong Un
            if(shotType.equals("FlaK")) {
                for (positioner coords : boat.getPosition()) {
                    for(positioner shot : shots) {
                        if (coords.equals(shot)) {
                            boat.takeDamage();
                            boat.takeDamage();
                        }
                    }
                }
                gunTimer[4] = 5;
            }
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
        if(shotType.equals("Aircraft Barrage")) {
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
            boolean youFoodInaBox = false;
            for(positioner position : boat.getPosition()) {
                for (positioner spot : internalIrradiatedArea) {
                    if (position.equals(spot) && youFoodInaBox) {
                        boat.takeDamage();
                        youFoodInaBox = true;
                    }
                }
            }
        }
    }
    public static boolean canFire(String shotType, int[] gunTimes) {
        if(shotType.equals("Normal"))
            return true;
        if(shotType.equals("Flare") && gunTimes[0] == 0)
            return true;
        if(shotType.equals("QuadGun") && gunTimes[1] == 0)
            return true;
        if(shotType.equals("Nuke") && gunTimes[2] == 0)
            return true;
        if(shotType.equals("Aircraft") && gunTimes[3] == 0)
            return true;
        if(shotType.equals("FlaK") && gunTimes[4] == 0)
            return true;
        return false;
    }
    public void ager() {
        for(int time : gunTimer) {
            if(time > 0)
                time--;
        }
        for(positioner spot : internalIrradiatedArea) {
            if(spot.getAge() >= 6) {
                internalIrradiatedArea.remove(spot);
            }
            else spot.ager();
        }
    }
}
