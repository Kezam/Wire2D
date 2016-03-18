package com.wire2D.GUI;

import com.wire2D.statistics.Statistics;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Mazek on 2016-03-18.
 */
public class Life_bar {

    private double health;
    private Rectangle lifeBar;

    public Life_bar(double health){
        this.health = health;
        this.lifeBar = new Rectangle(20,660,200,20);
    }


    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.draw(lifeBar);
    }

    public void update(GameContainer gc, StateBasedGame s, int i, Statistics stats) throws SlickException {
        //this
    }

}
