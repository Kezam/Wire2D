package com.wire2D.GUI;

import com.wire2D.statistics.Statistics;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Mazek on 2016-03-18.
 */

public class Life_bar {

    private float health;
    private Rectangle lifeBar;
    private Rectangle lifeBar_frame;

    public Life_bar(float health, float maxHealth){
        this.health = health;
        this.lifeBar_frame = new Rectangle(20, 660, 200, 20);
        this.lifeBar = new Rectangle(20, 660, 2 * health, 20);
    }


    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        //g.drawString();
        g.setColor(Color.red);
        g.fill(lifeBar);
        g.draw(lifeBar);

        g.setColor(Color.white);
        g.draw(lifeBar_frame);
    }

    public void update(GameContainer gc, StateBasedGame s, int i, Statistics stats) throws SlickException {
        this.health = stats.aHealth;
        lifeBar.setWidth(2 * health);
    }
}
