class Solution {
    public int numDecodings(String s) {
        if( s.length() == 0 ) return 0;
        return helper(s,0);
    }
    public int helper(String s, int index){
        int len = s.length();
        if( index == len ) return 1;
        if(s.charAt(index) == '0') return 0;
        int res = helper(s,index+1);
        if( index < len - 1 && ( s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index+1) < '7'))){
            res += helper(s,index+2);
        }
        return res;
    }
}

class Solution {
    public int numDecodings(String s) {
        if( s.length() == 0 ) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        return helper(s,0,map);
    }
    public int helper(String s, int index, Map<Integer,Integer> map){
        Integer cur = map.get(index);
        if( cur != null ) return cur;
        int len = s.length();
        if( index == len ) return 1;
        if( s.charAt(index) == '0' ) return 0;
        int res = 0;
        res += helper(s,index+1,map);
        if( index < len - 1 && ( s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index+1) < '7'))){
            res += helper(s,index+2,map);
        }
        map.put(index,res);
        return res;
    }
}



class Solution {
    public int numDecodings(String s) {
        if( s == null || s.length() == 0 ) return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for( int i = 2 ; i <= n ; i++ ){
            int first = Integer.valueOf(s.substring(i-1,i));
            int second = Integer.valueOf(s.substring(i-2,i));
            if( first >= 1 && first <= 9 ) dp[i] += dp[i-1];
            if( second >= 10 && second <= 26 ) dp[i] += dp[i-2];
        }
        return dp[n];
    }
}

