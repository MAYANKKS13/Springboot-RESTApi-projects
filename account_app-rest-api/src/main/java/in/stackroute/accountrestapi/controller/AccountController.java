package in.stackroute.accountrestapi.controller;


import in.stackroute.accountrestapi.model.Accounts;
import in.stackroute.accountrestapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @PostMapping
    public ResponseEntity<Accounts> createAccount(@RequestBody Accounts account)
    {
        var accounts = accountService.add(account);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(accounts);
    }



    @GetMapping
    public ResponseEntity<List<Accounts>> getAccounts()
    {
        var accounts = accountService.findAll();
        if(accounts.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accounts);
    }


   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteAccount(@PathVariable int id)
   {
       if(!accountService.existsById(id))
       {
           return ResponseEntity.notFound().build();
       }

       accountService.deleteById(id);
       return ResponseEntity.noContent().build();
   }








}
