package dsa.algorithms.blueoptima;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sol2 {

    static boolean isDiv(int n, int d){
        return n % d == 0;
    }
    static List<String> get(int N){
        Map<String,List<String>> m = new HashMap<>();
        m.put("shiva", Collections.singletonList("asgf"));
        m.put("sjj", Collections.singletonList("asgf"));
        List<String> list = m.entrySet().stream().filter((e) -> e.getKey().startsWith("s"))
                .flatMap(stringListEntry -> stringListEntry.getValue().stream()).collect(Collectors.toList());
        System.out.println(list);
        return IntStream.rangeClosed(1,N).mapToObj(Sol2::getString
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(get(44));
    }

    private static String getString(int num) {
        boolean isDevBy4 = isDiv(num, 4);
        boolean isDebBy11 = isDiv(num,11);
        String str = "";
        if(isDebBy11 && isDevBy4){
            str = "BearChicken";
        }else if(isDevBy4){
            str = "Bear";
        }else if(isDebBy11){
            str = "Chicken";
        }else{
            str = String.valueOf(num);
        }
        return str;
    }
}
