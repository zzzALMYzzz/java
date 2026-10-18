package ru.education.bootlab.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;
@Entity @Table(name="users") @Getter @Setter @NoArgsConstructor
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=50) private String firstName;
 @Column(nullable=false,length=50) private String lastName;
 @Column(nullable=false,unique=true,length=254) private String email;
 @com.fasterxml.jackson.annotation.JsonIgnore
 @Column(nullable=false,length=100) private String password;
 @ManyToMany(fetch=FetchType.EAGER)
 @JoinTable(name="user_roles",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
 private Set<Role> roles=new HashSet<>();
}
