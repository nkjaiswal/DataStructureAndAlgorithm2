import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JustifyContent {
    public String repeat(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
    public String[] fullJustify(String[] A, int B) {
        if(A.length == 1 && A[0].length() == 0) {
            String[] s = {};
            return s;
        }
        List<String> solution = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(String w: A) {
            if(sb.length() + w.length() + 1 <= B) {
                if(sb.length() == 0) {
                    sb.append(" ");
                }
                sb.append(w);
            } else {
                solution.add(sb.toString());
                sb = new StringBuilder();
                sb.append(w);
            }
        }
        solution.add(sb.toString());
        for(int i=0; i<solution.size(); i++) {
            String str = solution.get(i);
            int spaceAvailable = B - str.length();
            String[] words = str.split(" ");
            spaceAvailable = spaceAvailable + words.length - 1;
            int baseSpace = words.length == 1 ? 0 : spaceAvailable/(words.length-1);
            String baseSpaceStr = repeat(Math.max(0, baseSpace));
            spaceAvailable = spaceAvailable - (baseSpace * (words.length-1));
            StringBuilder sbFinal = new StringBuilder();
            for(String word: words) {
                sbFinal.append(word);
                if(!word.equals(words[words.length-1])) {
                    sbFinal.append(baseSpaceStr);
                }
                if(spaceAvailable > 0) {
                    sbFinal.append(" ");
                    spaceAvailable--;
                }
                if(word.equals(words[words.length-1])) {
                    sbFinal.append(repeat(Math.max(0, spaceAvailable)));
                }
            }
            solution.set(i, sbFinal.toString());
        }
        String[] s = new String[solution.size()];
        int c=0;
        for(String str: solution) {
            s[c++] = str;
        }
        return s;
    }

    public static void main(String[] args) {
        String[] str = {""};
        System.out.println(new JustifyContent().fullJustify(str, 10)[0]);
    }
}
