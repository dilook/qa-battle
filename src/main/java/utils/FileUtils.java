package utils;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static core.AppConstants.DOWNLOAD_PATH;

public class FileUtils {

    private FileUtils() {
    }

    /**
     * Read file from download folder.
     *
     * @param fileName file name
     * @return string
     */
    @SneakyThrows
    public static String readFileFromDownloadFolder(String fileName) {
        return new String(Files.readAllBytes(Paths.get(DOWNLOAD_PATH + fileName)), StandardCharsets.UTF_8);
    }

    /**
     * Remove file from download folder.
     *
     * @param fileName file name
     * @return true or false
     */
    @SneakyThrows
    public static boolean removeFileFromDownloadFolder(String fileName) {
        return Files.deleteIfExists(Paths.get(DOWNLOAD_PATH + fileName));
    }


    /**
     * Check if file is downloaded within specific time.
     *
     * @param fileName file name
     * @param waitSec  timeout in sec
     * @return true or false
     */
    public static boolean isFileDownloaded(String fileName, int waitSec) {
        File file = new File(DOWNLOAD_PATH + fileName);
        for (int i = 0; i < waitSec; i++) {
            if (file.exists()) {
                return true;
            } else {
                try {
                    Thread.sleep(waitSec * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

}
