package mo.izi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import mo.izi.entities.Category;
@RepositoryRestResource
public interface CategoryRepository extends MongoRepository<Category, String>{
	@RestResource(path = "categoryByKeyword")
	public Category findByNameIgnoreCaseContains(@Param("mc")String name);
}
