package org.wildcraft.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;

@Test
public class TryWithResourceTest {

    private static final Logger LOG = LoggerFactory.getLogger(TryWithResourceTest.class.getName());

    private static final String SEPARATOR = FileSystems.getDefault().getSeparator();

    String filePath = SEPARATOR+"org"+SEPARATOR+"wildcraft"+SEPARATOR+"exception"+SEPARATOR+"sample.txt";

    private URI fileURI;

    @BeforeTest(enabled = false)
    public void init() throws URISyntaxException {
        fileURI = Thread.currentThread().getContextClassLoader().getResource(filePath).toURI();
    }

    @Test(enabled = false)
    public void testTryWithResource() {
        String fileContent = null;
        try (FileReader fileReader = new FileReader(new File(fileURI));
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                fileContent =line;
            }
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage());
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
        LOG.info(fileContent);
        Assert.assertEquals(fileContent, "Hello World!!!");
    }

    @Test(enabled = false)
    public void testTryWithEffectivelyFinalResource() {
        String fileContent = null;
        try {
            FileReader fileReader = new FileReader(new File(fileURI));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            try (fileReader; bufferedReader) {

                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    fileContent =line;
                }
            }

        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage());
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
        LOG.info(fileContent);
        Assert.assertEquals(fileContent, "Hello World!!!");
    }
}
