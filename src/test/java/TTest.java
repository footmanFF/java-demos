import com.fm.framework.docbuilder.DocBuilder;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.junit.Test;
import java.io.IOException;

/**
 * @author zhangli on 2017/8/12.
 */
public class TTest {

    @Test
    public void a(){
        DocBuilder.run();
        /*
        try {
            Executor exec = new DefaultExecutor();
            CommandLine cl = new CommandLine("ls -l");
            int exitvalue = exec.execute(cl);

        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

}
