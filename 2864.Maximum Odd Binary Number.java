class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }

        StringBuilder ans = new StringBuilder();

        // Put all 1s except one at the front
        for (int i = 0; i < ones - 1; i++) {
            ans.append('1');
        }

        // Put all 0s in the middle
        for (int i = 0; i < s.length() - ones; i++) {
            ans.append('0');
        }

        // Last digit must be 1 to make it odd
        ans.append('1');

        return ans.toString();
    }
}
