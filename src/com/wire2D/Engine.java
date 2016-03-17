package com.wire2D;

import com.wire2D.states.StateAbout;
import com.wire2D.states.StateGame;
import com.wire2D.states.StateMenu;
import com.wire2D.states.StateOptions;
import com.wire2D.utis.Window;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Engine extends StateBasedGame {

    public static boolean _APPLET = true;

    public Engine() {
        super("Wire2D");
    }

    public static void main(String[] args) throws SlickException {

        _APPLET = false;

        AppGameContainer game = new AppGameContainer(new Engine());
        game.setDisplayMode(Window.WIDTH, Window.HEIGHT, false);
        game.start();
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        gc.setMaximumLogicUpdateInterval(60);
        gc.setTargetFrameRate(60);
        gc.getAlwaysRender();
        gc.setShowFPS(true);

        new Resource();

        this.addState(new StateGame());
        this.addState(new StateMenu());
        this.addState(new StateOptions());
        this.addState(new StateAbout());
    }
}