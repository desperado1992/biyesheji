package com.zyp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;





@Entity
@Table(name="channel",schema="")
@DynamicInsert(true)
@DynamicUpdate(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)  
public class Channel  implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3677304422933775644L;
	@Id
	@GeneratedValue
	private Long id;
	

    public Long getId()
	{
		return id;
	}



	public void setId(Long id)
	{
		this.id = id;
	}
	@Column(length=20)
	private String name;//栏目名称
	@Column(length=50)
    private String link_url;//栏目URL
    @Enumerated(EnumType.ORDINAL)
    private Position position; //private int is_navtop;//设置是否为顶部导航 1为顶部导航 0为非顶部导航7-8
    @Column(length=2)
    private int is_newWindow;//是否新窗口打开 0为默认不是 1表示是
    @Column(length=2)
    private int is_index;//是否是主页栏目 0为默认不是 1表示是，是主页栏目 每次更新都要重新生成缓存 如memcache 或者ecache 或者freemaker 1-2
    @Column(length=2)
    private int is_link;//栏目连接 0为本站的内部。1为外部连接 3-4
    @Column(length=2)
    private int is_recommend;//是否为推荐 0为不推荐 1为推荐 5-6
    @Column(length=2)
    private int is_stop;// 0为启用  1为不启用 是否停用 9-10
    
    @Enumerated(EnumType.ORDINAL)
    private ChannelType channelType;// private int type;//栏目类型 0为导航类型 1为图片类型 2为视频类型 3为内容类型11-14
    
   
    @ManyToOne
	@JoinColumn(name="pid")
    private Channel parent;//父类ID
    @OneToMany(targetEntity=Channel.class,fetch=FetchType.EAGER,mappedBy="parent")
    private List<Channel> childrens=new ArrayList<Channel>();
    
    
    @OneToMany
    private List<Category> categorys=new ArrayList<Category>();//分类通过对应外表查询
    @Column(length=2)
    private int orders;//栏目排系
    
    @ManyToOne
    @JoinColumn(name="articleId")
    private ChannelArticle article;//文章栏目 其中type 以及 Article对应

    
	public Channel()
	{
	
	}

	

	public List<Category> getCategorys()
	{
		return categorys;
	}



	public void setCategorys(List<Category> categorys)
	{
		this.categorys = categorys;
	}



	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	

	public int getIs_newWindow() {
		return is_newWindow;
	}



	public void setIs_newWindow(int is_newWindow) {
		this.is_newWindow = is_newWindow;
	}



	public String getLink_url()
	{
		return link_url;
	}

	public void setLink_url(String link_url)
	{
		this.link_url = link_url;
	}

	public int getIs_index()
	{
		return is_index;
	}

	public void setIs_index(int is_index)
	{
		this.is_index = is_index;
	}

	public int getIs_link()
	{
		return is_link;
	}

	public void setIs_link(int is_link)
	{
		this.is_link = is_link;
	}

	public int getIs_recommend()
	{
		return is_recommend;
	}

	public void setIs_recommend(int is_recommend)
	{
		this.is_recommend = is_recommend;
	}

	

	public int getIs_stop()
	{
		return is_stop;
	}

	public void setIs_stop(int is_stop)
	{
		this.is_stop = is_stop;
	}

	

	
	
	

	public ChannelType getChannelType() {
		return channelType;
	}



	public void setChannelType(ChannelType channelType) {
		this.channelType = channelType;
	}



	public Position getPosition() {
		return position;
	}



	public void setPosition(Position position) {
		this.position = position;
	}



	public Channel getParent()
	{
		return parent;
	}



	public void setParent(Channel parent)
	{
		this.parent = parent;
	}



	public List<Channel> getChildrens()
	{
		return childrens;
	}



	public void setChildrens(List<Channel> childrens)
	{
		this.childrens = childrens;
	}



	public int getOrders()
	{
		return orders;
	}

	public void setOrders(int orders)
	{
		this.orders = orders;
	}



	public ChannelArticle getArticle() {
		return article;
	}



	public void setArticle(ChannelArticle article) {
		this.article = article;
	}

	
	
    
	
}
