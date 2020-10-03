package com.hopscotch.tollticketingservice.model;

import lombok.Data;

@Data
public abstract class AbstractResponse {
    private BaseResponse status;
}
