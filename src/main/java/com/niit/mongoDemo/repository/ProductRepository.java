
package com.niit.mongoDemo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.niit.mongoDemo.domain.Product;
@Repository
public interface ProductRepository extends MongoRepository<Product,Integer>{
    List<Product> findByProductName(String productName);
    @Query("{'productDescription.material':{$in:[?0]}}")
    List<Product> findByMaterial(String material);

}