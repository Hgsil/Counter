import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class Counter {
    public Counter() {
    }
    public final static Map OP = new HashMap();
    static {
        OP.put('+',1);
        OP.put('-',1);
        OP.put('*',2);
        OP.put('/',2);
        OP.put('(',2);
        OP.put(')',2);


    }
    public static void main(String[] args) {
        HgsilStack<Character> opnd = new HgsilStack<>();
        HgsilStack<Character> operate = new HgsilStack<>();
        HgsilStack<Double> finalCount = new HgsilStack<>();
        String expression = "5*(2+4)/2-7";
        int times = 0;
        for (int i = 0; i <expression.length() ; i++) {
            if (expression.charAt(i)=='('||expression.charAt(i)==')')
                times++;
        }
        char[] data = expression.toCharArray();
        char[] finaldate = new char[expression.length()-times];
        int m = 0;


        for (int i = expression.length()-1 ; i >-1 ; i--) {
            if (Character.isDigit(data[i])){
                opnd.push(data[i]);
                continue;
            }
            else if (!Character.isDigit(data[i])){
                do {
                    if (operate.isEmpty()) {
                        operate.push(data[i]);
                        break;
                    }
                    else if (operate.peek()==')'){
                        operate.push(data[i]);
                        break;
                    }
                    if (OP.get(data[i])==OP.get(operate.peek())||(int)(OP.get(data[i]))>(int)(OP.get(operate.peek()))){

                        if (data[i]==')'){
                            operate.push(data[i]);
                            break;
                        }
                        else if (data[i] == '(') {
                            while (operate.peek()!=')'){
                                opnd.push(operate.pop());
                            }
                            operate.pop();
                            break;
                        }
                        else {
                            operate.push(data[i]);
                            break;
                        }
                    }
                    else {
                        opnd.push(operate.pop());
                        continue;
                    }
                }
                while (m==0);
            }
        }
        while (!operate.isEmpty()) opnd.push(operate.pop());

         while (!opnd.isEmpty()) {
            finaldate[m] = opnd.pop();
            m++;
        }
        for (int i = finaldate.length-1; i >-1 ; i--) {
            if (Character.isDigit(finaldate[i]))
                finalCount.push((double)(Character.getNumericValue(finaldate[i])));
            else{
                switch (finaldate[i]){
                    case '*':
                        finalCount.push(finalCount.pop()*finalCount.pop());
                        continue;
                    case '+':
                        finalCount.push(finalCount.pop()+finalCount.pop());
                        continue;
                    case '-':
                        finalCount.push(finalCount.pop()-finalCount.pop());
                        continue;
                    case '/':
                        finalCount.push(finalCount.pop()/finalCount.pop());
                        continue;
                }
            }
        }
        System.out.printf("%4.0f",finalCount.pop());
    }

}
