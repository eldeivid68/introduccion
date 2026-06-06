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
    private int fase = 1;
    private boolean transicion = false;
    private int contadorTransicion = 0;
    private boolean victoria = false;
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
            tiempo += 2;
    
            double avance =
                (double) tiempo / tiempoMeta;
    
            barra.actualizar(avance);
        }
        if(tiempo >= tiempoMeta && fase == 1)
        {
            transicion = true;
            
            removeObjects(getObjects(Lobster.class));
            removeObjects(getObjects(Bullet.class));
            removeObjects(getObjects(Bullet_2.class));
            removeObjects(getObjects(Bullet_3.class));
            
            GreenfootImage fondo = getBackground();
            
            fondo.setColor(new Color(0,0,0,180));
            fondo.fillRect(0,0,560,560);
            
            addObject(new NivelCompletado(), 280, 280);
        }
        if(tiempo >= tiempoMeta && fase == 2 && !transicion)
        {
            victoria();
        }
        showText("Score: " + score, 500, 15);
        if(transicion)
        {
            contadorTransicion++;
        
            if(contadorTransicion >= 120)
            {
                iniciarJefeFinal();
            }
        
            return;
        }
        if(victoria)
        {
            return;
        }
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
    public void iniciarJefeFinal()
    {
        removeObjects(getObjects(NivelCompletado.class));
        
        setBackground("fondoFinal.png");
        
        fase = 2;
    
        transicion = false;
    
        contadorTransicion = 0;
        barra.setLocation(210, 20);
        barra.setAncho(400);
        barra.actualizar(0);
        tiempo = 0;
    
        tiempoMeta = 7200;
        
        addObject(new BossFinal(), 280, 70);
    }
    public void victoria()
    {
        GreenfootImage fondo = getBackground();
    
        fondo.setColor(new Color(0,0,0,180));
        fondo.fillRect(0,0,560,560);
        
        removeObjects(getObjects(BossFinal.class));

        removeObjects(getObjects(Bullet.class));
        
        removeObjects(getObjects(Bullet_2.class));
        
        removeObjects(getObjects(Bullet_3.class));
        
        addObject(new Victoria(score), 280, 280);
        victoria = true;
    }
    public double getAvance()
    {
        return (double) tiempo / tiempoMeta;
    }
}
