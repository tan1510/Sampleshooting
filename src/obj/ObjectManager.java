package obj;

import java.util.ArrayList;
import java.util.Iterator;

import densan.s.game.calc.Calc;
import densan.s.game.drawing.Drawer;
import densan.s.game.manager.GameManager;
import densan.s.game.object.GameObjectBase;
/**
 * ゲームのオブジェクトを管理するクラス
 * @author isato
 *
 * @param <T>
 */
public class ObjectManager<T extends GameObjectBase> {
/**
 * 
 */
	private  ArrayList<T> objects = new ArrayList<T>();
	
	private ArrayList<T> additionalObjects = new ArrayList<T>();
	
	private static ObjectManager instance = new  ObjectManager<>();
	
	private ObjectManager(){
		
	}
	
	public static ObjectManager getInstace(){
		return instance;
	}
	/**
	 * オブジェクトのすべてにアップデート
	 */
	public void update() {
		Iterator<T> itr = objects.iterator();
		T o;
		while(itr.hasNext()) {
			o = itr.next();
			o.update();
		}
		collisionPlayer();
		removeProccess();
		joinList();
	}
	/**
	 * オブジェクトにremoveフラグが立っている場合消去
	 */
	private void removeProccess() {
		Iterator<T> itr = objects.iterator();
		T o;
		while(itr.hasNext()) {
			o = itr.next();
			if(o.isRemove())
				itr.remove();
		}
	}
	
	/**
	 * プレイヤーの当たり判定
	 */
	private void collisionPlayer(){
		Iterator<T> itr1 = objects.iterator();
		T o1;
		while(itr1.hasNext()) {
			o1 = itr1.next();
			if(o1 instanceof Player){
				Iterator<T> itr2 = objects.iterator();
				T o2;
				o2 = itr1.next();
				if(o2 instanceof Enemy){
					if(Calc.collisionCircleDetection(o1, o2))
					((Player) o1).damage();
				}
			}
		}
	}
/**
 * リストにゲームオブジェクトを登録する待機状態にする
 * その語updateメソッドのjoinlistでobjectsに追加される
 * @param object
 */
	public  void registerObject(T object) {
		additionalObjects.add(object);
	}
/**
 * インスタンスの参照
 */
	public ObjectManager getInstance() {
		return instance;
	}
	
	/**
	 * 追加されるのを待機しているオブジェクトをobjectsに追加しaddtionalObjectsリストを空にする
	 */
	private void joinList() {
		objects.addAll(additionalObjects);
		additionalObjects.clear();
	}
	/**
	 * 
	 * @param d
	 */
	public void draw(Drawer d) {
		Iterator<T> itr = objects.iterator();
		T o;
		while(itr.hasNext()) {
			o = itr.next();
			o.draw(d);
		}
	}
}
