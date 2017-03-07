/**
 * Created by fm on 16/9/11.
 */

/**
 * 用于需要返回多个对象的方法
 * 这里的泛型给予了这个类可以动态指定参数的功能
 */
public class TwoTuple<A, B>{
    public final A first;
    public final B second;
    public TwoTuple(B second, A first) {
        this.second = second;
        this.first = first;
    }
}
