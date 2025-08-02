INSERT INTO user(user_name, email, password, phone, biography)
VALUES('王小明', 'user@mail.com', 'password', '0912345678', '我是王小明');

INSERT INTO post(user_id, title, content, created_at)
VALUES(1001, '標題', '內容', '2025-07-31 12:00:00');

INSERT INTO comment(user_id, post_id, content,created_at)
VALUES(1001, 2001, '留言', '2025-07-31 12:30:00');