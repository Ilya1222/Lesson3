package tasks;

import java.io.*;

/**
 * Created by DELL on 05.10.2018.
 */
public class Part2 {
   public static String getText() throws IOException {
       File file = new File("RandomText.txt");
       int size =(int) file.length();
       FileReader fileReader = new FileReader(file);
       char [] arrayChar = new char[size];
       fileReader.read(arrayChar);
       String text=String.valueOf(arrayChar);
       return text;
   }

   public static String covert(String string){
       char arr[] = string.toCharArray();
       for (int i = 0; i < arr.length; i++) {
           if (arr[i] > 0 && arr[i] < 65) {
               arr[i] = ' ';
           }
       }
       String newString = String.valueOf(arr).replaceAll("  "," ") +" ";
       StringBuilder minS = new StringBuilder("Min: ");
       StringBuilder maxS = new StringBuilder("Max: ");
       int min = 100;
       int max = 1;
       int current_min  = 0;
       int current_max = 0;
       int count = 0;
       int word_start = 0;
       int word_end = 0;
       int size_array = newString.length();
       char space = ' ';
       char [] array  =  newString.toCharArray();
       for( int i = 0 ; i < size_array ; i++ ){
           count ++;
           if( array[i] == space ){
               word_end = count;
           }
           if( word_end > word_start ){
               StringBuilder stringBuilder = new StringBuilder(newString);
               String str =stringBuilder.substring(word_start,word_end-1);
               current_min = str.length();
               current_max = str.length();
               if( ( current_min < min ) && ( current_min>0 ) ){
                   min = current_min;
                   minS = new StringBuilder("Min: ");
               }
                if( ( current_min == min ) && ( current_min>0 ) ) {
                   minS.append( ", " + str );
               }
               if( current_max > max ){
                   max = current_max ;
                   maxS = new StringBuilder("Max: ");
               }
               if( current_max == max ){
                   maxS.append(", " + str);
               }
               word_start = word_end;
           }

       }
       System.out.println(maxS.delete(5,6).toString());
       return minS.delete(5,6).toString();


   }
}
