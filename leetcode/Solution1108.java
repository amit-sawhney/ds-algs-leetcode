package leetcode;

public class Solution1108 {
    /**
     * Jumps across the string from period to period
     * 
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {

        int current = 0;
        int next = address.indexOf(".");

        // More efficient than += string concatenation 
        StringBuilder defang = new StringBuilder();

        while (next != -1 && next > current) {
            defang.append(address.substring(current, next));
            defang.append("[.]");
            current = next + 1;
            next = address.substring(current).indexOf(".") + current;
        }

        defang.append(address.substring(current));

        return defang.toString();
    }
}