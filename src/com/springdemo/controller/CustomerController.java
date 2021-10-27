package com.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;
import com.springdemo.utils.SortingUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(@RequestParam(required = false, name = "sort") String sort, Model model) {
		List<Customer> customers = null;

		if (sort != null) {
			int theSortField = Integer.parseInt(sort);
			customers = customerService.getCustomers(theSortField);
		} else {
			customers = customerService.getCustomers(SortingUtils.LAST_NAME);
		}
//		for(Customer c:customers)
//			System.out.println(c);
		model.addAttribute("Customers", customers);
		return "customer-list";
	}
	
	@GetMapping("/searchCustomer")
	public String searchCustomer(@RequestParam(required = false, name = "searchName") String name, Model model) {
		List<Customer> customers =customerService.searchCustomer(name);
		model.addAttribute("Customers", customers);
		return "customer-list";
	}

	@GetMapping("/showAddCustomer")
	public String showAddCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@GetMapping("/showUpdateCustomer")
	public String updateCustomer(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
//		System.out.println(customer);
		model.addAttribute("customer", customer);
		return "update-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		if (result.hasErrors())
			if (customer.getId() != 0)
				return "update-form";
			else
				return "customer-form";
		else {
			System.out.println(customer);
			customerService.saveCustomer(customer);
			return "redirect:/customer/list";
		}
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {

		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}

}
