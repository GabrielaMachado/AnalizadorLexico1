/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

/**
 *
 * @author user
 */
public class Lexema {

  

        private int cont;
        private String tipo;
        private String token;

        public Lexema(int cont, String tipo, String token) {
            setCont(cont);
            setTipo(tipo);
            setToken(token);
        }

        public void setCont(int cont) {
            this.cont = cont;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getCont() {
            return cont;
        }

        public String getTipo() {
            return tipo;
        }

        public String getToken() {
            return token;
        }

        public void verTipos() {
            System.out.println("Los " + getTipo() + " son " + getCont() + " '" + getToken() + "'");
        }
    

}
