package bjk.learn.java.barancev;

import org.testng.annotations.Test;

import java.io.File;

public class FileTest {

  @Test
  public void testGetPathToFile() {
    File  currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File helloWorldFile = new File("src/test/resources/HelloWorld.txt");
    System.out.println(helloWorldFile.exists());
  }
}
