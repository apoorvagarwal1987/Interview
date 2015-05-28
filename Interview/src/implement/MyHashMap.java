package implement;

public class MyHashMap {
	static String location[];
	static int present;
	static int hop;
	
	static {
		location = new String[25];
		present = 0;
		hop=13;
	}
	
/*	private int getHashString(String key){
		if(key==null){
			return -1;
		}
		if(present != location.length){
			int hash =0;
			for(int i=0;i<key.length();i++){
				hash+=(key.charAt(i)-'a') * (Math.pow(2,i)%location.length);
				hash = hash%location.length;
			}
			return hash;			
		}
		return -1;
	}*/
	
	private int getHash(String key){
		int hash =0;
		if(key==null)
			return -1;
		
		if(present != location.length){
			for(int i=0;i<key.length();i++){
				hash+=key.charAt(i)-'a';
				hash = hash%location.length;
			}
			if(hash<0)
				return -1;
			return hash;
		}
		return -1;
	}
	
	public void put(String key){
		int hash = getHash(key);
		if(hash==-1)
			System.out.println("Hash is full");
		
		while(location[hash]!=null){
			System.out.println("Collison happened at "+ hash + " for key "+ key);
			hash+=hop;
			hash%=location.length;					
		}
		present++;
		location[hash]=key;
	}
	
	static void printMap(){
		for(int i =0; i<location.length;i++){
			System.out.println("key at location "+ i + " is " + location[i]);
		}
	}
	
	public void get(String key){
		int hash = getHash(key);
		if(hash==-1){
			System.out.println("Hash is empty");
			return;
		}
		int count=0;
		while(location[hash]!=key && count<location.length){
			hash+=hop;
			hash%=location.length;
			count++;
		}
		if(count==location.length){
			System.out.println("Key is absent");
		}
		else{
			System.out.println("key found at "+ hash);
		}
	}

	public static void main(String ... args){
		String keys[] = {"ab","ba","bc","cb","cd","ef"};
		MyHashMap map = new MyHashMap();
		for(String key:keys){
			map.put(key);		
		}
		
		printMap();
		
		map.get("bacc");
		
	}


}
