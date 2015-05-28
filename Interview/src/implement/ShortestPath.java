package implement;

import java.util.HashSet;
import java.util.Set;

public class ShortestPath {
	
	int[][]adjMatrix;
	int vertices;
	
	public ShortestPath(int x){
		vertices=x;
		adjMatrix=new int[x][x];
		for(int i=0;i<x;i++){
			for(int j=0;j<x;j++){
				adjMatrix[i][j]=Integer.MAX_VALUE;
			}
		}
	}
	
	public void addEdge(int v1,int v2, int weight){
		adjMatrix[v1][v2]=weight;
		adjMatrix[v2][v1]=weight;
	}
	
	public void addOneEdge(int v1,int v2, int weight){
		adjMatrix[v1][v2]=weight;
	}
	
	private int findMin(int[]path, Set<Integer> visited){
		int min=Integer.MAX_VALUE;
		int minIndex=-1;
		for(int i=0;i<path.length;i++){
			if(min>path[i] && !visited.contains(i)){
				min=path[i];
				minIndex=i;
			}				
		}
		return minIndex;
	}
	
	private void dijkstra(int startNode){
		int[] path = new int [adjMatrix.length];
		Set<Integer> visited = new HashSet<Integer>();
		for(int i=0;i<adjMatrix.length;i++){
			path[i]=Integer.MAX_VALUE;
		}
		path[startNode]=0;
		
		while(visited.size()!=adjMatrix.length){
			int nextNode=findMin(path, visited);
			visited.add(nextNode);
			for(int adjNode=0;adjNode<adjMatrix.length;adjNode++){
				if(adjMatrix[nextNode][adjNode]!=Integer.MAX_VALUE){
					int dist=adjMatrix[nextNode][adjNode];
					if(path[nextNode]+dist<path[adjNode])
						path[adjNode]=dist+path[nextNode];
					
				}
			}
		}		
		int count=0;
		for(int value: path){
			System.out.println(count+"  "+value);
			count++;
		}
		return;
	}
	
	private void bellmanFord(int startNode){
		boolean isChange=true;
		
		int path[]= new int[vertices];
		int parent[]=new int[vertices];
		int next[]=new int [vertices];
		
		for(int i=0;i<adjMatrix.length;i++){
			path[i] = Integer.MAX_VALUE;
			next[i] = Integer.MAX_VALUE;
			parent[i]=-1; 
		}
		int count=1,loop=0;
		path[startNode]=0;
		next[startNode]=0;
		while(isChange && count!=vertices){
			isChange=false;
			loop=0;
			for(int i=0;i<vertices;i++){
				if(path[i]!=Integer.MAX_VALUE){
					for(int adjNode=0;adjNode<adjMatrix.length;adjNode++){
						if(adjMatrix[i][adjNode]!=Integer.MAX_VALUE){
							int dist=adjMatrix[i][adjNode] + path[i];
							if(dist<path[adjNode]){
								next[adjNode]=dist;
								isChange=true;
								parent[adjNode]=i;
							}
						}
					}
				}				
			}
			System.out.println("Iteration :" +count);
			for(int value: next){
				System.out.println(loop+"  "+value);
				loop++;
			}
			path=next;	
			count++;
		}
		
		/*count=0;
		for(int value: path){
			System.out.println(count+"  "+value);
			count++;
		}*/
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestPath sp = new ShortestPath(4);
		/*
		sp.addEdge(0,1,4);
		sp.addEdge(0,7,8);
		
		sp.addEdge(1,2,8);
		sp.addEdge(1,7,11);
		
		sp.addEdge(2,3,7);
		sp.addEdge(2,5,4);
		sp.addEdge(2,8,2);
		
		sp.addEdge(7,8,7);
		sp.addEdge(7,6,1);
		
		sp.addEdge(6,5,2);
		sp.addEdge(6,8,6);
		
		sp.addEdge(3,5,14);
		sp.addEdge(3,4,9);
		
		sp.addEdge(5,4,10);*/
		
	/*	sp.addOneEdge(0, 1, -1);
		sp.addOneEdge(0, 2, 4);
		
		sp.addOneEdge(1, 2, 3);
		sp.addOneEdge(1, 4, 2);
		sp.addOneEdge(1, 3, 2);
		
		sp.addOneEdge(3, 1, 1);
		sp.addOneEdge(3, 2, 5);
		
		sp.addOneEdge(4, 3, -3);*/
		
		sp.addOneEdge(0, 1, 1);
		sp.addOneEdge(0, 2, 0);
		sp.addOneEdge(0, 3, 99);
		sp.addOneEdge(3, 1, -300);
		sp.addOneEdge(1, 2, 1);
		
		
		
		sp.dijkstra(0);
		sp.bellmanFord(0);
		
		
	}

}
