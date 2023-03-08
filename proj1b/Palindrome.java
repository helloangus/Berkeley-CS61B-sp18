public class Palindrome {
    


    /**
     * Convert String to Deque.
     * @param word
     * @return
     */
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> wordDeque = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); ++i) {
            Character c = word.charAt(i);
            wordDeque.addLast(c);            
        }
        return wordDeque;
    }



    /**
     * @helper_method:
     * Determine whether word_deque[front] == word_deque[rear].
     * If equal, ++front and --rear and continue recursion.
     * If not, return false.
     * @recursion When !(front < rear), return true.
     * @param front, rear, word_deque
     * @return
     */
    private boolean isPalindromeHelper(int front, int rear, Deque<Character> wordDeque) {
        if (!(front < rear)) {
            return true;
        } else {
            if (wordDeque.get(front).equals(wordDeque.get(rear))) {
                return isPalindromeHelper(front + 1, rear - 1, wordDeque);
            } else {
                return false;
            }
        }
    }



    /**
     * Whether the word is the same whether it's read forwards or backwards.
     * For other words, is it a palindrome.
     * Any word of length 1 or 0 is a palindrome.
     * @param word
     * @return
     */ 
    public boolean isPalindrome(String word) {
        // if word.length is 1 or 0, return true.
        if ((word.length() == 1) || (word.length() == 0)) {
            return true;
        } else {
            // else convert word to deque
            Deque<Character> wordDeque = wordToDeque(word);
            // using helper method and set front = 0, rear = word_deque.size - 1
            // get and return the conditional result.
            return isPalindromeHelper(0, wordDeque.size() - 1, wordDeque);
        }
    }



    /**
     * overloaded isPalindromeHelper.
     * @helper_method:
     * Determine whether word_deque[front] == word_deque[rear].
     * If equal, ++front and --rear and continue recursion.
     * If not, return false.
     * @recursion When !(front < rear), return true.
     * @param front, rear, word_deque
     * @return
     */
    private boolean isPalindromeHelper(int front, int rear, Deque<Character> wordDeque, 
        CharacterComparator cc) {
        if (!(front < rear)) {
            return true;
        } else {
            if (cc.equalChars(wordDeque.get(front), (wordDeque.get(rear)))) {
                return isPalindromeHelper(front + 1, rear - 1, wordDeque, cc);
            } else {
                return false;
            }
        }
    }


    /**
     * overloaded isPalindrome, decide if the given word is palindrome.
     * according to the given CharacterComparator.
     * @param word
     * @param cc
     * @return
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        // if word.length is 1 or 0, return true.
        if ((word.length() == 1) || (word.length() == 0)) {
            return true;
        } else {
            // else convert word to deque
            Deque<Character> wordDeque = wordToDeque(word);
            // using helper method and set front = 0, rear = word_deque.size - 1
            // get and return the conditional result.
            return isPalindromeHelper(0, wordDeque.size() - 1, wordDeque, cc);
        }
    }

}
