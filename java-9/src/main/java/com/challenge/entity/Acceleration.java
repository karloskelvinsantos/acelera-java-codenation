package com.challenge.entity;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 20/05/20
 Time: 14:25
 To change this template use File | Settings | File Templates.
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
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
public class Acceleration implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100, nullable = false)
  @NotNull
  @Size(max = 100)
  private String name;

  @Column(length = 50, nullable = false)
  @NotNull
  @Size(max = 50)
  private String slug;

  @ManyToOne
  @JoinColumn(name = "challenge_id")
  private Challenge challenge;

  @OneToMany
  @JoinColumn(name = "candidate_id")
  private Set<Candidate> candidates;

  @Column(name = "created_at", nullable = false, updatable = false)
  @CreatedDate
  @NotNull
  private LocalDateTime createdAt;

}
