package com.wire2D.states;

import com.wire2D.utis.States;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StateOptions extends BasicGameState {

    @Override
    public int getID() {
        return States.OPTIONS;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {

    }

    @Override
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {

    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int i) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            s.enterState(States.MENU);
        }
    }
}
