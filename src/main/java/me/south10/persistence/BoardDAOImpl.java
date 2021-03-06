package me.south10.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import me.south10.domain.BoardVO;
import me.south10.domain.Criteria;
import me.south10.domain.SearchCriteria;

/**
 * Created by south10 on 2016-06-13.
 */
@Repository
public class BoardDAOImpl implements BoardDAO{
    @Inject
    private SqlSession session;

    private static String namespace = "me.south10.mapper.BoardMapper";

    @Override
    public void create(BoardVO vo) throws Exception {
        session.insert(namespace + ".create", vo);
    }

    @Override
    public BoardVO read(Integer bno) throws Exception {
        return session.selectOne(namespace + ".read", bno);
    }

    @Override
    public void update(BoardVO vo) throws Exception {
        session.update(namespace + ".update", vo);
    }

    @Override
    public void delete(Integer bno) throws Exception {
        session.delete(namespace + ".delete", bno);
    }

    @Override
    public List<BoardVO> listAll() throws Exception {
        return session.selectList(namespace + ".listAll");
    }

    public List<BoardVO> listPage(int page) throws Exception {
        if(page <=0){
            page = 1;
        }
        page = (page - 1) * 10;
        return session.selectList(namespace + ".listPage", page);
    }

    @Override
    public List<BoardVO> listCriteria(Criteria cri) throws Exception {
        return session.selectList(namespace + ".listCriteria", cri);
    }

    @Override
    public int countPaging(Criteria cri) throws Exception {
        return session.selectOne(namespace + ".countPaging", cri);
    }

    @Override
    public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
        return session.selectList(namespace + ".listSearch", cri);
    }

    @Override
    public int listSearchCount(SearchCriteria cri) throws Exception {
        return session.selectOne(namespace + ".listSearchCount", cri);
    }

    @Override
    public void updateReplyCnt(Integer bno, int amount) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("bno", bno);
        map.put("amount", amount);
        session.update(namespace + ".updateReplyCnt", map);
    }

    @Override
    public void updateViewCnt(Integer bno) throws Exception {
        session.update(namespace + ".updateViewCnt", bno);
    }
}
