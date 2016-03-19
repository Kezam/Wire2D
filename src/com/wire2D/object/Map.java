package com.wire2D.object;

import com.wire2D.object.containers.Chest;
import com.wire2D.object.creatures.Mob;
import com.wire2D.object.creatures.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import java.util.ArrayList;

public class Map {

    public TiledMap map;

    public Player mPlayer;

    public ArrayList<Mob> mobs;
    public ArrayList<Chest> chests;

    public ArrayList<Box> mBox;

    public Map(String path) throws SlickException {

        map = new TiledMap("res/map/" + path + ".tmx", "res/map");

        mobs = new ArrayList<>();
        chests = new ArrayList<>();

        mPlayer = new Player();

        mobs.add(new Mob(new Vector2f(20 * 32, 15 * 32)));
        chests.add(new Chest(new Vector2f(25 * 32, 15 * 32)));

        int objectLayer = map.getLayerIndex("enter_block");
        mBox = new ArrayList<Box>();
        mBox = fillArrayBox(map, objectLayer, mPlayer);

        mPlayer.position.set(16 * 32, 15 * 32);
    }

    public void changemap(String path, int index) throws SlickException {
        map = new TiledMap("res/map/" + path + ".tmx", "res/map");

        if (mBox != null) {
            mBox.clear();
        }

        int objectLayer = map.getLayerIndex("enter_block");
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                int id = map.getTileId(i, j, objectLayer);
                String property_spawn = map.getTileProperty(id, "spawn", "false");
                String property_index = map.getTileProperty(id, "index", "null");
                if (property_spawn.equals("true")) {
                    if (Integer.parseInt(property_index) == index) {
                        mPlayer.position.set(i * 32, j * 32);
                    }
                }
            }
        }
        mBox = fillArrayBox(map, objectLayer, mPlayer);
    }

    public void init(GameContainer gc, StateBasedGame s) throws SlickException {

    }

    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {

        map.render(0, 0);
        mPlayer.render(gc, s, g);
        
        for (Mob mob : mobs) {
            mob.render(gc, s, g);
        }
        for (Chest chest : chests) {
            chest.render(gc, s, g);
        }

        for (Box xD : mBox) {
            xD.render(gc, s, g, mPlayer.punkt);
        }
    }

    public void update(GameContainer gc, StateBasedGame s, int i) throws SlickException {
        mPlayer.update(gc, s, i);

        for (Mob mob : mobs) {
            mob.update(gc, s, i);
        }
        for (Chest chest : chests) {
            chest.update(gc, s, i);
        }
    }

    private ArrayList<Box> fillArrayBox(TiledMap map, int objectLayer, Player player) {
        ArrayList<Box> boox = new ArrayList<Box>();
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                int id = map.getTileId(i, j, objectLayer);

                String property = map.getTileProperty(id, "blocked", "false");
                if (property.equals("true")) {
                    boox.add(new Box(i * 32, j * 32, "blocked", 0, "null"));
                }

                property = map.getTileProperty(id, "enter", "false");
                if (property.equals("true")) {
                    property = map.getTileProperty(id, "index", "null");
                    String src_property = map.getTileProperty(id, "map", "null");
                    boox.add(new Box(i * 32, j * 32, "enter", Integer.parseInt(property), src_property));
                }
            }
        }
        return boox;
    }
}
