package utilities;

import java.io.File;

public class FileUtils {

    public static void deleteFolder(File folder) {
        if (folder.exists()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteFolder(file); // Recursively delete subfolders
                    } else {
                        file.delete();
                    }
                }
            }
            folder.delete(); // Delete the now-empty folder
        }
    }

    public static void deleteScreenshotsFolder(String folderPath) {
        deleteFolder(new File(folderPath));
    }
}
