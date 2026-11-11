SELECT reg.contest_id, ROUND((reg.contest_cnt::NUMERIC / usr.all) * 100, 2) percentage
FROM 
    (SELECT r.contest_id, COUNT(*) contest_cnt
        FROM Register r
        GROUP BY r.contest_id) reg,
    (SELECT COUNT(*) all 
        FROM Users u) usr
ORDER BY percentage DESC, contest_id ASC