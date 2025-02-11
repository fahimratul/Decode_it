/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Morsecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Caesercypher{
    private static StringBuilder encipher( String text , int key ) {
        StringBuilder etext = new StringBuilder();
        for( char el:text.toCharArray() ){
            if( !Character.isAlphabetic(el) )
                etext.append(el);
            else{
                if( Character.isUpperCase(el) ){
                    int curc = (int)el + key;
                    if( curc>90 )
                        curc = 64 + (curc-90);
                    etext.append( (char)curc );
                } else {
                    int curc = (int)el + key;
                    if( curc>122 )
                        curc =  96 + ( curc-122 );
                    etext.append( (char)curc );
                }
            }
        }
        return etext;
    }
    private static StringBuilder decipher( String etext , int key ) {
        StringBuilder text = new StringBuilder();
        for( char el:etext.toCharArray() ){
            if( !Character.isAlphabetic(el) )
                text.append(el);
            else{
                int curc = (int)el - key;
                if( Character.isUpperCase(el)  ){
                    if(curc<65)
                        curc = 90 - ( 64-curc );
                } else if( Character.isLowerCase(el) ){
                    if( curc<97 )
                        curc = 122 - ( 96-curc );
                }
                text.append((char)curc);
            }
        }
        return text;
    }
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
            System.out.print("Enter integer key value:-");
            int key = Integer.parseInt( br.readLine() );
            System.out.print("Enter text value to be encrypted:-");
            String text = br.readLine();
            StringBuilder etext = encipher( text , key );
            System.out.println(etext);
            System.out.println(decipher( etext.toString() , key ));

        } catch ( IOException e ) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}
