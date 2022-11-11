package dsa.algorithms.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Turing {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] ops = scanner.nextLine().split(" ");
        System.out.println(calPoints(ops));
        scanner.close();


    }
    public static int calPoints(String[] ops){
        int res = 0;
        List<Integer> list = new LinkedList<>();
        int size = 0;
        for(String op : ops){
            switch (op){
                case "+":
                    size = list.size();
                    list.add(list.get(size -1) + list.get(size -2));
                    break;
                    case "D":
                        size = list.size();
                        list.add(2 * list.get(size -1));
                        break;
                case "C":
                    list.remove(list.size()-1);
                    break;
                default:
                    list.add(Integer.valueOf(op));
                    break;
            }
        }
        res = 0;
        for(int num : list){
            res+=num;
        }
        return res;
    }
}
