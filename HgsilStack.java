import java.util.LinkedList;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class HgsilStack<T> {
    LinkedList<T> hgsil= new LinkedList<T>();   //用来保存数据
    public HgsilStack() {
    }
    public void push(T i){
        hgsil.addFirst(i);
    }
    public T pop(){
        T a = hgsil.get(0);
        hgsil.remove(0);
        return a ;
    }
    public T peek(){
        T a = hgsil.get(0);
        return a;
    }
    public boolean isEmpty(){
        if (hgsil.isEmpty())
            return true;
        else
            return false;
    }
}
