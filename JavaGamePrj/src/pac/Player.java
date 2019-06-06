package pac;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {
	// 幅
	public static final int WIDTH = 64;
	// 高さ
	public static final int HEIGHT = 64;
	// スピード
	private static final int SPEED = 6;
	// ジャンプ力
	private static final int JUMP_SPEED = 24;
	// 重力
	private static final double GRAVITY = 2.0;

	// 位置
	private double x;
	private double y;

	// 速度
	private double vx;
	private double vy;

	// プレイヤーの幅
	private int width;
	// プレイヤーの高さ
	private int height;

	// 着地しているか
	private boolean onGround;

	// プレイヤーの画像
	private Image image;

	// メインパネルへの参照
	private MainPanel panel;

	public Player(double x, double y, MainPanel panel) {
		this.x = x;
		this.y = y;
		vx = 0;
		vy = 0;
		onGround = false;

		this.panel = panel;

		// イメージをロード
		loadImage();
	}

	/**
	 * 停止する
	 */
	public void stop() {
		vx = 0;
	}

	/**
	 * 左に加速する
	 */
	public void accelerateLeft() {
		vx = -SPEED;
	}

	/**
	 * 右に加速する
	 */
	public void accelerateRight() {
		vx = SPEED;
	}

	/**
	 * ジャンプする
	 */
	public void jump() {
		if (onGround) {
			// 上向きに速度を加える
			vy = -JUMP_SPEED;
			onGround = false;
		}
	}

	/**
	 * プレイヤーの状態を更新する
	 */
	public void update() {
		// 重力で下向きに加速度がかかる
		vy += GRAVITY;

		// 速度を元に位置を更新
		x += vx;
		y += vy;
		// 着地したか調べる
		if (y > MainPanel.HEIGHT - height) {
			vy = 0;
			y = MainPanel.HEIGHT - height;
			onGround = true;
		}
		// 画面の外に出ていたら中に戻す
		if (x < 0) {
			x = 0;
		}
		if (x > MainPanel.WIDTH - width) {
			x = MainPanel.WIDTH - width;
		}
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
	 * プレイヤーを描画
	 *
	 * @param g 描画オブジェクト
	 */
	public void draw(Graphics g) {
		//g.setColor(Color.RED);
		//g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
		g.drawImage(image, (int) x, (int) y, null);
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
