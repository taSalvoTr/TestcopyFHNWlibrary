package com.explosivepomegranate.rest.api.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //the actual controller that serves the HTML pages
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "login.html";
    }

    @GetMapping("/home")
    public String home() { return "Admin/book-search-admin.html"; }

    @GetMapping("/register")
    public String register() { return "register.html"; }

    @GetMapping("/myProfile")
    public String profile() { return "Admin/profile-admin.html"; }

    @GetMapping("/currentlyBorrowed")
    public String borrowed() { return "Admin/borrowed-books-overview.html"; }

    @GetMapping("/myBorrowedBooks")
    public String myBorrowed() { return "Admin/my-borrowed-books-overview.html"; }

    /**
     * @author: Clelia
     * when adding an ID as parameter the system adds a "folder"
     * this means when you want to access your file you need to add "../" in addition
     * to your url to the html file you want to display
     * */
    @GetMapping("/bookDetails/{id}")
    public String bookDetail(@PathVariable Long id) { return "../Admin/book-information-admin.html"; }

    @GetMapping("/createNewBook")
    public String createBook() { return "Admin/add-new-book.html"; }
}
