package sally.se.common.elastic;

import java.net.InetAddress;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.DocWriteResponse.Result;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sally.se.MessageCode;
import sally.se.SEException;
import sally.se.common.config.ConfigurationManager;

@Component
public class ESTemplate implements InitializingBean {
	
	private final String ES_HOST_KEY = "es.host";
	
	private final String ES_PORT_KEY = "es.port";
	
	private final String ES_CLUSTER_KEY = "es.cluster";
	
	private final ObjectMapper OM = new ObjectMapper();
	
	private TransportClient client;
	
	@Autowired
	private ConfigurationManager configurationManager;

	public <T> int create(String index, String type, String id, T data) throws SEException {
		try {
			IndexResponse response = client.prepareIndex(index, type).setId(id).setSource(OM.writeValueAsString(data)).execute().get();
			return response.getResult() == Result.CREATED ? 1 : -1;
		} catch (JsonProcessingException e) {
			throw new SEException(MessageCode.ESE0001, e);
		} catch (InterruptedException e) {
			throw new SEException(MessageCode.ESE0002, e);
		} catch (ExecutionException e) {
			throw new SEException(MessageCode.ESE0003, e);
		}
	}
	

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.isTrue(configurationManager.isExist(ES_HOST_KEY), "Elasticsearch host was not configured.");
		Assert.isTrue(configurationManager.isExist(ES_PORT_KEY), "Elasticsearch port was not configured.");
		Assert.isTrue(configurationManager.isExist(ES_CLUSTER_KEY), "Elasticsearch cluster name was not configured.");
		
		// TODO : need more detail.
		Settings settings = Settings.builder().put("cluster.name", configurationManager.getString(ES_CLUSTER_KEY)).build();
		client = new PreBuiltTransportClient(settings)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(configurationManager.getString(ES_HOST_KEY)), configurationManager.getInt(ES_PORT_KEY)));

	}
	
}
