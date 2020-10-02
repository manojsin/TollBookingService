package com.hopscotch.tollticketingservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "toll_booth_details")
public class TollBoothDetail implements Serializable {
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
