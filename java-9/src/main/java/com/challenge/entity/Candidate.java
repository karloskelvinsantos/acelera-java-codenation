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

import javax.persistence.*;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(schema = "codenation")
public class Candidate extends BaseEntity{

  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(targetEntity = Acceleration.class, mappedBy = "id")
  private Set<Acceleration> acceleration;

  @OneToOne
  @JoinColumn(name = "company_id")
  private Company company;

  private int status;
}
