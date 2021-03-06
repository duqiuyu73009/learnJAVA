mysql> select * from classes;
+----+-------------------------+-------------------------------------------------------------------+
| id | name                    | desc                                                              |
+----+-------------------------+-------------------------------------------------------------------+
|  1 | 计算机系2019级1班       | 学习了计算机原理、C和Java语言、数据结构和算法                     |
|  2 | 中文系2019级3班         | 学习了中国传统文学                                                |
|  3 | 自动化2019级5班         | 学习了机械自动化                                                  |
+----+-------------------------+-------------------------------------------------------------------+
3 rows in set (0.04 sec)

mysql> select * from course;
+----+--------------------+
| id | name               |
+----+--------------------+
|  1 | Java               |
|  2 | 中国传统文化       |
|  3 | 计算机原理         |
|  4 | 语文               |
|  5 | 高阶数学           |
|  6 | 英文               |
+----+--------------------+
6 rows in set (0.03 sec)

mysql> select * from score;
+-------+------------+-----------+
| score | student_id | course_id |
+-------+------------+-----------+
|  70.5 |          1 |         1 |
|  98.5 |          1 |         3 |
|  33.0 |          1 |         5 |
|  98.0 |          1 |         6 |
|  60.0 |          2 |         1 |
|  59.5 |          2 |         5 |
|  33.0 |          3 |         1 |
|  68.0 |          3 |         3 |
|  99.0 |          3 |         5 |
|  67.0 |          4 |         1 |
|  23.0 |          4 |         3 |
|  56.0 |          4 |         5 |
|  72.0 |          4 |         6 |
|  81.0 |          5 |         1 |
|  37.0 |          5 |         5 |
|  56.0 |          6 |         2 |
|  43.0 |          6 |         4 |
|  79.0 |          6 |         6 |
|  80.0 |          7 |         2 |
|  92.0 |          7 |         6 |
+-------+------------+-----------+
20 rows in set (0.04 sec)

mysql> select * from course;
+----+--------------------+
| id | name               |
+----+--------------------+
|  1 | Java               |
|  2 | 中国传统文化       |
|  3 | 计算机原理         |
|  4 | 语文               |
|  5 | 高阶数学           |
|  6 | 英文               |
+----+--------------------+
6 rows in set (0.00 sec)

mysql> select * from student;
+----+-------+-----------------+------------------+------------+
| id | sn    | name            | qq_mail          | classes_id |
+----+-------+-----------------+------------------+------------+
|  1 | 09982 | 黑旋风李逵      | xuanfeng@qq.com  |          1 |
|  2 | 00835 | 菩提老祖        | NULL             |          1 |
|  3 | 00391 | 白素贞          | NULL             |          1 |
|  4 | 00031 | 许仙            | xuxian@qq.com    |          1 |
|  5 | 00054 | 不想毕业        | NULL             |          1 |
|  6 | 51234 | 好好说话        | say@qq.com       |          2 |
|  7 | 83223 | tellme          | NULL             |          2 |
|  8 | 09527 | 老外学中文      | foreigner@qq.com |          2 |
+----+-------+-----------------+------------------+------------+
8 rows in set (0.05 sec)

mysql> select * from classes;
+----+-------------------------+-------------------------------------------------------------------+
| id | name                    | desc                                                              |
+----+-------------------------+-------------------------------------------------------------------+
|  1 | 计算机系2019级1班       | 学习了计算机原理、C和Java语言、数据结构和算法                     |
|  2 | 中文系2019级3班         | 学习了中国传统文学                                                |
|  3 | 自动化2019级5班         | 学习了机械自动化                                                  |
+----+-------------------------+-------------------------------------------------------------------+
3 rows in set (0.00 sec)

mysql> select * from course;
+----+--------------------+
| id | name               |
+----+--------------------+
|  1 | Java               |
|  2 | 中国传统文化       |
|  3 | 计算机原理         |
|  4 | 语文               |
|  5 | 高阶数学           |
|  6 | 英文               |
+----+--------------------+
6 rows in set (0.00 sec)

mysql> select * from score;
+-------+------------+-----------+
| score | student_id | course_id |
+-------+------------+-----------+
|  70.5 |          1 |         1 |
|  98.5 |          1 |         3 |
|  33.0 |          1 |         5 |
|  98.0 |          1 |         6 |
|  60.0 |          2 |         1 |
|  59.5 |          2 |         5 |
|  33.0 |          3 |         1 |
|  68.0 |          3 |         3 |
|  99.0 |          3 |         5 |
|  67.0 |          4 |         1 |
|  23.0 |          4 |         3 |
|  56.0 |          4 |         5 |
|  72.0 |          4 |         6 |
|  81.0 |          5 |         1 |
|  37.0 |          5 |         5 |
|  56.0 |          6 |         2 |
|  43.0 |          6 |         4 |
|  79.0 |          6 |         6 |
|  80.0 |          7 |         2 |
|  92.0 |          7 |         6 |
+-------+------------+-----------+
20 rows in set (0.00 sec)

