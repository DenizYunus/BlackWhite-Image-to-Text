package app;

import java.util.Arrays;
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class test{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BRIGHTMAGENTA = "\u001b[35;1m";
    public static final String ANSI_BLACK = "\u001B[30m";
    static String[] colors = {ANSI_BLUE, ANSI_CYAN, ANSI_GREEN, ANSI_PURPLE, ANSI_RED, ANSI_BRIGHTMAGENTA, ANSI_YELLOW, ANSI_BLACK};
    public static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public static Integer[] arr = new Integer[alphabet.length];
    public static Integer[] colorarr = new Integer[colors.length];


    public static void main(String[] args){
        float oneCharHeight = 16;
        float oneCharWidth = 8;

        
        BufferedImage image = null;
        try { // Resimi okuma
            File input_file = new File("a.jpg");
            image = ImageIO.read(input_file); 
            System.out.println("Image has read succesfully.");

        }   catch(IOException e) { 
            System.out.println("Error: "+e); 
        } 

        int width = image.getWidth();
        int height = image.getHeight();

        for (float y = 0; y < height; y += oneCharHeight){
            
            for (float x = 0; x < width; x+=oneCharWidth){
                int p = image.getRGB((int) x,(int) y);
                int a = (p>>16) & 0xff; 
                randomNumber(); //Rastgele harf için sayı
                randomNumberforColors(); //Rastgele renk
                if (x==0){
                    System.out.println();
                }
                if (a == 0) {
                    System.out.printf(ANSI_BLACK + alphabet[arr[0]]); // Beyaz kısımlar
                } else {
                    System.out.printf(ANSI_RESET + alphabet[arr[1]]); // Siyah kısımlar
                }
            }
        }

        /*
         * String[] words = {"mal ", "aptal ", "manyak ", "salak ", "gerizekalı ",
         * "yavşak ", "şerefsiz ", "gıcık ", "aptal "};
         * 
         * for (int i = 0; i < 100; i++){ System.out.printf(ANSI_RESET + "Ben bir ");
         * Collections.shuffle(Arrays.asList(arr)); for (int t = 0; t < arr.length;
         * t++){ System.out.printf(colors[arr[t]] + words [arr[t]]); if (t > 0)
         * System.out.printf(colors[arr[t-1]] + words [arr[t-1]]); }
         * System.out.println(colors[arr[3]] + words[arr[3]]);
         * //System.out.println(ANSI_RESET + "Ben bir " + colors[arr[0]] + words[arr[0]]
         * + colors[arr[1]] + words[arr[1]] + colors[arr[2]] + words[arr[2]] +
         * colors[arr[3]] + words[arr[3]] + colors[arr[4]] + words[arr[4]]); }
         */
    }

    public static void randomNumber() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        } Collections.shuffle(Arrays.asList(arr));
    }

    public static void randomNumberforColors(){
        for (int i = 0; i < colorarr.length; i++) {
           colorarr[i] = i;
        } Collections.shuffle(Arrays.asList(colorarr));
    }
}