/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingamebracketsen;

import java.util.Scanner;

/**
 *
 * @author Thomas
 */
public class CodinGameBracketsEn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        for (int i = 0; i < N; i++) {
            String expression = in.nextLine();
            expression = expression.replaceAll("[^<>()\\[\\]\\{\\}]","");
            expression = expression.replaceAll("[<>]","1");
            expression = expression.replaceAll("[()]","2");
            expression = expression.replaceAll("[\\[\\]]","3");
            expression = expression.replaceAll("[\\{\\}]","4");
//            System.out.println(expression);
//            System.out.println(ellenoriz(expression));
            System.out.println(csekkol(expression));
        }
    }
    
    static boolean csekkol(String mit){
        boolean vissza = true;
        char [] signs = {'1','2','3','4'};
        for(int i=0; i<signs.length; i++)
            if(szamol(mit,signs[i]) % 2 != 0)
                vissza = false;
        return vissza;
    }
    
    static int szamol(String miben, char mit){
        int darab =0;
        for(int i=0; i<miben.length(); i++)
            if(miben.charAt(i) == mit)
                darab++;
        return darab;
    }
    
    static boolean ellenoriz(String mit){
//        System.out.println(mit);
        boolean vissza = false;
        if(mit.length() == 0)
            vissza = true;
        if (mit.length() == 2) {
            if (mit.charAt(0) == mit.charAt(1)) 
                vissza = true;
            }
        else {
            if (mit.length() > 2) {
                if (mit.lastIndexOf(mit.charAt(0) + "") > 0) {
//                    System.out.println("->"+mit.substring(1+mit.lastIndexOf(mit.charAt(0) + "")));
                    vissza = ellenoriz(mit.substring(1+mit.lastIndexOf(mit.charAt(0) + "")))
                          && ellenoriz(mit.substring(1, mit.lastIndexOf(mit.charAt(0) + "")));
                          
                }
                else 
                    vissza = false;
                
            }
        }
//        System.out.println(mit+" ? "+vissza);
        return vissza;    
    }
    
    
}
