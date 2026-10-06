class Solution {
    private String fun(String s, String t, int i, int j, int carry) {
        
        if (i < 0 && j < 0) {
            if (carry == 1) return "1";
            return "";
        }

        int a = 0;
        int b = 0;

        if (i >= 0) {
            a = s.charAt(i) - '0';
        }

        if (j >= 0) {
            b = t.charAt(j) - '0';
        }

        int sum = a + b + carry;

        char bit = (char) ((sum % 2) + '0');

        return fun(s, t, i - 1, j - 1, sum / 2) + bit;
    }

    public String addBinary(String a, String b) {
        return fun(a, b, a.length() - 1, b.length() - 1, 0);
    }
}