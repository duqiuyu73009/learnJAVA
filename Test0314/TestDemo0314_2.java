package Test0314;

//题目描述
//1、对输入的字符串进行加解密，并输出。
//2加密方法为:
//当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B;字母Z时则替换为a;
//当内容是数字时则把该数字加1，如O替换1，1替换2，9替换0;其他字符不做变化。
//3、解密方法为加密的逆过程。
//接口描述:
//实现接口，每个接口实现1个基本操作:
//void Encrypt (char aucPassword[], char aucResult[]):在该函数中实现字符串加密并输出
//说明:
//1、字符串以O结尾。
//2、字符串最长100个字符。

//int unEncrypt (char result[], char password[]):在该函数中实现字符串解密并输出
//说明:
//1、字符串以\O结尾。
//2、字符串最长100个字符。
//输入描述:
//输入说明
//输入一串要加密的密码输入一串加过密的密码
//输出描述:
//输出说明
//输出加密后的字符输出解密后的字符

//示例1
//输入
//abcdefg
//BCDEFGH
//输出
//BCDEFGH
//abcdefg

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.ECField;
import java.util.Scanner;

public class TestDemo0314_2 {
    public static void main ( String[] args ) throws IOException, IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader( System.in ) );
        String s ;
        while(( s = bf.readLine()) != null ) {

            char aucPassword[] = s.toCharArray();
            char result[] = bf.readLine().toCharArray();

            int length1;
            if ( aucPassword.length <= 100 ) {
                length1 = aucPassword.length;
            }
            else {
                length1 = 100;
            }
            char aucResult[] = new char[ length1 ];

            int length2;
            if ( result.length <= 100 ) {
                length2 = result.length;
            }
            else {
                length2 = 100;
            }
            char password[] = new char[ length2 ];

            Encrypt ( aucPassword , aucResult );
            unEncrypt ( result , password );
        }
        bf.close();
    }

    static void Encrypt (char aucPassword[], char aucResult[]) {

        for ( int i = 0 ; i < aucResult.length ; i++ ) {
            if ( aucPassword[ i ] >= 65 && aucPassword[ i ] <= 90 ) {
                if ( aucPassword[ i ] == 'Z' ) {
                    aucResult[ i ] = 'a';
                }
                else {
                    aucResult[ i ] = (char) (aucPassword[ i ] + 33 );
                }
            }

            else  if ( aucPassword[ i ] >= 97 && aucPassword[ i ] <= 122 ) {
                if ( aucPassword[ i ] == 'z' ) {
                    aucResult[ i ] = 'A';
                }
                else {
                    aucResult[ i ] = (char) (aucPassword[ i ] - 31 );
                }
            }

            else if ( aucPassword[ i ] >= 48 && aucPassword[ i ] <= 57 ) {
                if ( aucPassword[ i ] == '9' ) {
                    aucResult[ i ] = '0';
                }
                else {
                    aucResult[ i ] = (char) (aucPassword[ i ] + 1 );
                }
            }

            else {
                aucResult[ i ] = aucPassword[ i ];
            }
        }

        System.out.println( String.valueOf( aucResult ) );
    }

    static int unEncrypt (char result[], char password[]) {
        for ( int i = 0 ; i < password.length ; i++ ) {
            if ( result[ i ] >= 65 && result[ i ] <= 90 ) {
                if ( result[ i ] == 'A' ) {
                    password[ i ] = 'z';
                }
                else {
                    password[ i ] = (char) ( result[ i ] + 31 );
                }
            }
            else if ( result[ i ] >= 97 && result[ i ] <= 122 ) {
                if ( result[ i ] == 'a' ) {
                    password[ i ] = 'Z';
                }
                else {
                    password[ i ] = ( char )( result[ i ] - 33 );
                }
            }
            else if ( result[ i ] >= 48 && result[ i ] <= 57 ) {
                if ( result[ i ] == '0' ) {
                    password[ i ] = '9';
                }
                else {
                    password[ i ] = ( char )( result[ i ] - 1 );
                }
            }
            else {
                password[ i ] = result[ i ];
            }
        }
        System.out.println( String.valueOf( password ) );
        return 0;
    }
}
