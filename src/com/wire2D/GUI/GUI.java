package com.wire2D.GUI;

import com.wire2D.statistics.Statistics;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Mazek on 2016-03-18.
 */

public class GUI {

    public Life_bar lifeBar;
    public Mana_bar manaBar;
    //to ponizej do usunięcia
    public ShopWindow shopWindow;

    public GUI(Statistics stats) throws SlickException{
        this.lifeBar = new Life_bar(stats.aHealth, stats.maxHealth);
        this.manaBar = new Mana_bar(stats.aMana, stats.maxMana);
        this.shopWindow = new ShopWindow();
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        lifeBar.render(gc, sbg, g);
        manaBar.render(gc, sbg, g);
        shopWindow.render(gc, sbg, g);
    }

    public void update(GameContainer gc, StateBasedGame s, int i, Statistics stats) throws SlickException {
        lifeBar.update(gc, s, i, stats);
        manaBar.update(gc, s, i, stats);
    }
}
