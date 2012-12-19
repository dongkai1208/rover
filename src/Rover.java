/**
 * Created with IntelliJ IDEA.
 * User: dk
 * Date: 12-12-19
 * Time: 上午10:06
 * To change this template use File | Settings | File Templates.
 */
public class Rover {

    private int coordinateX,coordinateY,direction;

    public Rover(int coordinateX,int coordinateY,int direction){
        this.coordinateX=coordinateX;
        this.coordinateY=coordinateY;
        this.direction=direction;
    }
    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }



    public int getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void turnLeft(){  //The rover spin 90 degrees left
        if(direction==1)  {
            direction=4;
        }
        else {
           direction--;
        }
    }

    public void turnRight(){    //The rover spin 90 degrees right
         if(direction==4){
                direction=1;
         }
        else{
             direction++;
         }
    }

    public void move(){          //The rover move forward one grid point
        if(direction==1) coordinateY++;
        else if(direction==3)  coordinateY--;
        else if(direction==2)  coordinateX++;
        else if(direction==4)  coordinateX--;
    }

}

