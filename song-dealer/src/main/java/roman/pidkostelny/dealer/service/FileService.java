package roman.pidkostelny.dealer.service;

import org.springframework.stereotype.Service;
import roman.pidkostelny.dealer.dto.request.FileRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Service
public class FileService {
    public static final String MP3_DIR = "./src/main/resources/static/css";

//            System.getProperty("user.home") + File.separator +
//                    "dealer-songs" + File.separator;


    public String saveFile(FileRequest request) throws IOException {
        createDir(MP3_DIR);

        String[] data = request.getData().split(",");
        String metaInfo = data[0];
        String base64File = data[1];

        String fileName = createFileName(request.getFileName(),
                getFileExtensionFromMetaInfo(metaInfo));

        Files.write(
                Paths.get(MP3_DIR, fileName),
                Base64.getDecoder().decode(base64File.getBytes())
        );
        return fileName;
    }

    private String createFileName(String fileName, String fileExtension) {
        if (fileName == null) {
            fileName = UUID.randomUUID().toString();
        }
        return String.format("%s.%s", fileName, fileExtension);
    }

    private String getFileExtensionFromMetaInfo(String metaInfo) {
        return metaInfo.split("/")[1].split(";")[0];
    }

    private void createDir(String dir) {
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
