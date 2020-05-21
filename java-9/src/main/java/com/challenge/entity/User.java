package com.challenge.entity;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 20/05/20
 Time: 14:24
 To change this template use File | Settings | File Templates.
*/

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(schema = "codenation")
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "full_name", length = 100, nullable = false)
  @Size(max = 100)
  @NotEmpty
  @NotNull
  private String fullName;

  @Column(length = 100, nullable = false)
  @Email
  @NotNull
  @Size(max = 100)
  private String email;

  @Column(length = 50, nullable = false)
  @NotNull
  @Size(max = 50)
  private String nickname;

  @NotNull
  @Size(max = 255)
  private String password;

  @OneToMany
  private Set<Candidate> candidates;

  @OneToMany
  private Set<Submission> submissions;

  @Column(name = "created_at", nullable = false, updatable = false)
  @CreatedDate
  @NotNull
  private LocalDateTime createdAt;

}
