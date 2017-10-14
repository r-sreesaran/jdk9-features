package or.wildcraft.Jshell;

import jdk.jshell.JShell;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class JshellTest {
    JShell shell;

    @BeforeTest
    public void constructMethod() {
        shell = JShell.create();

    }

    @Test
    public  void test() {

        List<SnippetEvent> events  = shell.eval("int x,y,sum;"+"x=1;y=2;sum=x+y;"+"System.out.println(sum);");
        for(SnippetEvent event : events) {
            Snippet snippet = event.snippet();
            Snippet.Status snippetstatus = shell.status(snippet);
            Assert.assertTrue(snippetstatus == Snippet.Status.VALID);
        }
        long x = 10;
        int y = (int)(2 * x) ;

    }

}