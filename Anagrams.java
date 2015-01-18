public class Solution {
    List<String> list;
    public List<String> anagrams(String[] strs) {
        int n = strs.length;
        list = new ArrayList<String>();
        /* 
            hash - string statistic prob.
            sorted string as key - a list of unsort string as value
        */
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i=0; i<n; i++) {
            String cur = strs[i];
            char[] cs = cur.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            ArrayList<String> l = map.get(key);
            if (l==null) { l = new ArrayList<String>(); l.add(cur); map.put(key,l);}
            else l.add(cur);
        }
        for (String k:map.keySet()) {
            ArrayList<String> arr = map.get(k);
            if (arr.size()<2)   continue;
            else {
                for (String s:arr)
                    list.add(s);
            }
        }
        return list;
    }
}
