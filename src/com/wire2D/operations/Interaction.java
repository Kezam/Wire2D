package com.wire2D.operations;

import com.wire2D.utis.Window;
import org.lwjgl.input.Mouse;

/**
 * Created by Mazek on 2016-03-16.
 */
public class Interaction {

    int x = Mouse.getX();
    int y = Window.HEIGHT - Mouse.getY();

}