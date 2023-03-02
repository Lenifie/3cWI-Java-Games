package at.stl.games.firstgame;

import org.newdawn.slick.Graphics;

public class Rectangle implements Actor{

    private float x;
    private float y;
    private  float speed;

    public Rectangle(float x, float y, float speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
    }


    public void render(Graphics graphics){
        graphics.drawRect(this.x,this.y,10,10);
    }

    public void update(int delta){
        this.x += (float)delta/this.speed;
        if(this.x>800){
            this.x = 0;
        }
    }
}

/*
Rectangle
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







              Oval
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
*/