import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: dk
 * Date: 12-12-19
 * Time: 下午3:00
 * To change this template use File | Settings | File Templates.
 */
public class RoverTest {
    public static void main(String[] args) throws IOException {

        String readTemp="";    //  storage characters from the keyboard
        boolean coordinateFlag=true;   // to identify whether the coordinate is  legality
        boolean positionFlag=true;    //   to identify whether the position is  legality
        boolean roverFlag=true;       //to identify whether to add a new rover
        String[] strTemp;
        int x,y,direction;
        Plateau plateau=null;
        Rover rover=null;
        ArrayList<Rover>  roverList=new ArrayList<Rover>();
        ArrayList<String> instructionsList=new ArrayList<String>();
        BufferedReader  br;

        System.out.println("Please input the upper-right coordinates of the plateau:\n");
        while(coordinateFlag){                //input the upper-right coordinates of the plateau

            br=new BufferedReader(new InputStreamReader(System.in));
            readTemp=br.readLine();
            strTemp= readTemp.split(" ");
            if(strTemp.length!=2){
                System.out.println("The number of upper-right coordinates is wrong,please input the right coordinates:\n");
                continue;
            }
            if(!strIsInt(strTemp[0]) || !strIsInt(strTemp[1]))  {
                System.out.println("The type of upper-right coordinates is not digit,please input the right coordinates:\n");
                continue;
            }

            if(Integer.parseInt(String.valueOf(strTemp[0]))<0 || Integer.parseInt(String.valueOf(strTemp[1]))<0){
                System.out.println("The value of upper-right coordinates is wrong,please input the right coordinates:\n");
                continue;
            }
            else {
                x= Integer.parseInt(String.valueOf(strTemp[0]));
                y=Integer.parseInt(String.valueOf(strTemp[1]));
                plateau=new Plateau(x,y);
                coordinateFlag=false;
            }

        }
        while(positionFlag){            //loop input the rover's position and instructions
            if(roverFlag){
            System.out.println("Please input the position of rovers(ordinateX,ordinateY,direction):\n");
            }
            br=new BufferedReader(new InputStreamReader(System.in));

                 readTemp=br.readLine();
            strTemp= readTemp.split(" ");
                 if(readTemp.trim().equals("q") || readTemp.trim().equals("Q")){
                     positionFlag=false;
                     continue;
                 }
                if(strTemp.length!=3){
                    System.out.println("The number of rover position is wrong,please input the right position:\n");
                    roverFlag=false;
                    continue;
                }
                if(!strIsInt(strTemp[0]) || !strIsInt(strTemp[1])){
                    System.out.println("The type of rover position is not digit,please input the right position:\n");
                    roverFlag=false;
                    continue;
                }
                if(!plateau.isLegality(Integer.parseInt(strTemp[0]),Integer.parseInt(strTemp[1]))){
                    System.out.println("The value of rover coordinates is wrong,please input the right position:\n");
                    roverFlag=false;
                    continue;
                }
                if(!legalityOfDirection(strTemp[2])){
                    System.out.println("The direction of rover is wrong,please input the right coordinates(N,E,S,W):\n");
                    roverFlag=false;
                    continue;
                }
            roverFlag=true;
            x=  Integer.parseInt(strTemp[0]);
            y= Integer.parseInt(strTemp[1]);
            direction=Util.getIntByChar(strTemp[2].toCharArray()[0]);
            rover=new Rover(x,y,direction);
            roverList.add(rover);

            System.out.println("Please input the instructions:\n");
            br=new BufferedReader(new InputStreamReader(System.in));
            readTemp=br.readLine();
            while(!legalityOfInstructions(readTemp)){
                  System.out.println("The instructions include valid letter,please input the correct instructions.\n");
                  br=new BufferedReader(new InputStreamReader(System.in));
                  readTemp=br.readLine();
            }
            instructionsList.add(readTemp);
        }

        System.out.println("Now,the rovers' position is:\n");
        for(int i=0;i<roverList.size();i++){                   //  loop output the rover's position
           Rover roverTemp= roverList.get(i);
           char[] instructionTemp=instructionsList.get(i).toCharArray();
            for(int j=0;j<instructionTemp.length;j++){
               if(instructionTemp[j]=='L')   {
                   roverTemp.turnLeft();
               }
               else if(instructionTemp[j]=='R'){
                    roverTemp.turnRight();
               }
               else if(instructionTemp[j]=='M'){
                   roverTemp.move();
               }

            }
            System.out.print(roverTemp.getCoordinateX()+" "+roverTemp.getCoordinateY()+" "+Util.getCharByInt(roverTemp.getDirection())+"\n");
        }
    }
    public static boolean legalityOfDirection(String str){      //Judge the direction of rover is legality or not
        if(str.equals("N")|| str.equals("E")|| str.equals("S")|| str.equals("W")) {
            return true;
        }
        return false;
    }
    public static boolean legalityOfInstructions(String instructions){    //judge the instructions is legality or not
           boolean flag=true;
           char[] instructionsOfChar=instructions.toCharArray();
           for(int i=0;i<instructionsOfChar.length;i++){
                 if(!(instructionsOfChar[i]=='L'||instructionsOfChar[i]=='M'||instructionsOfChar[i]=='R')){
                      flag=false;
                      break;
                 }
           }
        return flag;
    }
    public static boolean strIsInt(String str){    //to determine whether a character is digit or not
        try{
            Integer.parseInt(str);
        }
        catch   (NumberFormatException   nfe) {
            return false;
        }
        return true;
    }
}
