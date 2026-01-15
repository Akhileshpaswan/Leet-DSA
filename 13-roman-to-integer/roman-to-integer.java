class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;

        // Traverse from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = getValue(s.charAt(i));

            // If current value is smaller than previous, subtract it
            if (currValue < prevValue) {
                total -= currValue;
            } else {
                total += currValue;
            }

            prevValue = currValue;
        }

        return total;
    }

    // Helper method to get integer value of Roman symbol
    private int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
