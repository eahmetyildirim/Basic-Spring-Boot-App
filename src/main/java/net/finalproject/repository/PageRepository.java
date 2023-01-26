package net.finalproject.repository;

import net.finalproject.models.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {

    @Query("SELECT p FROM Page p WHERE p.url = :url")
    public Page getPageForUrlPath(String url);

    @Query("SELECT p FROM Page p WHERE p.url LIKE :url% ")
    public List<Page> getPageListUrlPathLike(@Param("url")String url);

    @Query("SELECT p FROM Page p WHERE p.url =:url and p.category.url = :categoryUrl")
    public Page getPageByUrlAndCategoryUrl(@Param("url")String pageUrl,@Param("categoryUrl")String categoryUrl);

    @Query("SELECT p FROM Page p WHERE p.title LIKE %:searchKey% or p.description LIKE %:searchKey%")
    public List<Page> searchPage(@Param("searchKey")String searchKey);

}
