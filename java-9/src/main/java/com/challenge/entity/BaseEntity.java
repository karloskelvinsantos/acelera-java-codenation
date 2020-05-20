package com.challenge.entity;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 20/05/20
 Time: 14:28
 To change this template use File | Settings | File Templates.
*/


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "created_at")
  @CreatedDate
  private LocalDateTime createdAt;
}
