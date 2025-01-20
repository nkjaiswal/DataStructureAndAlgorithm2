import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WordLadderNode {
    public String word;
    public boolean visited;
    public WordLadderNode(String word) {
        this.word = word;
        this.visited = false;
    }
}
class WordLadder {
    private static boolean canMove(String source, String dist) {
        int moveCount = 0;
        for(int i=0; i<source.length(); i++) {
            if(source.charAt(i) != dist.charAt(i)) {
                moveCount++;
            }
        }
        return moveCount < 2;
    }
    public static int transform(Set<WordLadderNode> dict, String source, String dest) {
        int count = 999;
        if(source.equals(dest)) {
            return 0;
        }
        for(WordLadderNode wln: dict.stream().toList()) {
            if(canMove(source, wln.word) && !wln.visited) {
                wln.visited = true;
                count = Math.min(transform(dict, wln.word, dest) + 1, count);
                wln.visited = false;
            }
        }
        return count;
    }
    public static void main(String[] args) {

        System.out.println(transform(Stream.of("hot", "dot", "dog", "lot", "log", "cog").map(WordLadderNode::new).collect(Collectors.toSet()), "hit", "cog"));
    }
}
