package at.stl.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.tests.AnimationTest;

import java.awt.*;

public class Rectangles extends BasicGame {
    private float x;
    private float y;
    private float x1;
    private  boolean x1end;
    private float y1;
    private float x2;
    private float y2;
    private float speed;


    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.x = 100;
        this.x1end = false;
        this.x2 = 400;
        this.speed = 10.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
       //Rectangle
        this.x+= (float)delta/speed;
        this.y+= (float)delta/speed;



        //Oval
        if(!this.x1end){

            this.x1 += (float)delta/5.0;
            if(this.x1>=700){
                this.x1end = true;
            }else{
                this.x1 -= (float)delta/5.0;
            }
        }


        //Circle
        this.x2 += (float)delta/speed;
        this.y2+= (float)delta/speed;


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
     graphics.drawRect(this.x,this.y,100,100);
     graphics.drawOval(this.x1,this.y1,100,50);
     graphics.drawOval(this.x2,this.y2,100,100);
     graphics.drawString("Hello you!",50,50);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800,600,false); //Größe Bild
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
