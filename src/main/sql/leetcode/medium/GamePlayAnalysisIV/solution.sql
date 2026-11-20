WITH first_activity AS (
	SELECT player_id,
		MIN(event_date) first_date
	FROM Activity
	GROUP BY player_id
)
SELECT ROUND(COUNT(a.player_id)::NUMERIC / COUNT(*), 2) fraction
FROM first_activity f
	LEFT OUTER JOIN Activity a ON f.player_id = a.player_id
	AND f.first_date + 1 = a.event_date