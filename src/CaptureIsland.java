import java.util.ArrayList;

public class CaptureIsland {
    public void visit(ArrayList<ArrayList<Character>> a, int i, int j) {
        if(i<0 || i>=a.size() || j<0 || j>=a.get(0).size()) {
            return;
        }
        if(a.get(i).get(j) == 'O') {
            a.get(i).set(j, 'Y');
            visit(a, i+1, j);
            visit(a, i-1, j);
            visit(a, i, j-1);
            visit(a, i, j+1);
        }
    }
    public void solve(ArrayList<ArrayList<Character>> a) {
        int n = a.size();
        int m = a.get(0).size();
        for(int i=0; i<n; i++) {
            visit(a, i, 0);
            visit(a, i, m);
        }
        for(int i=0; i<m; i++) {
            visit(a, 0, i);
            visit(a, n, i);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(a.get(i).get(j) == 'O') {
                    a.get(i).set(j, 'X');
                }
                if(a.get(i).get(j) == 'Y') {
                    a.get(i).set(j, 'O');
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] land = {"XOXXXXOOXX", "XOOOOXOOXX", "OXXOOXXXOO", "OXOXOOOXXO", "OXOOXXOOXX", "OXXXOXXOXO", "OOXXXXOXOO"};
//        new CaptureIsland().solve(land);
    }
}
