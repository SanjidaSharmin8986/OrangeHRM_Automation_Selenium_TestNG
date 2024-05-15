package Config;

import java.util.Random;

public class RandomPassword {
    public String password() {

       String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String LOWER = "abcdefghijklmnopqrstuvwxyz";
       String DIGITS = "0123456789";
       String SYMBOLS = "!@#$%&*-+=/?";
       String combinedChars = UPPER + LOWER + DIGITS + SYMBOLS;
       char[] upperArr=UPPER.toCharArray();
       char[] lowerArr=LOWER.toCharArray();
       char[] digitsArr=DIGITS.toCharArray();
       char[] symbolsArr=SYMBOLS.toCharArray();
       char[] combinedArr=combinedChars.toCharArray();
       Random random = new Random();
       int index1 = random.nextInt(upperArr.length);
       int index2 = random.nextInt(lowerArr.length);
       int index3 = random.nextInt(digitsArr.length);
       int index4 = random.nextInt(symbolsArr.length);
       String pass1 = String.valueOf(upperArr[index1]) + String.valueOf(lowerArr[index2]) + String.valueOf(digitsArr[index3]) + String.valueOf(symbolsArr[index4]);
       StringBuilder pass2 = new StringBuilder();
       for (int i = 0; i < 4; i++)
       {
           int index5 = random.nextInt(combinedArr.length);
           pass2.append(combinedArr[index5]);
       }

       String password = pass1.concat(String.valueOf(pass2));
       return password;
    }

}
