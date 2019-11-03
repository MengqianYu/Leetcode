Set<String> dict = new HashSet<>();
        for (String ss : wordDict){
            dict.add(ss);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j <=i; j++){
                dp[i+1] |= (dp[j] && dict.contains(s.substring(j, i+1)));
            }
        }
        return dp[s.length()];