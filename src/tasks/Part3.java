package tasks;

/**
 * Created by DELL on 05.10.2018.
 */
public class Part3 {

    public static String convert(String string){
        char space = ' ';
        int size = string.length();
        int count1 = 0;
        int count2 = 0;
        StringBuilder stringBuilder = new StringBuilder(string);
        char [] arrayChar = string.toCharArray();
        for(int i=0;i<size;i++){
            if(arrayChar[i] == space || count1 == 0 ){
                StringBuilder current = new StringBuilder(string);
                String current_string = current.substring( count2,count2+1 ).toUpperCase();
                stringBuilder.replace( count2 , count2+1 , current_string );
            }
            count1 ++;
            count2 = count1 + 1 ;
        }
        return stringBuilder.toString() ;
    }


}
