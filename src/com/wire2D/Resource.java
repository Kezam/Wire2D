package com.wire2D;

import com.wire2D.utis.Tile;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mazek on 2016-03-13.
 */
public class Resource {

    private static Map<String, Image> images;
    private static Map<String, SpriteSheet> sprites;
    private static Map<String, Sound> sounds;

    public Resource() {

        images = new HashMap<String, Image>();
        sprites = new HashMap<String, SpriteSheet>();
        sounds = new HashMap<String, Sound>();

        try {
            sprites.put("player", loadSprite("res/object/creatures/player/player.png", Tile.SIZE_PLAYER_X, Tile.SIZE_PLAYER_Y));
            sprites.put("chicken", loadSprite("res/object/creatures/mob/chicken.png", 70, 72));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    // Image

    public static Image loadImage(String path) throws SlickException {
        return new Image(path, false, Image.FILTER_NEAREST);
    }

    public static Image getImage(String getter) {
        return images.get(getter);
    }

    // SpriteSheet

    public static SpriteSheet loadSprite(String path, int tw, int th) throws SlickException {
        return new SpriteSheet(loadImage(path), tw, th);
    }

    public static SpriteSheet getSprite(String getter) {
        return sprites.get(getter);
    }

    public static Image getSpriteImage(String getter, int x, int y) {
        return sprites.get(getter).getSubImage(x, y);
    }

    // Sound

    public static Sound getSound(String getter) {
        return sounds.get(getter);
    }
}
