package implement;

public class HeapSort {
	
	private void swap(int [] arr, int pos1, int pos2){
		int temp = arr[pos1];
		arr[pos1]= arr[pos2];
		arr[pos2]=temp;		
	}
	private int getParent(int pos){
		int parent;		
		if(pos%2==0) 
			parent = (pos/2)-1;
		
		else
			parent=(pos/2);
		
		return parent;
	}
	private void swim(int[]arr, int child){		
		int parent = getParent(child);
		if(parent<0)
			return;
		
		if(arr[parent]>arr[child]){
			swap(arr,child,parent);
			swim(arr, parent);
		}		
	}
	private void sink(int[]arr,int parent,int size){
		int child1=2*parent+1;
		int child2=2*parent+2;
		
		if(child1<=size && child2<=size){
			int swapChild;
						
			if((arr[parent]<arr[child1]) && (arr[parent]>arr[child2])){
				swap(arr,parent,child2);
				sink(arr,child2,size);
			}
			else if((arr[parent]>arr[child1]) && (arr[parent]<arr[child2])){
				swap(arr,parent,child1);
				sink(arr,child1,size);
			}
			else if((arr[parent]>arr[child1]) && (arr[parent]>arr[child2])){
				if((arr[child1]<arr[child2])){
					swap(arr,parent,child1);
					sink(arr,child1,size);
				}				
				else{
					swap(arr,parent,child2);
					sink(arr,child2,size);
				}
			}			
		}
		else if(child1<=size){
			if(arr[parent]>arr[child1]){
				swap(arr,parent,child1);
				sink(arr,child1,size);
			}
		}
		else if(child2<=size){
			if(arr[parent]>arr[child2]){
				swap(arr,parent,child2);
				sink(arr,child2,size);
			}			
		}
		else{
			
		}
	}
	private void heapify(int arr[]){		
		for(int i=arr.length-1;i>=0;i--){
			swim(arr,i);
		}
	}
	private void heapSort(int[] arr){
		heapify(arr);
		int size=arr.length-1;
		while(size!=0){
			swap(arr,0,size);
			sink(arr,0,size-1);
			size--;
		}		
	}
	
	public static void main(String...args){
		int arr[]= {4,2,7,8,9,10};
		HeapSort hs = new HeapSort();
		hs.heapSort(arr);
		for(int i =0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
	
	
}
