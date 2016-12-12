package sally.se.common.elastic;

public class QueryParameter {

	private QueryType queryType;
	
	private String fieldName;
	
	private Object[] parameters;
	
	public QueryParameter(QueryType queryType, String fieldName, Object...parameters) {
		this.queryType = queryType;
		this.fieldName = fieldName;
		this.parameters = parameters;
	}

	public QueryType getQueryType() {
		return queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object[] getParameters() {
		return parameters;
	}

	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}
}
