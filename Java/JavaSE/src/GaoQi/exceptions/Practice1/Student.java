package GaoQi.Exceptions.Practice1;



import java.io.IOException;


class Student {
    private double usualScore;
    private double finalScore;

    public Student(double usualScore, double finalScore) {
        this.usualScore = usualScore;
        this.finalScore = finalScore;
    }


    public  double gettotalScore() throws IOException {
        double totalScore=usualScore+finalScore/2;
        if(totalScore<60){
            throw new IOException("不及格");
        }
        return totalScore;



    }
}
