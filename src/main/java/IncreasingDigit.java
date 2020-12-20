import java.util.Arrays;

public class IncreasingDigit {


    public String calculate(String inputVal) {
        int inputLen = inputVal.length();
        Integer[] inputArr = new Integer[inputLen];
        Integer[] outputArr = new Integer[inputLen];
        Integer[] outputResult;
        if(inputLen> 1) {
            for (int i = 0; i < inputLen; i++) {
                inputArr[i] = Integer.parseInt(String.valueOf(inputVal.charAt(i)));
            }
            for (int i = 0; i < inputLen; i++) {
                outputArr[i] = 0;
            }
            for (int i = inputLen - 2; i >= 0; i--) {
                if(inputArr[i] > inputArr[i + 1]) {
                    for (int j = i+1; j< inputLen; j++) {
                        outputArr[j] = 9;
                    }
                    outputArr[i] = inputArr[i] - 1;
                    inputArr[i] = inputArr[i] - 1;
                } else {
                    outputArr[i+1] = inputArr[i+1];
                    outputArr[i] = inputArr[i];
                }
            }
            if(outputArr[0] ==0) {
                outputResult = new Integer[inputLen-1];
                System.arraycopy(outputArr,1,outputResult,0,outputArr.length-1);

            } else {
                outputResult = new Integer[inputLen];
                System.arraycopy(outputArr,0,outputResult,0,outputArr.length);
            }
            System.out.println(Arrays.toString(outputResult).replaceAll("\\[|\\]|,|\\s", ""));
            return Arrays.toString(outputResult).replaceAll("\\[|\\]|,|\\s", "");
        }
        return inputVal;
    }
}
