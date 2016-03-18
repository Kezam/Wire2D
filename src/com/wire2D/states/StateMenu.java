package com.wire2D.states;

import com.wire2D.utis.States;
import com.wire2D.utis.Window;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Mazek on 2016-03-13.
 */
public class StateMenu extends BasicGameState {

    Image b_return;
    Image b_options;
    Image b_about;
    Image b_exit;

    int hw;

    @Override
    public int getID() {
        return States.MENU;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {

        b_return = new Image("res/menu/b_return.png");
        b_options = new Image("res/menu/b_options.png");
        b_about = new Image("res/menu/b_about.png");
        b_exit = new Image("res/menu/b_exit.png");

        hw = Window.WIDTH / 2;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame stateBasedGame, Graphics g) throws SlickException {

        b_return.draw(hw - b_return.getWidth() / 2, 2 * b_return.getHeight());
        b_options.draw(hw - b_options.getWidth() / 2, 3 * b_options.getHeight());
        b_about.draw(hw - b_about.getWidth() / 2, 4 * b_about.getHeight());
        b_exit.draw(hw - b_exit.getWidth() / 2, 5 * b_exit.getHeight());
    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {

        int posX = Mouse.getX();
        int posY = Window.HEIGHT - Mouse.getY();

        if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            s.enterState(States.GAME);
        }

        if ((posX > hw - b_return.getWidth() / 2 && posX < hw + b_return.getWidth() / 2) && (posY > 2 * b_return.getHeight() && posY < 3 * b_return.getHeight())) {
            if (Mouse.isButtonDown(0)) {
                s.enterState(States.GAME);
            }
        }

        if ((posX > hw - b_options.getWidth() / 2 && posX < hw + b_options.getWidth() / 2) && (posY > 3 * b_options.getHeight() && posY < 4 * b_options.getHeight())) {
            if (Mouse.isButtonDown(0)) {
                s.enterState(States.OPTIONS);
            }
        }

        if ((posX > hw - b_about.getWidth() / 2 && posX < hw + b_about.getWidth() / 2) && (posY > 4 * b_about.getHeight() && posY < 5 * b_about.getHeight())) {
            if (Mouse.isButtonDown(0)) {
                s.enterState(States.ABOUT);
            }
        }

        if ((posX > hw - b_exit.getWidth() / 2 && posX < hw + b_exit.getWidth() / 2) && (posY > 5 * b_exit.getHeight() && posY < 6 * b_exit.getHeight())) {
            if (Mouse.isButtonDown(0)) {
                System.exit(0);
            }
        }
    }
}
