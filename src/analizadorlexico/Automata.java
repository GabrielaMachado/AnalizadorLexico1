/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static analizadorlexico.AnalizadorLexico.posActual;

/**
 *
 * @author user
 */
public class Automata {

    private Character tokens[] = {'=', '(', ')', '+', '-', '*', '/', ';', '<', '>',};
    private Character au = 'x';
    private char[] palabra;
    private String isTrue = "true";
    private String isFalse = "false";
    Lexema lex;

    public Character[] leer(String texto) {
        String res = " " + texto + " ";
        int longitud = 0;
        Character ch[];
        res = res.toLowerCase();
        longitud = res.length();
        ch = new Character[longitud];
        System.out.println(res);
        for (int i = 0; i < longitud; i++) {
            ch[i] = res.charAt(i);
        }
        return ch;
    }

    /**
     * ****************************************
     * Verificamos la Expresion para ver si es un digito con el metodo de la
     * clase Character isDigit() ****************************************
     */
    public void esDigito(Character ch[]) {
        int cont = 0;
        String cualesSon = "";
        for (int i = 0; i < ch.length; i++) {
            if (au.isDigit(ch[i])) {
                cont++;
                cualesSon += ch[i].toString() + " ";
            }
        }

        Lexema out = new Lexema(cont, "Digitos", cualesSon);
        out.verTipos();
    }

    public String esEspacio(Character ch[], int pos) {

        String pal = "";
        if (ch[pos].equals(" ")) {
            for (int i = pos; i < ch.length; i++) {
                pal += ch[pos].toString();
                if (ch[pos].equals(" ")) {
                    return pal;
                }
                pos++;
            }
            return pal;
        } else {
            return pal;
        }
    }

    /**
     * ****************************************
     * Verificamos la Expresion para ver si es un digito con el metodo de la
     * clase Character isDigit() ****************************************
     */
    public Lexema esLiteralBooleana(Character ch[], int pos) {

        int posIn = pos;
        int posIn2 = pos;

        if (pos > 0 && ch[pos - 1].toString().equals(" ")) {

            palabra = isTrue.toCharArray();
            String lexema = "";

            for (int j = 0; j < palabra.length; j++) {
                if (ch[pos].equals(palabra[j])) {
                    lexema += ch[pos].toString();
                    if (lexema.equals(isTrue)) {
                        posActual = pos;
                        if (ch[pos + 1].toString().equals(" ")) {
                            pos++;
                            return lex = new Lexema(posIn , "Literal Booleana", lexema);
                        } else {
                            return null;
                        }
                    }
                } else {
                    palabra = isFalse.toCharArray();
                    lexema = "";

                    for (int i = 0; i < palabra.length; i++) {
                        if (ch[posIn].equals(palabra[i])) {
                            lexema += ch[posIn].toString();
                            if (lexema.equals(isFalse)) {
                                posActual = posIn;
                                if (ch[posIn + 1].toString().equals(" ")) {
                                    posIn++;
                                    return lex = new Lexema(pos, "Literal Booleana", lexema);
                                } else {
                                    return null;
                                }
                            }
                        } else {
                            return null;
                        }
                        posIn++;

                    }
                }
                pos++;
            }
        } else {
            return null;
        }
        return null;
    }

    /**
     * ****************************************
     * Verificamos la Expresion para ver si es un operador evaluandolo contra
     * nuestros tokens ****************************************
     */
    public void esToken(Character ch[]) {
        int ope = 0;
        String cualesSon = "";
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < tokens.length; j++) {
                if (ch[i].equals(tokens[j])) {
                    ope++;
                    cualesSon += ch[i].toString() + " ";
                }
            }
        }
//        Lexema out = new Lexema(ope, "Tokens", cualesSon);
//        out.verTipos();
    }

    /**
     * ***************************
     * Verificamos la Expresion para ver si es un identificador con el metodo de
     * la clase Cha racter isJavaIdentifierStart ***************************
     */
    public Lexema esIdentificador(Character ch[], int pos) {
        String lexema = "";
        lexema += ch[pos].toString() + " ";
        System.out.println("ch : " + pos);

        //     if (!ch[pos].toString().equals(" ")) {            
        //          while (!ch[pos + 1].equals(" ")) {
        System.out.print("." + ch[pos] + ".");
        pos++;
        posActual = pos;
        //          }

        return lex = new Lexema(pos-1, "Identificadores", lexema);
        //     } else {
        //         System.out.println("Espacio");
        //       return null;
        // }

    }

//        }
}

//                if (ch[i].equals(palabra[j])) {
//                    num++;
//                    lexema += ch[pos].toString();
//                    pos++;
//                    lex = new Lexema(0, "Literal Booleana", lexema);
//                } else {
//                    pos++;
//                    return null;
//                }s
