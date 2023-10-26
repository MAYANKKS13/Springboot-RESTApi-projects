package in.stackroute.accountrestapi.service;

import in.stackroute.accountrestapi.model.Accounts;
import in.stackroute.accountrestapi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository repository;

    @Override
    public Accounts add(Accounts account) {
        return repository.save(account);
    }

    @Override
    public List<Accounts> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(int id) {

        repository.deleteById(id);

    }


    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);

    }
}
