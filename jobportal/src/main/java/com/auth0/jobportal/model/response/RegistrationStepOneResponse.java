package com.auth0.jobportal.model.response;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationStepOneResponse {

  private UUID userId;

}
