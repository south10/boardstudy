package me.south10.persistence;

import me.south10.domain.MemberVO;

/**
 * Created by south10 on 2016-05-31.
 */
public interface MemberDAO {
	public String getTime();

	public void insertMember(MemberVO vo);

	public MemberVO readMember(String userid) throws Exception;

	public MemberVO readWithPW(String userid, String userpw) throws Exception;
}
