package com.wire2D.object;

import org.newdawn.slick.Image;

/**
 * Created by Mazek on 2016-03-16.
 */
public class Item {

    public Image icon;
    public int value;

    public Item(Image icon, int value) {
        this.icon = icon;
        this.value = value;
    }
}