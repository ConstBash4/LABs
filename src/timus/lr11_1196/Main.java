package timus.lr11_1196;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(reader.readLine());
            Set<Integer> teacherDates = new HashSet<>();
            for (int i = 0; i < N; i++) {
                teacherDates.add(Integer.parseInt(reader.readLine()));
            }

            int M = Integer.parseInt(reader.readLine());
            int matchCount = 0;
            for (int i = 0; i < M; i++) {
                int studentDate = Integer.parseInt(reader.readLine());
                if (teacherDates.contains(studentDate)) {
                    matchCount++;
                }
            }

            System.out.println(matchCount);
    }
}

