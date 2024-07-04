package com.usm.usmobile.model;

import java.util.Date;

@Data
@Document(collection = "daily_usage")
public class DailyUsage {
    private String id;
    private String mdn;
    private String userId;
    private Date usageDate;
    private Number usedInMb
}
