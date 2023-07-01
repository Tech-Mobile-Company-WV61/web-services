package com.fastporte.fastportewebservice.dto;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class CreateConctracDto {
  private String amount;
  private Date contractDate;
  private String timeDeparture;
  private String timeArrival;
  private String description;
  private String from;
  private String to;
  private String quantity;
  private String subject;
  private boolean visible;
}
