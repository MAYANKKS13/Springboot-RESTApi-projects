package in.stackroute.accountrestapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")

public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "a_id")
    private int accountsId;

    @Column(name = "a_name", nullable = false)
    private String name;

    @Column(name = "a_address", nullable = false)
    private String address;

    @Column(name = "a_type", nullable = false)
    private String accounttype;

    @Column(name = "a_status", nullable = false)
    private String status;


  public Accounts(String name, String address, String accounttype, String status)
  {
      this.name = name;
      this.address = address;
      this.accounttype = accounttype;
      this.status = status;
  }




}
