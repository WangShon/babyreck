package vn.edu.vnua.toiec.usecases.file;

import org.springframework.web.multipart.MultipartFile;
import vn.edu.vnua.toiec.presentation.model.FileResponse;

public interface FileService {
    String store (MultipartFile file);

    FileResponse uploadFile(MultipartFile file);
}
