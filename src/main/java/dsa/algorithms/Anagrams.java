package dsa.algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class Anagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
      //  strs = new String[]{"a"};
        Anagrams anagrams = new Anagrams();
        List<List<String>> res = anagrams.groupAnagrams(strs);
        System.out.println(res);
        res = anagrams.groupAnagrams1(strs);
        System.out.println(res);

    }
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap();

        for(String str : strs){
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String sorted = new String(letters);
            if(!map.containsKey(sorted)){
                List<String> list = new ArrayList();
                list.add(str);
                map.put(sorted,list);
            }else{
                List<String> list = map.get(sorted);
                list.add(str);
            }
        }

        List<List<String>> res = new ArrayList<>(map.values());
        return res;


    }
    public List<List<String>> groupAnagrams1(String[] s) {
     /*   if (s.length == 1) {
            List<String> list = new ArrayList<>(1);
            list.add(s[0]);
            List<List<String>> res = new ArrayList<>(1);
            res.add(list);
            return res;
        }*/
        Map<String, List<String>> map = new HashMap<>();
        for (String word : s) {
            char[] alphabet = new char[26];
            System.out.println("word "+word);
            for (char c : word.toCharArray()) {
                System.out.println("diff : "+ (c - 'a'));
                alphabet[c - 'a']++;
            }
            String key = new String(alphabet);
            System.out.println(word + " key "+ key);
            if (map.containsKey(key)) {
                map.get(key).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(key,list);
            }
        }
        return new ArrayList<>(map.values());
    }

}