mysql> select * from student;
+----+-------+-----------------+------------------+------------+
| id | sn    | name            | qq_mail          | classes_id |
+----+-------+-----------------+------------------+------------+
|  1 | 09982 | 黑旋风李逵      | xuanfeng@qq.com  |          1 |
|  2 | 00835 | 菩提老祖        | NULL             |          1 |
|  3 | 00391 | 白素贞          | NULL             |          1 |
|  4 | 00031 | 许仙            | xuxian@qq.com    |          1 |
|  5 | 00054 | 不想毕业        | NULL             |          1 |
|  6 | 51234 | 好好说话        | say@qq.com       |          2 |
|  7 | 83223 | tellme          | NULL             |          2 |
|  8 | 09527 | 老外学中文      | foreigner@qq.com |          2 |
+----+-------+-----------------+------------------+------------+
8 rows in set (0.00 sec)

mysql> select student.id,student.name,score.student_id,score.score from student,score where student.id = score.student_id;
+----+-----------------+------------+-------+
| id | name            | student_id | score |
+----+-----------------+------------+-------+
|  1 | 黑旋风李逵      |          1 |  70.5 |
|  1 | 黑旋风李逵      |          1 |  98.5 |
|  1 | 黑旋风李逵      |          1 |  33.0 |
|  1 | 黑旋风李逵      |          1 |  98.0 |
|  2 | 菩提老祖        |          2 |  60.0 |
|  2 | 菩提老祖        |          2 |  59.5 |
|  3 | 白素贞          |          3 |  33.0 |
|  3 | 白素贞          |          3 |  68.0 |
|  3 | 白素贞          |          3 |  99.0 |
|  4 | 许仙            |          4 |  67.0 |
|  4 | 许仙            |          4 |  23.0 |
|  4 | 许仙            |          4 |  56.0 |
|  4 | 许仙            |          4 |  72.0 |
|  5 | 不想毕业        |          5 |  81.0 |
|  5 | 不想毕业        |          5 |  37.0 |
|  6 | 好好说话        |          6 |  56.0 |
|  6 | 好好说话        |          6 |  43.0 |
|  6 | 好好说话        |          6 |  79.0 |
|  7 | tellme          |          7 |  80.0 |
|  7 | tellme          |          7 |  92.0 |
+----+-----------------+------------+-------+
20 rows in set (0.04 sec)

mysql> select student.id,student.name,score.student_id,score.score from student,score where student.id = score.student_id and student.name ='许仙';
+----+--------+------------+-------+
| id | name   | student_id | score |
+----+--------+------------+-------+
|  4 | 许仙   |          4 |  67.0 |
|  4 | 许仙   |          4 |  23.0 |
|  4 | 许仙   |          4 |  56.0 |
|  4 | 许仙   |          4 |  72.0 |
+----+--------+------------+-------+
4 rows in set (0.00 sec)

mysql> select student.id,student.name,score.student_id,score.score from student inner join score on student.id = score.student_id and student.name ='许仙';
+----+--------+------------+-------+
| id | name   | student_id | score |
+----+--------+------------+-------+
|  4 | 许仙   |          4 |  67.0 |
|  4 | 许仙   |          4 |  23.0 |
|  4 | 许仙   |          4 |  56.0 |
|  4 | 许仙   |          4 |  72.0 |
+----+--------+------------+-------+
4 rows in set (0.00 sec)

mysql> select student.id,student.name,sum(score.score) from student, score on student.id = score.student_id;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'on student.id = score.student_id' at line 1
mysql> select student.id,student.name,sum(score.score) from student, score where student.id = score.student_id;
+----+-----------------+------------------+
| id | name            | sum(score.score) |
+----+-----------------+------------------+
|  1 | 黑旋风李逵      |           1305.5 |
+----+-----------------+------------------+
1 row in set (0.03 sec)

