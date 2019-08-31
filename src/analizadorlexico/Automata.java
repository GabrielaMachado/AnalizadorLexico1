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
    private String isCatch = "catch";
    private String isTry = "try";
    private String isMessage = "message";
    private String isReturn = "return";
    private String isSwitch = "switch";
    private String isWhile = "while";
    private String isBreak = "break";
    private String isCase = "case";
    private String isElse = "else";
    private String isFor = "for";
    private String isIf = "if";
    private String isDo = "do";
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
                            return lex = new Lexema(posIn, "Literal Booleana", lexema);
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

    public Lexema esEstructuraDeControl(Character ch[], int pos) {

        int posWhile = pos;
        int posBreak = pos;
        int posCase = pos;
        int posElse = pos;
        int posFor = pos;
        int posIf = pos;
        int posDo = pos;

        if (pos > 0 && ch[pos - 1].toString().equals(" ")) {

            palabra = isSwitch.toCharArray();
            String lexema = "";

            for (int j = 0; j < palabra.length; j++) {
                if (ch[pos].equals(palabra[j])) {
                    lexema += ch[pos].toString();
                    if (lexema.equals(isSwitch)) {
                        posActual = pos;
                        if (ch[pos + 1].toString().equals(" ")) {
                            pos++;
                            return lex = new Lexema(posWhile, "Estructura de control", lexema);
                        } else {
                            return null;
                        }
                    }
                } else {
                    palabra = isWhile.toCharArray();
                    lexema = "";

                    for (int i = 0; i < palabra.length; i++) {
                        if (ch[posWhile].equals(palabra[i])) {
                            lexema += ch[posWhile].toString();
                            if (lexema.equals(isWhile)) {
                                posActual = posWhile;
                                if (ch[posWhile + 1].toString().equals(" ")) {
                                    posWhile++;
                                    return lex = new Lexema(pos, "Estructura de control", lexema);
                                } else {
                                    return null;
                                }
                            }
                        } else {
                            palabra = isBreak.toCharArray();
                            lexema = "";

                            for (int k = 0; k < palabra.length; k++) {
                                if (ch[posBreak].equals(palabra[k])) {
                                    lexema += ch[posBreak].toString();
                                    if (lexema.equals(isBreak)) {
                                        posActual = posBreak;
                                        if (ch[posBreak + 1].toString().equals(" ")) {
                                            posBreak++;
                                            return lex = new Lexema(pos, "Estructura de control", lexema);
                                        } else {
                                            return null;
                                        }
                                    }
                                } else {
                                    palabra = isCase.toCharArray();
                                    lexema = "";

                                    for (int l = 0; l < palabra.length; l++) {
                                        if (ch[posCase].equals(palabra[l])) {
                                            lexema += ch[posCase].toString();
                                            if (lexema.equals(isCase)) {
                                                posActual = posCase;
                                                if (ch[posCase + 1].toString().equals(" ")) {
                                                    posCase++;
                                                    return lex = new Lexema(pos, "Estructura de control", lexema);
                                                } else {
                                                    return null;
                                                }
                                            }
                                        } else {
                                            palabra = isElse.toCharArray();
                                            lexema = "";

                                            for (int m = 0; m < palabra.length; m++) {
                                                if (ch[posElse].equals(palabra[m])) {
                                                    lexema += ch[posElse].toString();
                                                    if (lexema.equals(isElse)) {
                                                        posActual = posElse;
                                                        if (ch[posElse + 1].toString().equals(" ")) {
                                                            posElse++;
                                                            return lex = new Lexema(pos, "Estructura de control", lexema);
                                                        } else {
                                                            return null;
                                                        }
                                                    }
                                                } else {
                                                    palabra = isFor.toCharArray();
                                                    lexema = "";

                                                    for (int n = 0; n < palabra.length; n++) {
                                                        if (ch[posFor].equals(palabra[n])) {
                                                            lexema += ch[posFor].toString();
                                                            if (lexema.equals(isFor)) {
                                                                posActual = posFor;
                                                                if (ch[posFor + 1].toString().equals(" ")) {
                                                                    posFor++;
                                                                    return lex = new Lexema(pos, "Estructura de control", lexema);
                                                                } else {
                                                                    return null;
                                                                }
                                                            }
                                                        } else {
                                                            palabra = isIf.toCharArray();
                                                            lexema = "";

                                                            for (int p = 0; p < palabra.length; p++) {
                                                                if (ch[posIf].equals(palabra[p])) {
                                                                    lexema += ch[posIf].toString();
                                                                    if (lexema.equals(isIf)) {
                                                                        posActual = posIf;
                                                                        if (ch[posIf + 1].toString().equals(" ")) {
                                                                            posIf++;
                                                                            return lex = new Lexema(pos, "Estructura de control", lexema);
                                                                        } else {
                                                                            return null;
                                                                        }
                                                                    }
                                                                } else {
                                                                    palabra = isDo.toCharArray();
                                                                    lexema = "";

                                                                    for (int q = 0; q < palabra.length; q++) {
                                                                        if (ch[posDo].equals(palabra[q])) {
                                                                            lexema += ch[posDo].toString();
                                                                            if (lexema.equals(isDo)) {
                                                                                posActual = posDo;
                                                                                if (ch[posDo + 1].toString().equals(" ")) {
                                                                                    posDo++;
                                                                                    return lex = new Lexema(pos, "Estructura de control", lexema);
                                                                                } else {
                                                                                    return null;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            return null;
                                                                        }
                                                                        posDo++;
                                                                    }
                                                                }
                                                                posIf++;
                                                            }
                                                        }
                                                        posFor++;
                                                    }
                                                }
                                                posElse++;
                                            }
                                        }
                                        posCase++;
                                    }
                                }
                                posBreak++;
                            }
                        }
                        posWhile++;
                    }
                }
                pos++;
            }
        } else {
            return null;
        }
        return null;
    }

    public Lexema esSalidaDato(Character ch[], int pos) {

        int posIn = pos;

        if (pos > 0 && ch[pos - 1].toString().equals(" ")) {

            palabra = isMessage.toCharArray();
            String lexema = "";

            for (int j = 0; j < palabra.length; j++) {
                if (ch[pos].equals(palabra[j])) {
                    lexema += ch[pos].toString();
                    if (lexema.equals(isMessage)) {
                        posActual = pos;
                        if (ch[pos + 1].toString().equals(" ")) {
                            pos++;
                            return lex = new Lexema(posIn, "Salida de dato", lexema);
                        } else {
                            return null;
                        }
                    }
                } else {
                    palabra = isReturn.toCharArray();
                    lexema = "";

                    for (int i = 0; i < palabra.length; i++) {
                        if (ch[posIn].equals(palabra[i])) {
                            lexema += ch[posIn].toString();
                            if (lexema.equals(isReturn)) {
                                posActual = posIn;
                                if (ch[posIn + 1].toString().equals(" ")) {
                                    posIn++;
                                    return lex = new Lexema(pos, "Salida de dato", lexema);
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

    public Lexema esExcepcion(Character ch[], int pos) {

        int posIn = pos;

        if (pos > 0 && ch[pos - 1].toString().equals(" ")) {

            palabra = isTry.toCharArray();
            String lexema = "";

            for (int j = 0; j < palabra.length; j++) {
                if (ch[pos].equals(palabra[j])) {
                    lexema += ch[pos].toString();
                    if (lexema.equals(isTry)) {
                        posActual = pos;
                        if (ch[pos + 1].toString().equals(" ")) {
                            pos++;
                            return lex = new Lexema(posIn, "Excepción", lexema);
                        } else {
                            return null;
                        }
                    }
                } else {
                    palabra = isCatch.toCharArray();
                    lexema = "";

                    for (int i = 0; i < palabra.length; i++) {
                        if (ch[posIn].equals(palabra[i])) {
                            lexema += ch[posIn].toString();
                            if (lexema.equals(isCatch)) {
                                posActual = posIn;
                                if (ch[posIn + 1].toString().equals(" ")) {
                                    posIn++;
                                    return lex = new Lexema(pos, "Excepción", lexema);
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

        return lex = new Lexema(pos - 1, "Identificadores", lexema);
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
