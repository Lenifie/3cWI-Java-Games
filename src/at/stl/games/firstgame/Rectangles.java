package at.stl.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

public class Rectangles extends BasicGame {
    private float x;
    private float y;
    private int recDirect;
    private float x1;
    private  boolean x1End;
    private float y1;
    private float x2;
    private float y2;
    private boolean y2End;
    private float speed;


    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.x = 100;
        this.y = 100;
        this.recDirect = 0;
        this.x1End = false;
        this.y2 = 0;
        this.y2End = false;
        this.speed = 10.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
       //Rectangle
        if(recDirect == 0){

            this.x += (float)delta/2.0;
            if(this.x>=600){
                this.recDirect = 1;
            }
        }
        else if(recDirect == 1){

            this.y += (float)delta/2.0;
            if(this.y>=400){
                this.recDirect = 2;
            }
        }
        else if(recDirect == 2){
            this.x -= (float)delta/2.0;
            if(this.x <=100){
                this.recDirect = 3;
            }
        }
        else if(recDirect == 3){
            this.y -= (float)delta/2.0;
            if(this.y <=100){
                this.recDirect = 0;
            }
        }







        //Oval
        if(!this.x1End){

            this.x1 += (float)delta/2.0;
            if(this.x1>=600){
                this.x1End = true;
            }
        }
        else{
            this.x1 -= (float)delta/2.0;
            if(this.x1 <=100){
                this.x1End = false;
            }
        }


        //Circle
        if(!this.y2End){

            this.y2 += (float)delta/2.0;
            if(this.y2>=500){
                this.y2End = true;
            }
        }
        else{
            this.y2 -= (float)delta/2.0;
            if(this.y2 <=100){
                this.y2End = false;
            }
        }


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
     graphics.drawRect(this.x,this.y,70,70); //Rectangle
     graphics.drawOval(this.x1,this.y1,70,30); //Oval
     graphics.drawOval(this.x2,this.y2,40,40); //Circle
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
