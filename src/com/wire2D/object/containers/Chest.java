package com.wire2D.object.containers;

import com.wire2D.Resource;
import com.wire2D.object.Base;
import com.wire2D.object.Item;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class Chest extends Base {

    ArrayList<Item> content;

    public Chest() {
        mImage = Resource.getImage("chest");
        position = new Vector2f();
        punkt = new Circle(position.getX(), position.getY(), 1);

        content = new ArrayList<>();
    }

    public void init(GameContainer gc, StateBasedGame s) throws SlickException {

    }

    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
        if (mImage != null) {
            mImage.draw(punkt.getX() - 16, punkt.getY() - 40);
        }
    }

    public void update(GameContainer gc, StateBasedGame s, int i) throws SlickException {
        punkt.setX(position.getX());
        punkt.setY(position.getY());
    }
}