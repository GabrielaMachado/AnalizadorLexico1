/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import analizadorlexico.Automata;
import analizadorlexico.Lexema;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class Pruebas {

    public Pruebas() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void AutomataLiteralBooleano() {
        Automata prueba = new Automata();
        //  Character [] palabra;
        //    Lexema lexe = ;
        int esperado = 1, resultado;

        if (prueba.esLiteralBooleana(transformar("yalse"), 0) != null) {
            resultado = 1;
        } else {
            resultado = 0;
        }
        assertEquals(esperado, resultado);

        //assertTrue(prueba.esLiteralBooleana(transformar("false"), 0) != null);
    }

    public Character[] transformar(String texto) {
        String res = " " + texto + " ";
        int longitud;
        Character ch[];
        res = res.toLowerCase();
        longitud = res.length();
        ch = new Character[longitud];
        for (int i = 0; i < longitud; i++) {
            ch[i] = res.charAt(i);
        }
        return ch;
    }
}
