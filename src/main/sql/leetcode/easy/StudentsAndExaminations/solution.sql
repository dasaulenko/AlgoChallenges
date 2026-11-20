SELECT 
	st.student_id AS student_id, 
	st.student_name AS student_name, 
	sb.subject_name AS subject_name, 
	COUNT(e.student_id) AS attended_exams
FROM Students st
	CROSS JOIN Subjects sb
	LEFT OUTER JOIN Examinations e
		ON st.student_id = e.student_id
			AND sb.subject_name = e.subject_name
GROUP BY st.student_id, st.student_name, sb.subject_name
ORDER BY st.student_id, sb.subject_name
