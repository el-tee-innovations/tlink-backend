package za.co.tlinkportal.cv.api.dto.request;

import lombok.Data;

@Data
public class CvCreateRequest {

    private Long userId;
    private String title;
}
