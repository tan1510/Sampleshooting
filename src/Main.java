import densan.s.game.manager.GameManager;
import scene.GameScene;

public class Main {
	public static void main(String[] args) {
		GameManager gm = GameManager.getInstance();
		//このメソッドでウインドウを表示する
		//引数はそれぞれ(幅, 高さ, タイトルバーに表示する文字)
		gm.createFrame(800, 600, "シューティングゲーム");
		//更新と描画を担うオブジェクトを設定
		//今はあまり関係ない
		gm.setUpdatable(new GameScene());
	}
}
