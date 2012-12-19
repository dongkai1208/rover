import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dk
 * Date: 12-12-19
 * Time: 下午2:00
 * To change this template use File | Settings | File Templates.
 */
public class Util {
    private static Map<Character,Integer>  charToInt=new HashMap<Character, Integer>();  //change type of char to type of Integer
    private static Map<Integer,Character>  intToChar=new HashMap<Integer, Character>();   //change type of Integer to type of char
   static{
        charToInt.put('N',1);
        charToInt.put('E',2);
        charToInt.put('S',3);
        charToInt.put('W',4);

         intToChar.put(1,'N');
        intToChar.put(2,'E');
        intToChar.put(3,'S');
        intToChar.put(4,'W');
}
    public static int getIntByChar(char c){
           return charToInt.get(c);
    }
    public static char getCharByInt(int i){
           return intToChar.get(i);
    }
}

