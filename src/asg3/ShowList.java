//--------------------------------------------
//Assignment 03
//Part 2
//© Waleed Ahmed Siddiqui
//Written by: Waleed Ahmed SIDDIQUI 40186042
//--------------------------------------------
package asg3;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * ShowList is a custom Linked List for Storing, retreiving and modifying TVShow Objects.
 * @author Waleed Ahmed Siddiqui
 * @version 1.0
 *
 */

public class ShowList {
	
	private ShowNode head;
	private int size=size();
	public int totat_iterations;
	
	
	/**
	 * Size() method will keep track of number's of nodes in ShowList.
	 * @return int- Size of ShowList.
	 */
	public int size() {
		int result=0;
		
		ShowNode runNode= head;
		while(runNode!=null) {
			runNode=runNode.next;
			result++;
		}
		
		return result;
	}
	
	
	/**
	 * insert() method will attach new node at the end of ShowList.
	 * @param newnode - TVShow Object.
	 */
	public void insert(TVShow newnode) {
		
		ShowNode node= new ShowNode();
		node.TVShowNode= newnode;
		
		if(head==null) { //if this is first element
			head=node;
		}
		
		else {// if head is not null
			
			ShowNode tempNode= head; //Temprory node to traverse showlist till end
			while(tempNode.next!=null) {
				tempNode=tempNode.next;
			}				
			tempNode.next=node; //if null Found, attach new node here.
						
		}
				
	}
	
	/**
	 * Show() - To print all nodes data sequentially.
	 */
	public void show() {
		ShowNode printNode= head; //it will print only if LL has some elements.
		
		while(printNode!=null) {
			System.out.println(printNode.TVShowNode.toString());
			printNode=printNode.next;
		}		
	}
	
	/**
	 * insertAtStart()- This method will attach new node at the start of ShowList.
	 * @param newNode - TVShow Object.
	 */
	
	public void insertAtStart(TVShow newNode) {
		
		ShowNode addNode= new ShowNode();
		addNode.TVShowNode=newNode;
		addNode.next=null;
		addNode.next=head;
		head=addNode;
	}
		
	/**
	 * Default Constructor to initialize empty Show List.
	 */
	ShowList(){// Default Constructor
		//a list is by default empty when it initialize.
		this.head=null;
	
	}
	
	
	
	/**
	 * Copy Constructor to copy other ShowList.
	 * @param s
	 */
	ShowList(ShowList s){// Copy Constructor - to copy other list.
		ShowNode previous =s.head.clone();
		ShowNode temp=null;
		ShowNode first=null;
		
		while(previous!=null) {
			ShowNode mynode= new ShowNode(previous.TVShowNode); //this will give deep copy node.
			
			if(first==null) {//head node
				first=mynode;
				temp=first;
			}
			
			else {
				temp.next=mynode;
				temp=temp.next;
			}
			previous=previous.next;
		}
		this.head=first;
	
	}

	
	
	/**
	 * addToStart()- This method will attach new node at the start of ShowList.
	 * @param newNode - TVShow Object.
	 */
	public void addToStart(TVShow newNode) {
		
		ShowNode addNode= new ShowNode();
		addNode.TVShowNode=newNode;
		addNode.next=head;
		head=addNode;
	
	}
	
	/**
	 * insertAtend - This method will attach new node at the end of ShowList.
	 * @param newNode - TVShow Object.
	 */
	
public void insertAtend(TVShow newNode) {
		
		if(size()==0) {
			insertAtStart(newNode);
		}
		else {
		ShowNode addNode = new ShowNode();
		addNode.TVShowNode=newNode;
		
		ShowNode tempnode=head;
		int counter=0;
		while(counter<size()-1) {
			tempnode=tempnode.next;
			counter++;
		}
		tempnode.next=addNode;
		
		}
				
	}

	/**
	 * insertAtIndex() - This method will attach new node at the given Index.
	 * @param newNode - TVShow Object.
	 * @param index - index position.
	 */

