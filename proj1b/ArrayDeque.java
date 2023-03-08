public class ArrayDeque<T> implements Deque<T> {

    private T[] _arrayDeque;
    private int _lengthOfArray;
    private int _size;
    private int _front; // Point to the first item of the deque.
    private int _rear;  // The next index of last item of the deque.
    
    /**
     * Constructor for ArrayDeque.
     */
    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        _arrayDeque = (T[]) new Object[8];
        _lengthOfArray = 8;
        _size = 0;
        _front = 0;
        _rear = 0;
    }


    // Some utility private method
    private int findNextIndex(int index) {
        if (index == (_lengthOfArray - 1)) {
            return 0;
        } else {
            return index + 1;
        }
    }

    private int findPreIndex(int index) {
        if (index == 0) {
            return _lengthOfArray - 1;
        } else {
            return index - 1;
        }
    }

    @SuppressWarnings("unchecked")
    private void arrayGrow() {
        T[] newArray = (T[]) new Object[_lengthOfArray * 2];
        int ptrOld = _front;
        int ptrNew = 0;
        while (ptrOld != _rear) {
            newArray[ptrNew] = _arrayDeque[ptrOld];
            ptrNew  = findNextIndex(ptrNew);
            ptrOld  = findNextIndex(ptrOld);
        }
        _front = 0;
        _rear = ptrNew;
        _arrayDeque = newArray;
        _lengthOfArray *= 2;
    }

    @SuppressWarnings("unchecked")
    private void arrayShirk() {
        T[] newArray = (T[]) new Object[_lengthOfArray / 2];
        int ptrOld = _front;
        int ptrNew = 0;
        while (ptrOld != _rear) {
            newArray[ptrNew] = _arrayDeque[ptrOld];
            ptrNew = findNextIndex(ptrNew);
            ptrOld = findNextIndex(ptrOld);
        }
        _front = 0;
        _rear = ptrNew;
        _arrayDeque = newArray;
        _lengthOfArray /= 2;
    }

    @Override
    public void addFirst(T item) {
        if (_size == (_lengthOfArray - 1)) {
            arrayGrow();
        }
        _front = findPreIndex(_front);
        _arrayDeque[_front] = item;
        _size += 1;

    }

    @Override
    public void addLast(T item) {
        if (_size == (_lengthOfArray - 1)) {
            arrayGrow();
        }
        _arrayDeque[_rear] = item;
        _rear = findNextIndex(_rear);
        _size += 1;
    }

    @Override
    public boolean isEmpty() {
        return (_size == 0);
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public void printDeque() {
        if (isEmpty()) {
            System.out.println("The linked list deque is empty!");
        } else {
            int ptr = _front;
            while (ptr != _rear) {
                System.out.print(_arrayDeque[ptr] + " ");
                ptr = findNextIndex(ptr);
            }
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T ret = _arrayDeque[_front];
            _front = findNextIndex(_front);
            _size -= 1;

            if ((_lengthOfArray >= 16) && (_lengthOfArray / _size >= 4)) {
                arrayShirk();
            }

            return ret;
        }
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            _rear = findPreIndex(_rear);
            T ret = _arrayDeque[_rear];
            _size -= 1;

            if ((_lengthOfArray >= 16) && (_lengthOfArray / _size >= 4)) {
                arrayShirk();
            }

            return ret;
        }
    }

    @Override
    public T get(int index) {
        if (isEmpty()) {
            return null;
        } else if (index < 0) {
            System.out.println("Wrong number, the index must greater than 0.");
            return null;
        } else {
            if (index + 1 > _size) {
                return null;
            } else {
                int actualIndex = (_front + index) % _lengthOfArray;
                return _arrayDeque[actualIndex];
            }
        }
    }

}
