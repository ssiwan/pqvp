package com.qualapps.ka.data;
import java.util.Date;

public class ArticleData {
	
	private long artId;
	private String artTile;
	private String artContent;
	private String artStatus;
	private long artViews;
	private Date chngDate;
	private String chngType;
	private String chngUser;
	private int artRating;
	private long catId;
	private String artCreator;
	private Date artCreateTime;
	private String artTags;
	private String artAccess;

	public String getArtAccess() {
		return artAccess;
	}

	public void setArtAccess(String artAccess) {
		this.artAccess = artAccess;
	}

	public String getArtTags() {
		return artTags;
	}

	public void setArtTags(String artTags) {
		this.artTags = artTags;
	}

	public Date getArtCreateTime() {
		return artCreateTime;
	}

	public void setArtCreateTime(Date artCreateTime) {
		this.artCreateTime = artCreateTime;
	}

	public String getArtCreator() {
		return artCreator;
	}

	public void setArtCreator(String artCreator) {
		this.artCreator = artCreator;
	}

	public long getArtId() {
		return artId;
	}
	public void setArtId(long artId) {
		this.artId = artId;
	}
	public String getArtTile() {
		return artTile;
	}
	public void setArtTile(String artTile) {
		this.artTile = artTile;
	}
	public String getArtContent() {
		return artContent;
	}
	public void setArtContent(String artContent) {
		this.artContent = artContent;
	}
	public String getArtStatus() {
		return artStatus;
	}
	public void setArtStatus(String artStatus) {
		this.artStatus = artStatus;
	}
	public long getArtViews() {
		return artViews;
	}
	public void setArtViews(long artViews) {
		this.artViews = artViews;
	}
	public Date getChngDate() {
		return chngDate;
	}
	public void setChngDate(Date chngDate) {
		this.chngDate = chngDate;
	}
	public String getChngType() {
		return chngType;
	}
	public void setChngType(String chngType) {
		this.chngType = chngType;
	}
	public String getChngUser() {
		return chngUser;
	}
	public void setChngUser(String chngUser) {
		this.chngUser = chngUser;
	}
	public long getArtRating() {
		return artRating;
	}
	public void setArtRating(int artRating) {
		this.artRating = artRating;
	}
	public long getCatId() {
		return catId;
	}
	public void setCatId(long catId) {
		this.catId = catId;
	}

}
