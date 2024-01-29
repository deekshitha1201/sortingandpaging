package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import com.example.Entity.Employee;
import com.example.Repository.EmployeeRepository;

@SpringBootApplication
public class SortingandpagingApplication implements CommandLineRunner {
	@Autowired
	private EmployeeRepository employeerepo;

	public static void main(String[] args) {
		SpringApplication.run(SortingandpagingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		employeerepo.save(new Employee(1,"deekshitha",30000));
		employeerepo.save(new Employee(2,"purnima",25000));
		employeerepo.save(new Employee(3,"lavanya",40000));
		employeerepo.save(new Employee(4,"adilaxmi",33000));
		employeerepo.save(new Employee(5,"rajyalaxmi",35000));
		int page;
		int size;
		PageRequest pageRequest=PageRequest.of(0, 3, Sort.by("id").ascending());
		Page<Employee>empdetails=employeerepo.findAll(pageRequest);
		System.out.println("paging and sorting the data:");
		empdetails.getContent().forEach(System.out::println);
		
	}

}
