package com.hopscotch.tollticketingservice.repository;
import com.hopscotch.tollticketingservice.entity.TollBoothDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TollBothDetailRepository extends JpaRepository<TollBoothDetail,Long> {
}
