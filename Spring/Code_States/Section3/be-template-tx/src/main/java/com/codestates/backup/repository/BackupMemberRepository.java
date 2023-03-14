package com.codestates.backup.repository;

import com.codestates.backup.entity.BackupMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackupMemberRepository extends JpaRepository<BackupMember, Long> {
}
