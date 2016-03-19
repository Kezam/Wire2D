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
class Mana_bar {
    private float aMana;
    private float cMana;
    private Rectangle manaBar;
    private Rectangle manaBar_freame;

    Mana_bar(float mana, float maxMana){
        this.aMana = mana;
        this.cMana = maxMana;
        this.manaBar_freame = new Rectangle(20,690,200,20);
        this.manaBar = new Rectangle(20,690,0,20);
    }


    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.blue);
        g.fill(manaBar);
        g.draw(manaBar);

        g.setColor(Color.white);
        g.draw(manaBar_freame);

        g.drawString("MP: " + aMana + "/" + cMana, 20,690);
    }

    public void update(GameContainer gc, StateBasedGame s, int i, Statistics stats) throws SlickException {
        this.aMana = stats.aMana;
        this.cMana = stats.maxMana;
        manaBar.setWidth(200*(aMana/cMana));
    }
}
