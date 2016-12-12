package sally.se.index;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sally.se.SEException;
import sally.se.common.elastic.ESTemplate;
import sally.se.km.MappedKey;

@Repository
public class IndexDAO {
	
	private static final String INDEX_NAME = "index_all_sprint1";
	
	private static final String TYPE_NAME = "TYPE";
	
	@Autowired
	private ESTemplate esTemplate;

	public int classificationTags(IndexRequest request, MappedKey mk) throws SEException {
		// TODO : 바꿀 필요 있음
		Map<String, Object> data = new HashMap<>();
		data.put("id", request.getId());
		data.put("time_ss", request.getTimeSs());
		data.put("imagga_who_tag", mk.getWhoKeys());
		data.put("imagga_when_tag", mk.getWhenKeys());
		data.put("imagga_where_tag", mk.getWhereKeys());
		data.put("imagga_what_tag", mk.getWhatKeys());
		data.put("imagga_why_tag", mk.getWhyKeys());
		data.put("imagga_how_tag", mk.getHowKeys());
		
		return esTemplate.create(INDEX_NAME, TYPE_NAME, request.getId(), data);
	}
}
