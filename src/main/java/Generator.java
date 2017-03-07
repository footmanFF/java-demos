/**
 * Created by fm on 16/9/11.
 */
public interface Generator <T>{
    public T next();
}

class IntegerGenerator implements Generator<Integer>{
    @Override
    public Integer next() {
        return 1;
    }
}