
package com.ldbmcs.elasticSearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "customer", type = "customer", shards = 1, replicas = 0, refreshInterval = "-1")
@Data
public class Customer {

    //Id注解加上后，在Elasticsearch里相应于该列就是主键了，在查询时就可以直接用主键查询
    @Id
    private String id;

    private String userName;

    private String address;

    private int age;

    public Customer() {
    }

    public Customer(String userName, String address, int age) {
        this.userName = userName;
        this.address = address;
        this.age = age;
    }

    public Customer(String id, String userName, String address, int age) {
        this.id = id;
        this.userName = userName;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
