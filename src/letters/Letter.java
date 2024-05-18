package letters;


import entity.Entity;
import entity.Player;
import main.GamePanel;
import main.objectforgem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Letter extends objectforgem {
    Player player;
    public String[] dialogues = new String[20];
    public Letter(int x, int y, Player player) {
        super(x, y, "/object/letter/004.png", 16, 16);
        this.player = player;
    }

    public void setDialogue() {
        dialogues[0] = "Welcome to the Dungeon of Doom";
    }


    @Override
    public void interact() {

    }

    @Override
    public void draw(Graphics2D g2) {

        int screenX = position.x - player.worldX + player.screenX;
        int screenY = position.y - player.worldY + player.screenY;

        g2.drawImage(image, screenX, screenY, (int)(image.getWidth() * 3 ), (int)(image.getHeight() * 3), null);

    }
}