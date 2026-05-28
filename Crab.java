import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Crab extends Actor
{
    public void act() 
    {
        if (Greenfoot.isKeyDown("left")) {  move(-6); }
        if (Greenfoot.isKeyDown("right")) { move(6); }
    }    
}