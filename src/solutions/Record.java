package solutions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Record implements Comparable<Record> {
	LocalDateTime ldt;
	String content;
	
	public Record(String record){
		String[] split = record.split("[\\[\\]]");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.ldt = LocalDateTime.parse(split[1], formatter);
		this.content = split[2].trim();
	}
	
	public LocalDateTime getTimeStamp(){
		return this.ldt;
	}
	
	public String getContent(){
		return this.content;
	}

	@Override
	public int compareTo(Record o) {
		return this.ldt.compareTo(o.getTimeStamp());
	}
}