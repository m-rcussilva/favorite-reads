package app.netlify.marcussilva.favoritereads.services;

import app.netlify.marcussilva.favoritereads.mapper.FavoriteReadsMapper;
import app.netlify.marcussilva.favoritereads.models.FavoriteReads;
import org.springframework.stereotype.Service;

@Service
public class FavoriteReadsService {

    public FavoriteReadsMapper favoriteReadsMapper;

    public FavoriteReadsService(FavoriteReadsMapper favoriteReadsMapper) {
        this.favoriteReadsMapper = favoriteReadsMapper;
    }

    public int addBook(FavoriteReads favoriteReads) {
        return favoriteReadsMapper.insertBook(favoriteReads);
    }

    public FavoriteReads[] getBook() {
        FavoriteReads[] books = favoriteReadsMapper.selectBooks();

        return books;
    }
}
