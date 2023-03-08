public class OffByN implements CharacterComparator {

    private int _N;

    public OffByN(int n) {
        _N = n;
    }

    /**
     * Determine whether two input char are off by one.
     * @return
     */
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == _N;
    }
    
}
