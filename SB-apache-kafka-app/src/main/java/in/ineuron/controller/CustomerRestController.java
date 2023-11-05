package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Customer;
import in.ineuron.service.CustomerService;

/**
 * This class is used to handle user requests
 * 
 * @author Nitin
 *
 */
@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	/**
	 * This method is used to Customer records in post request
	 * 
	 * @param customers
	 * @return
	 */
	@PostMapping(value = "/addCustomer")
	public String addCustomer(@RequestBody Customer customer) {
		System.out.println("CustomerRestController.addCustomer() >> "+customer);
		return customerService.add(customer);
	}
}
