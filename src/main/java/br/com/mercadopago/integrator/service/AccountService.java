package br.com.mercadopago.integrator.service;

import br.com.mercadopago.integrator.entity.Account;
import br.com.mercadopago.integrator.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class AccountService {

	@Autowired
    private AccountRepository accountRepository;
	@Autowired
	private PlayerPaymentService playerPaymentService;


    public Optional<Account> findById(Integer accountId) {
        return accountRepository.findById(accountId);
    }

    @Transactional
    public void addCoinsTransferable(String accountName, String idPayment, Double amount) {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Amount value must be greater than zero.");
        }

        Optional<Account> accountOpt = accountRepository.findByName(accountName);

        if (accountOpt.isPresent()) {
            accountRepository.addCoinsTransferable(accountOpt.get().getId(), amount.intValue());
            
            playerPaymentService.updatePaymentStatus(accountName, idPayment);
        } else {
            throw new IllegalArgumentException("Account ID " + accountName + " not found.");
        }
    }
}
