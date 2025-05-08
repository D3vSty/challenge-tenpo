package com.stavaray.challenge_tenpo.repository;

import com.stavaray.challenge_tenpo.entity.CallRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRecordRepository extends JpaRepository<CallRecord,Long> {
}
