package cabra.dotacard.dao;

import cabra.dotacard.entity.References;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ReferencesMapper {
   int rdainit(@Param("references")References references);

   List<References> Searchbycid(@Param("cid")String cid);
}
