package com.kasa.task_manager.model.entity;

import com.kasa.task_manager.model.user.SignupRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    @Column(unique=true)
    String username;
//    @NotBlank
    String email;
    @NotBlank
    @Size(min = 6, max = 256)
    String password;

    public static User from(SignupRequest request) {
        return User.builder()
//                .email(request.getEmail())
                .username(request.getUsername())
                .password(request.getPassword())
                .build();
    }
}
