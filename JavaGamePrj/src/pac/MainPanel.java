package pac;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements Runnable, KeyListener {
	// パネルサイズ
	public static final int WIDTH = 800;
	public static final int HEIGHT = 640;

	// 方向定数
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;

	// プレイヤー
	private Player player;

	// キーの状態（このキー状態を使ってプレイヤーを移動する）
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	private boolean upPressed = false;
	private boolean downPressed = false;

	// ゲームループ用スレッド
	private Thread gameLoop;

	public MainPanel() {
		// パネルの推奨サイズを設定、pack()するときに必要
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		// パネルがキー入力を受け付けるようにする
		setFocusable(true);

		// プレイヤーを作成
		player = new Player(WIDTH / 2, HEIGHT / 2, this);

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
			// 押されているキーに応じてプレイヤーを移動する
			// 何も押されていないときは移動しない
			if (leftPressed) {
				player.move(LEFT);
			} else if (rightPressed) {
				player.move(RIGHT);
			} else if (upPressed) {
				player.move(UP);
			} else if (downPressed) {
				player.move(DOWN);
			}

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

	public void keyTyped(KeyEvent e) {
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
		if (key == KeyEvent.VK_UP) {
			upPressed = true;
		}
		if (key == KeyEvent.VK_DOWN) {
			downPressed = true;
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
		if (key == KeyEvent.VK_UP) {
			upPressed = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			downPressed = false;
		}
	}
}
