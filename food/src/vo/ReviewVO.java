package vo;

import java.util.Date;

public class ReviewVO {
	int rid;		//    rid NUMBER CONSTRAINT review_pk PRIMARY key,
	String userid;	//    userid varchar2(30),
	int fid;		//    fid number,
	String image;	//    image VARCHAR2(30),
	String text;	//    text VARCHAR2(100),
	String eval;	//    eval VARCHAR2(30) DEFAULT 'normal' check(eval in('good','normal','bad')),
	Date date;	//    pubdate DATE
	
	
	public ReviewVO() {
		super();
	}
	
	public ReviewVO(int rid, String userid, int fid, String image, String text, String eval, Date date) {
		super();
		this.rid = rid;
		this.userid = userid;
		this.fid = fid;
		this.image = image;
		this.text = text;
		this.eval = eval;
		this.date = date;
	}

	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getEval() {
		return eval;
	}
	public void setEval(String eval) {
		this.eval = eval;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ReviewVO [rid=" + rid + ", userid=" + userid + ", fid=" + fid + ", image=" + image + ", text=" + text
				+ ", eval=" + eval + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((eval == null) ? 0 : eval.hashCode());
		result = prime * result + fid;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + rid;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewVO other = (ReviewVO) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (eval == null) {
			if (other.eval != null)
				return false;
		} else if (!eval.equals(other.eval))
			return false;
		if (fid != other.fid)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (rid != other.rid)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	
	
	
	
}
