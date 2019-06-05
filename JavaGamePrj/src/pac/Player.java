package pac;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Player {
	// 方向定数
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;

	// 移動スピード
	private static final int SPEED = 5;

	// プレイヤーの位置（x座標）
	private int x;
	// プレイヤーの位置（y座標）
	private int y;
	// プレイヤーの幅
	private int width;
	// プレイヤーの高さ
	private int height;
	// プレイヤーの画像
	private Image image;

	// メインパネルへの参照
	private MainPanel panel;

	public Player(int x, int y, MainPanel panel) {
		this.x = x;
		this.y = y;
		this.panel = panel;

		// イメージをロード
		loadImage();
	}

	/**
	 * プレイヤーを移動する
	 *
	 * @param dir 移動方向
	 */
	public void move(int dir) {
		if (dir == LEFT) {
			x -= SPEED;
		} else if (dir == RIGHT) {
			x += SPEED;
		}else if (dir == UP) {
			y -= SPEED;
		}else if (dir == DOWN) {
			y += SPEED;
		}

		// 画面の外に出ていたら中に戻す
		if (x < 0) {
			x = 0;
		}
		if (x > MainPanel.WIDTH - width) {
			x = MainPanel.WIDTH - width;
		}
		if (y < 0) {
			y = 0;
		}
		if (y > MainPanel.HEIGHT - height) {
			y = MainPanel.HEIGHT - height;
		}
	}

	/**
	 * プレイヤーを描画する
	 *
	 * @param g 描画オブジェクト
	 */
	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}

	/**
	 * プレイヤーの位置を返す
	 *
	 * @return プレイヤーの位置座標
	 */
	public Point getPos() {
		return new Point(x, y);
	}

	/**
	 * プレイヤーの幅を返す
	 *
	 * @param width プレイヤーの幅
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * プレイヤーの高さを返す
	 *
	 * @return height プレイヤーの高さ
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * イメージをロードする
	 *
	 */
	private void loadImage() {
		// プレイヤーのイメージを読み込む
		// ImageIconを使うとMediaTrackerを使わなくてすむ
		ImageIcon icon = new ImageIcon(getClass().getResource(
				"image/player.jpg"));
		image = icon.getImage();

		// 幅と高さをセット
		width = image.getWidth(panel);
		height = image.getHeight(panel);
	}
}