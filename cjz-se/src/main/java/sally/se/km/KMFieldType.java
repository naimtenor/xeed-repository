package sally.se.km;

public enum KMFieldType {

	WHO("imagga_who_tag"),
	WHEN("imagga_when_tag"),
	WHERE("imagga_where_tag"),
	WHAT("imagga_what_tag"),
	WHY("imagga_why_tag"),
	HOW("imagga_how_tag");
	
	private String fieldName;
	
	private KMFieldType(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
}
