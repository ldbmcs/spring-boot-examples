package com.ldbmcs.elasticSearch.Controller;

import com.ldbmcs.elasticSearch.model.Customer;
import com.ldbmcs.elasticSearch.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
//    @GetMapping("getGoodsList")
//    public List<Customer> getList(Integer pageNumber, String query) {
//        if (pageNumber == null) {
//            pageNumber = 0;
//        }
//        //es搜索默认第一页页码是0
//        SearchQuery searchQuery = getEntitySearchQuery(pageNumber, PAGESIZE, query);
//        Page<Customer> goodsPage = customerRepository.search(searchQuery);
//        return goodsPage.getContent();
//    }

//    private SearchQuery getEntitySearchQuery(int pageNumber, int pageSize, String searchContent) {
//        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
//                .add(QueryBuilders.matchPhraseQuery("name", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(100))
//                .add(QueryBuilders.matchPhraseQuery("description", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(100))
//                //设置权重分 求和模式
//                .scoreMode("sum")
//                //设置权重分最低分
//                .setMinScore(10);
//        // 设置分页
//        Pageable pageable = new PageRequest(pageNumber, pageSize);
//        return new NativeSearchQueryBuilder()
//                .withPageable(pageable)
//                .withQuery(functionScoreQueryBuilder).build();
//    }
}
