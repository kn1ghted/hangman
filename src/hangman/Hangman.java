package hangman;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Edwin Calderón
 */
public class Hangman {

    public static void main(String[] args) throws IOException {
        
        //Inicio del juego
        Verdugo verdug = new Verdugo();
        Condenado conde = new Condenado();
        boolean continuar = true;
        // Ciclo principal
        do {
            //Verdugo define la palabra (condenado no debe ver)
            String word = JOptionPane.showInputDialog(null, "Verdugo ingresa palabra (Condenado no debe ver):",
                                                        "Turno del Condenado", JOptionPane.QUESTION_MESSAGE);
            //Se verifica que la palabra no este vacía
            if(verdug.emptyWord(word)){
                System.out.println("Palabra no puede estar vacía!");
                continue;
            }
            //Se verifica que la palabra no tenga números
            if(verdug.numInWord(word)){
                System.out.println("Palabra tiene numeros!");
                continue;
            }
            //Se eliminan las letras acentuadas
            word = verdug.avoidAccent(word);
            //Se transforma toda la palabra a uppercase
            word = word.toUpperCase();
            //Se guarda la palabra
            verdug.setChosenWord(word);
            
            //Se inicializan los parámetros del juego
            JOptionPane.showMessageDialog(null, "Que empiece el juego!");
            
            // crear un frame o ventana
            JFrame f = new JFrame("Imagen Ahorcado");
            
            //Cantidad de letras en la palabra
            String adivinada = "";
            for (int i = 0; i < verdug.giveWordLength(); i++) {
                adivinada += "_";
            }
            String letrasDadas = "";
            conde.setGuessedWord(letrasDadas);
            short intentos = conde.getGUESSES_CONDENADO();
            
            
            
            JLabel pcilabel = null;
            
            
//            if(intentos==8){
//                pcilabel = new JLabel(new ImageIcon("img/hangman.png"));
//                hp.add(pcilabel);
//                f.add(hp);
//                f.setVisible(true);
//            }
            
            //Mientras el condenado aún tenga intentos disponibles...
            while(intentos > 0){
                // crear un panel para el agregar al frame y lo dimensiona
                HangedPanel hp = new HangedPanel(intentos);
                f.setSize(450,450);
                // crear el objeto label con la imagen segun intento
                pcilabel = new JLabel(new ImageIcon(hp.getImagenIntento()));
                // agregar el label al panel
                hp.add(pcilabel);
                // agregar el panel al frame
                f.add(hp);
                // desplegar ventana
                //f.repaint();
                f.setVisible(true);
                
                String guess = JOptionPane.showInputDialog(null, adivinada + 
                                                "\n Numero de intentos: " + intentos +
                                                "\n Letras dadas: " + letrasDadas +
                                                "\n TIP: ingrese letras en mayúscula"
                                                , "Turno del Condenado", JOptionPane.QUESTION_MESSAGE);
                //Añade letra a letras escogidas
                char letra = guess.charAt(0);
                conde.addLetter(letra);
                letrasDadas = conde.getGuessedWord();
                //Si la letra está en la palabra, se muestra letra en todas sus posiciones
                String tmp = verdug.buscaColoca(letra, adivinada, word);
                //Si la letra no está, decrementa número de intentos
                if(tmp.equals(adivinada))
                    intentos -= 1;
                else
                    adivinada = tmp;                
                //Verifica si condenado ganá
                if(adivinada.equals(word)){
                    conde.setWin(true);
                    verdug.setWin(false);
                    break;
                }
                if (intentos == 0){
                    verdug.setWin(true);
                    conde.setWin(false);
                    break;
                }
               
            }
            
            if(verdug.isWin())
                JOptionPane.showMessageDialog(null, "VERDUGO GANA! la palabra era: " + word);
            if(conde.isWin())
                JOptionPane.showMessageDialog(null, "CONDENADO GANA! la palabra era: " + word);
            
            int c = JOptionPane.showConfirmDialog(null,
             "Continuar", "¿Desea jugar otra vez?", JOptionPane.YES_NO_OPTION);
            
            if(c == 1)
                continuar = false;
        } while (continuar);
        System.exit(0);        
    }
}