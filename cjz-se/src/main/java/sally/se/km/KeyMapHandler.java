package sally.se.km;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sally.se.km.data.KeyMapper;

@Component
public class KeyMapHandler implements InitializingBean {
	
	@Autowired
	private KeyMapper keyMapper;
	
	public MappedKey mappingKeyMap(String...words) {
		MappedKey mappedKey = new MappedKey();
		
		for (String word : words) {
			int result = keyMapper.getCategoryByWord(word);
			switch (result) {
			case 1:
				mappedKey.setWhoKeys(mappedKey.getWhoKeys().equals("") ? word : "," + word);
				break;
			case 2:
				mappedKey.setWhenKeys(mappedKey.getWhenKeys().equals("") ? word : "," + word);
				break;
			case 3:
				mappedKey.setWhereKeys(mappedKey.getWhereKeys().equals("") ? word : "," + word);
				break;
			case 4:
				mappedKey.setWhatKeys(mappedKey.getWhatKeys().equals("") ? word : "," + word);
				break;
			case 5:
				mappedKey.setHowKeys(mappedKey.getHowKeys().equals("") ? word : "," + word);
				break;
			case 6:
				mappedKey.setWhyKeys(mappedKey.getWhyKeys().equals("") ? word : "," + word);
				break;
			default:
				break;
			}
		}
		
		return mappedKey;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO : 최초 가져올 키맵 셋을 정의 
	}

}
