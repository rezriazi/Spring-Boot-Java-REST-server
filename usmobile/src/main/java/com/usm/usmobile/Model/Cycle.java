package com.usm.usmobile.model;

import java.util.Date;

@Data
@Document(collection = "cycles")
public class Cycle {
    private String id;
    private String mdn;
    private Date startDate;
    private Date endDate;
    private String userId;
}
