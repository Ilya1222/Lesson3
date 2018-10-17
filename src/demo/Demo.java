package demo;

import tasks.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static tasks.Part1.getText;


/**
 * Created by DELL on 05.10.2018.
 */
public class Demo {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        System.out.println("Part1");
        System.out.println(Part1.convert1(getText()));
        System.out.println("****************************************************************");
        System.out.println(Part1.convert2(getText()));
        System.out.println("****************************************************************");
        System.out.println(Part1.convert3(getText()));
        System.out.println("****************************************************************");
        System.out.println(Part1.convert4(getText()));
        System.out.println("--------------------------------------------------------------------------|");

        System.out.println("Part2");
        System.out.println(Part2.covert(Part2.getText()));
        System.out.println("--------------------------------------------------------------------------|");

        System.out.println("Part3");
        System.out.println(Part3.convert("inner parameters that was deployed with the program."));
        System.out.println("--------------------------------------------------------------------------|");
        System.out.println("Part4");
        System.out.println(Part4.hash("password","SHA-256"));
        System.out.println(Part4.hash("passwort","SHA-256"));
        System.out.println(Part4.hash("passwort","SHA-256"));
        System.out.println("--------------------------------------------------------------------------|");
        System.out.println("Part5");
        for(int i=1;i<101;i++){
         String roman = Part5.toRoman(i);
          int number = Part5.toDecimal(roman);
            System.out.println(i+"-->"+roman+"-->"+number);
        }
        System.out.println("--------------------------------------------------------------------------|");
    }
}
