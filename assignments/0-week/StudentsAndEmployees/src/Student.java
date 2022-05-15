import java.util.ArrayList;

public class Student extends Person {
    private ArrayList<String[]> transcript = new ArrayList<String[]>();

    public Student(String fn, String ln) {
        super(fn, ln);
    }

    public int findClass(String className) {
        for (int i = 0; i < transcript.size(); i++) {
            if (transcript.get(i)[0].equals(className)) {
                return i;
            }
        }
        return -1;
    }

    public void addClass(String className, String grade) {
        String[] classTaken = { className, grade };
        transcript.add(classTaken);
    }

    public void addClass(String className) {
        String[] classTaken = { className, "N/A" };
        transcript.add(classTaken);
    }

    public void removeClass(String className) {
        int classInd = findClass(className);
        if (classInd != -1) {
            transcript.remove(classInd);
        }
    }

    public void assignGrade(String className, String grade) {
        int classInd = findClass(className);
        if (classInd != -1) {
            transcript.get(classInd)[1] = grade;
        }
    }

    public void printTranscript() {
        for (int i = 0; i < transcript.size(); i++) {
            System.out.println(transcript.get(i)[0] + ": " + transcript.get(i)[1]);
        }
    }
}