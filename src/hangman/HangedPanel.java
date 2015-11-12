package hangman;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JPanel;

/**
 *
 * @author Edwin Calderon
 */
public class HangedPanel extends JPanel{
    // Atributos
    private BufferedImage imagenIntento;
    private String ruta;
    
    //Constructor con generacion de excepcion
    public HangedPanel() throws IOException{
        this.imagenIntento = null;
    }
    
    public HangedPanel(String ruta) throws IOException{
        this.imagenIntento = ImageIO.read(new File(ruta));
    }
    
    // Constructor que usa el intento
    public HangedPanel(int intento) throws IOException{
        String nuevaRuta = "img/";
        switch(intento){
            case 8:
                nuevaRuta += "fallo01.png";
                break;
            case 7:
                nuevaRuta += "fallo02.png";
                break;
            case 6:
                nuevaRuta += "fallo03.png";
                break;
            case 5:
                nuevaRuta += "fallo04.png";
                break;
            case 4:
                nuevaRuta += "fallo05.png";
                break;
            case 3:
                nuevaRuta += "fallo06.png";
                break;
            case 2:
                nuevaRuta += "fallo07.png";
                break;
            case 1:
                nuevaRuta += "fallo08.png";
                break;
        }
        this.ruta = nuevaRuta;
        this.imagenIntento = ImageIO.read(new File(ruta));
    }
    
    // Getters & Setters
    public BufferedImage getImagenIntento() {
        return imagenIntento;
    }

    public void setImagenIntento(BufferedImage imagenIntento) {
        this.imagenIntento = imagenIntento;
    }
    
    public void setImagenIntentoFile(String ruta) throws IOException{
        this.imagenIntento = ImageIO.read(new File(ruta));
    }
    
    // Metodos adicionales
    public void nuevaRuta(int numeroIntento) throws IOException{
        String nuevaRuta = "img/";
        switch(numeroIntento){
            case 8:
                nuevaRuta += "fallo08.png";
                break;
            case 7:
                nuevaRuta += "fallo07.png";
                break;
            case 6:
                nuevaRuta += "fallo06.png";
                break;
            case 5:
                nuevaRuta += "fallo05.png";
                break;
            case 4:
                nuevaRuta += "fallo04.png";
                break;
            case 3:
                nuevaRuta += "fallo03.png";
                break;
            case 2:
                nuevaRuta += "fallo02.png";
                break;
            case 1:
                nuevaRuta += "fallo01.png";
                break;
        }
        this.ruta = nuevaRuta;
        this.setImagenIntentoFile(ruta);
    }
    
    public void pintar(Graphics g){
        g.drawImage(imagenIntento, 0, 0, null);
    }
    
    public Dimension getPreferredSize() {
        if (imagenIntento == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(imagenIntento.getWidth(null), imagenIntento.getHeight(null));
       }
    }
}