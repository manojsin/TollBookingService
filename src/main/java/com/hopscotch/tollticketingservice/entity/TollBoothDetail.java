package com.hopscotch.tollticketingservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "toll_booth_details")
public class TollBoothDetail {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "booth_num")
    private Long boothNum;
    @Column(name = "toll_num")
    private Long tollNum;
    @Column(name = "booth_name")
    private String boothName;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "update_on")
    private Date updateOn;
}
