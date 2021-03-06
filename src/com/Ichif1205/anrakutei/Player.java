package com.Ichif1205.anrakutei;

import android.graphics.Path;

public class Player {

	private float posX;
	private float posY;
	private int width = 50;
	private int height = 30;
	private boolean existFlag;
	private float gurdX;
	private float gurdY;

	Player(int x, int y) {
		posX = x;
		posY = y;
		existFlag = true;
	}

	public float getPlayerPosX() {
		return posX;
	}

	public float getPlayerPosY() {
		return posY;
	}

	public int getPlayerWidth() {
		return width;
	}

	public int getPlayerHeight() {
		return height;
	}

	public void setPlayerPosX(float x) {
		posX = x;
	}

	public void setPlayerPosY(float y) {
		posY = y;
	}

	public boolean getPlayerExistFlag() {
		return existFlag;
	}

	public void setPlayerWidth(int w) {
		width = w;
	}

	public void setPlayerHeight(int h) {
		height = h;
	}

	public Path draw(Path path, int itemSFlg) {
		// itemSをとった場合
		if (itemSFlg == 1) {
			width = 15;
		}

		path.moveTo(posX, posY);
		// 左下から反時計回りに描画
		path.lineTo(posX - width / 2, posY + height / 4);
		path.lineTo(posX + width / 2, posY + height / 4);
		path.lineTo(posX + width / 2, posY - height / 4);
		path.lineTo(posX + width / 6, posY - height / 4);
		path.lineTo(posX + width / 6, posY - height * 3 / 4);
		path.lineTo(posX - width / 6, posY - height * 3 / 4);
		path.lineTo(posX - width / 6, posY - height / 4);
		path.lineTo(posX - width / 2, posY - height / 4);
		path.lineTo(posX - width / 2, posY + height / 4);

		return path;
	}

	// ガード描画のパス
	public Path drawGurd(Path path, float x, float y) {
		gurdX = x;
		gurdY = y;
		path.moveTo(gurdX, gurdY);
		// 左下から反時計回りに描画
		path.lineTo(gurdX - width, gurdY + height / 4);
		path.lineTo(gurdX + width, gurdY + height / 4);
		path.lineTo(gurdX + width, gurdY - height / 4);
		path.lineTo(gurdX + width, gurdY - height / 4);
		path.lineTo(gurdX + width, gurdY - height * 3 / 4);
		path.lineTo(gurdX - width, gurdY - height * 3 / 4);
		path.lineTo(gurdX - width, gurdY - height / 4);
		path.lineTo(gurdX - width, gurdY - height / 4);
		path.lineTo(gurdX - width, gurdY + height / 4);

		return path;
	}

	public boolean isShooted(float shotX, float shotY) {
		if ((posX - width / 2 <= shotX && posX + width / 2 >= shotX)
				&& (posY - height / 2 <= shotY && posY + height / 2 >= shotY)) {
			return true;
		}
		return false;
	}

	// itemのあたり判定
	public boolean isItemted(float shotX, float shotY) {
		if ((posX - width / 2 <= shotX && posX + width / 2 >= shotX)
				&& (posY - height <= shotY && posY + height >= shotY)) {
			return true;
		}
		return false;
	}

	// gurd判定
	public boolean isGurded(float shotX, float shotY) {
		if ((gurdX - width <= shotX && gurdX + width >= shotX)
				&& (gurdY - height <= shotY && gurdY + height >= shotY)) {
			return true;
		}
		return false;
	}

	public void remove() {
		posY = -100;
		existFlag = false;
	}
}
