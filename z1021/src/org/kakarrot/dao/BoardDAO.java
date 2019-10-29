package org.kakarrot.dao;

import org.kakarrot.domain.BoardVO;
import org.kakarrot.domain.FileUploadVO;


public interface BoardDAO extends CrudDAO<BoardVO, Long>{

	public int getCount();
	public int getnextval();
	public boolean insertfile(FileUploadVO fvo);
	public boolean updateViewCnt(Long bno);
	
	
}
