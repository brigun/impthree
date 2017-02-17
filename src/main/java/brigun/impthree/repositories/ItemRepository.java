package brigun.impthree.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import brigun.impthree.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findByCategory(String category);
	
	List<Item> findAll();

	Set<Item> findAllByVendor(Long vendorId);
	


}
