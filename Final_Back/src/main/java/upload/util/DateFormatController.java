package upload.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DateFormatController {

	@GetMapping("/date/format")
	public Timestamp formatDate()
	{
		Date s = new Date();
		Timestamp time = (Timestamp)s;
		return time;
	}
	
}
