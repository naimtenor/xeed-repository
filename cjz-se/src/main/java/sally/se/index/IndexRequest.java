package sally.se.index;

public class IndexRequest {

	private String id;
	
	private String filePath;
	
	private String contents;
	
	private long timeSs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public long getTimeSs() {
		return timeSs;
	}

	public void setTimeSs(long timeSs) {
		this.timeSs = timeSs;
	}
	
}
