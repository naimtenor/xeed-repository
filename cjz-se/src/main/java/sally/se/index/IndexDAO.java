package sally.se.index;

import java.io.File;
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

	public int indexTag(IndexRequest request, MappedKey mk) throws SEException {
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
		data.put("fr_tag", request.getFrContents());
		data.put("", "");
		
		if (request.getFilePath() != null && !"".equals(request.getFilePath().trim())) {
			
			data.put("image_file_name", request.getFilePath().substring(request.getFilePath().indexOf(File.separator) + 1));
			data.put("image_file_path", request.getFilePath().substring(0, request.getFilePath().lastIndexOf(File.separator)));
		}		
		
		return esTemplate.create(INDEX_NAME, TYPE_NAME, request.getId(), data);
	}
}
