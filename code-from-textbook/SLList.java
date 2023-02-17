public class SLList {

    /**
     * Just the Node struct
    */
    public static class IntNode{
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n)
        {
            item = i;
            next = n;
        }	

    }

    private IntNode __sentinel;
    private IntNode __lastIntNode;
    private int __size;


    /**
     * test method
     */
    private static void test()
    {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
        System.out.println(L.size());
        L.addLast(150);
        System.out.println(L.getLast());
        System.out.println(L.size());
        L.removeFirst();
        L.removeFirst();
        L.removeLast();
        L.removeLast();
        System.out.println(L.getFirst());
        System.out.println(L.getLast());
    }

    public static void main(String[] args) {
        test();
    }


    /**
     * Init a list without items
     */
    public SLList()
    {
        __sentinel = new IntNode(Integer.MIN_VALUE, null);
        __lastIntNode = null;
    }


    /**
     * Init a list with one item
     * @param x
     */
    public SLList(int x)
    {
        __sentinel = new IntNode(Integer.MIN_VALUE, null);
        __sentinel.next = new IntNode(x, null);
        __lastIntNode = __sentinel.next;
        sizeAdd();
    }

    /**
     * Helper method for adding size
     */
    private void sizeAdd()
    {
        __size += 1;
    }

    private void sizeReduce()
    {
        __size -= 1;
    }

    /**
     * Add an item to the front of the list
     * @param x
     */
    public void addFirst(int x)
    {
        __sentinel.next = new IntNode(x, __sentinel.next);
        if(__lastIntNode == null)
        {
            __lastIntNode = __sentinel.next;
        }
        sizeAdd();
    }


    /**
     * Adds an item to the end of the list
     * @param x
     */
    public void addLast(int x)
    {
        __lastIntNode.next = new IntNode(x, null);
        __lastIntNode = __lastIntNode.next;
        sizeAdd();
    }


    /**
     * Retrieves the front item from the list
     * @return
     */
    public int getFirst()
    {
        if(__sentinel.next == null)
        {
            System.out.println("The SLList is empty!");
            return Integer.MIN_VALUE;
        }
        else
        {
            return __sentinel.next.item; 
        }
    }


    /**
     * Retrieves the last item from the list
     * @return
     */
    public int getLast()
    {
        if(__lastIntNode == null)
        {
            System.out.println("The SLList is empty!");
            return Integer.MIN_VALUE;
        }
        else
        {
            return __lastIntNode.item;
        }
    }


    public void removeFirst()
    {
        if(__sentinel.next == null)
        {
            System.out.println("The SLList is empty!");
        }
        else
        {
            __sentinel.next = __sentinel.next.next;
            if(__sentinel.next == null)
            {
                __lastIntNode = null;
            }
            sizeReduce();
        }
    }

    public void removeLast()
    {
        if(__lastIntNode == null)
        {
            System.out.println("The SLList is empty!");
        }
        else
        {
            IntNode pre = __sentinel;
            while(pre.next != __lastIntNode)
            {
                pre = pre.next;
            }
            __lastIntNode = pre;
            __lastIntNode.next = null;
            if(__sentinel.next == null)
            {
                __lastIntNode = null;
            }
            sizeReduce();
        }
    }

    // /**
    //  * Private helper method that returns
    //  * the size of the list starting at IntNode p.
    //  * @param p
    //  * @return
    //  */
    // private static int size(IntNode p)
    // {
    //     if(p.next == null)
    //     {
    //         return 1;
    //     }
    //     else
    //     {
    //         return 1 + size(p.next);
    //     }
    // }

    /**
     * Compute the size of the entire list
     * @return
     */
    public int size()
    {
        /**There no need to use a helper method,
         * we can just add an int size to count.
         */
        // return size(__sentinel.next);
        return __size;
    }


}
