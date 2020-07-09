package books.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService implements BooksServiceInter{

	@Autowired
	private BooksDaoInter dao;
	@Override
	public void insertBooks(BooksDto booksdto) {
		// TODO Auto-generated method stub
		dao.insertBooks(booksdto);
	}
	@Override
	public List<BooksDto> processBooks(int books_process_num) {
		// TODO Auto-generated method stub
		return dao.processBooks(books_process_num);
	}
	@Override
	public void deleteBooks(int books_num) {
		// TODO Auto-generated method stub
		dao.deleteBooks(books_num);
	}
}
