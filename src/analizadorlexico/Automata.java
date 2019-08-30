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
        String res = texto;
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

    /**
     * ****************************************
     * Verificamos la Expresion para ver si es un digito con el metodo de la
     * clase Character isDigit() ****************************************
     */
    public Lexema esLiteralBooleana(Character ch[], int pos) {

        palabra = isTrue.toCharArray();
        String lexema = "";

        for (int j = 0; j < palabra.length; j++) {
            if (ch[pos].equals(palabra[j])) {
                lexema += ch[pos].toString();
                if (lexema.equals(isTrue)) {
                    posActual = pos;
                    if (ch[pos + 1].toString().equals(" ")) {
                        pos++;
                        return lex = new Lexema(pos - 1, "Literal Booleana", lexema);
                    } else {
                        return null;
                    }
                }
            } else {
                return null;
            }
            pos++;
        }
        Lexema out = new Lexema(pos, "Literal booleana", lexema);
        out.verTipos();
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
        if (ch[pos].equals(" ")) {
            while (ch[pos + 1].equals(" ")) {
                pos++;
                posActual = pos;
            }
            return lex = new Lexema(pos, "Identificadores", lexema);
        } else {
            return null;
        }

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
