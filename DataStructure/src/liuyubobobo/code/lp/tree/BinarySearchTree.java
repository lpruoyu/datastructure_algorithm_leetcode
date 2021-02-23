package liuyubobobo.code.lp.tree;

import liuyubobobo.code.lp.queue.LinkedListQueue;
import liuyubobobo.code.lp.queue.Queue;
import liuyubobobo.code.lp.stack.LinkedWDHStack;
import liuyubobobo.code.lp.stack.Stack;

public class BinarySearchTree<E extends Comparable<E>> {

	private static class Node<E> {
		E e;
		Node<E> left;
		Node<E> right;

		public Node(E e) {
			this.e = e;
		}
	}

	private Node<E> root;
	private int size;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void add(E e) {
		if (null == e) {
			throw new IllegalArgumentException("element must not be null.");
		}
		root = add(root, e);
	}

	private Node<E> add(Node<E> node, E e) {
		if (node == null) {
			size++;
			return new Node<>(e);
		}
		if (node.e.compareTo(e) < 0) {
			node.right = add(node.right, e);
		} else if (node.e.compareTo(e) > 0) {
			node.left = add(node.left, e);
		}
		return node;
	}

	/*
	 * 是否包含元素
	 */
	public boolean contains(E e) {
		return contains(root, e);
	}

	private boolean contains(Node<E> node, E e) {
		if (node == null) {
			return false;
		}
		if (node.e.compareTo(e) == 0) {
			return true;
		} else if (node.e.compareTo(e) < 0) {
			return contains(node.right, e);
		} else {
			return contains(node.left, e);
		}
	}

	/*
	 * 前序遍历
	 */
	public void prevOrder() {
		if (null == root) {
			return;
		}

		prevOrder(root);
		System.out.println();
	}

	private void prevOrder(Node<E> node) {
		if (node == null) {
			return;
		}

		System.out.print(node.e + "---");
		prevOrder(node.left);
		prevOrder(node.right);
	}

	/*
	 * 后序遍历
	 */
	public void postOrder() {
		if (root == null) {
			return;
		}

		postOrder(root);
		System.out.println();
	}

	private void postOrder(Node<E> node) {
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.e + "---");
	}

	/*
	 * 中序遍历
	 */
	public void inOrder() {
		if (root == null) {
			return;
		}

		inOrder(root);
		System.out.println();
	}

	private void inOrder(Node<E> node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.e + "---");
		inOrder(node.right);
	}

	/*
	 * 前序遍历非递归版
	 */
	public void prevOrderNN() {
		if (null == root) {
			return;
		}
		Stack<Node<E>> stack = new LinkedWDHStack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node<E> top = stack.pop();
			System.out.print(top.e + "---");
			if (top.left != null) {
				stack.push(top.left);
			}
			if (top.right != null) {
				stack.push(top.right);
			}
		}

		System.out.println();

	}

	/*
	 * 广度优先遍历
	 */
	public void prevOrderBreadthFirst() {
		if (null == root) {
			return;
		}

		Queue<Node<E>> queue = new LinkedListQueue<>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			Node<E> front = queue.dequeue();
			System.out.print(front.e + "---");
			if (front.left != null) {
				queue.enqueue(front.left);
			}
			if (front.right != null) {
				queue.enqueue(front.right);
			}
		}

		System.out.println();

	}

	// 寻找二分搜索树的最小元素
	public E minimum() {
		checkIsEmpty();
		return minimum(root).e;
	}

	// 返回以node为根的二分搜索树的最小值所在的节点
	private Node<E> minimum(Node<E> node) {
		if (node.left == null) {
			return node;
		}
		return minimum(node.left);
	}

	// 寻找二分搜索树的最大元素
	public E maximum() {
		checkIsEmpty();
		return maximum(root).e;
	}

	// 返回以node为根的二分搜索树的最大值所在的节点
	private Node<E> maximum(Node<E> node) {
		if (node.right == null) {
			return node;
		}
		return maximum(node.right);
	}

	// 从二分搜索树中删除最小值所在节点, 返回最小值
	public E removeMin() {
		checkIsEmpty();
		E e = minimum();
		root = removeMin(root);
		return e;
	}

	private void checkIsEmpty() {
		if (isEmpty()) {
			throw new IllegalArgumentException("bst is empty.");
		}
	}

	// 删除掉以node为根的二分搜索树中的最小节点
	// 返回删除节点后新的二分搜索树的根
	private Node<E> removeMin(Node<E> node) {
		if (node.left == null) {
			size--;
			return node.right;
		}
		node.left = removeMin(node.left);
		return node;
	}

	// 从二分搜索树中删除最大值所在节点
	public E removeMax() {
		checkIsEmpty();
		E e = maximum();
		root = removeMax(root);
		return e;
	}

	// 删除掉以node为根的二分搜索树中的最大节点
	// 返回删除节点后新的二分搜索树的根
	private Node<E> removeMax(Node<E> node) {
		if (node.right == null) {
			size--;
			return node.left;
		}
		node.right = removeMax(node.right);
		return node;
	}

	public void remove(E e) {
		checkIsEmpty();
		if(null == e) {
			throw new IllegalArgumentException("e must not be null.");
		}
		root = remove(root, e);
	}

	private Node<E> remove(Node<E> node, E e) {
		if (node == null) {
			return null;
		}

		if (node.e.compareTo(e) == 0) {

			if (node.left == null) {
				size--;
				return node.right;
			} else if (node.right == null) {
				size--;
				return node.left;
			} else {

				Node<E> minimum = minimum(node.right);
				minimum.right = removeMin(node.right);
				minimum.left = node.left;
				
				return minimum;

			}

		} else if (node.e.compareTo(e) < 0) {
			node.right = remove(node.right, e);
			return node;
		} else {
			node.left = remove(node.left, e);
			return node;
		}

	}
	
//
//    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
//    // 返回删除节点后新的二分搜索树的根
//    private Node<E> remove(Node<E> node, E e){
//
//        if( node == null )
//            return null;
//
//        if( e.compareTo(node.e) < 0 ){
//            node.left = remove(node.left , e);
//            return node;
//        }
//        else if(e.compareTo(node.e) > 0 ){
//            node.right = remove(node.right, e);
//            return node;
//        }
//        else{   // e.compareTo(node.e) == 0
//
//            // 待删除节点左子树为空的情况
//            if(node.left == null){
//                Node rightNode = node.right;
//                node.right = null;
//                size --;
//                return rightNode;
//            }
//
//            // 待删除节点右子树为空的情况
//            if(node.right == null){
//                Node leftNode = node.left;
//                node.left = null;
//                size --;
//                return leftNode;
//            }
//
//            // 待删除节点左右子树均不为空的情况
//
//            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
//            // 用这个节点顶替待删除节点的位置
//            Node successor = minimum(node.right);
//
//            successor.right = removeMin(node.right);
//            successor.left = node.left;
//
//            node.left = node.right = null;
//
//            return successor;
//        }
//    }


}
