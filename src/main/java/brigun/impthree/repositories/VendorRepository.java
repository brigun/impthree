package brigun.impthree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import brigun.impthree.models.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