	public void insertAtIndex(TVShow newNode, int index) {
		
		if(index==0 && size()>0) {
			insertAtStart(newNode);
		}
		
		else if(index <0 || index>=size()) {
			
			throw new NoSuchElementException("Invalid Index");
		}
		
		else if(index==size()-1) {
			insertAtend(newNode);
		}
		
		else {
			ShowNode currentNode=new ShowNode();
			currentNode.TVShowNode=newNode;
			
			ShowNode tempNode=head;
			int counter=0;
			while(counter!=index-1 && tempNode!=null) {
				tempNode=tempNode.next;
				counter++;
			}
			currentNode.next=tempNode.next;
			tempNode.next=currentNode;
			
			
		}
		
	}
	
	/**
	 * deleteFromIndex() - This method will remove node from given Index.
	 * @param index - index position.
	 */
	
	public void deleteFromIndex(int index) {
		
		if(index<0 || index>size()) {
			throw new NoSuchElementException("Invalid Index");
		}
		
		else if(index==0)
			deleteFromStart();
		
		else {
			ShowNode tempNode=head;
			ShowNode tempNode2=null;
			int counter=0;
			while(counter!=index-1 && tempNode!=null) {
				tempNode=tempNode.next;
				counter++;
			}
			tempNode2=tempNode.next;
			tempNode.next=tempNode2.next;
			
			
		}
		
	}
	
	/**
	 * deleteFromStart() - This method will remove first node from the Show List.
	 */
	
	public void deleteFromStart() {
		//delete first head node.
		if(size()!=0) {
		ShowNode tempNode= head;
		head=tempNode.next; }
		
	}
	
	/**
	 * deleteFromEnd() - This method will remove last node from the Show List.
	 */
	
	public void deleteFromEnd() {
		
	 if(size()==1) {
		 deleteFromStart();
	 }
	else if(size()>1) {
			int counter=0;
		ShowNode tempnode=head;
		while(counter<size()-2 && tempnode!=null) {
			tempnode=tempnode.next;
			//System.out.println(tempnode.TVShowNode.toString());
			counter++;
		}
		tempnode.next=null;
		
		}
	}
	
	/**
	 * replaceAtIndex() - This Method will replace TVShow by new TVShow on given specified index
	 * @param newNode - TVShow object.
	 * @param index - Index of ShowList.
	 */
	public void replaceAtIndex(TVShow newNode, int index) {
			
			if(index <0 || index>=size()) {
				
				throw new NoSuchElementException("Invalid Index");
			}
			
			if(index==0 && size()>0) {
				head.TVShowNode=newNode;
				
			}
			
			
			else {
				ShowNode currentNode=new ShowNode();
				currentNode.TVShowNode=newNode;
				
				ShowNode tempNode=head;
				int counter=0;
				while(counter!=index && tempNode!=null) {
					tempNode=tempNode.next;
					//System.out.println(tempNode.TVShowNode.getshowName());
					counter++;
				}
				tempNode.TVShowNode=newNode;
				
				
			}
			
		
	}
	
	/**
	 * find() - This method will find for a node which has same Show ID.
	 * @param ShowID - TVShow.ShowId 
	 * @return ShowNode OR null.
	 */
	
	public ShowNode find(String ShowID) {
		//totat_iterations=0;
		ShowNode findNode= head;
		ShowNode resultNode=null;
		boolean findFlag=false;
		while(findNode!=null) {
			
			if(findNode.TVShowNode.getShowID().equals(ShowID)) {
				//System.out.println("Found at index: "+(totat_iterations+1));
				resultNode=findNode;
				findFlag=true;
			}
			findNode=findNode.next;
			//totat_iterations++;
		}
		
		if(findFlag) {
			return resultNode; // This will return node and pointer of next node.
			// PRIVACY LEAK CHANCES.
			//We could return TVShow Object only instead of whole node.
		}
		else
			return null;
		
		
		
		
	}
	
	/**
	 * findx() - This method will find for a node which has same Show ID.
	 * It keeps track of total iterations.
	 * @param ShowID - TVShow.ShowId 
	 * @return ShowNode OR null.
	 */
	public ShowNode findx(String ShowID) {
		totat_iterations=0;
		ShowNode findNode= head;
		ShowNode resultNode=null;
		boolean findFlag=false;
		while(findNode!=null) {
			
			if(findNode.TVShowNode.getShowID().equals(ShowID)) {
				//System.out.println("Found at index: "+(totat_iterations+1));
				resultNode=findNode;
				findFlag=true;
				totat_iterations++;
				break;
			}
			findNode=findNode.next;
			totat_iterations++;
		}
		
		if(findFlag) {
			return resultNode;
		}
		else
			return null;		
		
	}
	
