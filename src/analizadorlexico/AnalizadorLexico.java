/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import static analizadorlexico.FrmPrincipal.prueba;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class AnalizadorLexico {

    /**
     * @param args the command line arguments
     */
    public static int posActual = 0;
    public static String miniPalabra = "";
    public static Character[] miniCadena;
    public static int posInicial = 0;
    public static ArrayList<Lexema> arrayLexema = new ArrayList<>();
    static Lexema lexema;
    

    public static void main(String[] args) {
        FrmPrincipal frm = new FrmPrincipal();
        frm.setVisible(true);
        
    }

    public static void verificarAutomatas(Character[] cadena) {
        while (cadena.length > posInicial) {
         //   miniPalabra = prueba.esEspacio(cadena, posInicial);
         //   miniCadena = prueba.leer(miniPalabra);
            lexema = (prueba.esLiteralBooleana(cadena, posInicial));
            if (lexema != null) {
                posInicial = posActual + 1;
                arrayLexema.add(lexema);
                verificarAutomatas(cadena);
            } else {
                lexema = prueba.esIdentificador(cadena, posInicial);
                if (lexema != null) {
                    posInicial = posActual;
                    arrayLexema.add(lexema);
                } else {
                    System.out.println("ERROR");
                    verificarAutomatas(cadena);
                }
            }
        }
    }
}
