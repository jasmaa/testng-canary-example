package com.github.canary;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;
import software.amazon.awssdk.services.cloudwatch.model.Dimension;
import software.amazon.awssdk.services.cloudwatch.model.MetricDatum;
import software.amazon.awssdk.services.cloudwatch.model.PutMetricDataRequest;
import software.amazon.awssdk.services.cloudwatch.model.StandardUnit;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;

public interface CloudWatchMetricTest {
  @AfterSuite
  default void putMetric(ITestContext context) {
    Instant instant = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    List<String> resultCategories = List.of(
        "Total",
        "Passed",
        "Failed",
        "Skipped");
    List<Integer> resultCounts = List.of(
        context.getAllTestMethods().length,
        context.getPassedTests().getAllResults().size(),
        context.getFailedTests().getAllResults().size(),
        context.getSkippedTests().getAllResults().size());

    CloudWatchClient cwClient = Utils.getCloudWatchClient();
    for (int i = 0; i < resultCategories.size(); i++) {
      MetricDatum datum = MetricDatum.builder()
          .metricName(resultCategories.get(i))
          .unit(StandardUnit.COUNT)
          .value((double) resultCounts.get(i))
          .timestamp(instant)
          .dimensions(
              Dimension.builder()
                  .name("TestSuite")
                  .value(context.getSuite().getName())
                  .build())
          .build();
      PutMetricDataRequest request = PutMetricDataRequest.builder()
          .namespace("TestNG Canary")
          .metricData(datum)
          .build();
      cwClient.putMetricData(request);
    }
  }
}
