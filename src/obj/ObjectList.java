package obj;

public enum ObjectList {
	
	PLAYER(0x0000),
	ENEMY(0x0001),
	LIFEGAIN_TEM(0x0002);
	
	
	
	;
	private final int id;
	private ObjectList(int id){
		this.id = id;
	}
	
	 /**id から、定数オブジェクトを逆引きするメソッド
	  * 
	  * @param id
	  * @return
	  */
    public static ObjectList valueOf(int id) {
        // values() で、列挙したオブジェクトをすべて持つ配列が得られる
        for (ObjectList num : values()) {
            if (num.getId() == id) { // id が一致するものを探す
                return num;
            }
        }
        throw new IllegalArgumentException("no such enum object for the id: " + id);
    }

	private int getId() {
		// TODO 自動生成されたメソッド・スタブ
		return id;
	}

}
