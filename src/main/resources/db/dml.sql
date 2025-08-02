INSERT INTO user(user_name, email, password, phone, biography)
VALUES
('吉伊卡哇', 'chiikawa@mail.com', 'pwd001', '0912345678', '我是吉伊卡哇'),
('烏薩奇', 'usagi@mail.com', 'pwd002', '0912345677', '嗚啦~'),
('小八貓', 'hachiware@mail.com', 'pwd003', '0912345666', '尖尖哇嘎乃');

INSERT INTO post(user_id, title, content, created_at)
VALUES
(1001, '終於拿到除草證', '苦熬4年八個月，終於讓我拿到除草證了呀', '2025-07-03 12:00:00'),
(1002, '烏薩奇教主', '嗚啦呀哈，嚕嚕嚕嚕嚕~', '2025-07-03 12:00:00')
;

INSERT INTO comment(user_id, post_id, content,created_at)
VALUES
(1003, 2001, '中了！93！93！考上了，考上了', '2025-07-3 12:30:00'),
(1003, 2002, '嗚拉呀哈', '2025-07-31 12:30:00');