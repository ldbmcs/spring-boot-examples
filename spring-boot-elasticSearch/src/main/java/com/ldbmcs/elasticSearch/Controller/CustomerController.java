package com.ldbmcs.elasticSearch.Controller;

import com.ldbmcs.elasticSearch.model.Customer;
import com.ldbmcs.elasticSearch.repository.CustomerRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    //http://localhost:8080/save
    @PutMapping("save")
    public String save() {
        Customer customer = new Customer("用户名称" + System.currentTimeMillis(), "用户地址" + System.currentTimeMillis(), new Random().nextInt(100));
        customerRepository.save(customer);
        return "success";
    }

    //http://localhost:8080/delete
    @DeleteMapping("delete")
    public String delete(String id) {
        customerRepository.deleteById(id);
        return "success";
    }

    //http://localhost:8080/update
    @PostMapping("update")
    public String update(String id, String userName, String address, int age) {
        Customer customer = new Customer(id, userName, address, age);
        customerRepository.save(customer);
        return "success";
    }

    //http://localhost:8080/getOne
    @GetMapping("getOne")
    public Customer getOne(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    //每页数量
    private Integer PAGESIZE = 10;

    //http://localhost:8888/getGoodsList?query=商品
    //http://localhost:8888/getGoodsList?query=商品&pageNumber=1
    //根据关键字"商品"去查询列表，name或者description包含的都查询
    @GetMapping("getList")
    public List<Customer> getList(Integer pageNumber, String keyword) {
        if (pageNumber == null) {
            pageNumber = 0;
        }
        QueryBuilder customerQuery = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("address", keyword));
        // 构建分页对象
        Pageable pageable = PageRequest.of(pageNumber, PAGESIZE);
        Page<Customer> spuDocPage = customerRepository.search(customerQuery, pageable);
        return spuDocPage.getContent();
    }
}
