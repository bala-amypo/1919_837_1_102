public interface WarrantyRepository extends JpaRepository<Warranty, Long> {
    
    List<Warranty> findByUserId(Long userId);
}