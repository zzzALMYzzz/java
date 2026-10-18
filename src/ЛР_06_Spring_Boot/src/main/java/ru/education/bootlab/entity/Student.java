package ru.education.bootlab.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity @Table(name="students") @Getter @Setter @NoArgsConstructor
public class Student {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Size(max=15) @Column(length=15,nullable=false) private String name;
 @NotBlank @Size(max=25) @Column(length=25,nullable=false) private String surname;
 @NotBlank @Size(max=20) @Column(length=20,nullable=false) private String faculty;
 @NotNull @Min(14) @Max(120) @Column(nullable=false) private Integer age;
}
