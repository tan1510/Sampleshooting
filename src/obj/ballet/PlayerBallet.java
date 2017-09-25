package obj.ballet;

import java.awt.Color;

import densan.s.game.drawing.Drawer;
import densan.s.game.manager.GameManager;
import densan.s.game.object.GameObjectBase;

public class PlayerBallet extends GameObjectBase implements Ballet{

	public PlayerBallet(double x, double y, double rad, double speed) {
		super(x, y, 10, 10);
		// TODO Auto-generated constructor stub
		setVector(speed, rad);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("aa");
		move();
		vanish();
	}

	@Override
	public void draw(Drawer d) {
		// TODO Auto-generated method stub
		d.setColor(Color.BLACK);
		d.drawCircle(getCenterX(), getCenterY(), 10);
	}

	@Override
	/**
	 * 消失判定
	 */
	public void vanish() {
		// TODO Auto-generated method stub
		//画面外に出たか
		if(!(0<getMaxY()&&getY()<GameManager.getInstance().getFrameHeight()&&0<getMaxX()&&getX()<GameManager.getInstance().getFrameWidth())) 
			remove();
		}
	
}
