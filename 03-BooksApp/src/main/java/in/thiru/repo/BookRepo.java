package in.thiru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.thiru.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{

}
