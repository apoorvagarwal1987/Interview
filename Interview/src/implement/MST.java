package implement;

import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge>{
	int v1;
	int v2;
	int value;
	public String toString(){		
		return v1+"---->"+v2+"::"+value;
	}
	public Edge (int x1,int x2, int value){
		v1=x1;
		v2=x2;
		this.value=value;
	}
	@Override
	public int compareTo(Edge second) {
		if(this.value<second.value)
			return -1;
		
		if(second.value<this.value)
			return 1;
		
		return 0;
	}
}

public class MST {
	
	public static void kruskal(int vertices, ArrayList<Edge> edges){
		UnionFind uf = new UnionFind(vertices);
		Collections.sort(edges);
		ArrayList<Edge> output = new ArrayList<Edge>();
		int sum=0;
		for(Edge edge:edges){
			int v1 = edge.v1;
			int v2 = edge.v2;
			
			Union u1 = new Union(v1);
			Union u2 = new Union(v2);
			
			if(uf.find(u1, u2))
				continue;
			
			uf.union(u1, u2);
			output.add(edge);
			sum = sum+edge.value;
		}
		
		for(Edge edge:output){
			System.out.println(edge);
		}
		System.out.println("Total MST :"+sum);
	}
			
	public static void main(String ... args){
		
		ArrayList<Edge> edges = new ArrayList<Edge>();

/*		edges.add(new Edge(0,1,4));
		edges.add(new Edge(0,7,8));
		
		edges.add(new Edge(1,2,8));
		edges.add(new Edge(1,7,11));
		
		edges.add(new Edge(2,3,7));
		edges.add(new Edge(2,5,4));
		edges.add(new Edge(2,8,2));
		
		edges.add(new Edge(7,8,7));
		edges.add(new Edge(7,6,1));
		
		edges.add(new Edge(6,5,2));
		edges.add(new Edge(6,8,6));
		
		edges.add(new Edge(3,5,14));
		edges.add(new Edge(3,4,9));
		
		edges.add(new Edge(5,4,10));*/
		
		
		edges.add(new Edge(0,1,10));
		edges.add(new Edge(0,3,5));
		edges.add(new Edge(0,2,6));
		
		edges.add(new Edge(2,3,4));
		
		edges.add(new Edge(3,1,15));	
		
		
		kruskal(4,edges);
	}
}
