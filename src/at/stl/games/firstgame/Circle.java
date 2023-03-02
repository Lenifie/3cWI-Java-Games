package at.stl.games.firstgame;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle implements Actor{
    private float x;
    private float y;
    private  float speed;
    private int diameter;

    public Circle(){
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600);
        this.speed = 2;
        this.diameter = random.nextInt(20)+20;
    }


    public void render(Graphics graphics){
        graphics.drawOval(this.x,this.y,this.diameter,this.diameter);
    }

    public void update(int delta){
        this.x += (float)delta/this.speed;
        if(this.x>800){
            this.x = 0;
        }

        this.y += (float)delta/this.speed;
        if(this.y>600){
            this.y = 0;
        }

        this.diameter += (float)delta/this.speed;
    }
}
