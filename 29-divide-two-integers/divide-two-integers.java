class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign of result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to negative to avoid overflow
        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;

        int result = 0;

        // Repeat until dividend is smaller than divisor
        while (a <= b) {
            int temp = b;
            int multiple = 1;

            // Double divisor using bit shifts
            while (a <= (temp << 1) && (temp << 1) < 0) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }
}
