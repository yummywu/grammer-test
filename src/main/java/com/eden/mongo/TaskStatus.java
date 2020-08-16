package com.eden.mongo;

import java.util.Date;
import java.util.UUID;

public class TaskStatus {

  public String msgId;
  public Date createdDateTime;

  public TaskStatusInfo taskStatusInfo;

  public TaskStatus(String uuid, TaskStatusInfo taskStatusInfo) {
    this.msgId = uuid;
    this.createdDateTime = new Date();
    this.taskStatusInfo = taskStatusInfo;
  }

  public TaskStatus(TaskStatusInfo taskStatusInfo) {
    this.msgId = UUID.randomUUID().toString();
    this.createdDateTime = new Date();
    this.taskStatusInfo = taskStatusInfo;
  }

  @Override
  public String toString() {
    return "TaskStatus{" +
      ", msgId='" + msgId + '\'' +
      ", createdDateTime=" + createdDateTime +
      ", taskStatusInfo=" + taskStatusInfo +
      '}';
  }
}


