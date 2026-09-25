class Solution {

    private String s;
    private int index;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        index = 0;

        Set<String> result = parseExpression();

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    // Handles expressions separated by comma
    private Set<String> parseExpression() {

        Set<String> result = parseTerm();

        while (index < s.length() && s.charAt(index) == ',') {
            index++; // skip ','

            Set<String> next = parseTerm();

            result.addAll(next);
        }

        return result;
    }

    // Handles concatenation
    private Set<String> parseTerm() {

        Set<String> result = new HashSet<>();
        result.add("");

        while (index < s.length()
                && s.charAt(index) != ','
                && s.charAt(index) != '}') {

            Set<String> next = parseFactor();

            result = combine(result, next);
        }

        return result;
    }

    // Handles a single letter or {...}
    private Set<String> parseFactor() {

        Set<String> result = new HashSet<>();

        if (s.charAt(index) == '{') {

            index++; // skip '{'

            result = parseExpression();

            index++; // skip '}'

        } else {

            result.add(String.valueOf(s.charAt(index)));
            index++;
        }

        return result;
    }

    // Cartesian product + concatenation
    private Set<String> combine(Set<String> a, Set<String> b) {

        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}