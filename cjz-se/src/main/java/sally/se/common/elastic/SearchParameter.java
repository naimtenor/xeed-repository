package sally.se.common.elastic;

import org.elasticsearch.action.search.SearchType;

public class SearchParameter {

	private String[] indices;
	
	private String[] types;
	
	private SearchType searchType;
	
	private QueryParameter queryParameter;
	
	private QueryParameter filterParameter;

	public String[] getIndices() {
		return indices;
	}

	public void setIndices(String...indices) {
		this.indices = indices;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String...types) {
		this.types = types;
	}

	public SearchType getSearchType() {
		return searchType;
	}

	public void setSearchType(SearchType searchType) {
		this.searchType = searchType;
	}

	public QueryParameter getQueryParameter() {
		return queryParameter;
	}

	public void setQueryParameter(QueryParameter queryParameter) {
		this.queryParameter = queryParameter;
	}

	public QueryParameter getFilterParameter() {
		return filterParameter;
	}

	public void setFilterParameter(QueryParameter filterParameter) {
		this.filterParameter = filterParameter;
	}
}
