package kr.board.domain;


public class Board {
	//property(프로퍼티, 속성)
	private int idx; //번호 
	private String title;//제목 
	private String contents; //내용 
	private String writer; //작성자 
	private String indate; //작성일 mysql에서 이미 datetime로 날짜를 정해줬기때문에 자바에서까지 date로 다시하지말고 String으로 하라.
	private int count; //조회수
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}