package com.wire2D.operations;

import com.wire2D.utis.Window;
import org.lwjgl.input.Mouse;

public class Interaction {

    int x = Mouse.getX();
    int y = Window.HEIGHT - Mouse.getY();

}