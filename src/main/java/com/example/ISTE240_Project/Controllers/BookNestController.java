package com.example.ISTE240_Project.Controllers;

import com.example.ISTE240_Project.Models.*;
import com.example.ISTE240_Project.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Controller
public class BookNestController {

    //INJECTING THE 'nobelService' TO ACCESS WINNERS DATA
    private final NobelService nobelService;

    @Autowired
    private final BookService bookService;

    @Autowired
    private final QuoteService quoteService;

    @Autowired
    private UserService userService;

    @Autowired
    private final FunFactService funFactService;

    @Autowired
    private AlreadyReadService alreadyReadService;

    @Autowired
    private WantToReadService wantToReadService;

    @Autowired
    private CurrentlyReadingService currentlyReadingService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private final NewsletterService newsletterService;


    public BookNestController(BookService bookService, QuoteService quoteService, FunFactService funFactService, NobelService nobelService, NewsletterService newsletterService, AlreadyReadService alreadyReadService, CurrentlyReadingService currentlyReadingService, WantToReadService wantToReadService, UserService userService, AuthorService authorService) {
        this.bookService = bookService;
        this.quoteService = quoteService;
        this.funFactService = funFactService;
        this.nobelService=nobelService;
        this.newsletterService=newsletterService;
        this.alreadyReadService = alreadyReadService;
        this.currentlyReadingService=currentlyReadingService;
        this.wantToReadService=wantToReadService;
        this.userService=userService;
        this.authorService=authorService;
    }

    /* Handles requests to Login/SignUp page */
    @GetMapping("/joinbooknest")
    public String joinBookNest(Model model) {
        model.addAttribute("status",false); /* LoggedIn is set to false initially */
        return "Login_Signup";
    }

    /* Handles account creation in Login/SignUp page. Is attached to Sign Up button */ 
    @PostMapping("/joinbooknest/signup")
    public String signup(User user, Model model, @RequestParam("profilepicture") MultipartFile profilePicture) throws IOException {
        if (userService.findUserByEmail(user.getEmail()) != null) {
            model.addAttribute("status",false); /* If account with email exists, set LoggedIn to false and dont create the account */ 
            return "Login_Signup";
        }
        else { /* Otherwise, create the account successfully. */
            user.setImage(profilePicture.getBytes());   /* Profile picture is provided intially as a MultipartFile from the html form. So transform it to bytes and add it to the user */
            userService.addUser(user); 
            return "redirect:/home/" + user.getEmail(); /* After account creation, redirect to home page */
        }
    }

    /* Handles account login in Login/SignUp page. Is attached to Login button */
    @PostMapping("/joinbooknest/login")
    public String login( @RequestParam String password, @RequestParam String email, Model model){
        var user = userService.findUserByEmail(email);
        if (password.equals(user.getPassword())){ /* Checks database to see if the provided password is the same as the stored one */
            return "redirect:/home/" + email; /* If it is, redirect to home */
        }
        else{
            model.addAttribute("status", false); /* If not, set LoggedIn to false and reload the page */
            return "Login_Signup";
        }
    }

    /* Handles requests to home page */ 
    @GetMapping("/home/{email}")
    public String getHome(Model model, @PathVariable String email) {
        // Fetch upcoming releases
        var upcomingReleases = bookService.getUpcomingReleases();

        for (var book : upcomingReleases) {
            book.setThumbnailUrl("/images/coming-soon.png");
        }
        model.addAttribute("email",email);
        model.addAttribute("status",false);
        model.addAttribute("newReleases", bookService.getNewReleases());
        model.addAttribute("twentiethCentury", bookService.getTwentiethCenturyBooks());
        model.addAttribute("thrillers", bookService.getByGenre("Thriller"));
        model.addAttribute("memoirs", bookService.getMemoirs());
        model.addAttribute("upcoming", upcomingReleases);
        model.addAttribute("allBooks", bookService.getAllBooks());
        model.addAttribute("quote", quoteService.getRandomQuote());
        model.addAttribute("funFact", funFactService.getRandomFunFact());
        return "home";
    }

    /* Handles newsletter subscription */
    @PostMapping("/subscribe/{email}")
    public String subscribe(@PathVariable String email, @RequestParam String newsletteremail, Model model, RedirectAttributes redirectAttributes) {
        boolean alreadySubscribed = newsletterService.existsByEmail(newsletteremail);

        if (alreadySubscribed) {
            redirectAttributes.addFlashAttribute("subscribed", false);
            redirectAttributes.addFlashAttribute("subscribeFailed", true);
        } else {
            newsletterService.save(newsletteremail);
            redirectAttributes.addFlashAttribute("subscribed", true);
        }

        return "redirect:/home/" + email;
    }

    /* Displays book-details page when clicking on a book in the home page */
    @GetMapping("/book/{email}/{id}")
    public String getBookDetails(@PathVariable String email, @PathVariable int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("email",email);
        if (book == null) {
            return "redirect:/home/"+email;
        }

        model.addAttribute("book", book);
        model.addAttribute("isbn", book.getIsbn());
        return "book-details";
    }

    /* Handles requests to discover page */
    @GetMapping("/Discover/{email}")
    public String getSearch(@PathVariable String email, Model model) {
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("displayedBooks", allBooks);
        model.addAttribute("email",email);
        return "Discover";
    }

    /* Handles requests to a certain genre on the discover page */
    @GetMapping("/Discover/{email}/{genre}")
    public String getBooksByGenre(@PathVariable String email, @PathVariable("genre") String genre, Model model) {
        List<Book> books = bookService.getByGenre(genre);
        model.addAttribute("displayedBooks", books);
        model.addAttribute("genre", genre);
        model.addAttribute("email",email);
        return "Discover";
    }

