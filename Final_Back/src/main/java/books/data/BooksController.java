package books.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BooksController {

	@Autowired
	private BooksServiceInter service;
	
	@PostMapping("/books/insert")
	public void insertBooks(@ModelAttribute BooksDto booksdto)
	{
		System.out.println("react >> booksInsert");
		System.out.println(booksdto);
		service.insertBooks(booksdto);
	}
}