mysql> select student.id,student.name,score.student_id,score.score from student,score where student.id = score.student_id ;
+----+-----------------+------------+-------+
| id | name            | student_id | score |
+----+-----------------+------------+-------+
|  1 | 黑旋风李逵      |          1 |  70.5 |
|  1 | 黑旋风李逵      |          1 |  98.5 |
|  1 | 黑旋风李逵      |          1 |  33.0 |
|  1 | 黑旋风李逵      |          1 |  98.0 |
|  2 | 菩提老祖        |          2 |  60.0 |
|  2 | 菩提老祖        |          2 |  59.5 |
|  3 | 白素贞          |          3 |  33.0 |
|  3 | 白素贞          |          3 |  68.0 |
|  3 | 白素贞          |          3 |  99.0 |
|  4 | 许仙            |          4 |  67.0 |
|  4 | 许仙            |          4 |  23.0 |
|  4 | 许仙            |          4 |  56.0 |
|  4 | 许仙            |          4 |  72.0 |
|  5 | 不想毕业        |          5 |  81.0 |
|  5 | 不想毕业        |          5 |  37.0 |
|  6 | 好好说话        |          6 |  56.0 |
|  6 | 好好说话        |          6 |  43.0 |
|  6 | 好好说话        |          6 |  79.0 |
|  7 | tellme          |          7 |  80.0 |
|  7 | tellme          |          7 |  92.0 |
+----+-----------------+------------+-------+
20 rows in set (0.00 sec)

mysql> select student.id,student.name,score.student_id,score.score from student,score where student.id = score.student_id group by student_id;
+----+-----------------+------------+-------+
| id | name            | student_id | score |
+----+-----------------+------------+-------+
|  1 | 黑旋风李逵      |          1 |  70.5 |
|  2 | 菩提老祖        |          2 |  60.0 |
|  3 | 白素贞          |          3 |  33.0 |
|  4 | 许仙            |          4 |  67.0 |
|  5 | 不想毕业        |          5 |  81.0 |
|  6 | 好好说话        |          6 |  56.0 |
|  7 | tellme          |          7 |  80.0 |
+----+-----------------+------------+-------+
7 rows in set (0.03 sec)

