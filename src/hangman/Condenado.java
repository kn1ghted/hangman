package hangman;

/**
 *
 * @author Edwin Calderón
 */
public class Condenado {
    // Atributos
    private String guessedWord;
    private boolean win;
    private final short GUESSES_CONDENADO = 8;
    
    // Constructores
    public Condenado(){
        this.guessedWord = "";
        this.win = false;
    }
    
    // Getters & Setters
    public String getGuessedWord() {
        return guessedWord;
    }

    public void setGuessedWord(String guessedWord) {
        this.guessedWord = guessedWord;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public short getGUESSES_CONDENADO() {
        return GUESSES_CONDENADO;
    }
    
    // Métodos adicionales
    public void addLetter(char c){
        this.guessedWord += c;
    }
}