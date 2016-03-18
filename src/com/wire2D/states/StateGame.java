package com.wire2D.states;

import com.wire2D.GUI.Life_bar;
import com.wire2D.object.Map;
import com.wire2D.operations.Movement;
import com.wire2D.utis.States;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Mazek on 2016-03-13.
 */
public class StateGame extends BasicGameState {

    public Map ObjectMap;
    public Movement Ctrl_mov;
    public Life_bar lifeBar_GUI;

    @Override
    public int getID() {
        return States.GAME;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        ObjectMap = new Map("shop_place");
        Ctrl_mov = new Movement(ObjectMap.mPlayer);
        lifeBar_GUI = new Life_bar(100);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        ObjectMap.render(gc, sbg, g);
        lifeBar_GUI.render(gc, sbg, g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int i) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            s.enterState(States.MENU);
        }
        ObjectMap.update(gc, s, i);
        Ctrl_mov.update(gc, s, i, ObjectMap);
        lifeBar_GUI.update(gc, s, i, ObjectMap.mPlayer.statistics);

    }
}
