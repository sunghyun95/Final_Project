package books.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BooksDao extends SqlSessionDaoSupport implements BooksDaoInter{

	@Override
	public void insertBooks(BooksDto booksdto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertBooks",booksdto);
	}

	@Override
	public List<BooksDto> processBooks(int books_process_num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("processBooks", books_process_num);
	}

	@Override
	public void deleteBooks(int books_num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteBooks",books_num);
	}
}
