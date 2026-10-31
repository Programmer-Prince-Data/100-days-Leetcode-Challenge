class Solution {
    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (words[i].length() < pref.length()) continue;

            int j;
            for (j = 0; j < pref.length(); j++) {
                if (pref.charAt(j) != words[i].charAt(j)) {
                    break;
                }
            }

            if (j == pref.length()) {
                count++;
            }
        }

        return count;
    }
}