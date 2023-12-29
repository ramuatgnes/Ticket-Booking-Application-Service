package com.ticketbooking.repository;
import com.ticketbooking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    public Account findByEmail(String email);

    public Account findByVerificationCode(String Otp);

    Account findByEmailAndPassword(String email, String password);

    Account findByResetToken(String resetToken);
}
