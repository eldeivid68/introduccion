import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossFinal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossFinal extends Actor
{
    /**
     * Act - do whatever the BossFinal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int direccion = 1;
    private int contador = 0;
    private int amplitud = 50;
    private int contadorDisparo = 0;
    private int descanso = 0;
    private int hueco = 3;
    private int anguloObjetivo = 90;
    private int contadorApuntado = 0;
    private int contadorEspecial = 0;
    private boolean especialActivo = false;
    private boolean disparando = false;
    private int tiempoDisparo = 0;
    private int faseActual = 1;
    public void act()
    {
        if(getWorld().getObjects(Crab.class).isEmpty())
        {
            return;
        }
        if(!disparando)
        {
            setLocation(getX() + direccion * 3, getY());
        }
        if(getX() < 50)
        {
            direccion = 1;
        
            amplitud = Greenfoot.getRandomNumber(80) + 20;
        }
        
        if(getX() > getWorld().getWidth() - 50)
        {
            direccion = -1;
        
            amplitud = Greenfoot.getRandomNumber(80) + 20;
        }
        if(!disparando)
        {
            contador++;
            int yBase = 120;
            int y = yBase +
                    (int)(Math.sin(contador * 0.05) * amplitud);
            setLocation(getX(), y);
        }
        if(getWorld().getObjects(Crab.class).isEmpty())
        {
            return;
        }
        atacar();
    }
    
    public void atacar()
    {
        if(disparando)
        {
            tiempoDisparo--;
        
            if(tiempoDisparo == 35) dispararPatronNormal();
            if(tiempoDisparo == 30) dispararPatronNormal();
            if(tiempoDisparo == 25) dispararPatronNormal();
            if(tiempoDisparo == 20) dispararPatronNormal();
            if(tiempoDisparo == 15) dispararPatronNormal();
            if(tiempoDisparo == 10) dispararPatronNormal();
            if(tiempoDisparo == 5)  dispararPatronNormal();
            
            {
                if(faseActual == 1)
                {
                    dispararPatronNormal();
                }
                else if(faseActual == 3)
                {
                    dispararPatronFinal();
                }
            }
            
            if(tiempoDisparo <= 0)
            {
                disparando = false;
            }
        
            return;
        }
        if(descanso > 0)
        {
            descanso--;
            return;
        }
    
        contadorDisparo++;
        contadorApuntado++;
        if(contadorApuntado >= 35)
        {
            contadorApuntado = 0;
        
            actualizarObjetivo();
        }
    
        double avance = ((CrabWorld)getWorld()).getAvance();
        
        if(avance < 0.33)
        {
            if(contadorDisparo % 40 == 0)
            {
                disparando = true;
                tiempoDisparo = 47;
            }
        
            if(contadorDisparo % 40 == 0)
            {
                moverHueco();
            }
            if(contadorDisparo > 120)
            {
                contadorDisparo = 0;
                descanso = 60;
            }
        }
        else if(avance < 0.66)
        {
            if(faseActual != 2)
            {
                faseActual = 2;
            
                limpiarBalas();
                contadorDisparo = 0;
            }        
            dispararLaser();
        
            if(contadorDisparo > 40)
            {
                contadorDisparo = 0;
                descanso = 45;
            }
        }
        else
        {
            if(faseActual != 3)
            {
                faseActual = 3;
            
                limpiarBalas();
                contadorDisparo = 0;
            }
            if(contadorDisparo % 30 == 0)
            {
                disparando = true;
            
                tiempoDisparo = 20;
            }
        
            if(contadorDisparo % 30 == 0)
            {
                moverHueco();
            }
            if(contadorDisparo > 60)
            {
                contadorDisparo = 0;
                descanso = 30;
            }
        }
    }
    public void moverHueco()
    {
        int cambio =
            Greenfoot.getRandomNumber(3) - 1;
    
        hueco += cambio;
    
        if(hueco < 0)
        {
            hueco = 0;
        }
    
        if(hueco > 6)
        {
            hueco = 6;
        }
    }
    public void actualizarObjetivo()
    {
        Crab crab =
            (Crab)getWorld()
            .getObjects(Crab.class)
            .get(0);
    
        int dx = crab.getX() - getX();
        int dy = crab.getY() - getY();
    
        anguloObjetivo =
            (int)Math.toDegrees(
                Math.atan2(dy, dx)
            );
    }
    public void dispararPatronNormal()
    {
        int[] angulos =
        {
            anguloObjetivo - 35,
            anguloObjetivo - 23,
            anguloObjetivo - 11,
            anguloObjetivo,
            anguloObjetivo + 11,
            anguloObjetivo + 23,
            anguloObjetivo + 35
        };
    
        for(int i = 0; i < 7; i++)
        {
            if(i != hueco)
            {
                getWorld().addObject(
                    new Bullet_2(angulos[i], 5),
                    getX(),
                    getY()
                );
            }
        }
    }
    public void dispararLaser()
    {
        Crab crab =
            (Crab)getWorld()
            .getObjects(Crab.class)
            .get(0);
    
        int dx = crab.getX() - getX();
        int dy = crab.getY() - getY();
    
        int anguloCentro =
            (int)Math.toDegrees(
                Math.atan2(dy, dx)
            );
    
        getWorld().addObject(
            new Bullet_2(anguloCentro - 4, 10),
            getX(),
            getY()
        );
    
        getWorld().addObject(
            new Bullet_3(anguloCentro, 10),
            getX(),
            getY()
        );
    
        getWorld().addObject(
            new Bullet_2(anguloCentro + 4, 10),
            getX(),
            getY()
        );
    }
    public void dispararPatronFinal()
    {
        int[] angulos =
        {
            anguloObjetivo - 45,
            anguloObjetivo - 21,
            anguloObjetivo,
            anguloObjetivo + 21,
            anguloObjetivo + 45
        };
    
        for(int i = 0; i < 5; i++)
        {
            if(i == hueco)
            {
                continue;
            }
    
            if(i == 3)
            {
                getWorld().addObject(
                    new Bullet_3(angulos[i], 7),
                    getX(),
                    getY()
                );
            }
            else if(i==0 || i == 2 || i == 4 || i == 6)
            {
                getWorld().addObject(
                    new Bullet_2(angulos[i], 7),
                    getX(),
                    getY()
                );
            }
            else
            {
                getWorld().addObject(
                    new Bullet(angulos[i], 7),
                    getX(),
                    getY()
                );
            }
        }
    }
    public void limpiarBalas()
    {
        World world = getWorld();
    
        for(Bullet b : world.getObjects(Bullet.class))
        {
            world.removeObject(b);
        }
    
        for(Bullet_2 b : world.getObjects(Bullet_2.class))
        {
            world.removeObject(b);
        }
    
        for(Bullet_3 b : world.getObjects(Bullet_3.class))
        {
            world.removeObject(b);
        }
    }
}
