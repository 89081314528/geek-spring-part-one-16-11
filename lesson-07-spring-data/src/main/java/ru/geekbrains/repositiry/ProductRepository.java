package ru.geekbrains.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.geekbrains.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID>
//        , JpaSpecificationExecutor<Product>
{

//    List<Product> findAllByNameLike(String pattern);
//
//    @Query("select p " +
//            "from Product p " +
//            "where (p.name like :pattern or :pattern is null) and " +
//            " (p.price >= :minPrice or :minPrice is null)") // TODO
//    List<Product> findByFilter(@Param("pattern") String pattern,
//                               @Param("minPrice") BigDecimal minPrice,
//                               @Param("maxPrice") BigDecimal maxPrice);

//    void delete(long id);
}
