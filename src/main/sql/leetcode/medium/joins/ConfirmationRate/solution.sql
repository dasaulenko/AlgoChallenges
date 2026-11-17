SELECT 
	s.user_id user_id, 
	COALESCE(ROUND(conf.cnt::NUMERIC / t.cnt, 2), 0) as confirmation_rate
FROM Signups s
	LEFT OUTER JOIN (SELECT user_id, COUNT(*) cnt
										FROM Confirmations
										GROUP BY user_id) t
		ON S.user_id = t.user_id
	LEFT OUTER JOIN (SELECT user_id, COUNT(*) cnt
										FROM Confirmations
										WHERE action = 'confirmed'
										GROUP BY user_id) conf
		ON s.user_id = conf.user_id