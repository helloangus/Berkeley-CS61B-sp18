public class LinkedListDeque<T> implements Deque<T> {
    
    /**
     * inner class node. Using circular sentinel topology
     */
    private class Node {

        private T item; // The item stored on this node.
        private Node pre;   // The node before this node.
        private Node next;  // The node after this node.

        // constructor for Node without the init of item.
        Node(Node ppre, Node nnext) {
            pre = ppre;
            next = nnext;
        }

        // Constructor for Node.
        Node(T t, Node ppre, Node nnext) {
            item = t;
            pre = ppre;
            next = nnext;
        }
        
    }



    private Node _sentinel;
    private int _size;

    /**
     * Creates an empty linked list deque.
     */
    public LinkedListDeque() {
        _sentinel = new Node(null, null);
        _sentinel.next = _sentinel;
        _sentinel.pre = _sentinel;
        _size = 0;
    }


    /**
     * Adds an item of type T to the front of the deque.
     * @param item
     */
    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item, _sentinel, _sentinel.next);
        _sentinel.next.pre = newNode;
        _sentinel.next = newNode;
        _size += 1;
    }


    /**
     * Adds an item of type T to the back of the deque.
     * @param item
     */
    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, _sentinel.pre, _sentinel);
        _sentinel.pre.next = newNode;
        _sentinel.pre = newNode;
        _size += 1;
    }



    /**
     * Returns true if deque is empty, false otherwise.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (_size == 0);
    }



    /**
     * Returns the number of items in the deque.
     * @return
     */
    @Override
    public int size() {
        return _size;
    }


    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    @Override
    public void printDeque() {
        if (isEmpty()) {
            System.out.println("The linked list deque is empty!");
        } else {
            Node p = _sentinel.next;
            while (p != _sentinel) {
                System.out.print(p.item + " ");
                p = p.next;
            }
        }
    }



    /**
     * Removes and returns the item at the front of the deque. 
     * If no such item exists, returns null.
     * @return
     */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            Node p = _sentinel.next;
            _sentinel.next = _sentinel.next.next;
            _sentinel.next.pre = _sentinel;
            _size -= 1;
            return p.item;
        }
    }    



    /**
     * Removes and returns the item at the back of the deque. 
     * If no such item exists, returns null.
     * @return
     */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            Node p = _sentinel.pre;
            _sentinel.pre = _sentinel.pre.pre;
            _sentinel.pre.next = _sentinel;
            _size -= 1;
            return p.item;
        }
    }


    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. 
     * If no such item exists, returns null.
     *  Must not alter the deque!
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        if (isEmpty()) {
            return null;
        } else if (index < 0) {
            System.out.println("Wrong number, the index must greater than 0.");
            return null;
        } else {
            Node p = _sentinel;
            int i;
            for (i = 0; i <= index; ++i) {
                p = p.next;
                if (p == _sentinel) {
                    break;
                }
            }
            if ((i - 1) == index) {
                return p.item;
            } else {
                return null;
            }
        }
    }


    /**
     * Same as get, but uses recursion.
     * @param index
     * @return
     */
    private T getRecursiveHelper(int index, Node p) {
        if (p == _sentinel) {
            return null;
        } else if (index == 0) {
            return p.item;
        } else {
            return getRecursiveHelper(index - 1, p.next);
        }
    }

    public T getRecursive(int index) {
        if (isEmpty()) {
            return null;
        } else if (index < 0) {
            System.out.println("Wrong number, the index must greater than 0.");
            return null;
        } else {
            return getRecursiveHelper(index, _sentinel.next);
        }
    }





}
