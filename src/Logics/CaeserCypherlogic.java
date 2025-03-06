/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author tanzid
 */
public class CaeserCypherlogic {
    public CaeserCypherlogic(){}
        public static StringBuilder encipher( String text , int key ) {
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
    public static StringBuilder decipher( String etext , int key ) {
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
}
