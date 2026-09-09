class Solution {
    Map<String, Integer> dp = new HashMap<>();

    private int fun(int i, String s, Map<String, Integer> m1, String temp) {

        if (i >= s.length()) {
            if (temp.length() == 0) return 1;
            return 0;
        }

        String key = i + "+" + temp;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int m = 0;

        temp += s.charAt(i);

        if (m1.containsKey(temp)) {
            int a = fun(i + 1, s, m1, "");
            m = m | a;
        }

        int a = fun(i + 1, s, m1, temp);
        m = m | a;

        dp.put(key, m);

        return m;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Integer> m1 = new HashMap<>();

        for (String a : wordDict) {
            m1.put(a, m1.getOrDefault(a, 0) + 1);
        }

        dp.clear();

        return fun(0, s, m1, "") == 1;
    }
}