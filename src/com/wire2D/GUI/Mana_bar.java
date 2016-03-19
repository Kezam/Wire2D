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

public class Mana_bar {
    private float mana;
    private Rectangle manaBar;
    private Rectangle manaBar_frame;

    public Mana_bar(float mana, float maxMana){
        this.mana = mana;
        this.manaBar_frame = new Rectangle(20, 690, 200, 20);
        this.manaBar = new Rectangle(20, 690, 2 * mana, 20);
    }


    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        //g.drawString();
        g.setColor(Color.blue);
        g.fill(manaBar);
        g.draw(manaBar);

        g.setColor(Color.white);
        g.draw(manaBar_frame);
    }

    public void update(GameContainer gc, StateBasedGame s, int i, Statistics stats) throws SlickException {
        this.mana = stats.aHealth;
        manaBar.setWidth(2*mana);
    }
}