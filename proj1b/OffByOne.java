public class OffByOne implements CharacterComparator {

    /**
     * Determine whether two input char are off by one.
     * @return
     */
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
    
}
