package sally.se.index;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sally.se.SEException;
import sally.se.km.KeyMapHandler;
import sally.se.km.MappedKey;

@Service
public class IndexPostController {
	
	@Autowired
	private KeyMapHandler keyMapHandler;
	
	@Autowired
	private IndexDAO indexDAO;

	public int classificationByKeymap(List<IndexRequest> requestList) throws SEException {
		
		int count = 0;
		
		for (IndexRequest request : requestList) {
			MappedKey mk = keyMapHandler.mappingKeyMap(request.getContents().split(","));
			count += indexDAO.indexTag(request, mk);
		}
		
		return count;
	}
}