    /* Handles requests to profile page */
    @GetMapping("/profile/{email}")
    public String getProfile(Model model, @PathVariable String email){
        var user = userService.findUserByEmail(email);
        List<AlreadyRead> readBooks = alreadyReadService.findBooksByEmail(email);
        List<WantToRead> toReadBooks = wantToReadService.findBooksByEmail(email);
        List<CurrentlyReading> currentlyReading = currentlyReadingService.findBooksByEmail(email);
        List<AlreadyRead> reviews = alreadyReadService.findReviewsByEmail(email);
        List<AlreadyRead> favoritebooks = alreadyReadService.getAllBooksSortedByRating(email);
        model.addAttribute("displayname",user.getDisplayName());
        model.addAttribute("bio",user.getBio());
        model.addAttribute("alreadyread",readBooks);
        model.addAttribute("wanttoread",toReadBooks);
        model.addAttribute("currentbooks",currentlyReading);
        model.addAttribute("reviews",reviews);
        model.addAttribute("username",user.getUsername());
        model.addAttribute("numberofbooksread",readBooks.size());
        model.addAttribute("favoritebooks",favoritebooks);
        model.addAttribute("avgrating",alreadyReadService.getUserAverageRating(email));
        model.addAttribute("pagesread",alreadyReadService.getUserPagesRead(email));
        model.addAttribute("romancecount",alreadyReadService.getUserFavouriteGenre(email));
        if (user.getImage() != null && user.getImage().length > 0) { /* Checks if the image bytes is not null and the file isnt empty */
            String profilepic = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(user.getImage()); 
            /* Gets image bytes and transforms it into a base64Image string that can be embedded in the page, combined with a 
                Data URI prefix that informs the browsers its an jpeg image that is base64 encoded */
            model.addAttribute("image", profilepic);
        }
        else{
            model.addAttribute("image",null);
        }
        return "profile";
    }

    @GetMapping("/nobel/{email}") //MAPPING FOR THE NOBEL PRIZE PAGE
    public String getNobelPage(@PathVariable String email, Model model) {

        model.addAttribute("email",email);
        List<NobelFunFact> funFacts = Arrays.asList(
                new NobelFunFact("Youngest Literature Winner", "Rudyard Kipling (42 years old, 1907)"),
                new NobelFunFact("Most Nominated Author", "Graham Greene (20+ nominations, but never won)"),
                new NobelFunFact("Only Songwriter to Win", "Bob Dylan (2016) – The first musician awarded the prize, for his poetic lyrics"),
                new NobelFunFact("A Winner Who Refused the Prize", "Jean-Paul Sartre (1964) – The French philosopher and writer declined the award, saying a writer should not accept official honors"),
                new NobelFunFact("A Winner Who Didn’t Know She Won", "Doris Lessing (2007) – She found out about her win from journalists waiting outside her house and responded with, \"Oh Christ!\"")
        );
        model.addAttribute("funFacts", funFacts);

        List<NotableSpeech> speeches = Arrays.asList(
                new NotableSpeech("William Faulkner", 1950, "https://www.nobelprize.org/prizes/literature/1949/faulkner/speech/"),
                new NotableSpeech("Toni Morrison", 1993, "https://www.nobelprize.org/prizes/literature/1993/morrison/speech/"),
                new NotableSpeech("Ernest Hemingway", 1954, "https://www.nobelprize.org/prizes/literature/1954/hemingway/speech/"),
                new NotableSpeech("Bob Dylan", 2016, "https://www.nobelprize.org/prizes/literature/2016/dylan/speech/")
        );
        model.addAttribute("speeches", speeches);

        //ADDING WINNERS DATA FROM THE SERVICE TO THE MODEL
        List<NobelPrize> winners = nobelService.getAllWinners();
        model.addAttribute("winners", winners);

        return "nobel"; // RETURNING THE MUSTACHE TEMPLATE
    }


    @GetMapping("/authors/{email}/{name}")
    public String getAuthorPage(@PathVariable String email, @PathVariable String name, Model model) {
        Author author = authorService.getAuthorByName(name);
        model.addAttribute("author", author);
        model.addAttribute("email",email);
        return "authors";
    }


    /* Attached to WantToRead button on discover page, adds book to the database through its id */
    @PostMapping("/{email}/{id}/ToRead")
    public void toReadBook(@PathVariable String email,@PathVariable int id){
        Book addedbook = bookService.getBookById(id);
        wantToReadService.addBook(addedbook, email);
    }


    /* Attached to CurrentlyReading form on discover page, adds book to the database */
    @PostMapping("/{email}/{id}/CurrentlyReading")
    public String currentlyReadBook(@RequestParam int pagesRead, @RequestParam LocalDate startDate, @PathVariable String email, @PathVariable int id) {
        Book addedbook = bookService.getBookById(id);
        currentlyReadingService.addBook(addedbook, email, pagesRead,startDate);
        return "redirect:/Discover/" +email;

    }

    /* Attached to update button on profile page, updates the pages read in currently reading database */
    @PostMapping("/{email}/{id}/UpdateCurrentlyReading")
    public String updateCurrentlyReading(@PathVariable String email,@PathVariable int id,@RequestParam int pagesRead){
        currentlyReadingService.updateBook(id,pagesRead);
        return "redirect:/profile/" + email;
    }

     /* Attached to AlreadyRead form on discover page, adds book to the database */
    @PostMapping("/{email}/{id}/AlreadyRead")
    public String alreadyReadBook(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate, @RequestParam String review, @RequestParam int rating, @PathVariable String email,@PathVariable int id){
        Book addedbook = bookService.getBookById(id);
        alreadyReadService.addBook(addedbook, email, startDate, endDate, review, rating);
        return "redirect:/Discover/" +email;

    }

}
