package peaksoft.springbootanddatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.springbootanddatajpa.entities.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    // Ichinde logika (methods tuzboibuz antkeni JpaRepo uje dayar relizasiasy bolgon methodor bar)



    // A egerde JpaReponun ichinde jok method kerek bolup kalsa anda ozubuz zapros jazabyz
    @Query("select p from Post p join p.user pu where pu.id =:userId")
    List<Post> getAllPostByUserId(@Param("userId") Long userId);

    Post searchPostByTitle(String word);
}
