package com.wire2D.operations;

import com.wire2D.object.Box;
import com.wire2D.utis.Window;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

/**
 * Created by Mazek on 2016-03-16.
 */
public class Interaction {

    int posX;
    int posY;

    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
        posX = Mouse.getX();
        posY = Window.HEIGHT - Mouse.getY();
    }

    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
        g.drawString(String.valueOf(posX), 10, 50);
        g.drawString(String.valueOf(posY), 10, 65);
    }

    public void update(GameContainer gc, StateBasedGame s, int i, ArrayList<Box> Box) throws SlickException {
        posX = Mouse.getX();
        posY = Window.HEIGHT - Mouse.getY();

        if (Mouse.isButtonDown(0)) {
            for(Box box : Box){

            }
        }
    }
}