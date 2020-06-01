import java.util.Stack;

/******************************
 * AdvCSBinTree.java Author: Robert Walker Purpose: Binary Tree
 *****************************/
public class AdvCSBinTree<T> {

	public BinTreeNode root;

	public AdvCSBinTree() {
		root = null;
	}

	// Add method
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(int inKey, T inData) {
		BinTreeNode temp = root;
		if (root == null) { // If tree is empty
			root = new BinTreeNode(null, null, inKey, inData);
		} else {
			while (temp != null) { // While the current node isn't empty
				if (inKey < temp.key) { // If the key belongs on the right {
					if (temp.left != null) {
						temp = temp.left;
					} else {
						break;
					}
				} else { // Else if it belongs on the right or is equal {
					if (temp.right != null) {
						temp = temp.right;
					} else {
						break;
					}
				}
			}
			if (inKey < temp.key) {
				temp.left = new BinTreeNode(null, null, inKey, inData); // If the key belongs on the left create the
																		// node
			} else {
				temp.right = new BinTreeNode(null, null, inKey, inData); // Else create the node on the right
			}
		}
	}

	public void traverse() {
		inOrder(root);
	}

	private void inOrder(BinTreeNode inNode) {
		BinTreeNode temp = inNode;

		if (temp == null) { // Base Case
			System.out.print("");
		}
		if (temp.left != null) { // Recursive statement #2
			inOrder(temp.left);
		}
		System.out.print(temp + " ");
		if (temp.right != null) { // Recursive statement #2
			inOrder(temp.right);
		}
	}
	

	public T delete(int inKey) {
		BinTreeNode<T> cur = root, parent = null;

		if (root == null) { // If empty
			return null;
		} else if (cur == root && root.left == null && root.right == null) { // If root is blank
			T holder = (T) root.data;
			root = null;
			return holder;
		} else {
			while (cur.key != inKey && cur != null) { // Find the node with the key
				parent = cur;
				if (inKey < cur.key) {
					if (cur.left != null) {
						cur = cur.left;
					} else {
						return null;
					}
				} else {
					if (cur.right != null) {

						cur = cur.right;
					} else {
						return null;
					}
				}
			}

			if (cur.left == null && cur.right == null) { // If no kids
				T holder = cur.data;
				if (cur == root) {
					root = null;
				} else if (cur.key < parent.key) {
					parent.left = null;
				} else if (cur.key > parent.key) {
					parent.right = null;
				}
				return holder;

			} else if (cur.left != null && cur.right == null) { // If left kid
				T holder = cur.data;
				if (cur == root) {
					root = root.left;
				} else if (cur.key < parent.key) {
					parent.left = cur.left;
				} else {
					parent.right = cur.left;
				}
				return holder;

			} else if (cur.left == null && cur.right != null) { // If right kid
				T holder = cur.data;
				if (cur == root) {
					root = root.right;
				} else if (cur.key > parent.key) {
					parent.right = cur.right;
				} else {
					parent.left = cur.right;
				}
				return holder;

			} else { // Else if complete tree
				BinTreeNode<T> suc = findSuccessor(cur);
				if (cur == root) {
					suc.left = root.left;
					// suc.right = root.right;
					root = suc;
					return (T) root.data;
				}
				if (cur.left != null) {
					suc.left = cur.left;
				} else {
					suc.left = null;
				}
				if (cur.key < parent.key) {
					parent.left = suc;
				} else {
					parent.right = suc;
				}
			}
		}
		return cur.data;

	}

	private BinTreeNode<T> findSuccessor(BinTreeNode<T> delNode) {
		BinTreeNode<T> sucessor = delNode.right;
		BinTreeNode<T> succPar = delNode;
		if (sucessor.left == null) {
			return sucessor;
		} else {
			while (sucessor.left != null) {
				succPar = sucessor;
				sucessor = sucessor.left;
			}
			if (sucessor.right != null) {
				succPar.left = sucessor.left;
			} else {
				succPar.left = null;
			}
			sucessor.right = delNode.right;
			return sucessor;
		}
	}

	public void displayTree() {
		Stack<BinTreeNode<T>> globalStack = new Stack<>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");
		while (isRowEmpty == false) {
			Stack<BinTreeNode<T>> localStack = new Stack<>();
			isRowEmpty = true;

			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');

			while (globalStack.isEmpty() == false) {
				BinTreeNode<T> temp = (BinTreeNode<T>) globalStack.pop();
				if (temp != null) {
					System.out.print(temp.data);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if (temp.left != null || temp.right != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(' ');
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		} // end while isRowEmpty is false
		System.out.println("......................................................");
	} // end displayTree()

	// Node class
	public class BinTreeNode<T> {
		BinTreeNode left;
		BinTreeNode right;
		int key;
		T data;

		public BinTreeNode(BinTreeNode inLeft, BinTreeNode inRight, int inKey, T inData) {
			left = inLeft;
			right = inRight;
			key = inKey;
			data = inData;
		}

		public String toString() {
			return data + " ";
		}
	}
}
