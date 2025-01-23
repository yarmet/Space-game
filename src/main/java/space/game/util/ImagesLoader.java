package space.game.util;

import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

@Getter
public enum ImagesLoader {

    EXPLOSION_TYPE1("/bum1.png"),
    EXPLOSION_TYPE2("/bum2.png"),
    EXPLOSION_TYPE3("/bum3.png"),
    EXPLOSION_TYPE4("/bum4.png"),
    PLAYER("/player/player.png"),
    GUN_LENT("/gunLent.png"),
    GUN_LENT2("/gunLent2.png"),
    HEALTH_LENT("/healthLent.png"),
    LASER_LENT("/laserLent.png"),
    BOSS("/bots/Boss.png"),
    BOT_TYPE1("/bots/BotType1.png"),
    BOT_TYPE2("/bots/BotType2.png"),
    BOT_TYPE3("/bots/BotType3.png"),
    BOT_GUN("/guns/GunType2.png"),
    GUN_TYPE1("/guns/GunType1.png"),
    GUN_TYPE2("/guns/GunType2.png"),
    LASER("/guns/laser/whiteLaser.png"),


    SPACE_MENU("");


    private final BufferedImage image;

    ImagesLoader(String path) {
        try {
            image = ImageIO.read(Objects.requireNonNull(this.getClass().getResourceAsStream(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
