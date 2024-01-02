package in.thiru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.thiru.entity.Mobile;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Integer>{

}
