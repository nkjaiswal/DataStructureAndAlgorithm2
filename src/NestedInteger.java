import java.util.List;

class NestedIntegerIterator {
    NestedInteger nInt;
    boolean hasNext;
    int pointer;
    NestedIntegerIterator iterator;
    public NestedIntegerIterator(NestedInteger nInt) {
        this.nInt = nInt;
        if(nInt.data != null) {
            this.hasNext = true;
        }
        this.pointer = 0;
    }
    public boolean hasNext() {
        if(this.nInt.data != null) {
            return hasNext;
        }
        if(this.nInt.datas.isEmpty()) {
            return false;
        }
        if(this.pointer == 0) {
            this.iterator = this.nInt.datas.get(this.pointer).getIterator();
            this.pointer++;
        }
        if(this.iterator.hasNext()) {
            return true;
        }
        while(!this.iterator.hasNext() && this.pointer < this.nInt.datas.size()) {
            this.iterator = this.nInt.datas.get(this.pointer++).getIterator();
        }
        return this.iterator.hasNext();
    }
    public int next() throws Exception {
        if(this.nInt.data != null) {
            if(!this.hasNext) {
                throw new Exception("Error");
            }
            this.hasNext = false;
            return this.nInt.data;
        }
        return this.iterator.next();
    }
}
class NestedInteger {
    Integer data;
    List<NestedInteger> datas;
    public NestedInteger(Integer data) {
        this.data = data;
        this.datas = null;
    }
    public NestedInteger(List<NestedInteger> datas) {
        this.data = null;
        this.datas = datas;
    }
    public NestedIntegerIterator getIterator() {
        return new NestedIntegerIterator(this);
    }

    public static void main(String[] args) throws Exception {
        NestedInteger n1 = new NestedInteger(10);
        NestedInteger n2 = new NestedInteger(20);
        NestedInteger n3 = new NestedInteger(30);
        NestedInteger n4 = new NestedInteger(List.of(n1, n2, n3));
        NestedInteger n5 = new NestedInteger(40);
        NestedInteger n6 = new NestedInteger(List.of(n4, n5));
        NestedInteger n7 = new NestedInteger(List.of(n6));
        NestedInteger n8 = new NestedInteger(List.of(n7));
        NestedInteger n9 = new NestedInteger(50);
        NestedInteger BLANK = new NestedInteger(List.of());
        NestedInteger n10 = new NestedInteger(List.of(n8, BLANK, n9));
        NestedIntegerIterator it = n10.getIterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        // it.next();
    }
}
