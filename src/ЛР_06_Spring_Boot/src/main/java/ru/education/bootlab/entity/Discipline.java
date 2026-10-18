package ru.education.bootlab.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity @Table(name="disciplines") @Getter @Setter @NoArgsConstructor
public class Discipline {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Size(max=100) @Column(length=100,nullable=false) private String name;
 @NotNull @Min(1) @Max(1000) @Column(nullable=false) private Integer hours;
}
