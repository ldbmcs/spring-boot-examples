
package com.ldbmcs.elasticSearch.repository;

import com.ldbmcs.elasticSearch.model.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {
}
