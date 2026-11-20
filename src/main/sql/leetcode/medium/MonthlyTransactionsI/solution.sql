SELECT TO_CHAR(trans_date, 'yyyy-mm') AS "month",
	country,
	COUNT(*) AS trans_count,
	COUNT(
		CASE
			WHEN state = 'approved' then id
			else null
		end
	) AS approved_count,
	SUM(amount) AS trans_total_amount,
	SUM(
		CASE
			WHEN state = 'approved' then amount
			else 0
		end
	) AS approved_total_amount
FROM Transactions
GROUP BY month,
	country;