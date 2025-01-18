package br.com.fabex.utils;

import java.io.File;

public class FileUtil extends BaseUtil {

    public static boolean isFileExist(final String fileName) {
        File file = new File(fileName);
        return file.exists();
    }
}
