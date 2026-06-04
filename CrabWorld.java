import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{
    private progreso barra;
    private int tiempo = 0;
    private int tiempoMeta = 1800;
    private int score = 0;
    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public CrabWorld()
    {    
        super(560, 560, 1); 
        prepare();
        barra = new progreso();
        addObject(barra,110,17);
        showText("Score: " + score, 500, 15);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Lobster lobster = new Lobster();
        addObject(lobster,274,55);
        Crab crab = new Crab();
        addObject(crab,280,466);
        for (int x=0; x<30; x++){
            for (int y=0; y<20; y++){
                out out = new out();
                addObject(out,x*50,550+y);
            }
        }
    }
    
    public void act()
    {
        if(!getObjects(Crab.class).isEmpty())
        {
            tiempo++;
    
            double avance =
                (double) tiempo / tiempoMeta;
    
            barra.actualizar(avance);
        }
        showText("Score: " + score, 500, 15);
    }
    public void sumarScore()
    {
        score++;
    }
    public void gameOverr()
    {
        GreenfootImage fondo = getBackground();
    
        fondo.setColor(new Color(0,0,0,180));
        fondo.fillRect(0,0,560,560);
    
        addObject(new gameOver(), 280, 280);
    }
}
