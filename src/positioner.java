public class positioner {
    private int xcoord;
    private int ycoord;
    public positioner(){
        this(0,0);
    }
    public positioner(int x, int y){
        xcoord = x;
        ycoord = y;
    }
    public void changeXPosition(int x){
        xcoord += x;
    }
    public void changeYPosition(int y){
        ycoord += y;
    }
    public int getXPosition(){
        return xcoord;
    }
    public int getYPosition(){
        return ycoord;
    }
    public boolean equals(positioner position) {
        if(position.getXPosition() == xcoord && position.getYPosition() == ycoord) {
            return true;
        }
        return false;
    }
}
