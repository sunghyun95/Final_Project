package books.data;

import java.util.List;

public interface BooksDaoInter {
	
	public void insertBooks(BooksDto booksdto);
	public List<BooksDto> processBooks(int books_process_num);
	public void deleteBooks(int books_num);
}
