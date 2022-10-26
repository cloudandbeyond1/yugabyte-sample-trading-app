package com.yugabyte.samples.tradex.api.model;

import lombok.Data;

@Data

public class UserPreferences {
  NotificationType tradeConfirmation;
  NotificationType dailyReport;
  NotificationType monthlyReport;
}
