package net.finalproject.repository;

import net.finalproject.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("SELECT c FROM Category c WHERE c.url = :url")
    public Category findCategoryByUrl(@Param("url")String url);
}
