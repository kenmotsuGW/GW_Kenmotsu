package pac;

import java.awt.Container;

import javax.swing.JFrame;

public class GameMain extends JFrame {
	public GameMain() {
		// タイトルを設定
		setTitle("ジャンプ");
		// サイズ変更不可
		setResizable(false);

		// メインパネルを作成してフレームに追加
		MainPanel panel = new MainPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);

		// パネルサイズに合わせてフレームサイズを自動設定
		pack();
	}

	public static void main(String[] args) {
		GameMain frame = new GameMain();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
