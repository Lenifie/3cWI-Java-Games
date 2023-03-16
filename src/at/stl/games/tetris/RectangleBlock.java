package at.stl.games.tetris;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class RectangleBlock implements Actor{
    private Color color;
    float x;
    float y;
    float speed;

    public RectangleBlock(){
        this.color = Color.cyan;
        this.x = 100;
        this.y = 100;
        this.speed = 35;
    }


    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(this.x,this.y,40,40);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y += (float)delta/speed;
        if(gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)){
            if(this.x<515){
                this.x += (float)delta;
            }
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_LEFT)){
            this.x--;
            if(this.x <0){
                this.x = 0;
            }
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_SPACE)){
            if(this.y<800-100){
                this.y += (float)delta;
            }
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_UP)){

        }
    }

    @Override
    public Color getColor() {
        return color;
    }
}
