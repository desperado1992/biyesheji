package com.zyp.service.impl;



import java.util.List;

import org.springframework.stereotype.Service;

import com.zyp.base.BaseDaoImpl;
import com.zyp.model.Forum;
import com.zyp.service.ForumService;


@Service
@SuppressWarnings("unchecked")
public class ForumServiceImpl extends BaseDaoImpl<Forum,Long> implements ForumService{

	
	
	
	
	
	@Override
	public void save(Forum entity) {
		
		getSession().save(entity);
		entity.setPosition(entity.getId().intValue());
		
	}

	@Override
	public List<Forum> findAll() {
		
		return getSession().createQuery("FROM Forum f ORDER BY f.position ASC").list();
	}

	public void moveDown(Long id) {
		  Forum forum=findById(id);
		   Forum other=(Forum) getSession().createQuery("FROM Forum f WHERE f.position>? ORDER BY f.position ASC")
				   .setParameter(0, forum.getPosition())
				   .setFirstResult(0)
				   .setMaxResults(1).uniqueResult();
		   
		   if(other==null){
			   return;
		   }
		   int temp=forum.getPosition();
		   forum.setPosition(other.getPosition());
		   other.setPosition(temp);
		
		
		
	}

	public void moveUp(Long id) {
       Forum forum=findById(id);
	   Forum other=(Forum) getSession().createQuery("FROM Forum f WHERE f.position<? ORDER BY f.position DESC")
			   .setParameter(0, forum.getPosition())
			   .setFirstResult(0)
			   .setMaxResults(1).uniqueResult();
	   
	   if(other==null){
		   return;
	   }
	   int temp=forum.getPosition();
	   forum.setPosition(other.getPosition());
	   other.setPosition(temp);
	}

	

}
