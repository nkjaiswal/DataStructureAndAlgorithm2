public class StringMutliply {
    private int toInt(char c) {
        return c - '0';
    }
    public String multiple(String A, char C, int base) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<base; i++) {
            sb.append('0');
        }
        for(char c: A.toCharArray()) {
            int mul = carry + toInt(c) * toInt(C);
            carry = mul/10;
            mul = mul%10;
            sb.append(mul);
        }
        if(carry > 0) {
            sb.append(carry);
        }
        return sb.toString();
    }
    private char getOrDefault(String A, int i) {
        if(i >= A.length()) {
            return '0';
        }
        return A.charAt(i);
    }
    private String reverse(String A) {
        StringBuilder sb = new StringBuilder();
        for(int i=A.length()-1; i>=0; i--) {
            sb.append(A.charAt(i));
        }
        return sb.toString();
    }
    private String scrubLeadingZero(String A) {
        boolean skipZero = true;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<A.length(); i++) {
            if(A.charAt(i) != '0') {
                skipZero = false;
                sb.append(A.charAt(i));
            }
            if(A.charAt(i) == '0' && !skipZero) {
                sb.append(A.charAt(i));
            }

        }
        if(sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
    public String add(String A, String B) {
        int length = Math.max(A.length(), B.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i=0; i<length; i++) {
            int addition = carry + toInt(getOrDefault(A, i)) + toInt(getOrDefault(B, i));
            carry = addition / 10;
            addition = addition % 10;
            sb.append(addition);
        }
        if(carry > 0) {
            sb.append(carry);
        }
        return sb.toString();
    }
    public String multiply(String A, String B) {
        A = reverse(A);
        B = reverse(B);
        String result = "";
        int base = 0;
        for(char c: B.toCharArray()) {
            String currentRow = multiple(A, c, base++);
            result = add(result, currentRow);
        }
        return scrubLeadingZero(reverse(result));
    }

    public static void main(String[] args) {
        System.out.println(new StringMutliply().multiply("995", "0"));
    }
}
