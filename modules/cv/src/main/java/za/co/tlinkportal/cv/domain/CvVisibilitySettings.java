package za.co.tlinkportal.cv.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class CvVisibilitySettings {

    private boolean visibleToRecruiters = true;

    private boolean allowDownload = true;
}
