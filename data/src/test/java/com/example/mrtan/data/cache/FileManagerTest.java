package com.example.mrtan.data.cache;

import com.example.mrtan.data.ApplicationTestCase;
import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author mrtan on 17-3-16.
 */

public class FileManagerTest extends ApplicationTestCase {

  @After public void tearDown(){
    if (cacheDir() != null){
      FileManager.clearDirectory(cacheDir());
    }
  }

  @Test public void testWriteToFile() {
    File file = createDummyFile();
    FileManager.writeToFile(file, "content");
    assertThat(file.exists(), is(true));
  }

  File createDummyFile() {
    String path = cacheDir().getPath() + File.separator + "deummyFile";
    return new File(path);
  }
}
