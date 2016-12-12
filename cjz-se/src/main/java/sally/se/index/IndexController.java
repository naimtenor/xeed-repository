package sally.se.index;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sally.se.SEException;

@RestController
public class IndexController {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	private IndexPostController indexPostController;

	@RequestMapping(value = "/index/tags", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int classificationTags(@RequestBody List<IndexRequest> requestList) {
		for (IndexRequest req : requestList) {
			LOGGER.debug(req.getId());
			LOGGER.debug(req.getFilePath());
			LOGGER.debug(req.getContents());
		}
		
		try {
			return indexPostController.classificationTags(requestList);
		} catch (SEException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
