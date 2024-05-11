package main;

import entity.Player;
import main.LockedDoor;
import java.awt.*;

public class Key extends objectforgem {
    private Player player;

    private boolean pickedUp = false; // Thêm biến để kiểm tra xem chìa khóa đã được nhặt hay chưa

    public Key(int x, int y, Player player) {
        super(x, y, "/object/key.png", 16, 16);
        this.player = player;
    }

    @Override
    public void interact() {  if (!pickedUp) { // Chỉ nhặt chìa khóa nếu nó chưa được nhặt
        int distanceThreshold = 50; // Khoảng cách cho phép chìa khóa bắt đầu theo người chơi
        int playerX = player.getWorldX();
        int playerY = player.getWorldY();

        int distanceX = Math.abs(this.position.x - playerX);
        int distanceY = Math.abs(this.position.y - playerY);

        if (distanceX < distanceThreshold && distanceY < distanceThreshold) {
            player.pickUpKey(); // Người chơi nhặt chìa khóa
            pickedUp = true; // Đánh dấu chìa khóa đã được nhặt
        }
    }
    }
    public boolean isPickedUp() {
        return pickedUp;
    }
    @Override
    public void draw(Graphics2D g2) { if (!pickedUp) { // Chỉ vẽ chìa khóa nếu nó chưa được nhặt lên
        int screenX = this.position.x - player.getWorldX() + player.screenX;
        int screenY = this.position.y - player.getWorldY() + player.screenY;

        if (image != null) {
            g2.drawImage(image, screenX, screenY, image.getWidth() * 3, image.getHeight() * 3, null);
        }
    }
    }
}