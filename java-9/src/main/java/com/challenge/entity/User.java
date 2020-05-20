package com.challenge.entity;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 20/05/20
 Time: 14:24
 To change this template use File | Settings | File Templates.
*/

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(schema = "codenation")
public class User extends BaseEntity{

  @Column(name = "full_name", length = 100, nullable = false)
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
  private String password;

}
