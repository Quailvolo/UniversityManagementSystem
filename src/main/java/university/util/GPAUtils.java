package university.util;

import university.entities.Enrollment;

public class GPAUtils {

    public static double calculateGPA(Enrollment[] enrollments, int count) {

        double sum = 0;
        int graded = 0;

        for (int i = 0; i < count; i++) {

            if (enrollments[i].getGrade().getPoints() > 0) {
                sum += enrollments[i].getGrade().getPoints();
                graded++;
            }

        }

        if (graded == 0) {
            return 0;
        }

        return sum / graded;
    }

}
