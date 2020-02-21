package taedeEngine;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A list that manages items
 * @author Twentyone
 *
 */
public class ItemList implements List<Item> {
	
	private Element head;

	@Override
	public boolean add(Item arg0) {
		this.head = new Element(null, arg0, this.head);
		return true;
	}

	@Override
	public void add(int arg0, Item arg1) {
		Element current = this.head;
		Element newElement = new Element(arg1);
		if (current == null) {
			this.head = newElement;
		} else {
			for (int a = 0; a < arg0; a++) {
				if (current.getNext() == null) {
					a = arg0;
				} else {
					current = current.getNext();
				}
			}
			if (current.getPrevious() != null) {
				current.getPrevious().setNext(newElement);
			}
			current.setPrevious(newElement);
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int arg0, E arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}

class Element {
	private Item content;
	private Element previous;
	private Element next;
	
	Element() {
	}
	
	Element(Element previous, Item content, Element next) {
		this.content = content;
		this.previous = previous;
		this.next = next;
	}
	
	Element(Item content) {
		this.content = content;
	}
	
	void setPrevious(Element newPrevious) {
		this.previous = newPrevious;
		this.previous.next = this;
	}
	
	void setNext(Element newNext) {
		this.next = newNext;
		this.next.previous = this;
	}
	
	void setContent(Item newContent) {
		this.content = newContent;
	}
	
	Element getPrevious() {
		return this.previous;
	}
	
	Element getNext() {
		return this.next;
	}
	
	Item getContent() {
		return this.content;
	}
}
