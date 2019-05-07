package com.ittx.edi.express.jd.ldop.controller;

public class longest_palindromic_substring_5 {
    public static void main(String[] args) {
        longestPalindrome("aab");
    }

    /**
     * ""
     * zazaazakakakkakaka
     * abcddcbbcddcba
     * babad
     */
    public static String longestPalindrome(String s) {
        int i = 0 , j = 1 ;
        int start = i,end = j;
        String palindrome = "";
        while (i>=0&&i<s.length()&&j<s.length()){
            if (s.charAt(i) == s.charAt(j)||((i>0)&&(s.charAt(i-1) == s.charAt(j)))){
                end = j;
                if (j<s.length()&&i>0&&s.charAt(i-1) == s.charAt(j)){
                    start = i-1;
                }else{
                    start = i;
                }
                while (start>0&&end<s.length()&&s.charAt(end) == s.charAt(start)){
                    end++;
                    start--;
                }

                if (palindrome.length()<=end-start-2+1){
                    palindrome = s.substring(start+1,end);
                }
                //当start与end都没有到临界值
                /**
                 * 1.
                 */
//                if (start!=0&&end!=s.length()){
//                    if (s.length()<end-start-2){
//                        palindrome = s.substring(start,end);
//                    }
//                }else if (start==0&&end!=s.length()){
//                    if (s.length()<end-start-1){
//                        palindrome = s.substring(start,end-1);
//                    }
//                }else if (start!=0&&end==s.length()){
//                    if (s.length()<end-start-2){
//                        palindrome = s.substring(start-1,end);
//                    }
//                }


                if (palindrome.length() == s.length()){
                    break;
                }
                i++;
                j++;
            }else{
                i++;
                j++;
            }
        }
        if (s.length() == 1){
            palindrome = String.valueOf(s.charAt(0));
        }
        return palindrome;
    }
}
