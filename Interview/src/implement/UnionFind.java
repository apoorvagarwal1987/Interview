package implement;
class Union{
	int size;
	int value;
	
	public Union(int x){
		size=1;
		value=x;
	}
}

public class UnionFind {
	int size;
	Union[] unions ;
	
	public UnionFind(int size){
		this.size=size;
		unions = new Union[size];
		for(int i = 0;i<size;i++){
			unions[i]=new Union(i);
		}
	}
	
	public Union getRoot(Union node){
		while((unions[node.value]).value!=node.value)
			node = unions[node.value];		
		return node;
	}
	
	public boolean find(Union u1, Union u2){
		return (getRoot(u1).value==getRoot(u2).value);
	}
	
	public void union(Union u1, Union u2){
		Union rU1 = getRoot(u1);
		Union rU2 = getRoot(u2);
		if(rU1.value==rU2.value)
			return;
		
		if(rU1.size<rU2.size){
			unions[rU1.value]=rU2;
			rU2.size+=rU1.size;
		}
		else{
			unions[rU2.value]=rU1;
			rU1.size+=rU2.size;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
