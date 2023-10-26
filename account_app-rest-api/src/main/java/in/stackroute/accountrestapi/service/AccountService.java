package in.stackroute.accountrestapi.service;

import in.stackroute.accountrestapi.model.Accounts;

import java.util.List;

public interface AccountService {


      Accounts add(Accounts account);

      List<Accounts> findAll();

      void deleteById(int id);

      boolean existsById(int id);






}
