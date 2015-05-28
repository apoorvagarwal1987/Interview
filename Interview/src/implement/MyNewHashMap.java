package implement;


class KeySpace{
	String[] keyTable;
	int total;
	int size;
	
	public KeySpace(){
		size=3;
		keyTable = new String[size];
		total=0;
	}
	
	public void put(int hash, String key){
		if(total==size){
			growTable();
		}
		System.out.println("Key :" +key+ " is added hash "+hash + " inside "+ (total+1));
		keyTable[total++]=key;		
	}

	public void get(int hash, String key){
		int count =0;
		for(String pKey:keyTable){
			count++;
			if(pKey!=null && pKey.equals(key)){
				System.out.println("Key "+key+ " at hash "+hash+"  inside " + (count));
				return;
			}
		}
		System.out.println("Key not found ");
	}
		
	private void growTable() {
		System.out.println("Growing up the Key Table");
		size = size * 2;
		String shadow[] = new String[size];
		for(int i=0;i<total;i++){
			shadow[i]=keyTable[i];
		}
		keyTable=shadow;
	}
}


public class MyNewHashMap {
	KeySpace[] keyMap = new KeySpace[5];
	
	private int getHash(String key){
		int hash =0;
		if(key==null)
			return -1;
		
		for(int i=0;i<key.length();i++){
				hash+=key.charAt(i)-'a';
				hash = hash%keyMap.length;
		}
			return hash;
	}
	
	public void put(String key){
		int hash = getHash(key);
		if(keyMap[hash]==null)
			keyMap[hash]=new KeySpace();
		
		keyMap[hash].put(hash, key);
	}
	
	public void get(String key){
		int hash = getHash(key);
		if(keyMap[hash]==null){
			System.out.println("Key not found");
			return;
		}
		keyMap[hash].get(hash, key);
	}
	
	
	public static void main(String[] args) {
		String keys[] = {"ab","ba","bc","cb","cd","ef","cc","bb","dd","ff","gg","hh","ii","jj","kk","ll","mm"};
		MyNewHashMap map = new MyNewHashMap();
		for(String key:keys){
			map.put(key);		
		}
		map.get("ab");
	}

}
