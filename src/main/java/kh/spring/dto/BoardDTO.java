package kh.spring.dto;

import java.sql.Timestamp;

public class BoardDTO {
	private int board_seq;
	private String title;
	private String content;
	private Timestamp write_time;
	private int viewcount;
	private String name;

	public BoardDTO() {
		super();
	}

	public BoardDTO(int board_seq, String title, String content, Timestamp write_time, int viewcount, String name) {
		super();
		this.board_seq = board_seq;
		this.title = title;
		this.content = content;
		this.write_time = write_time;
		this.viewcount = viewcount;
		this.name = name;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getWrite_time() {
		return write_time;
	}

	public void setWrite_time(Timestamp write_time) {
		this.write_time = write_time;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
