package mo.izi.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import mo.izi.entities.Product;
@RepositoryRestResource
public interface ProductRepository extends MongoRepository<Product, String> {

	@RestResource(path = "findByKeyword")
	public Page<Product> findByDesignationIgnoreCaseContains(@Param("mc")String motCle,Pageable pageable);
}
