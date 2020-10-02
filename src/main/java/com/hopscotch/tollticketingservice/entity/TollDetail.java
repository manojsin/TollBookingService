package com.hopscotch.tollticketingservice.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Data
@NoArgsConstructor
@Entity
@Table(name = "toll_details")
public class TollDetail implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "toll_num")
    private Long tollNum;
    @Column(name = "toll_name")
    private String tollName;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "update_on")
    private Date updateOn;
    @OneToMany(targetEntity = PassDetail.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "toll_num")
    private Set<PassDetail> passDetails;
    @OneToMany(targetEntity = TollBoothDetail.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "toll_num")
    private Set<TollBoothDetail> tollBoothDetails;
}
