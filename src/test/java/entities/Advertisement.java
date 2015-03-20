package entities;

import utils.PropertyLoader;

import java.io.File;

/**
 * Created by Елена on 15.03.2015.
 */
public class Advertisement {
    public String title = "";
    public String rubric = "";
    public String price = "";
    public String desc = "";
    public String imagePath = PropertyLoader.loadProperty("project.path") + "src/test/resources/g6Zx0AY0Mfc.jpg";
    public String photoFilePath = new File(PropertyLoader.loadProperty("project.path") + "src/test/resources/g6Zx0AY0Mfc.jpg").getAbsolutePath();
    public String region = "";
    public String user = "";
    public String email = "";
    public String phone = "";
    public String icq = "";
    public String skype = "";
}
