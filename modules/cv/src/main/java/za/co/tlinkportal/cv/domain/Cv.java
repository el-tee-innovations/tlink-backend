package za.co.tlinkportal.cv.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String title;
    private String bio;
    private String cvFilePath;
    private String cvFileName;
    private String videoIntroPath;
    private boolean cvVisibleToRecruiters;
    private LocalDateTime createdAt;

    @Embedded
    private CvVisibilitySettings visibilitySettings;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CvSkill> skills = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkExperience> workExperiences = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Qualification> qualifications = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certification> certifications = new ArrayList<>();
}
