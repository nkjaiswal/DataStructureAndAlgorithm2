import java.util.HashMap;
import java.util.Map;

class WordSetWithRandomTrieNode {
    boolean wordEnd;
    int wordCount;
    Map<Character, WordSetWithRandomTrieNode> map;
    public WordSetWithRandomTrieNode() {
        this.wordCount = 0;
        this.wordEnd = false;
        this.map = new HashMap<>();
    }

    public void add(String str) {
        this.wordCount ++;
        if(str.isEmpty()) {
            this.wordEnd = true;
        } else {
            Character ch = str.charAt(0);
            if(!this.map.containsKey(ch)) {
                this.map.put(ch, new WordSetWithRandomTrieNode());
            }
            this.map.get(ch).add(str.substring(1));
        }
    }

    public boolean remove(String str) {
        if(str.isEmpty()) {
            this.wordEnd = false;
            this.wordCount --;
            return true;
        }
        Character ch = str.charAt(0);
        if(this.map.containsKey(ch)) {
            WordSetWithRandomTrieNode node = this.map.get(ch);
            if(node.remove(str.substring(1))) {
                if(node.wordCount == 0) {
                    this.map.remove(ch);
                }
                this.wordCount--;
                return true;
            }
        }
        return false;
    }

    public String getRandom(String str) {
        if(str.isEmpty()) {
            return this.getRandom();
        }
        return str.charAt(0)+this.map.get(str.charAt(0)).getRandom(str.substring(1));
    }

    public String getRandom() {
        if(this.wordCount == 1 && this.wordEnd) {
            return "";
        }
        int index = this.getRandomIndex();
        int sum = 0;
        for(Map.Entry<Character, WordSetWithRandomTrieNode> node: this.map.entrySet()) {
            sum += node.getValue().wordCount;
            if(sum > index) {
                return node.getKey() + node.getValue().getRandom();
            }
        }
        return "";
    }

    private int getRandomIndex() {
        return (int) (Math.random() * this.wordCount);
    }
}
public class WordSetWithRandom {
    public static void main(String[] args) {
        WordSetWithRandomTrieNode treeRoot = new WordSetWithRandomTrieNode();
        treeRoot.add("test");
        treeRoot.add("testing");
        treeRoot.add("liquid");
        treeRoot.add("limit");
        treeRoot.remove("testing1");
        treeRoot.remove("test");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("test", 0);
        expected.put("testing", 0);
        expected.put("liquid", 0);
        expected.put("limit", 0);
        for(int i=0; i<100000; i++) {
            String r = treeRoot.getRandom("li");
            expected.put(r, expected.get(r)+1);
        }

        System.out.println(expected);

    }
}
