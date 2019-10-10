package roman.pidkostelny.dealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import roman.pidkostelny.dealer.dto.request.FileRequest;
import roman.pidkostelny.dealer.service.FileService;

import java.io.IOException;


@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public String upload(@RequestBody FileRequest fileRequest) throws IOException {
        String filePath = fileService.saveFile(fileRequest);

        return filePath;
    }

}
