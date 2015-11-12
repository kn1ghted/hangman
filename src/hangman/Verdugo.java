package hangman;

import javax.swing.JOptionPane;

/**
 *
 * @author Edwin Calderón
 */
public class Verdugo {
    // Attributes
    private String chosenWord;
    private boolean win;
    
    // Constructors
    public Verdugo(){
        this.chosenWord = "";
        this.win = false;
    }

    public Verdugo(String chosenWord) {
        this.chosenWord = chosenWord;
        this.win = false;
    }
    
    // Getters & Setters
    public String getChosenWord() {
        return chosenWord;
    }

    public void setChosenWord(String chosenWord) {
        this.chosenWord = chosenWord;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
    
    // Métodos adicionales
    // Devuelve el largo de la palabra
    public short giveWordLength(){
        return (short)this.chosenWord.length();
    }
    
    // Revisión si la palabra es vacía
    public boolean emptyWord(String w){
        int numeroCaracteres = w.length();
        return (numeroCaracteres == 0);
    }
    
    // Revisión si la palabra tiene numeros
    public boolean numInWord(String w){
        boolean numerosPalabra = false;
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            int test = Character.getNumericValue(c);
            if(test == -1 || (test >= 0 && test <= 9)){
                numerosPalabra = true;
            }    
        }
        return numerosPalabra;
    }
    
    // Sustituye letras acentuadas
    public String avoidAccent(String w){
        String noAccent = "";
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if(c == 'á')
                c = 'a';
            if(c == 'é')
                c = 'e';
            if(c == 'í')
                c = 'i';
            if(c == 'ó')
                c = 'o';
            if(c == 'ú')
                c = 'u';
            noAccent += c;
        }
        return noAccent;
    }
    
    // Busca y coloca un caracter en la palabra
    public String buscaColoca(char l, String palabraC, String palabraV){
        String res = "";
        for (int i = 0; i < palabraV.length(); i++) {
            char tmp;
            if(l == palabraV.charAt(i)){
                tmp = palabraV.charAt(i);
            } else tmp = palabraC.charAt(i);
            res += tmp;
        }
        return res;
    }
}