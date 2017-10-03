package obj;
import java.awt.Color;
import java.awt.event.KeyEvent;
 
import densan.s.game.drawing.Drawer;
import densan.s.game.input.KeyInput;
import densan.s.game.object.GameObjectBase;
import obj.ballet.PlayerBallet;
 
 
public class Player extends GameObjectBase {
	/**
	 * 
	 */
	public static final int SPEED = 2;
	/**
	 * 
	 */
	private static final int SHOOT_WAIT_FRAME = 10;
	
	/**
	 * 
	 */
	private static final int INVINSIBLE =40;
	private ObjectManager om;
	
	public Player() {
		super(100, 100, 50, 50);
		 om = ObjectManager.getInstace(); 
	}
 
	@Override
	public void update() {
		movement();
		shoot();
		if(damageCount>0)
			damageCount--;
	}
	
	/**
	 * 移動処理
	 */
	private void movement() {
		if (KeyInput.isPressing(KeyEvent.VK_UP)) {
			addY(-SPEED);
		}
		if (KeyInput.isPressing(KeyEvent.VK_DOWN)) {
			addY(SPEED);
		}
		if (KeyInput.isPressing(KeyEvent.VK_RIGHT)) {
			addX(SPEED);
		}
		if (KeyInput.isPressing(KeyEvent.VK_LEFT)) {
			addX(-SPEED);
		}
	}
 
	private int restTime = 0;
	private void shoot() {
		if(KeyInput.isPressing(KeyEvent.VK_Z)&&restTime==0) {
			om.registerObject(new PlayerBallet(getCenterX(), getCenterY(), 0, 8));
			restTime = SHOOT_WAIT_FRAME;
		}
		if(restTime>0)
			restTime--;
	}
	/**
	 * ダメージ食らった時のカウント
	 */
	private int damageCount = 0;
	/**
	 *被弾
	 */
	public void damage(){
		if(damageCount==0){
	//未実装
		System.out.println("damaged");
		damageCount=INVINSIBLE;
		}
	}
	
	@Override
	public void draw(Drawer d) {
		d.setColor(Color.BLUE);
		d.fillRect(getX(), getY(), getWidth(), getHeight());
 
	}
	
 
}