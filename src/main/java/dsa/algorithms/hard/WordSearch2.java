package dsa.algorithms.hard;

import java.util.*;

public class WordSearch2 {

    static class Position{
        int r,c;
        Position(int r,int c){
            this.r = r;
            this.c = c;
        }
        public String toString(){
            return r+","+c;
        }
        public int hashCode(){
            return ("row"+r+"col"+c).hashCode();
        }
        public boolean equals(Object o){
            Position that = (Position) o;
            if(this.r == that.r && this.c == that.c){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        WordSearch2 wordSearch2 = new WordSearch2();
        char[][] b = new char[][]
                {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};
      /*  char[][] b = new char[][]
                {{'a','b'},{'c','d'}};
        String[] words = new String[]{"abcd"};*/
        wordSearch2.findWords(b,words);
    }

    public List<String> findWords(char[][] board, String[] words) {

        Collection<String> res = new HashSet<>();
        Map<Position,Character> map = new HashMap(board.length * board[0].length);
        Map<Character, Set<Position>> map1 = new HashMap<>();
        Map<Character, Set<Position>> map3 = new HashMap<>();

        for(int i = 0 ; i < board.length;i++){
            for(int j = 0 ; j < board[i].length;j++){
                map.put(new Position(i,j), board[i][j]);
                Set<Position> set = map1.getOrDefault(board[i][j], new HashSet<>());
                set.add(new Position(i,j));
                map1.put(board[i][j],set);

            }
        }
        System.out.println(map);
        for(String w : words){
            for(int i = 0 ; i < board.length; i++){
                for(int j = 0 ; j < board[i].length; j++){
                    boolean isExist = isExist(board,w,0,i,j,map,map1);
                    if(isExist){
                        res.add(w);
                    }
                }

            }
        }
        System.out.println(res);
        return new ArrayList<>(res);
    }

    boolean isExist(char[][] board, String word, int pos, int r, int c, Map<Position,Character> map, Map<Character, Set<Position>> map1){
        int i = 0;
        for( ; i < word.length() ;i++){
            char ch = word.charAt(i);
            if(map1.containsKey(ch)){
                Set<Position> set = map1.get(ch);

                if((set.contains(new Position(r+1,c)) ||
                        set.contains(new Position(r-1,c)))) {
                    r++;
                }else if(set.contains(new Position(r,c-1)) ||
                        set.contains(new Position(r,c+1))) {
                    c++;
                }else{
                    return false;
                }

                /*if(!map1.containsKey(word.charAt(i+1))) {
                    return false;
                }else{
                    Set<Position> set = map1.get(ch);
                    if(!(set.contains(new Position(r++,c)) ||
                            set.contains(new Position(r-1,c)) ||
                            set.contains(new Position(r,c-1)) ||
                            set.contains(new Position(r,c+1)))){
                        return false;
                    }

                }*/
            }else{
                return false;
            }
        }
       return i == word.length();
    }

    /*boolean isExist(char[][] board, String word, int pos, int r, int c, Map<Position,Character> map){
        if(pos >= word.length()){
            return true;
        }
        if(r < 0 || c < 0  ||r >= board.length || c >= board[r].length  ){
            return false;
        }

        if(board[r][c] != word.charAt(pos)) return false;
        board[r][c] ^= 256;
       *//* boolean isExists =
                isExist(board, word, pos+1, r+1,c) ||
                isExist(board, word, pos+1, r-1,c)  ||
                isExist(board,word,  pos+1, r,  c+1)   ||
                isExist(board,word,  pos+1, r,  c-1);*//*

        if(pos == word.length() -1){
            return isExist(board, word, pos+1, r+1,c,map) ||
                    isExist(board, word, pos+1, r-1,c,map)  ||
                    isExist(board,word,  pos+1, r,  c+1,map)   ||
                    isExist(board,word,  pos+1, r,  c-1,map);
        }
        else if(map.getOrDefault(new Position(r+1,c),'#') == word.charAt(pos+1) ||
                map.getOrDefault(new Position(r-1,c),'#') == word.charAt(pos+1) ||
                map.getOrDefault(new Position(r,c+1),'#') == word.charAt(pos+1) ||
                map.getOrDefault(new Position(r,c-1),'#') == word.charAt(pos+1)){
            return isExist(board, word, pos+1, r+1,c,map) ||
                    isExist(board, word, pos+1, r-1,c,map)  ||
                    isExist(board,word,  pos+1, r,  c+1,map)   ||
                    isExist(board,word,  pos+1, r,  c-1,map);
        }

        board[r][c] ^= 256;
        return false;
    }*/
}
