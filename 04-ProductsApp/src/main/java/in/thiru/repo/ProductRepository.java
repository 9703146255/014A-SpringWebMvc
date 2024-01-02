package in.thiru.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.thiru.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
