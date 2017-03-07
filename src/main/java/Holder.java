/**
 * Created by fm on 16/9/11.
 */
public class Holder<T> {
    private T target;
    public T getTarget() {
        return target;
    }
    public void setTarget(T target) {
        this.target = target;
    }
    public static void main(String[] args) {
        Holder<String> holder = new Holder<String>();
        holder.setTarget("some string");
    }
}
