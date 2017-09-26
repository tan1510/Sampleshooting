package obj;

import java.awt.Color;

import densan.s.game.drawing.Drawer;
import densan.s.game.manager.GameManager;
import densan.s.game.object.GameObjectBase;
/**
 * GameObjectBaseを継承したEnemyのクラス
 * @author tachibana
 *
 */
public class Enemy extends GameObjectBase{
/**
 * 半径
 */
	private static final int SIZE =50;
	/**
	 * 速度
	 */
	private static final double SPEED = 1.5;
	
	public Enemy( double y) {
		super(GameManager.getInstance().getFrameWidth(), y, SIZE, SIZE);
		// TODO 自動生成されたコンストラクター・スタブ
		setVx(-SPEED);
	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		move();
	}

	@Override
	public void draw(Drawer d) {
		// TODO 自動生成されたメソッド・スタブ
		d.setColor(Color.RED);
		d.fillRect(getX(), getY(), getWidth(), getHeight());
	}

}
