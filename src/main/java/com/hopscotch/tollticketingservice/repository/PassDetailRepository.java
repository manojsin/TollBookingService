package com.hopscotch.tollticketingservice.repository;
import com.hopscotch.tollticketingservice.entity.PassDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PassDetailRepository extends JpaRepository<PassDetail,Long> {
}
