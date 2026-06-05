import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class progreso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class progreso extends Actor
{
    private int ancho = 200;
    private int alto = 20;

    public progreso()
    {
        actualizar(0);
    }
    public void setAncho(int nuevoAncho)
    {
        ancho = nuevoAncho;
    }
    public void actualizar(double avance)
    {
        GreenfootImage img = new GreenfootImage(ancho, alto);

        // Marco
        // Resplandor exterior
        img.setColor(new Color(255, 255, 255, 40));
        img.drawRect(0, 0, ancho - 1, alto - 1);

        // Resplandor medio
        img.setColor(new Color(255, 255, 255, 80));
        img.drawRect(1, 1, ancho - 3, alto - 3);

        // Resplandor fuerte
        img.setColor(new Color(255, 255, 255, 150));
        img.drawRect(2, 2, ancho - 5, alto - 5);

        // Núcleo brillante
        img.setColor(Color.WHITE);
        img.drawRect(3, 3, ancho - 7, alto - 7);

        // Relleno
        img.setColor(new Color(148, 0, 211));
        int relleno = (int)(avance * (ancho - 10));
        img.fillRect(5, 5, relleno, alto - 10);

        setImage(img);
    }
    
}
