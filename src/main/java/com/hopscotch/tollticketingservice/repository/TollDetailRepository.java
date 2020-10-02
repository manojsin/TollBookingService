package com.hopscotch.tollticketingservice.repository;
import com.hopscotch.tollticketingservice.entity.TollDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface TollDetailRepository extends JpaRepository<TollDetail,Long> {

    Optional<TollDetail> findByTollNum(Long tollNum);
}
