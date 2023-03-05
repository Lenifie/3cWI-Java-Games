package at.stl.games.snowworld;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Snowflake implements ActorSnow {
    public enum SIZE{BIG,SMALL,MEDIUM}
    private float x,y;
    private int size;
    private  float speed;
    private Random random;


    public Snowflake(SIZE size){
        this.random = new Random();
        if (size == SIZE.BIG){
            this.size = 12;
            this.speed = 2.5F;
        }
        if (size == SIZE.MEDIUM){
            this.size = 8;
            this.speed = 5;
        }
        if (size == SIZE.SMALL){
            this.size = 4;
            this.speed = 10;
        }

        setRandomPosition();
    }

    public void setRandomPosition(){
        this.x = random.nextInt(800);
        this.y = random.nextInt(600)-600;
    }


    public void render(Graphics graphics){
        graphics.fillOval(this.x,this.y,this.size,this.size);
    }


    public void update(int delta){
            this.y += (float)delta/this.speed;
            if (this.y>600){
                setRandomPosition();
            }
    }
}
