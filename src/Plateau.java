/**
 * Created with IntelliJ IDEA.
 * User: dk
 * Date: 12-12-19
 * Time: 上午11:38
 * To change this template use File | Settings | File Templates.
 */
public class Plateau {

   private int x,y;

    public Plateau(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLegality(int x,int y){
         if(x<0||x>this.x||y<0||y>this.y)
             return false;
        else return true;
    }

}
