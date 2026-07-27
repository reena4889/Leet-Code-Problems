class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            int[] vowels = new int[5];
            int unique = 0;

            for (int j = i; j < word.length(); j++) {
                char c = word.charAt(j);

                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    int index = getIndex(c);

                    if (vowels[index] == 0) {
                        unique++;
                    }

                    vowels[index]++;

                    if (unique == 5) {
                        count++;
                    }
                } else {
                    break;
                }
            }
        }

        return count;
    }

    private int getIndex(char c) {
        if (c == 'a') return 0;
        if (c == 'e') return 1;
        if (c == 'i') return 2;
        if (c == 'o') return 3;
        return 4;
    }
}
