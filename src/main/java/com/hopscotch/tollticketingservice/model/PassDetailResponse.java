package com.hopscotch.tollticketingservice.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hopscotch.tollticketingservice.entity.PassDetail;
import com.hopscotch.tollticketingservice.entity.TollBoothDetail;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassDetailResponse extends AbstractResponse{
    private Long tollId;
    private String tollName;
    private List<PassData> passDetail;
    private List<BoothData> boothDetail;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class PassData{
        private String passType;
        private double price;
    }
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class BoothData{
        private String boothName;
        private Long boothId;
    }
    public PassDetailResponse(String tollName, Set<PassDetail> passDetail, Long tollId,Set<TollBoothDetail> tollBoothDetails) {
        this.passDetail=convert(passDetail);
        this.tollName=tollName;
        this.tollId=tollId;
        this.boothDetail=getBothDetails(tollBoothDetails);
    }
    private  List<PassData> convert(Set<PassDetail> passDetail) {
        List<PassData> passDetails=new ArrayList<>();
        for(PassDetail detail:passDetail) {
            PassData data=new PassData();
            data.setPassType(detail.getPassType());
            data.setPrice(detail.getPassPrice());
            passDetails.add(data);
        }
        return passDetails;
    }
    private  List<BoothData> getBothDetails(Set<TollBoothDetail> boothDetails) {
        List<BoothData> passDetails=new ArrayList<>();
        for(TollBoothDetail detail:boothDetails) {
            BoothData data=new BoothData();
            data.setBoothName(detail.getBoothName());
            data.setBoothId(detail.getBoothNum());
            passDetails.add(data);
        }
        return passDetails;
    }
}

