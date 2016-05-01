/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;


public class Summa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField syotekentta;
    private JTextField tuloskentta;    
    private int edellinen;
    
    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
    }
    
    @Override
    public void suorita() {
        edellinen = Integer.parseInt(syotekentta.getText());
        int luku = Integer.parseInt(syotekentta.getText());
        sovellus.plus(luku);
        tuloskentta.setText("" + sovellus.tulos());
        syotekentta.setText("");
    }

    @Override
    public void peru() {
        sovellus.miinus(edellinen);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
    
}
