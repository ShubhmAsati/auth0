package com.auth0.jobportal.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "otp_manager")
public class OtpManagerEntity extends BaseEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  public Integer otp;
  @Column(name = "user_id", unique = true)
  public UUID userId;

  @Column(name = "resend_count")
  public Integer resendCount;

}