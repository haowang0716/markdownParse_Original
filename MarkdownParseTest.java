import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void parseTest1() throws IOException {
        List<String> test1 = List.of("https://something.com", "some-page.html");
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);

        assertEquals("test for file 1", test1, MarkdownParse.getLinks(contents)); 
    }

    @Test
    public void parseTest2() throws IOException {
        List<String> test1 = List.of("https://something.com", "some-page.html");
        Path fileName = Path.of("test-file");
	    String contents = Files.readString(fileName);

        assertEquals("test for file 1", test1, MarkdownParse.getLinks(contents)); 
    }

    public void parseTest3() throws IOException {
        List<String> contents2 = List.of();
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);

        assertEquals("test for file 1", contents2.size(), 0); 
    }

    public void parseTest4() throws IOException {
        List<String> contents4 = List.of(" ");
        Path fileName = Path.of("test-file4");
	    String contents = Files.readString(fileName);

        assertEquals(null , MarkdownParse.getLinks(contents)); 
    }



}