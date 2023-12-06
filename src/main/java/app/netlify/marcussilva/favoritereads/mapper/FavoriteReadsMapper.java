package app.netlify.marcussilva.favoritereads.mapper;

import app.netlify.marcussilva.favoritereads.models.FavoriteReads;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FavoriteReadsMapper {

    @Insert("INSERT INTO books (bookName, authorName, published) VALUES (#{bookName}, #{authorName}, #{published})")
    int insertBook(FavoriteReads favoriteReads);

    @Select("SELECT * FROM books")
    FavoriteReads[] selectBooks();
}
