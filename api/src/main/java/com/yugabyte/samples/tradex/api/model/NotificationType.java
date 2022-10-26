package com.yugabyte.samples.tradex.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat
public enum NotificationType {
  MAIL,
  EMAIL
}
