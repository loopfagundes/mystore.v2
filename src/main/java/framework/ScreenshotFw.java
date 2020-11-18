package framework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotFw {
    public static final String PATH_SCREENSHOT = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "ScreenshotFw";

    public static String viewScreenshot(WebDriver driver) {

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = PATH_SCREENSHOT + File.separator + src.getName();
            FileUtils.copyFile(src, new File(path));
            return path;
        } catch (IOException erro) {
            System.out.println(erro.getMessage());
            erro.getStackTrace();
            return "Error a capturar de tela";
        }
    }
}