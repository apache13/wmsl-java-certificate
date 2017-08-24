import java.util.ArrayList;
import java.util.List;

public class Reservations {
	public static final int MAX_EXAM = 128;	
	public static final int SEQ= 1;
	public static final int TOTAL= 14;
	
	public static void main(String[] args) {
		List<Integer> examinationList = new ArrayList<>();
		for(int i=1;i<=MAX_EXAM;i++) {
			examinationList.add(i);
		}
				
		examinationList.stream().filter( (e) -> {return SEQ==(e%TOTAL)?true:false;} ).forEach((e)->System.out.println(e));
		
	}

}
