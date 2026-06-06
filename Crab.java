import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Crab extends Actor
{
    private GreenfootImage idle =
    new GreenfootImage("knight.png");

    private GreenfootImage walk1 =
        new GreenfootImage("walkKnigth1.png");
    
    private GreenfootImage walk2 =
        new GreenfootImage("walkKnigth2.png");
    
    private int contadorAnimacion = 0;
    private int velocidad =3;
    public void act() 
    {
        boolean moviendoseVertical = false;
        boolean moviendose = false;
        if (Greenfoot.isKeyDown("left")) 
        {  
            move(-velocidad); 
            setImage("leftKnight.png");
            moviendose = true;
        }
        if (Greenfoot.isKeyDown("right")) 
        { 
            move(velocidad);
            setImage("rightKnight.png");
            moviendose = true;
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-velocidad-1);
            moviendoseVertical = true;
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+velocidad-1);
            moviendoseVertical = true;
        }
        if(Greenfoot.isKeyDown("shift")){
            velocidad=5;
        }
        else{
            velocidad=3;
        }
        if(moviendoseVertical)
        {
            contadorAnimacion++;
        
            if((contadorAnimacion / 2) % 2 == 0)
            {
                setImage(walk1);
            }
            else
            {
                setImage(walk2);
            }
        }
        else if(!moviendose)
        {
            contadorAnimacion = 0;
            setImage(idle);
        }
    }    
}