
// check Balanced string
// you are given a string num consisting of only
// digits A string of digit is called balanced if
// the sum of the digits at even indices is equal
// to the sum of digits at odd indices
// return true if mum is balanced otherwise
// return false
// Ex num 1234
// false
// Ex num It
// even S1 2 1 3 6
// odd 52 4 2 6
// 2 digit 2
// 2 d 2

public class A_checkBalanceStrings {

    public static void main(String[] args) {
        //main fn
    }public class Solution{
        public boolean isBalanced(String num){
            int evenSum = Integer.MIN_VALUE;
            int oddSum= Integer.MIN_VALUE;




            for(int i = 0 ;i< num.length(); i++){
                char ch = num.charAt(i);
                int digit = ch - '0';
                if(i%2 == 0){

                    evenSum += digit;
                }else{
                    oddSum +=digit;
                }


            }


            if(evenSum==oddSum){
                return true;
            }else{
                return false;
            }






        }
    }
}