package com.wire2D.object;

import com.wire2D.object.creatures.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;


public class Box {
    public Rectangle box;
    public String property;
    public int index;
    public String src;

    public Box(int x, int y, String property, int index, String src) {
        this.box = new Rectangle(x, y, 32, 32);
        this.property = property;
        this.index = index;
        this.src = src;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g, Circle circle) throws SlickException {
        //g.draw(box);
    }

    public void update(GameContainer gc, StateBasedGame s, int i, Player player) throws SlickException {

    }
}
