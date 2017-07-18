package com.eden.mongo;

public class TaskStatusInfo {
  public String region;
  public String activityId;
  public String activityType;
  public Long actDefId;
  public String status;
  public String owner;
  public String creationTime;
  public String completionTime;
  public String e2eDuration;
  public String bkgNums;
  public String blNum;
  public String amsCutoffDate;
  public String sla;
  public String taskComplexity;
  public Boolean amsRequired;
  public String vbcReceivingTime;

  public TaskStatusInfo() {
  }

  @Override
  public String toString() {
    return "TaskStatusInfo{" +
      "region='" + region + '\'' +
      ", activityId='" + activityId + '\'' +
      ", activityType='" + activityType + '\'' +
      ", actDefId=" + actDefId +
      ", status='" + status + '\'' +
      ", owner='" + owner + '\'' +
      ", creationTime='" + creationTime + '\'' +
      ", completionTime='" + completionTime + '\'' +
      ", e2eDuration='" + e2eDuration + '\'' +
      ", bkgNums='" + bkgNums + '\'' +
      ", blNum='" + blNum + '\'' +
      ", amsCutoffDate='" + amsCutoffDate + '\'' +
      ", sla='" + sla + '\'' +
      ", taskComplexity='" + taskComplexity + '\'' +
      ", amsRequired=" + amsRequired +
      ", vbcReceivingTime='" + vbcReceivingTime + '\'' +
      '}';
  }
}