package sally.se.km.data;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KeyMapper {

	@Select("SELECT CATEGORY FROM KEYMAP WHERE WORD = #{word}")
	int getCategoryByWord(@Param("word") String word);
	
}
