import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

public class MultimapTest {
	Map<String, List<StudentScore>> StudentScoreMap = new HashMap<String, List<StudentScore>>();

	@Test
	public void testStudentScore() {
		for (int i = 10; i < 20; i++) {
			StudentScore studentScore = new StudentScore();
			studentScore.CourseId = 1001 + i;
			studentScore.score = 100 - i;
			this.addStudentScore("peida", studentScore);
		}

		System.out.println("StudentScoreMap:" + StudentScoreMap.size());
		System.out.println("StudentScoreMap:" + StudentScoreMap.containsKey("peida"));

		System.out.println("StudentScoreMap:" + StudentScoreMap.containsKey("jerry"));
		System.out.println("StudentScoreMap:" + StudentScoreMap.size());
		System.out.println("StudentScoreMap:" + StudentScoreMap.get("peida").size());

		List<StudentScore> StudentScoreList = StudentScoreMap.get("peida");
		if (StudentScoreList != null && StudentScoreList.size() > 0) {
			for (StudentScore stuScore : StudentScoreList) {
				System.out.println("stuScore one:" + stuScore.CourseId + " score:" + stuScore.score);
			}
		}
	}

	public void addStudentScore(final String stuName, final StudentScore studentScore) {
		List<StudentScore> stuScore = this.StudentScoreMap.get(stuName);
		if (stuScore == null) {
			stuScore = new ArrayList<StudentScore>();
			this.StudentScoreMap.put(stuName, stuScore);
		}
		stuScore.add(studentScore);
	}

	@Test
	public void testStuScoreMulitmap() {
		Multimap<String, StudentScore> scoreMultimap = ArrayListMultimap.create();
		for (int i = 10; i < 20; i++) {
			StudentScore studentScore = new StudentScore();
			studentScore.CourseId = 1001 + i;
			studentScore.score = 100 - i;
			scoreMultimap.put("peida", studentScore);
		}

		System.out.println("scoreMultimap:" + scoreMultimap.size());
		System.out.println("scoreMultimap:" + scoreMultimap.keys());

		Collection<StudentScore> studentScore = scoreMultimap.get("peida");
		studentScore.clear();
		StudentScore studentScoreNew = new StudentScore();
		studentScoreNew.CourseId = 1034;
		studentScoreNew.score = 67;
		studentScore.add(studentScoreNew);

		System.out.println("scoreMultimap:" + scoreMultimap.size());
		System.out.println("scoreMultimap:" + scoreMultimap.keys());
	}

	@Test
	public void testStuScoreMulitmap2() {
		
		Multimap<String, StudentScore> scoreMultimap = ArrayListMultimap.create();
		for (int i = 10; i < 20; i++) {
			StudentScore studentScore = new StudentScore();
			studentScore.CourseId = 1001 + i;
			studentScore.score = 100 - i;
			studentScore.name = "peida";
			scoreMultimap.put("peida", studentScore);
		}

		System.out.println("scoreMultimap:" + scoreMultimap.size());
		System.out.println("scoreMultimap:" + scoreMultimap.keys());

		StudentScore studentScore2 = new StudentScore();
		studentScore2.CourseId = 1045;
		studentScore2.score = 56;
		studentScore2.name = "jerry";
		scoreMultimap.put("jerry", studentScore2);

		System.out.println("scoreMultimap:" + scoreMultimap.size());
		System.out.println("scoreMultimap:" + scoreMultimap.keys());
		
		/*
		 * 1.asMap把自身Multimap<K, V>映射成Map<K, Collection<V>>视图。
		 * 这个Map视图支持remove和修改操作，但是不支持put和putAll。严格地来讲，当你希望传入参数是不存在的key，
		 * 而且你希望返回的是null而不是一个空的可修改的集合的时候就可以调用asMap().get(key)。
		 * （你可以强制转型asMap().get(key)的结果类型－对SetMultimap的结果转成Set，
		 * 对ListMultimap的结果转成List型－但是直接把ListMultimap转成Map<K, List<V>>是不行的。）
		 */
		Map<String, Collection<StudentScore>> asMap = scoreMultimap.asMap();
		Iterator<StudentScore> iter_StudentScore = asMap.get("jerry").iterator();
		while ( iter_StudentScore.hasNext() ) {
			StudentScore temp = iter_StudentScore.next();
			temp.score = 100;
		}
		
		Collection<Entry<String, StudentScore>> entries0 = scoreMultimap.entries();
		for ( Entry<String, StudentScore> entry : entries0 ) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		/*
		 * 执行put和putAll操作会抛出 
		 * java.lang.UnsupportedOperationException
		 * 异常
		 */
//		asMap.put("Tom", Arrays.asList(new StudentScore("Tom", 99999, 60)));
		
		Set<String> setKeys = scoreMultimap.keySet();
		for ( String key : setKeys ) {
			System.out.println(key);
		}
		
		Multiset<String> keys = scoreMultimap.keys();
		for ( String key : keys ) {
			System.out.println(key);
		}
		
		Collection<StudentScore> studentScores = scoreMultimap.values();
		for ( StudentScore studentScore : studentScores ) {
			System.out.println(studentScore);
		}
		
		Collection<Entry<String, StudentScore>> entries = scoreMultimap.entries();
		for ( Entry<String, StudentScore> entry : entries ) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		
		System.out.println("Multimap.size() = " + scoreMultimap.size());
	}

}

class StudentScore {
	String name;
	int CourseId;
	int score;
	
	public StudentScore() {
		super();
	}
	
	public StudentScore(String name, int courseId, int score) {
		super();
		this.name = name;
		CourseId = courseId;
		this.score = score;
	}



	@Override
	public String toString() {
		return "StudentScore [name=" + name + ", CourseId=" + CourseId + ", score=" + score + "]";
	}
	
}