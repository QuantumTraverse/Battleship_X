import java.util.ArrayList;

public class boardProduction {
    static String board;
    public static String makeBoard(ArrayList<positioner> irradiatedArea) {
        for(int row=10 ; row > 0 ; row-- ){
            for(int column=0 ; column < 10 ; column++ ){
                for(positioner coord : irradiatedArea) {
                    if((coord.getXPosition() == column)&&(coord.getYPosition() == row))
                        board += "R"+"\t";
                }

            }
            board += "\n";
        }
        return board;
    }
    public static String makeBoard(ship[] shipArray) {
        for(int row=10 ; row > 0 ; row-- ){
            for(int column=0 ; column < 10 ; column++ ){
                for(ship boat : shipArray) {
                    for(positioner coord : boat.getPosition()) {
                        if ((coord.getXPosition() == column) && (coord.getYPosition() == row))
                            board += "B" + "\t";
                        else board += "~" + "\t";
                    }
                }

            }
            board += "\n";
        }
        return board;
    }
}
