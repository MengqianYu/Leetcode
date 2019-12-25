class Solution {
    public String validIPAddress(String IP) {
        if (checkIPv4(IP)) return "IPv4";
        else if (checkIPv6(IP)) return "IPv6";
        else return "Neither";
    }
    
    private boolean checkIPv4(String IP){
        String[] ip = IP.split("\\.", -1);
        if (ip.length != 4) return false;
        for (int i = 0; i < 4; i++){
            if (ip[i].length() == 0) return false;
            if (ip[i].charAt(0) == '0' && ip[i].length() != 1) return false;
            if (ip[i].length() > 4) return false;
            for (int j = 0; j < ip[i].length(); j++){
                if (ip[i].charAt(j) > '9' || ip[i].charAt(j) < '0') return false;
            }
            int n = Integer.parseInt(ip[i]);
            if (n > 255) return false;
        }
        return true;
    }
    
    private boolean checkIPv6(String IP){
        String[] ip = IP.split("\\:", -1);
        if (ip.length != 8) return false;
        for (int i = 0; i < 8; i++){
            if (ip[i].length() == 0) return false;
            if (ip[i].length() > 4) return false;
            for (int j = 0; j < ip[i].length(); j++){
                if (!Character.isDigit(ip[i].charAt(j)) && (ip[i].charAt(j) < 'a' || ip[i].charAt(j) > 'f') && (ip[i].charAt(j) < 'A' || ip[i].charAt(j) > 'F')){
                    return false;
                }
            }
        }
        return true;
    }
}