package tasks;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Created by DELL on 06.10.2018.
 */
public class Part1 {
    public static String getText() throws IOException {
        File file = new File("Emails.txt");
        int size =(int) file.length();
        FileReader fileReader = new FileReader(file);
        char [] arrayChar = new char[size];
        fileReader.read(arrayChar);
        String text=String.valueOf(arrayChar);
        return text;
    }

    public static String convert1(String str){
        boolean flag = false;
        boolean flag1 = false;
        String string =  " " + str.substring(17,str.length()).replaceAll(" ","*") + " ";
        String finish_string=string.replaceAll("\r\n"," ").replaceAll("  "," ");
        int count=0;
        int start=0;
        int end=0;
        int enter=0;
        int exit=1;
        StringBuilder convert = new StringBuilder("");
        char [] chars =finish_string.toCharArray();
        for(int i=0;i<chars.length;i++){
            count++;
            if( chars[i] == ' '){
                start = count;
                enter ++;
                flag = true;
            }
            if( chars[i] == ';' ){
                end = count;
                exit ++;
                flag1 = true;

            }
            if( enter < exit && start < end && flag == true && flag1 == true ){
                StringBuilder newStringB = new StringBuilder(finish_string);
                String current = newStringB.substring(start,end-1);
                convert.append( current + "-->" );
                 flag = false;
                 flag1 = false;
                 enter = 1;
                 exit = 0;

            }
            if( enter > exit && start > end && flag == true && flag1 == true ){
                StringBuilder newStringB = new StringBuilder( finish_string );
                String current =newStringB.substring( end , start-1 );
                convert.append( current + "\n" );
                flag1 = false;
                flag = true;
                enter = 0;
                exit = 1;
            }
        }

        return convert.toString();
    }


     public static String convert2(String str){
         String string = str.substring(17,str.length()).replaceAll(" ",";") + "0 ";
         String finish_string=string.replaceAll("\r\n","0 ").replaceAll("  "," ");
         StringBuilder convert = new StringBuilder("");
         char [] chars =finish_string.toCharArray();
         boolean flag = false;
         int count = 0;
         int space = 0;
         int dot = 0;
         int start_name = 0;
         int end_name = 0;
         int start_surname = 0;
         int end_surname = 0;
         int start_email = 0;
         int end_email = 0;
         for(int i = 0 ; i<chars.length ; i++){
             count ++;
             if( chars [i] == ' '){
                 space ++;
             }
             if( chars[i] == ';' && space > dot ){
                 start_name = count;
                 dot ++;
             }
            else if( chars[i] == ';' &&  space == dot ){
                 end_name = count;
                 start_surname = count;
                 dot ++;
             }
             else if(chars[i]==';'&& space<dot){
                 end_surname=count;
                 start_email=count;
                 dot++;
                 space++;
             }
             if(chars[i]=='0' && space>0){
                 end_email=count;
                 flag=true;
                 space++;
             }
             if(dot==space && flag==true){
                 flag=false;
                 StringBuilder stringBuilder_name = new StringBuilder(finish_string);
                 String current_name =stringBuilder_name.substring(start_name,end_name-1);
                 StringBuilder stringBuilder_surname = new StringBuilder(finish_string);
                 String current_surname =stringBuilder_surname.substring(start_surname,end_surname-1);
                 StringBuilder stringBuilder_email = new StringBuilder(finish_string);
                 String current_email =stringBuilder_email.substring(start_email,end_email-1);
                 convert.append(current_surname+" "+current_name+"(email "+current_email+")\n");
             }



         }
        return convert.toString();
     }
      public static String convert3(String str){
          String string =str.substring(17,str.length()).replaceAll("\r\n"," 0 ");
          String finish_string=string.substring(0,string.length()-27).replaceAll("  "," ")+" 0";
          StringBuilder mailru = new StringBuilder("mail.ru -->");
          StringBuilder mailua = new StringBuilder("mail.ua -->");
          StringBuilder google = new StringBuilder("google.com-->");
          StringBuilder convert = new StringBuilder("");
          char [] chars=finish_string.toCharArray();
          boolean flag=false;
          boolean flag_space=false;
          int start_login=0;
          int end_login=0;
          int start_mail=0;
          int end_mail=0;
          int count=0;
          int space=0;
          int dot=0;
          for(int i=0;i<chars.length;i++){
              count++;
              if(chars[i]==' ' && flag==true){
                  end_mail=count;
                  flag=false;
              }
              else if(chars[i]==' ' && flag_space==true ){
                  start_login=count;
                  space++;
                  flag_space=false;
              }
              if(chars[i]==';' && space>dot){
                  end_login=count;
                  dot++;
              }
              if (chars[i]=='@'){
                  start_mail=count;
                  flag=true;
              }
              if(chars[i]=='0'&&space>0){
                  flag_space=true;
                  StringBuilder stringBuilder_login = new StringBuilder(finish_string);
                  String current_login =stringBuilder_login.substring(start_login,end_login-1);
                  StringBuilder stringBuilder_email = new StringBuilder(finish_string);
                  String current_email =stringBuilder_email.substring(start_mail,end_mail-1);

                  if(current_email.contentEquals("mail.ru")){
                      mailru.append(","+current_login);
                  }
                   if(current_email.contentEquals("google.com")){
                      google.append(","+current_login);
                  }
                  if(current_email.contentEquals("mail.ua"))  {
                      mailua.append(","+current_login);
                  }

              }
              else  if(chars[i]=='0'){
                  flag_space=true;
              }


          }

        convert.append(new String(mailru+"\n"+google+"\n"+mailua+"\n").replaceAll(">,",">"));

          return convert.toString();


      }

      public static String convert4(String str){
          String string ="0"+str.substring(19,str.length()).replaceAll("\r\n","230")+"\r\n ".replaceAll("\r\n","23");
          String finish_string=string.replaceAll("  "," ");
          StringBuilder convert = new StringBuilder("Login;Name;Email;Password\r\n");
          char []chars=finish_string.toCharArray();
          int count=0;
          int sub_start=0;
          int sub_end=0;
          for(int i =0;i<chars.length;i++){
              count++;
              if(chars[i]=='0'){
                  sub_start=count;
              }
              if(chars[i]=='2'){
                  sub_end=count;
              }
              if(chars[i]=='3'){
                  Random random = new Random();
                  int a=random.nextInt(9);
                  int b=random.nextInt(9);
                  int c=random.nextInt(9);
                  int d=random.nextInt(9);
                  StringBuilder newStringB = new StringBuilder(finish_string);
                  String current =newStringB.substring(sub_start,sub_end-1);
                  convert.append(current+";"+a+""+b+""+c+""+d+""+"\n");
              }


          }
          return convert.toString();
      }


}
