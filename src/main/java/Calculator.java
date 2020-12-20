import java.util.Arrays;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Stack;

public class Calculator {
    public  int calculate(String inputString, int x) {
        String termAftProcess;
        String[] termAftProcessArr;

        char[] termArr;
        termArr = processPrio(inputString);

        termAftProcess = String.valueOf(termArr);
        termAftProcessArr = termAftProcess.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");

        for(int i = 0; i< termAftProcessArr.length; i++) {
            if("*".equals(termAftProcessArr[i])) {
                termAftProcessArr = processOprs(termAftProcessArr,i, "*");
                i = 0;
            }
        }
        for(int i = 0; i< termAftProcessArr.length; i++) {
            if("/".equals(termAftProcessArr[i])) {
                termAftProcessArr = processOprs(termAftProcessArr,i, "/");
                i = 0;
            }
        }
        for(int i = 0; i< termAftProcessArr.length; i++) {
            if("+".equals(termAftProcessArr[i])) {
                termAftProcessArr = processOprs(termAftProcessArr,i, "+");
                i = 0;
            }
        }
        for(int i = 0; i< termAftProcessArr.length; i++) {
            if("-".equals(termAftProcessArr[i])) {
                termAftProcessArr = processOprs(termAftProcessArr,i, "-");
                i = 0;
            }
        }
        DrawGraph drawGraph = new DrawGraph(x,Integer.parseInt(termAftProcessArr[0]));
        drawGraph.draw();
        System.out.println(Integer.parseInt(termAftProcessArr[0]));
        return Integer.parseInt(termAftProcessArr[0]);
    }


    private static String[] processOprs(String[] termAftProcessArr, int i, String op) {
        int result = 0;
        int k = 0;
        String[] returnStr = new String[termAftProcessArr.length - 2];
        switch (op.charAt(0)) {
            case('+'): result = Integer.parseInt(termAftProcessArr[i-1]) + Integer.parseInt(termAftProcessArr[i+1]);
                break;
            case('*'): result = Integer.parseInt(termAftProcessArr[i-1]) * Integer.parseInt(termAftProcessArr[i+1]);
                break;
            case('/'): result = Integer.parseInt(termAftProcessArr[i-1]) / Integer.parseInt(termAftProcessArr[i+1]);
                break;
            case('-'): result = Integer.parseInt(termAftProcessArr[i-1]) - Integer.parseInt(termAftProcessArr[i+1]);
                break;
            default: System.out.println("Invalid Operator.");
        }
        for (int j = 0; k< termAftProcessArr.length; j++, k++) {
            if(j == i - 1) {
                returnStr[j] = String.valueOf(result);
                k = k + 2;
            }else {
                returnStr[j] = termAftProcessArr[k];
            }
        }
        return returnStr;
    }

    private static char[] processPrio(String term) {
        char[] termArr = new char[term.length()];
        int start = 0;
        int end = 0;

        for(int i = 0; i < term.length(); i++) {
            termArr[i] = term.charAt(i);
        }
        for(int i = 0; i< termArr.length; i++) {
            StringBuilder termSb = new StringBuilder();
            StringBuilder op1 = new StringBuilder();
            Stack<String> stack = new Stack<String>();
            if(termArr[i] == ')') {
                end = i;
                for(int j = i - 1; j>=0; j--) {
                    if(termArr[j] >='0' && termArr[j] <= '9'){
                        op1.append(termArr[j]);
                    } else {
                        stack.push(String.valueOf(op1.reverse()));
                        op1.delete(0,op1.length());
                        start = j;
                        if(termArr[j] != '(')
                            stack.push(String.valueOf(termArr[j]));
                    }
                    if(termArr[j] == '(')
                        break;
                }
                ListIterator<String>
                        iterator = stack.listIterator();

                while (iterator.hasNext()) {
                    termSb.append(iterator.next());
                }
                String[] splited = termSb.toString().split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
                Collections.reverse(Arrays.asList(splited));
                termArr = process(splited, termArr, start,end + 1);
                i = 0;
            }
        }
        return termArr;
    }

    private static char[] process(String[] splited, char[] termArr, int start, int end) {
        int result = 0;
        char[] termArray;
        StringBuilder returnStr = new StringBuilder();
        StringBuilder toReplace = new StringBuilder();
        switch (splited[1].charAt(0)) {
            case ('+'):
                result = Integer.parseInt(splited[0]) + Integer.parseInt(splited[2]);
                break;
            case ('-'):
                result = Integer.parseInt(splited[0]) - Integer.parseInt(splited[2]);
                break;
            case ('/'):
                result = Integer.parseInt(splited[0]) - Integer.parseInt(splited[2]);
                break;
            case ('*'):
                result = Integer.parseInt(splited[0]) - Integer.parseInt(splited[2]);
                break;
            default:
                System.out.println(("Invalid Operator"));
        }
        returnStr.append(termArr);
        toReplace.append("(");
        for(String s : splited) {
            toReplace.append(s);
        }
        toReplace.append(")");
        returnStr.replace(start, end, Integer.toString(result));
        termArray = new char[returnStr.length()];
        for(int i =0; i < returnStr.length(); i++) {
            termArray[i] = returnStr.charAt(i);
        }
        return termArray;
    }
}
