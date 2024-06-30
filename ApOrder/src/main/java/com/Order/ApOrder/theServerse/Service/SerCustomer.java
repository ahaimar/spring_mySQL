package com.Order.ApOrder.theServerse.Service;

import com.Order.ApOrder.theModel.Entity.Customer;
import com.Order.ApOrder.theModel.theRepository.RepCustomer;
import com.Order.ApOrder.theServerse.Interface.CustomerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerCustomer implements CustomerInterface {

    @Autowired
    private RepCustomer repUser;

    @Override
    public Optional<Customer> login(String FerstName, String password, String email) {

        Customer cos = new Customer(FerstName, password, email);
        return Optional.of(repUser.save(cos));
    }
    @Override
    public Optional<Customer> getUserById(Long id) {

        return Optional.of(repUser.findById(id).get());
    }

    @Override
    public Optional<Customer> addUser(Customer user) {

        return  Optional.of(repUser.save(user));
    }
    @Override
    public Optional<List<Customer>> getAllUsers() {

        return Optional.of(repUser.findAll());
    }
    @Override
    public Optional<Customer> updateUser(Customer customer, Long id) {

        return repUser.findById(id).map(user -> {
            user.setFirstName(customer.getFirstName());
            user.setLastName(customer.getLastName());
            user.setAddress(customer.getAddress());
            user.setAge(customer.getAge());
            user.setPhone(customer.getPhone());
            user.setPassword(customer.getPassword());
            user.setEmail(customer.getEmail());
            return repUser.save(user);
        });
    }
    @Override
    public Optional<Customer> deleteCustomer(Long id) {

        return repUser.findById(id).map(user -> {
            repUser.deleteById(id);
            return user;
        });
    }

}
