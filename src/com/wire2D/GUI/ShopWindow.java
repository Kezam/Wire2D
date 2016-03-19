package com.wire2D.GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Dariusz on 2016-03-19.
 */
public class ShopWindow {
    private Rectangle mainWindow;
    private Image sellButton;
    private Image buyButton;
    private Image tradeButton;

    public void ShopWindow() throws SlickException {
        this.mainWindow = new Rectangle(240, 660, 10, 10);
        this.sellButton = new Image("res/menu/shop_buttons/sellShop.png");
        this.buyButton = new Image("res/menu/shop_buttons/buyShop.png");
        this.tradeButton = new Image("res/menu/shop_buttons/tradeShop.png");
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.red);
        g.fill(this.mainWindow);
        g.draw(this.mainWindow);
    }

}
