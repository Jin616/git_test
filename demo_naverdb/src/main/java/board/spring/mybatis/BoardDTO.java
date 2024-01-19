package board.spring.mybatis;

public class BoardDTO {
	/*
	seq int primary key auto_increment,
	title varchar(100) not null,
	contents varchar(4000),
	writer varchar(30),
	pw int,
	viewcount int default 0,
	writingtime datetime default now(),
	isdelete boolean default false
	*/
	
	private Integer seq;
	private String title;
	private String contents;
	private String writer;
	private Integer pw;
	private Integer viewcount;
	private String writingtime;
	private boolean isdelete;
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Integer getPw() {
		return pw;
	}
	public void setPw(Integer pw) {
		this.pw = pw;
	}
	public Integer getViewcount() {
		return viewcount;
	}
	public void setViewcount(Integer viewcount) {
		this.viewcount = viewcount;
	}
	public String getWritingtime() {
		return writingtime;
	}
	public void setWritingtime(String writingtime) {
		this.writingtime = writingtime;
	}
	public boolean isIsdelete() {
		return isdelete;
	}
	public void setIsdelete(boolean isdelete) {
		this.isdelete = isdelete;
	}
	@Override
	public String toString() {
		return "BoardDTO [seq=" + seq + ", title=" + title + ", contents=" + contents + ", writer=" + writer + ", pw="
				+ pw + ", viewcount=" + viewcount + ", writingtime=" + writingtime + ", isdelete=" + isdelete + "]";
	}
	
}
