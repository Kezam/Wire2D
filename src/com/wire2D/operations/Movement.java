package com.wire2D.operations;

import com.wire2D.Resource;
import com.wire2D.object.Box;
import com.wire2D.object.Map;
import com.wire2D.object.creatures.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class Movement {

    private Player player;
    private Vector2f pos;

    public Movement(Player player) {
        this.player = player;
        this.pos = player.position;
    }

    public void update(GameContainer gc, StateBasedGame s, int i, Map mapa) throws SlickException {

        if (gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
            test(mapa, player, i, 1, 0, mapa.mBox);
        } else if (gc.getInput().isKeyDown(Input.KEY_LEFT)) {
            test(mapa, player, i, -1, 0, mapa.mBox);
        }

        if (gc.getInput().isKeyDown(Input.KEY_UP)) {
            test(mapa, player, i, 0, -1, mapa.mBox);
        } else if (gc.getInput().isKeyDown(Input.KEY_DOWN)) {
            test(mapa, player, i, 0, 1, mapa.mBox);
        }
        player.update(gc, s, i);
    }

    private void test(Map mapa, Player player, int i, int x, int y, ArrayList<Box> Box) throws SlickException {

        float speed = 3f;
        float droga = Math.round(speed * (i / 10));

        if (x == 0) {
            if (Box != null)
                if (y == -1) {
                    player.setImage(Resource.getSpriteImage("player", 0, 3));
                    pos.set(pos.getX(), pos.getY() - droga);
                    player.punkt.setLocation(pos.getX(), pos.getY() - droga);
                    for (Box xD : Box) {
                        if (player.punkt.intersects(xD.box)) {
                            if (xD.property.equals("enter")) {
                                mapa.changemap(xD.src, xD.index);
                                break;
                            }
                            pos.set(pos.getX(), pos.getY() + droga);
                        }
                    }
                }
            if (y == 1) {
                player.setImage(Resource.getSpriteImage("player", 0, 0));
                pos.set(pos.getX(), pos.getY() + droga);
                player.punkt.setLocation(pos.getX(), pos.getY() + droga);
                assert Box != null;
                for (Box xD : Box) {
                    if (player.punkt.intersects(xD.box)) {
                        if (xD.property.equals("enter")) {
                            mapa.changemap(xD.src, xD.index);
                            break;
                        }
                        pos.set(pos.getX(), pos.getY() - droga);
                    }
                }
            }
        } else {
            if (Box != null) {
                if (x == -1) {
                    player.setImage(Resource.getSpriteImage("player", 0, 1));
                    pos.set(pos.getX() - droga, pos.getY());
                    player.punkt.setLocation(pos.getX() - droga, pos.getY());
                    for (Box xD : Box) {
                        if (player.punkt.intersects(xD.box)) {
                            if (xD.property.equals("enter")) {
                                mapa.changemap(xD.src, xD.index);
                                break;
                            }
                            pos.set(pos.getX() + droga, pos.getY());
                        }
                    }
                }

                if (x == 1) {
                    player.setImage(Resource.getSpriteImage("player", 0, 2));
                    pos.set(pos.getX() + droga, pos.getY());
                    player.punkt.setLocation(pos.getX() + droga, pos.getY());
                    for (Box xD : Box) {
                        if (player.punkt.intersects(xD.box)) {
                            if (xD.property.equals("enter")) {
                                mapa.changemap(xD.src, xD.index);
                                break;
                            }
                            pos.set(pos.getX() - droga, pos.getY());
                        }
                    }
                }
            }
        }
    }
}