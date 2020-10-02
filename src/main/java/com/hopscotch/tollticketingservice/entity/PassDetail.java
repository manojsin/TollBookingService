package com.hopscotch.tollticketingservice.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@Entity
@Table(name = "pass_details")
public class PassDetail implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "pass_id")
    private Long passId;
    @Column(name = "toll_num")
    private Long tollNum;
    @Column(name = "pass_type")
    private String passType;
    @Column(name = "apply_On")
    private String applyOn;
    @Column(name = "pass_price")
    private Double passPrice;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "updated_on")
    private Date updatedOn;
}
