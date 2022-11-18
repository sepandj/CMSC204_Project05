/**
 * @author Sepand Jahrominejad
 * 
 * CMSC 204 - Project 5
 * 
 * 11/17/2022
 */




import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 
 * A generic class that creates a binary tree using Norse code
 * 
 *
 * @param <T> A generic data type
 * @implements LinkedConverterTreeInterface
 */
public class MorseCodeTree<T> implements LinkedConverterTreeInterface<String> {
	
	TreeNode<String> root;
	
	
	/**
	 * Constructor starts a new binary Morse Code tree
	 */
	public MorseCodeTree() {
		
		root = new TreeNode<String>("");
		buildTree();
		
	}
	
	
	/**
	 * It will return the root of the tree when called
	 * 
	 * 
	 * @return The root of the binary Morse code tree
	 */
	@Override
	public TreeNode<String> getRoot(){
		
		return root;
	}
	
	
	
	/**
	 * Sets the root of the binary Morse code tree
	 * 
	 * @param newNode a TreeNode<String>
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
		
	}
	
	
	
	/**
	 * Inserts nodes into the tree by calling addNode method
	 * 
	 * @param code the Morse code String
	 * @param letter the letter associated with the Morse code
	 */
	@Override
	public void insert(String code, String letter) {
		
		addNode(root, code, letter);
		
	}
	
	
	/**
	 * Adds a new node to the tree
	 * 
	 * @param root the root of the tree of type TreeNode<String>
	 * @param code the Morse code String
	 * @param letter the letter associated with the Morse code
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		TreeNode<String> currentNode = root;
		for(int i=0; i<code.length(); i++) {
			if(code.substring(i, i+1).equals(".")) {
				if(currentNode.getLeft() !=null)
					currentNode = currentNode.getLeft();
				else {
					currentNode.setLeft(null);
					currentNode = currentNode.getLeft();
				}
			}
			else {
				if(currentNode.getRight() !=null)
					currentNode = currentNode.getRight();
				else {
					currentNode.setRight(null);
					currentNode = currentNode.getRight();
				}
			}
		}
		
		currentNode.setData(letter);
		
	}
	
	
	
	/**
	 * fetches the letter associated with the given Morse code by calling fetchNode method
	 * 
	 * @param code the Morse code to call a letter
	 * @return the letter associated with the given Morse code
	 */
	@Override
	public String fetch(String code) {
		buildTree();
		return fetchNode(root, code);
		
	}
	
	
	
	/**
	 * fetches the node associated with the given Morse code
	 * 
	 * @param root the root of the binary Morse code of type TreeNode<String>
	 * @param code the code that is associated with the needed node
	 * @return the letter associated with the given Morse code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		
		TreeNode<String> currentNode = root;
		
		for(int i=0; i<code.length(); i++) {
			if(code.substring(i, i+1).equals(".")) {
				currentNode = currentNode.getLeft();
			}
			else {
				currentNode = currentNode.getRight();
			}
		}
		
		return currentNode.getData();
		
	}
	
	
	/**
	 * Deletes the last child in the binary Morse code tree
	 * 
	 * @param node the node of type TreeNode<String> to be deleted from the tree
	 */
	public void deleteLastLeaf(TreeNode<String> node) {
		Queue<TreeNode<String>> queue = new LinkedList<TreeNode<String>>();
		queue.add(root);
		
		TreeNode<String> temp = null;
		
		
		while(!queue.isEmpty()) {
			temp = queue.peek();
			queue.remove();
			
			if(temp.equals(node)) {
				temp=null;
				return;
			}
			
			if(temp.getLeft() !=null) {
				if(temp.getLeft().equals(node)) {
					temp.setLeft(null);
					return;
				}
				else 
					queue.add(temp.getLeft());
			}
			
			if(temp.getRight() !=null) {
				if(temp.getRight().equals(node)) {
					temp.setRight(null);
					return;
				}
				else
					queue.add(temp.getRight());
			}
		}
	}
	
	
	
	/**
	 * Deletes the the node associated with the data it's been given
	 * 
	 * @param data the String whose node is to be deleted from the tree
	 * @return the updated version of the tree
	 * @throws UnsupportedOperationException
	 */
	public MorseCodeTree<String> delete(String data) throws UnsupportedOperationException{
		MorseCodeTree<String> daTree = new MorseCodeTree<String>();
		if(daTree.root == null)
			throw new UnsupportedOperationException();
		
		if(daTree.root.getLeft() == null &&
				daTree.root.getRight() ==null)
			throw new UnsupportedOperationException();
		
		Queue<TreeNode<String>> queue = new LinkedList<TreeNode<String>>();
		queue.add(daTree.root);
		TreeNode<String> temp = null;
		TreeNode<String> targetNode = null;
		
		
		while(!queue.isEmpty()) {
			temp = queue.peek();
			queue.remove();
			
			if(temp.getData().equals(data))
				targetNode = temp;
			
			if(temp.getLeft() !=null)
				queue.add(temp.getLeft());
			
			if(temp.getRight() !=null)
				queue.add(temp.getRight());
					
		}
		
		if(targetNode != null) {
			String d = temp.getData();
			
			deleteLastLeaf(temp);
			targetNode.setData(d);
		}
		
		return daTree;
		
		
	}
	
	
	/**
	 * If anybody is reading this, please let me know what is the purpose of this method if it does not have any parameters??
	 * 
	 * @return the updated tree
	 * @throws UnsupportedOperationException
	 */
	public MorseCodeTree<String> update() throws UnsupportedOperationException{
		MorseCodeTree<String> daTree = new MorseCodeTree<String>();
		return daTree;
	}
	
	/**
	 * builds the full binary morse code tree by calling insert method multiple times
	 */
	public void buildTree() {
		
		
		insert(".-", "a");
		insert("-...", "b");
		insert("-.-.", "c");
		insert("-..", "d");
		insert(".", "e");
		insert("..-.", "f");
		insert("--.", "g");
		insert("....", "h");
		insert("..", "i");
		insert(".---", "j");
		insert("-.-", "k");
		insert(".-..", "l");
		insert("--", "m");
		insert("-.", "n");
		insert("---", "o");
		insert(".--.", "p");
		insert("--.-", "q");
		insert(".-.", "r");
		insert("...", "s");
		insert("-", "t");
		insert("..-", "u");
		insert("...-", "v");
		insert(".--", "w");
		insert("-..-", "x");
		insert("-.--", "y");
		insert("--..", "z");
	}
	
	
	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	public ArrayList<String> toArrayList(){
		
		MorseCodeTree<String> daTree = new MorseCodeTree<String>();
		
		ArrayList<String> morseCodeAL = new ArrayList<String>();
		
		LNRoutputTraversal(daTree.getRoot(), morseCodeAL);
		
		return morseCodeAL;
		
	}
	
	
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal(TreeNode<String> root,
			ArrayList<String> list) {
		
		if(root==null)
			return;
		
		LNRoutputTraversal(root.getLeft(), list);
		list.add(root.getData());
		LNRoutputTraversal(root.getRight(), list);
		
	}

}
