package academy.atl.customers.services;

import academy.atl.customers.entities.Customer;
import academy.atl.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer getCustomer(Integer id) {
        Optional<Customer> customer = repository.findById(id);
        return customer.orElse(null);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        Iterable<Customer> customers = repository.findAll();
        for(Customer customer:customers){
            list.add(customer);
        }
        return list;
    }

    public void removeCustomer(Integer id) {
        repository.deleteById(id);
    }

    public void addCustomer(Customer customer) {
        repository.save(customer);
    }

    public void updateCustomer(Integer id, Customer updateCustomer) {
        updateCustomer.setId(id);
        repository.save(updateCustomer);
    }

    public List<Customer> searchCustomer(String firstname, String lastname, String email, String address) {
        return repository.findByEmailorAddress(firstname, lastname, email, address);
    }
}
