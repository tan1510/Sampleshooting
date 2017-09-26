package scene;
import java.awt.Color;

import densan.s.game.drawing.Drawer;
import densan.s.game.manager.Updatable;
import obj.Enemy;
import obj.ObjectManager;
import obj.Player;
 
 
public class GameScene implements Updatable{
 /**
  * オブジェクトマネージャーへの参照
  */
	private ObjectManager om = ObjectManager.getInstace();
			
	public GameScene() {
		om.registerObject(new Player());
		om.registerObject(new Enemy(100));
	}
 
	@Override
	public void update() {
		om.update();//登録されているオブジェクトすべてにupdateを実行
	}
 
	@Override
	public void draw(Drawer d) {
		//ちゃんとクラスを使えてるか確認するための文字描画
		om.draw(d);
		d.setColor(Color.BLUE);
		d.setFontSize(40);
		d.drawString("TEST", 100, 100);
		
 
	}
 
}
 