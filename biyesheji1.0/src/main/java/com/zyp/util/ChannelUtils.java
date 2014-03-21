package com.zyp.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.zyp.model.Channel;



public class ChannelUtils {

	
	/**
	 * 遍历部门树 并修改名称来表示层次
	 * @param topList
	 * @return
	 */
	
	public static List<Channel> getAllChannels(List<Channel> topList){
		List<Channel> list=new ArrayList<Channel>();
		
		
		walkChannelTrees(topList,"┣",list);
		
		
		return list;
		
	}

	private static void walkChannelTrees(Collection<Channel> topChannelList,
			String prefix, List<Channel> list) {
		
		for(Channel topChannel : topChannelList){
			// 顶点
			Channel copy = new Channel(); // 原对象是在Session中的对象，是持久化状态，所以要使用副本。
			copy.setId(topChannel.getId());
			copy.setName(prefix + topChannel.getName());
			list.add(copy);
			// 子树
			
			walkChannelTrees(topChannel.getChildrens(), "　　" + prefix, list); // 使用的是全角的空格
			
		}
		
	}
	
	
}
