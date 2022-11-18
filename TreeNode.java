/**
 * @author Sepand Jahrominejad
 * 
 * CMSC 204 - Project 5
 * 
 * 11/17/2022
 */


/**
 * 
 * A generic class to define the nodes of a binary tree
 *
 * @param <T>
 */
public class TreeNode<T> extends Object {
	
	private T data;
	private TreeNode<T> rightChild, leftChild;
	

	/**
	 * The constructor that initializes right and left children to null
	 * @param dataNode the data stored in the node
	 */
	public TreeNode(T dataNode) {
		data = dataNode;
		rightChild = null;
		leftChild = null;
		
	}
	
	
	/**
	 * The default constructor of the TreeNode class that initializes all the attributes to null
	 */
	public TreeNode() {
		data = null;
		rightChild = null;
		leftChild = null;
	}
	
	
	
	/**
	 * Copy constructor 
	 * @param node the node to be copied
	 */
	public TreeNode(TreeNode<T> node) {
		rightChild = node.rightChild;
		leftChild = node.leftChild;
		data = node.data;
		
	}
	
	
	/**
	 * returns the stored data in the node
	 * @return the store data in the node
	 */
	public T getData() {
		
		return data;
	}
	
	
	/**
	 * Sets the data of the node
	 * @param data the data to be stored in the node
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	
	/**
	 * Gets the reference to the left child in a tree
	 * @return the node containing the left child
	 */
	public TreeNode<T> getLeft(){
		return leftChild;
	}
	
	
	/**
	 * Sets the data stored in the left child of the node
	 * @param leftD
	 */
	public void setLeft (T leftD) {
		leftChild = new TreeNode<T>(leftD);
	}
	
	
	/**
	 * Gets the reference to the right child in a tree
	 * @return the node containing the right child
	 */
	public TreeNode<T> getRight(){
		return rightChild;
	}
	
	
	/**
	 * Sets the data stored in the right child of the node
	 * @param rightD
	 */
	public void setRight (T rightD) {
		rightChild = new TreeNode<T>(rightD);
	}
	
	
}