mysql> select student.id,student.name,sym(score.score from student,score where student.id = score.student_id group by student.id;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'from student,score where student.id = score.student_id group by student.id' at line 1
mysql> select student.id,student.name,sum(score.score) from student,score where student.id = score.student_id group by student.id;
+----+-----------------+------------------+
| id | name            | sum(score.score) |
+----+-----------------+------------------+
|  1 | 黑旋风李逵      |            300.0 |
|  2 | 菩提老祖        |            119.5 |
|  3 | 白素贞          |            200.0 |
|  4 | 许仙            |            218.0 |
|  5 | 不想毕业        |            118.0 |
|  6 | 好好说话        |            178.0 |
|  7 | tellme          |            172.0 |
+----+-----------------+------------------+
7 rows in set (0.03 sec)

mysql> select student.name, course.name, score.score from student,score,course where student.id = score.student_id and course.id = score.course_id;
+-----------------+--------------------+-------+
| name            | name               | score |
+-----------------+--------------------+-------+
| 黑旋风李逵      | Java               |  70.5 |
| 黑旋风李逵      | 计算机原理         |  98.5 |
| 黑旋风李逵      | 高阶数学           |  33.0 |
| 黑旋风李逵      | 英文               |  98.0 |
| 菩提老祖        | Java               |  60.0 |
| 菩提老祖        | 高阶数学           |  59.5 |
| 白素贞          | Java               |  33.0 |
| 白素贞          | 计算机原理         |  68.0 |
| 白素贞          | 高阶数学           |  99.0 |
| 许仙            | Java               |  67.0 |
| 许仙            | 计算机原理         |  23.0 |
| 许仙            | 高阶数学           |  56.0 |
| 许仙            | 英文               |  72.0 |
| 不想毕业        | Java               |  81.0 |
| 不想毕业        | 高阶数学           |  37.0 |
| 好好说话        | 中国传统文化       |  56.0 |
| 好好说话        | 语文               |  43.0 |
| 好好说话        | 英文               |  79.0 |
| tellme          | 中国传统文化       |  80.0 |
| tellme          | 英文               |  92.0 |
+-----------------+--------------------+-------+
20 rows in set (0.00 sec)

mysql> select s1.student_id, s1.score, s1.course_id, s2.student_id, s2.score, s2.course_id from score s1,score s2 where s1.student_id = s2.student_id;
+------------+-------+-----------+------------+-------+-----------+
| student_id | score | course_id | student_id | score | course_id |
+------------+-------+-----------+------------+-------+-----------+
|          1 |  70.5 |         1 |          1 |  70.5 |         1 |
|          1 |  98.5 |         3 |          1 |  70.5 |         1 |
|          1 |  33.0 |         5 |          1 |  70.5 |         1 |
|          1 |  98.0 |         6 |          1 |  70.5 |         1 |
|          1 |  70.5 |         1 |          1 |  98.5 |         3 |
|          1 |  98.5 |         3 |          1 |  98.5 |         3 |
|          1 |  33.0 |         5 |          1 |  98.5 |         3 |
|          1 |  98.0 |         6 |          1 |  98.5 |         3 |
|          1 |  70.5 |         1 |          1 |  33.0 |         5 |
|          1 |  98.5 |         3 |          1 |  33.0 |         5 |
|          1 |  33.0 |         5 |          1 |  33.0 |         5 |
|          1 |  98.0 |         6 |          1 |  33.0 |         5 |
|          1 |  70.5 |         1 |          1 |  98.0 |         6 |
|          1 |  98.5 |         3 |          1 |  98.0 |         6 |
|          1 |  33.0 |         5 |          1 |  98.0 |         6 |
|          1 |  98.0 |         6 |          1 |  98.0 |         6 |
|          2 |  60.0 |         1 |          2 |  60.0 |         1 |
|          2 |  59.5 |         5 |          2 |  60.0 |         1 |
|          2 |  60.0 |         1 |          2 |  59.5 |         5 |
|          2 |  59.5 |         5 |          2 |  59.5 |         5 |
|          3 |  33.0 |         1 |          3 |  33.0 |         1 |
|          3 |  68.0 |         3 |          3 |  33.0 |         1 |
|          3 |  99.0 |         5 |          3 |  33.0 |         1 |
|          3 |  33.0 |         1 |          3 |  68.0 |         3 |
|          3 |  68.0 |         3 |          3 |  68.0 |         3 |
|          3 |  99.0 |         5 |          3 |  68.0 |         3 |
|          3 |  33.0 |         1 |          3 |  99.0 |         5 |
|          3 |  68.0 |         3 |          3 |  99.0 |         5 |
|          3 |  99.0 |         5 |          3 |  99.0 |         5 |
|          4 |  67.0 |         1 |          4 |  67.0 |         1 |
|          4 |  23.0 |         3 |          4 |  67.0 |         1 |
|          4 |  56.0 |         5 |          4 |  67.0 |         1 |
|          4 |  72.0 |         6 |          4 |  67.0 |         1 |
|          4 |  67.0 |         1 |          4 |  23.0 |         3 |
|          4 |  23.0 |         3 |          4 |  23.0 |         3 |
|          4 |  56.0 |         5 |          4 |  23.0 |         3 |
|          4 |  72.0 |         6 |          4 |  23.0 |         3 |
|          4 |  67.0 |         1 |          4 |  56.0 |         5 |
|          4 |  23.0 |         3 |          4 |  56.0 |         5 |
|          4 |  56.0 |         5 |          4 |  56.0 |         5 |
|          4 |  72.0 |         6 |          4 |  56.0 |         5 |
|          4 |  67.0 |         1 |          4 |  72.0 |         6 |
|          4 |  23.0 |         3 |          4 |  72.0 |         6 |
|          4 |  56.0 |         5 |          4 |  72.0 |         6 |
|          4 |  72.0 |         6 |          4 |  72.0 |         6 |
|          5 |  81.0 |         1 |          5 |  81.0 |         1 |
|          5 |  37.0 |         5 |          5 |  81.0 |         1 |
|          5 |  81.0 |         1 |          5 |  37.0 |         5 |
|          5 |  37.0 |         5 |          5 |  37.0 |         5 |
|          6 |  56.0 |         2 |          6 |  56.0 |         2 |
|          6 |  43.0 |         4 |          6 |  56.0 |         2 |
|          6 |  79.0 |         6 |          6 |  56.0 |         2 |
|          6 |  56.0 |         2 |          6 |  43.0 |         4 |
|          6 |  43.0 |         4 |          6 |  43.0 |         4 |
|          6 |  79.0 |         6 |          6 |  43.0 |         4 |
|          6 |  56.0 |         2 |          6 |  79.0 |         6 |
|          6 |  43.0 |         4 |          6 |  79.0 |         6 |
|          6 |  79.0 |         6 |          6 |  79.0 |         6 |
|          7 |  80.0 |         2 |          7 |  80.0 |         2 |
|          7 |  92.0 |         6 |          7 |  80.0 |         2 |
|          7 |  80.0 |         2 |          7 |  92.0 |         6 |
|          7 |  92.0 |         6 |          7 |  92.0 |         6 |
+------------+-------+-----------+------------+-------+-----------+
62 rows in set (0.01 sec)

mysql> select s1.student_id, s1.score, s1.course_id, s2.student_id, s2.score, s2.course_id from score s1,score s2 where s1.student_id = s2.student_id and s1.course_id = 3 and s2.course_id = 1 and s1.score > s2.score;
+------------+-------+-----------+------------+-------+-----------+
| student_id | score | course_id | student_id | score | course_id |
+------------+-------+-----------+------------+-------+-----------+
|          1 |  98.5 |         3 |          1 |  70.5 |         1 |
|          3 |  68.0 |         3 |          3 |  33.0 |         1 |
+------------+-------+-----------+------------+-------+-----------+
2 rows in set (0.00 sec)