package general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

class MyIterator {
	
	private Iterator<Integer> thisIterator;
	private Object peekVal;
	private boolean nextItem;
	public MyIterator (Iterator<Integer> otherIterator){
		peekVal = null;
		thisIterator=(Iterator<Integer>) otherIterator;
		nextItem=otherIterator.hasNext();
	}



	public boolean hasNext() {
		// TODO Auto-generated method stub		
		return nextItem;
	}

	public Object next() throws NoSuchElementException{
		// TODO Auto-generated method stub
		if(!nextItem)
			throw new NoSuchElementException();
		
		if(peekVal==null){
			peekVal=thisIterator.next();					
		}
		Object retValue = peekVal;
		nextItem=thisIterator.hasNext();
		if(!nextItem){
			peekVal=null;
			return retValue;
		}	
		peekVal=thisIterator.next();		
		return retValue;
	}

	public void remove() throws UnsupportedOperationException{
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	public Object peek() throws NoSuchElementException{
		if(!nextItem)
			throw new NoSuchElementException();
		
		if(peekVal==null){
			peekVal=thisIterator.next();					
		}		
		return peekVal;
		
	}
}

public class MyIteratorImpl{
	public static void main(String ... args){
		ArrayList<Integer> temp =  new ArrayList<Integer>();
		temp.add(1);
		/*temp.add(2);
		temp.add(3);
		temp.add(4);*/
		MyIterator myIt = new MyIterator(temp.iterator());
		System.out.println(myIt.next());
		/*while(myIt.hasNext())
			System.out.println(myIt.next());
		
		System.out.println(myIt.peek());
		*/
		System.out.println(myIt.peek());
	}
}
