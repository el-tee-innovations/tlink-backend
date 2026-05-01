package za.co.tlinkportal.assessment.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UploadSubmissionRequest {

    private MultipartFile file;
}