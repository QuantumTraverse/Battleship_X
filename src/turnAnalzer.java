public class turnAnalzer {
<<<<<<< HEAD
    private static ship [] shipArray;
    public turnAnalzer(positioner shot, String shotType, ship [] shipArray){
        this.shipArray = shipArray;
        shootSys(shot, shotType);
    }
    public static void shootSys(positioner shot, String shotType){
        for(ship boat: shipArray) {
            if(shotType.equals("Normal")) {
                for (positioner coords : boat.getPosition()) {
                    if (coords.equals(shot)) {
                        boat.takeDamage();
                    }
                }
            }
            if(shotType.equals("Flare")) {
                for (positioner coords : boat.getPosition()) {
                    if (coords.equals(shot)) {
                        boat.takeDamage();
                    }
                }
            }
            if(shotType.equals("QuadGun")) {
                for (positioner coords : boat.getPosition()) {
                    if (coords.equals(shot)) {
                        boat.takeDamage();
                    }
                    shot.changeXPosition(1);
                    if (coords.equals(shot)) {
                        boat.takeDamage();
                    }
                    shot.changeYPosition(1);
                    if (coords.equals(shot)) {
                        boat.takeDamage();
                    }
                    shot.changeYPosition(-1);
                    if (coords.equals(shot)) {
                        boat.takeDamage();
                    }
                    shot.changeXPosition(-1);
                }
            }
            if(shotType.equals("Aircraft")) {
                for (positioner coords : boat.getPosition()) {
                    if (coords.equals(shot)) {
                        boat.takeDamage();
                    }
                }
            }
            //Nukes
            //FlaK
        }
    }
=======
//
//    public turnAnalzer(positioner shot, String shotType, ship [] shipArray){
//        shootSys();
//    }
//    public static shootSys(){
//        for(ship boat: shipArray)
//    }
>>>>>>> origin/master
}
