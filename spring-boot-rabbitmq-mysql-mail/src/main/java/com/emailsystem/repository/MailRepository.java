package com.emailsystem.repository;

import com.emailsystem.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailRepository extends JpaRepository<Mail,Long> {

    List<Mail> findByReceiver(Long id);

    List<Mail> findBySender(Long id);

    List<Mail> findBySenderOrReceiver(Long senderId,Long recevierId);
}
