package com.hopscotch.tollticketingservice.repository;
import com.hopscotch.tollticketingservice.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingDetailRepository extends JpaRepository<BookingDetail,Long> {

    @Query("select bd from BookingDetail bd where bd.validTill > now() and bd.maxLimit > bd.usedNum AND bd.vehicleRegNum=:vehicleRegNum")
    Optional<List<BookingDetail>> checkValidPassByRegistrationNum(@Param("vehicleRegNum") String vehicleRegNum);

}
