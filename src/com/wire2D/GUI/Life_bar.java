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
class Life_bar {

    private float aHealth;
    private float cHealth;
    private Rectangle lifeBar;
    private Rectangle lifeBar_freame;

    Life_bar(float health, float maxHealth){
        this.aHealth = health;
        this.cHealth = maxHealth;
        this.lifeBar_freame = new Rectangle(20,660,200,20);
        this.lifeBar = new Rectangle(20,660,2 * health,20);
    }


    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.red);
        g.fill(lifeBar);
        g.draw(lifeBar);

        g.setColor(Color.white);
        g.draw(lifeBar_freame);
        g.drawString("HP: " + aHealth + "/" + cHealth, 20,660);
    }

    public void update(GameContainer gc, StateBasedGame s, int i, Statistics stats) throws SlickException {
        this.aHealth = stats.aHealth;
        this.cHealth = stats.maxHealth;
        lifeBar.setWidth(200*(aHealth/cHealth));
    }

}
