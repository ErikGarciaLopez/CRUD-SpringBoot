package academy.atl.customers.repository;

import academy.atl.customers.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository <Customer, Integer>{

    //Consulta en HQL
//    @Query("SELECT c FROM Customer c WHERE email LIKE %:email% or address LIKE %:address%")
//    List<Customer> findByEmailorAddress(@Param("email") String email, String address);
    @Query("SELECT c FROM Customer c WHERE firstname LIKE %:firstname% or lastname LIKE %:lastname% or email LIKE %:email% or address LIKE %:address% ")
    List<Customer> findByEmailorAddress(@Param("firstname") String firstname, String lastname, String email, String address);

}
