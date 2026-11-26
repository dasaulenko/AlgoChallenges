WITH first_activity AS (
  SELECT player_id,
    MIN(event_date) first_date
  FROM Activity
  GROUP BY player_id
)
SELECT *
FROM first_activity;