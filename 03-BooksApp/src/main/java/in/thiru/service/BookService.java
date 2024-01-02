package in.thiru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.thiru.entity.Book;
import in.thiru.repo.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	public List<Book> getAllBooks()
	{
		return bookRepo.findAll();
	}
	
	public boolean saveBook(Book bookObj)
	{
		Book book = bookRepo.save(bookObj);
		
		if(book.getBookId() != null)
		{
			return true;
		}
		
		return false;
		
	}

}
