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
    public int getXPosition(){
        return xcoord;
    }
    public int getYPosition(){
        return ycoord;
    }
}
