package ru.education.bootlab.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity @Table(name="study_groups") @Getter @Setter @NoArgsConstructor
public class StudyGroup {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Size(max=30) @Column(length=30,nullable=false) private String name;
 @NotBlank @Size(max=50) @Column(length=50,nullable=false) private String faculty;
 @NotNull @Min(1) @Max(6) @Column(nullable=false) private Integer course;
}