	/**
	 * contains() - This method checks if ShowList has given ShowID node.
	 * @param ShowID - TVShow.ShowId 
	 * @return boolean
	 */
	
	public boolean contains(String ShowID) {
		ShowNode findNode= head;
		boolean findFlag=false;
		while(findNode!=null) {
			
			if(findNode.TVShowNode.getShowID().equals(ShowID)) 
				findFlag=true;
			findNode=findNode.next;
		}
		
		if(findFlag) 
			return true;
		
		else
			return false;	}
	
	/**
	 * equals() - This method check if two ShowList has same nodes.
	 * @param sl_p - ShowList
	 * @return - Boolean
	 */
	public boolean equals(ShowList sl_p) {
		
		boolean result=true;
		//compare two Showlists.
		ShowNode temp = head;
		ShowNode temp_sl_p=sl_p.head;
		
		while(temp!=null) {
			
			if(temp.TVShowNode.equals(temp_sl_p.TVShowNode.getshowName(), 
					temp_sl_p.TVShowNode.getstartTime(), temp_sl_p.TVShowNode.getendTime())) {
				
			}
			else {
				result=false;
			}
			
			temp=temp.next;
			temp_sl_p=temp_sl_p.next;
		}
	
		return result;	
	}
	
	/**
	 * Sclone() - This method will clone head node and add it to the ShowList.
	 */
	
	public void Sclone() {
		ShowNode mynode=head;
		ShowNode newnode=mynode.clone();
		insertAtStart(newnode.TVShowNode);
		
	}
	
	/**
	 * Inner Class of ShowList for TVShow Nodes.
	 * @author Waleed Ahmed Siddiqui
	 * @version 1.0
	 */
	
	 class ShowNode implements Cloneable{
		 //Privacy leak chances, because ShowNode visibility is Package.
		 //So, within Package nodes pointer has some privacy leaks.
		
		private TVShow TVShowNode; // TVShow Object - Data.
		private ShowNode next; //pointer to the next node.
		
		/**
		 * Default Constructor to initialize attributes.
		 */
		ShowNode(){ //default constructor
			this.TVShowNode=null;
			this.next=null;
		}
		
		/**
		 * Parameterized Constructor to create new node with given TVShow and next node pointer.
		 * @param tv_s - TVShow
		 * @param node - Next node Pointer.
		 */
		ShowNode(TVShow tv_s, ShowNode node){ //Parameterized Constructor
			TVShowNode=tv_s;
			next=node;
			
		}
		
		/**
		 * Copy Constructor.
		 * @param tv_s - TVShow
		 */
		ShowNode(TVShow copy_node){ //Copy Constructor	
			this.TVShowNode=new TVShow(copy_node, copy_node.getShowID());	
			this.next=null;
		}
		
		/**
		 * Clone() - This method will deep copy given node.
		 * @return ShowNode
		 */
		
		@Override
		public ShowNode clone() {
			ShowNode newNode= new ShowNode(new TVShow
					(this.TVShowNode, this.TVShowNode.getShowID()),this.next);
			
			//return new ShowNode(this.TVShowNode, this.next);
			return newNode;
		}
		
		
		/**
		 * This is the example of Shallow Copy.
		 * @return ShowNode
		 */
		public ShowNode shallowclone() {//This is the example of Shallow copy of a node.
			
			ShowNode newNode= new ShowNode();
			newNode.TVShowNode=this.TVShowNode;
			newNode.next=this.next;
			return newNode;
		}
		
		/**
		 * Accessor - To access TVShow Object.
		 * @return - TVShow
		 */
		public TVShow getShow() {
			return TVShowNode;
		}
		
		/**
		 * Mutator - To set TVShow Object.
		 */
		
		public void setShow(TVShow tv_s) {
			this.TVShowNode=tv_s;
		}
		
		/**
		 * Accessor - To access next Node.
		 * @return - ShowNode
		 */
		
		public ShowNode getNext() {
			return next;
		}
		
		/**
		 * Mutator - To set next Node.
		 */
		public void setNext(ShowNode nextx) {
			this.next=nextx;
		}
		
		
	}//ShowNode inner class.

}//ShowList outer class.
