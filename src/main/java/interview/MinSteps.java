package interview;

import java.util.HashMap;
import java.util.Map;

public class MinSteps {

   static int[][] mapping= new int[][]
           {        {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16},
                    {17,18,19,20},
                    {21,22,23,24},
                    {25,26,27}
    };

    public static void main(String[] args) {
        int steps = countMinSteps("whatfix");
        System.out.println(steps);

        steps = countMinSteps("youtube");
        System.out.println(steps);

        steps = countMinSteps("sdd");
        System.out.println(steps);
    }

    static int countMinSteps(String str){
        int count = 0;



        Map<Character,Integer> map = new HashMap<>();

        map.put('a',1);
        char a = 'a';
        for(int i = 1; i <=26;i++){
            map.put( (char) ('a'+i),i+1);
        }
        System.out.println(map);
        int i = 0;
        int j = 0;

        int targetI;
        int targetJ;
        char prev = 'a';
        for(char ch : str.toCharArray()){
            int pos = map.get(ch);


            if(pos % 4 == 0){
                targetI = (pos / 4) - 1;
                targetJ = 3;
            }else{
                 targetI = pos / 4; //1
                 targetJ = (pos % 4) - 1; //
            }
            int subCount=countSteps(i,j,targetI,targetJ,pos,prev,ch);

            count+=subCount;
            System.out.println(prev + " to "+ ch+ " "+subCount+ " count "+count);
            prev = ch;
            i = targetI;
            j = targetJ;
        }
        return count + str.length();
    }

    static  int countSteps(int i, int j , int targetI,int targetJ,int pos,char prev,char ch){
        int stepsByRow =   targetI > i ? targetI - i : i - targetI;
             //   Math.abs(targetI - i);
        int stepsByCol = mapping[targetI][j];
        //Math.abs((pos - stepsByCol)

        return stepsByRow + (pos > stepsByCol ? pos - stepsByCol : stepsByCol -pos);
    }

}
