package at.stl.games.tetris;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class RectangleBlock implements Actor{
    float x,y;
    float speed;

    public RectangleBlock(){
        this.x = 100;
        this.y = 100;
        this.speed = speed;
    }


    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(this.x,this.y,40,40);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if(gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)){

            this.x++;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_LEFT)){
            this.x--;

        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_SPACE)){
            this.y++;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_UP)){
            this.x = -y;
            this.y = x;
        }
    }
}
