package pac;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements Runnable, KeyListener {
	// パネルサイズ
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;

	// プレイヤー
	private Player player;

	// キーの状態（押されているか、押されてないか）
	private boolean leftPressed;
	private boolean rightPressed;
	private boolean upPressed;

	// ゲームループ用スレッド
	private Thread gameLoop;

	public MainPanel() {
		// パネルの推奨サイズを設定、pack()するときに必要
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		// パネルがキー入力を受け付けるようにする
		setFocusable(true);

		// プレイヤーを作成
		player = new Player(0, HEIGHT - Player.HEIGHT, this);

		// キーイベントリスナーを登録
		addKeyListener(this);

		// ゲームループ開始
		gameLoop = new Thread(this);
		gameLoop.start();
	}

	/**
	 * ゲームループ
	 */
	public void run() {
		while (true) {
			if (leftPressed) {
				// 左キーが押されていれば左向きに加速
				player.accelerateLeft();
			} else if (rightPressed) {
				// 右キーが押されていれば右向きに加速
				player.accelerateRight();
			} else {
				// 何も押されてないときは停止
				player.stop();
			}

			if (upPressed) {
				// ジャンプする
				player.jump();
			}

			// プレイヤーの状態を更新
			player.update();

			// 再描画
			repaint();

			// 休止
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 描画処理
	 *
	 * @param 描画オブジェクト
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// 背景を黒で塗りつぶす
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		// プレイヤーを描画
		player.draw(g);
	}

	/**
	 * キーが押されたらキーの状態を「押された」に変える
	 *
	 * @param e キーイベント
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		if (key == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
		if (key == KeyEvent.VK_SPACE) {
			upPressed = true;
		}
	}

	/**
	 * キーが離されたらキーの状態を「離された」に変える
	 *
	 * @param e キーイベント
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if (key == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
		if (key == KeyEvent.VK_SPACE) {
			upPressed = false;
		}
	}

	public void keyTyped(KeyEvent e) {
	}
}
