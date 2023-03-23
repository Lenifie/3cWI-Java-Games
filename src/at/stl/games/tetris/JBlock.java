package at.stl.games.tetris;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class JBlock implements Actor{

    private Color color;
    float x;
    float y;
    float speed;

    public JBlock(){
        this.color = Color.cyan;
        this.x = 100;
        this.y = 100;
        this.speed = 35;
    }
    @Override
    public void render(Graphics graphics) {

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }

    @Override
    public Color getColor() {
        return null;
    }
}
