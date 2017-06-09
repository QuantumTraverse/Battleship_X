import java.util.ArrayList;

public class boardProduction {
    static String board;
    public static String makeBoard(ArrayList<positioner> irradiatedArea, positioner[] yourShots) { //enemy'sShips
        for(int row=10 ; row > 0 ; row-- ){
            for(int column=0 ; column < 10 ; column++ ){
                boolean youNoFindAWatch = true;
                for(positioner shot : yourShots) {
                    if ((shot.getXPosition() == column) && (shot.getYPosition() == row) && youNoFindAWatch) {
                        board += "X" + "\t";
                        youNoFindAWatch = false;
                    }
                }
                for(positioner coord : irradiatedArea) {
                    if((coord.getXPosition() == column)&&(coord.getYPosition() == row) && youNoFindAWatch)
                        board += "R"+"\t";
                    youNoFindAWatch = false;
                }

            }
            board += "\n";
        }
        return board;
    }
    public static String makeBoard(ship[] shipArray, positioner[] enemyShots) { //yourShips
        for(int row=10 ; row > 0 ; row-- ){
            for(int column=0 ; column < 10 ; column++ ){
                boolean youNoFindAWatch = true;
                for(positioner shot : enemyShots) {
                    if ((shot.getXPosition() == column) && (shot.getYPosition() == row) && youNoFindAWatch) {
                        board += "X" + "\t";
                        youNoFindAWatch = false;
                    }
                }
                for(ship boat : shipArray) {
                    for(positioner coord : boat.getPosition()) {
                        if ((coord.getXPosition() == column) && (coord.getYPosition() == row) && youNoFindAWatch) {
                            board += "B" + "\t";
                            youNoFindAWatch = false;
                        }
                    }
                }
                if(youNoFindAWatch)
                    board += "~" + "\t";
            }
            board += "\n";
        }
        return board;
    }
}
