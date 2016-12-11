package sally.se.index;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/index/tags")
public class IndexController {

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String classificationTags(@RequestBody List<IndexRequest> requestList) {
		for (IndexRequest req : requestList) {
			System.out.println(req.getFrameId());
			System.out.println(req.getDataString());
		}
		
		return "test";
	}
}
