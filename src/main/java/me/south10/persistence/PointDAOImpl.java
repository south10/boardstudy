package me.south10.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by south10 on 2016-06-16.
 */
@Repository
public class PointDAOImpl implements PointDAO {
    @Inject
    SqlSession session;

    private static String namespace = "me.south10.mapper.PointMapper";

    public void updatePoint(String uid, int point) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("point", point);
        session.update(namespace + ".updatePoint", map);
    }
}
