package br.com.mercadopago.integrator.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mercadopago.integrator.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
	
    @Modifying
    @Transactional
    @Query("UPDATE Account a SET a.coinsTransferable = a.coinsTransferable + :amount WHERE a.id = :accountId")
    void addCoinsTransferable(Integer accountId, Integer amount);

	Optional<Account> findByName(String accountName);

}
