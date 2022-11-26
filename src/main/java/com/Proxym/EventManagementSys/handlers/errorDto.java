package com.Proxym.EventManagementSys.handlers;

import com.Proxym.EventManagementSys.exception.errorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class errorDto {
  private Integer codeHttp;
  private errorCodes code;
  private String message;
  private List<String> errors = new ArrayList<>();


}
