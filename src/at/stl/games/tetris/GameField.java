package at.stl.games.tetris;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GameField implements Actor{
    int Rows = 16;
    int Columns = 10;
    int[][] FieldArray = new int[Rows][Columns];





    @Override
    public void render(Graphics graphics) {
        System.out.println(FieldArray);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }

    @Override
    public Color getColor() {
        return null;
    }

    public void FieldArray() {
    }
}
