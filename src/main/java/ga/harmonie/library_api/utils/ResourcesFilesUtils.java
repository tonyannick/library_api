package ga.harmonie.library_api.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class ResourcesFilesUtils {

    private ResourcesFilesUtils() {
    }

    public static InputStream loadAppResourcesFiles(String fileName){
        var inputStream = ResourcesFilesUtils.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException(fileName + " introuvable dans le dossier resources");
        }
        return inputStream;
    }

    public static Reader readAppResourcesFiles(String fileName) throws IOException{
       return Files.newBufferedReader(Paths.get(fileName));
    }

    public static Reader readAppResourcesFiles(InputStream inputStream){
        return new InputStreamReader(inputStream);
    }


    public static String printResourceFilesContentFromInputStream(InputStream is) throws IOException {
        try (var streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             var reader = new BufferedReader(streamReader)) {
            String line;
            var contenuFichier = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                contenuFichier.append(line);
            }
            is.close();
            return contenuFichier.toString();
        }
    }
}
