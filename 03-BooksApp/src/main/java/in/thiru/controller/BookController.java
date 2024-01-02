package in.thiru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.thiru.entity.Book;
import in.thiru.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	
	@GetMapping("/book")
	public ModelAndView showAddForm()
	{
		
		System.out.println("showAddForm() :: method  ");
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("book",new Book());
		
		mav.setViewName("book");
		
		return mav;
	}
	
	@PostMapping("/book")
	public ModelAndView addBooks(Book book)
	{
		ModelAndView mav=new ModelAndView();
		
		System.out.println("addBooks() :: method");
		
		boolean saveBook = bookService.saveBook(book);
		
	
		System.out.println(book);
		
		if(saveBook)
		{
			mav.addObject("successMsg","Book Saved");
		}
		else
		{
			mav.addObject("errorMsg","Book record is failed to save");
		}
		
		
		mav.setViewName("book");
		
		
		return mav;
	}
	
	
	
	
	
	@GetMapping(value = "/books")
	public ModelAndView getBooks()
	{
		
		System.out.println("getBooks() :: method");
		List<Book> allBooks = bookService.getAllBooks();
		
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("books",allBooks);
		
		mav.setViewName("index");
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	

}
