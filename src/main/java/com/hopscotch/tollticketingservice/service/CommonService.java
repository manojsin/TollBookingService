package com.hopscotch.tollticketingservice.service;

import com.hopscotch.tollticketingservice.model.TotalCollectionResponse;

public interface CommonService {
    TotalCollectionResponse getTotalCollection(Long bootId, Long tollId);
}
