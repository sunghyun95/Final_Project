package books.data;

public class BooksDto {
	private int books_num;
	private String books_name;
	private String books_brand;
	private String books_writer;
	private int books_process_num;
	
	public int getBooks_num() {
		return books_num;
	}
	public void setBooks_num(int books_num) {
		this.books_num = books_num;
	}
	public String getBooks_name() {
		return books_name;
	}
	public void setBooks_name(String books_name) {
		this.books_name = books_name;
	}
	public String getBooks_brand() {
		return books_brand;
	}
	public void setBooks_brand(String books_brand) {
		this.books_brand = books_brand;
	}
	public String getBooks_writer() {
		return books_writer;
	}
	public void setBooks_writer(String books_writer) {
		this.books_writer = books_writer;
	}
	public int getBooks_process_num() {
		return books_process_num;
	}
	public void setBooks_process_num(int books_process_num) {
		this.books_process_num = books_process_num;
	}
	
	@Override
	public String toString() {
		return "BooksDto [books_num=" + books_num + ", books_name=" + books_name + ", books_brand=" + books_brand
				+ ", books_writer=" + books_writer + ", books_process_num=" + books_process_num + "]";
	}
	
}
