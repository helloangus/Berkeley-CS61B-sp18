/**Class of intList */

public class IntList {
    public int first;
    public IntList rest;


    /**Constructor of IntList
     * 
     * @param f
     * @param r
     */
    public IntList(int f, IntList r)
    {
        first = f;
        rest = r;
    }

    /**Return the size of IntList
     * 
     * @return
     */
    public int size()
    {
        if(rest == null)
        {
            return 1;
        }
        else
        {
            return 1 + this.rest.size();
        }
    }

    /**Get the index of i element in this IntList
     * 
     * @param i
     * @return
     */
    public int get(int i)
    {
        if(i == 0)
        {
            return first;
        }
        else
        {
            return this.rest.get(i-1);
        }
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.size());
        System.out.println(L.get(1));
    }

}
