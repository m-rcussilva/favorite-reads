package app.netlify.marcussilva.favoritereads.controllers;

import app.netlify.marcussilva.favoritereads.models.FavoriteReads;
import app.netlify.marcussilva.favoritereads.services.FavoriteReadsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FavoriteReadsController {

    private FavoriteReadsService favoriteReadsService;

    public FavoriteReadsController(FavoriteReadsService favoriteReadsService) {
        this.favoriteReadsService = favoriteReadsService;
    }

    @PostMapping("/books")
    public String addBook(Model model, FavoriteReads favoriteReads) {

        if (favoriteReads.getBookName() == null || favoriteReads.getBookName().trim().isEmpty()) {
            model.addAttribute("errorMessage", String.format("The field Book name cannot be empty.", favoriteReads.getBookName()));
        } else if (favoriteReadsService.addBook(favoriteReads) < 1) {
            model.addAttribute("errorMessage", String.format("Could not add %s", favoriteReads.getBookName()));
        } else {
            model.addAttribute("successMessage", String.format("The book " + favoriteReads.getBookName() + " was successfully added."));
        }

        FavoriteReads[] books = favoriteReadsService.getBook();
        model.addAttribute("books", books);

        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getBooks(Model model, FavoriteReads favoriteReads) {
        model.addAttribute("title", "Favorite Reads ⭐️");

        FavoriteReads[] books = favoriteReadsService.getBook();
        model.addAttribute("books", books);

        return "home";
    }
}
